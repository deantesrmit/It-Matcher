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
import spark.Spark;
import java.util.Optional;

import static com.itmatcher.util.RequestUtil.clearSessionRedirect;
import static com.itmatcher.util.RequestUtil.getQueryParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.getSessionRedirect;


/**
 * RegisterController - a class for handling the serving and posting of the register feature
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Component
public class RegisterController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthService authService;

    /** Serves the register page to the user
     * @return the register page for the current session */
    public Route serveRegisterPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.REGISTER);

        };
    }

    /**Handles the POST method of the register function
     * @return the current session view */
     public Route handleRegisterPost() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            final User user = populateUser(request);
            final String password = getQueryParam(request, "password");
            Optional <User> usercheck = userRepository.getUserByUserName(getQueryParam(request, "username"));
            if (usercheck.isPresent()){
                model.put("error", "That username is already taken");
                return ViewUtil.render(request, model, Path.Template.REGISTER);
            }
            if (isNullOrEmpty(user.getUsername()) || isNullOrEmpty(password)) {
                model.put("error", "Please enter an email and password to register.");
                return ViewUtil.render(request, model, Path.Template.REGISTER);
            }

            final User newUser = authService.registerUser(user, password);
            request.session().attribute("currentUser", newUser);
            response.redirect(Path.Web.PROFILE);
            return Spark.redirect;

        };
    }

    private User populateUser(Request request) {
        final User user = new User();
        user.setUsername(getQueryParam(request, "username"));
        user.setFirstName(getQueryParam(request,"firstName"));
        user.setLastName(getQueryParam(request,"lastName"));
        user.setAccountType(getQueryParam(request, "registrationType"));
        return user;
    }
}