package com.itmatcher.controller;

import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.AuthService;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthService authService;

    public Route serveRegisterPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.REGISTER);

        };
    }

    public Route handleRegisterPost() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            User user = populateUser(request);
            String password = getQueryParam(request, "password");
            //Set other required fields here
            if (isNullOrEmpty(user.getUsername()) || isNullOrEmpty(password)) {
                model.put("error", "Please enter a username and password to register.");
                return ViewUtil.render(request, model, Path.Template.REGISTER);
            } else if (userRepository.getUserByUserName(user.getUsername()).isPresent()) {
                model.put("error", "Username already exists.");
                return ViewUtil.render(request, model, Path.Template.REGISTER);
            } else {
                final User newUser = authService.registerUser(user, password);
                request.session().attribute("currentUser", newUser);
                return ViewUtil.render(request, model, Path.Template.PROFILE);
            }
        };
    }

    //Use this method set all fields from form
    private User populateUser(Request request) {
        User user = new User();
        String username = getQueryParam(request, "username");
        String registrationType = getQueryParam(request, "registrationType");
        user.setUsername(username);
        user.setAccountType(registrationType);
        return user;
    }
}