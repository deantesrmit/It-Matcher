package com.itmatcher.config;

import com.itmatcher.controller.IndexController;
import com.itmatcher.controller.LoginController;
import com.itmatcher.controller.RegisterController;
import com.itmatcher.filters.Filters;
import com.itmatcher.util.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Spark;

import static spark.Spark.before;
import static spark.Spark.get;

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
        get(Path.Web.REGISTER, registerController.serveRegisterPage());
    }
}
