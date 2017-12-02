package com.itmatcher.filters;

import org.springframework.stereotype.Component;
import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Filters Class - A class that assists users with filtering if they forget slashes in the URL
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Component
public class Filters {
    // If a user manually manipulates paths and forgets to add
    // a trailing slash, redirect the user to the correct path
    public Filter addTrailingSlashes() {
        return (Request request, Response response) -> {
            if (!request.pathInfo().endsWith("/")) {
                response.redirect(request.pathInfo() + "/");
            }
        };
    }
}
