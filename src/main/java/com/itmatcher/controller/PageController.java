package com.itmatcher.controller;

import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.springframework.stereotype.Component;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deant on 10/4/17.
 */
@Component
public class PageController {
    public Route serveJobPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.CREATE_JOB);
        };
    }
    public Route serveMatchesPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_MATCHES);
        };
    }


}
