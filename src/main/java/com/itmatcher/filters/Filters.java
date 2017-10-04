package com.itmatcher.filters;

import org.springframework.stereotype.Component;
import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Created by deant on 10/4/17.
 */
@Component
public class Filters {
    // If a user manually manipulates paths and forgets to add
    // a trailing slash, redirect the user to the correct path
    public Filter addTrailingSlashes = (Request request, Response response) -> {
        if (!request.pathInfo().endsWith("/")) {
            response.redirect(request.pathInfo() + "/");
        }
    };
}
