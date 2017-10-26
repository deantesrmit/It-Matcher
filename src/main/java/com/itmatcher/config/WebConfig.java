package com.itmatcher.config;

import com.itmatcher.controller.*;
import com.itmatcher.filters.Filters;
import com.itmatcher.util.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Spark;

import static spark.Spark.*;

/**
 * Created by deant on 10/4/17.
 */
@Component
public class WebConfig {
    @Autowired
    Filters filters;
    @Autowired
    LoginController loginController;
    @Autowired
    IndexController indexController;
    @Autowired
    RegisterController registerController;
    @Autowired
    ProfileController profileController;
    @Autowired
    PageController pageController;
    @Autowired
    JobController jobController;
    @Autowired
    FreeLancerController freeLancerController;


    public void initApplication() {
        staticFileLocation("public");
        port(getHerokuAssignedPort());
        initFilters();
        initRoutes();
    }

    private void initFilters() {
        before("*", filters.addTrailingSlashes());
    }

    private void initRoutes() {
        get(Path.Web.INDEX, indexController.serveIndexPage());
        get(Path.Web.LOGIN, loginController.serveLoginPage());
        post(Path.Web.LOGIN, loginController.handleLoginPost());
        post(Path.Web.LOGOUT, loginController.handleLogoutPost());
        get(Path.Web.REGISTER, registerController.serveRegisterPage());
        post(Path.Web.REGISTER,registerController.handleRegisterPost());
        post(Path.Web.EDIT_PROFILE, profileController.handleEditProfile());
        get (Path.Web.EDIT_PROFILE, profileController.serveEditProfilePage());
        get(Path.Web.PROFILE, profileController.serveProfilePage());
        get(Path.Web.VIEW_JOB, jobController.serveViewJobPage());
        get(Path.Web.CREATE_JOB, pageController.serveCreateJobPage());
        get(Path.Web.VIEW_MATCHES, pageController.serveMatchesPage());
        get(Path.Web.VIEW_FREELANCERS, pageController.serveFreelancersPage());
        get(Path.Web.ABOUT_US, pageController.serveAboutUsPage());
        get(Path.Web.HOW_IT_WORKS, pageController.serveHowItWorksPage());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
