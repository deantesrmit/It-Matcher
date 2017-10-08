package com.itmatcher.controller;

import com.google.common.base.Strings;
import com.itmatcher.domain.User;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.AuthService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.clearSessionRedirect;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import static com.itmatcher.util.RequestUtil.getSessionRedirect;

/**
 * Created by deant on 10/4/17.
 */
@Component
public class LoginController {
    @Autowired
    AuthService authService;
    @Autowired
    UserRepository userRepository;


    public Route serveLoginPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.LOGIN);
        };
    }

    public Route handleLoginPost() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            final String username = getQueryParam(request, "username");
            if (!authService.authenticateUser(username, getQueryParam(request, "password"))) {
                model.put("error", "Incorrect username or password");
                return ViewUtil.render(request, model, Path.Template.LOGIN);
            }
            request.session().attribute("currentUser", userRepository.getUserByUserName(username).get());
            final String sessionRedirect = getSessionRedirect(request);
            if (!isNullOrEmpty(sessionRedirect)) {
                clearSessionRedirect(request);
                response.redirect(sessionRedirect);
            }
            return ViewUtil.render(request, model, Path.Template.INDEX);
        };
    }

    public Route handleLogoutPost() {
        return (Request request, Response response) -> {
            request.session().removeAttribute("currentUser");
            return ViewUtil.render(request,  new HashMap<>(), Path.Template.LOGIN);
        };
    }
}
