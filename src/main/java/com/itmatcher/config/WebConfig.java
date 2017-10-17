package com.itmatcher.config;

import com.itmatcher.controller.IndexController;
import com.itmatcher.controller.LoginController;
import com.itmatcher.controller.ProfileController;
import com.itmatcher.controller.RegisterController;
import com.itmatcher.controller.PageController;
import com.itmatcher.filters.Filters;
import com.itmatcher.util.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Spark;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

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


    public void initApplication() {
        Spark.staticFiles.externalLocation("src/main/resources/public");
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
        get(Path.Web.EDIT_PROFILE, profileController.serveEditProfilePage());
        /*get(Path.Web.PROFILE, profileController.serveProfilePage()); */
        get(Path.Web.CREATE_JOB, pageController.serveCreateJobPage());
        get(Path.Web.VIEW_MATCHES, pageController.serveMatchesPage());
        get(Path.Web.VIEW_FREELANCERS, pageController.serveFreelancersPage());

        get(Path.Web.ABOUT_US, pageController.serveAboutUsPage());
        get(Path.Web.HOW_IT_WORKS, pageController.serveHowItWorksPage());

    }
}
