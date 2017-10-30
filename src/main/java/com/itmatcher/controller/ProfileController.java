package com.itmatcher.controller;

import com.itmatcher.domain.Profile;
import com.itmatcher.domain.User;
import com.itmatcher.repository.ProfileRepository;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.JobService;
import com.itmatcher.service.ProfileService;
import com.itmatcher.type.AccountType;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.itmatcher.util.RequestUtil.getQueryParam;
import static com.itmatcher.util.RequestUtil.getSessionCurrentUser;

/**
 * Created by deant on 10/8/17.
 */
@Component
public class ProfileController {
    @Autowired
    JobService jobService;
    @Autowired
    ProfileService profileService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;
    public Route serveProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            final AccountType accountType = RequestUtil.getAccountType(request);
            return ViewUtil.render(request, getParams(accountType, request), getProfilePath(accountType));
        };
    }

    private Map<String, Object> getParams(AccountType type, Request request) {
        Map<String, Object> params = new HashMap<>();

        String username1 = getSessionCurrentUser(request).getUsername();
        User test = (userRepository.getUserByUserName(username1)).get();
        Profile current_profile= profileRepository.getProfileByUserName(getSessionCurrentUser(request).getId()).get();
        if(AccountType.FREELANCER.equals(type)) {
            params.put("users",test);
            params.put("profile",current_profile);

        } else {
            params.put("jobs", jobService.getJobsForUser(getSessionCurrentUser(request)).get());
            params.put("users",test);
            params.put("profile",current_profile);

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
            //IF YOU NEED PROFILE DETAILS ON THIS PAGE NOT THE SESSION
            final Profile profile = profileService.getProfileByUserId(RequestUtil.getSessionCurrentUser(request).getId());
            viewObjects.put("profile", profile);
            return ViewUtil.render(request, viewObjects, Path.Template.EDIT_PROFILE);
        };
    }

    public Route handleEditProfile() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            profileService.updateProfile(request);
            return ViewUtil.render(request, model, Path.Template.FREELANCER_PROFILE);
        };
    }
}

