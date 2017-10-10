package com.itmatcher.controller;

import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.AuthService;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;
import com.itmatcher.domain.User;

import static com.itmatcher.util.RequestUtil.clearSessionRedirect;
import static com.itmatcher.util.RequestUtil.getQueryParam;

import java.util.HashMap;
import java.util.Map;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.getSessionRedirect;


/**
 * Created by deant on 10/4/17.
 */
@Component
public class RegisterController {

    UserRepository userRepository;
    AuthService authService;

    public Route serveRegisterPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.REGISTER);

        };
    }

    /*Returns null and redirects if user already exists bedehickey*/
    public Route handleRegisterPost() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            String username = getQueryParam(request, "username");
            String password = getQueryParam(request,"password");

            if (isNullOrEmpty(username) || isNullOrEmpty(password)){
                model.put("error", "Please enter a username and password to register.");
                return ViewUtil.render(request, model, Path.Template.REGISTER);
            }
            else {
                try {
                    User user = new User();
                    user.setUsername(username);

                    authService.registerUser(user,password);
                    authService.authenticateUser(username,password);

                    request.session().attribute("currentUser",userRepository.getUserByUserName(username).get());

                    final String sessionRedirect = getSessionRedirect(request);

                    if (!isNullOrEmpty(sessionRedirect)) {
                        clearSessionRedirect(request);
                        response.redirect(sessionRedirect);
                    }

                    return ViewUtil.render(request, model, Path.Template.INDEX);
                } catch (Exception e) {
                    model.put("error", "Username already exists.");
                    return ViewUtil.render(request, model, Path.Template.REGISTER);
                }
            }
        };
    }
}