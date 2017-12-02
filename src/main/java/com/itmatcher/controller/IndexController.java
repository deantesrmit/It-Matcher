package com.itmatcher.controller;

import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.springframework.stereotype.Component;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * IndexController - a class for serving the index page for a user
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Component
public class IndexController {
    public Route serveIndexPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.INDEX);
        };
    }
}
