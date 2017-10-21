package com.itmatcher.controller;

import com.itmatcher.service.JobService;
import com.itmatcher.type.AccountType;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.itmatcher.util.RequestUtil.getSessionCurrentUser;

/**
 * Created by deant on 10/8/17.
 */
@Component
public class ProfileController {
    @Autowired
    JobService jobService;

    public Route serveProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            final AccountType accountType = RequestUtil.getAccountType(request);
            return ViewUtil.render(request, getParams(accountType, request), getProfilePath(accountType));
        };
    }

    private Map<String, Object> getParams(AccountType type, Request request) {
        Map<String, Object> params = new HashMap<>();
        if(AccountType.FREELANCER.equals(type)) {

        } else {
            params.put("jobs", jobService.getJobsForUser(getSessionCurrentUser(request)).get());
        }
        return params;
    }

    private String getProfilePath(AccountType type) {
        if(AccountType.FREELANCER.equals(type)) {
            return Path.Template.FREELANCER_PROFILE;
        } else {
            return Path.Template.POSTER_PROFILE;
        }
    }

    public Route serveEditProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
                Map<String, Object> viewObjects = new HashMap<>();
                return ViewUtil.render(request, viewObjects, Path.Template.EDIT_PROFILE);
        };
    }
}

