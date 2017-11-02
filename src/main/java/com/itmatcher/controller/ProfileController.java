package com.itmatcher.controller;

import com.itmatcher.domain.Profile;
import com.itmatcher.domain.User;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.EducationService;
import com.itmatcher.service.JobService;
import com.itmatcher.service.LookupService;
import com.itmatcher.service.ProfileService;
import com.itmatcher.type.AccountType;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
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
    LookupService lookupService;
    @Autowired
    UserRepository userRepository;
    public Route serveProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            final AccountType accountType = RequestUtil.getAccountType(request);
            Map<String, Object> params = new HashMap<>();
            final Optional<Profile> profile = profileService.getProfileByUserId(RequestUtil.getSessionCurrentUser(request).getId());
            String username1 = getSessionCurrentUser(request).getUsername();
            User test = (userRepository.getUserByUserName(username1)).get();
            if(!profile.isPresent()) {
                response.redirect(Path.Web.EDIT_PROFILE);
                return Spark.redirect;
            }
            params.put("users",test);
            params.put("profile", profile.get());
            params.put("jobs", jobService.getJobsForUser(getSessionCurrentUser(request)).get());
            return ViewUtil.render(request, params, getProfilePath(accountType));
        };
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
            viewObjects.put("educations", lookupService.getAllEducations());
            final Optional<Profile> profileByUserId = profileService.getProfileByUserId(RequestUtil.getSessionCurrentUser(request).getId());
            viewObjects.put("profile", profileByUserId.orElseGet(Profile::new));
            return ViewUtil.render(request, viewObjects, Path.Template.EDIT_PROFILE);
        };
    }

    public Route handleEditProfile() {
        return (Request request, Response response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();
            profileService.updateProfile(request);
            return ViewUtil.render(request, model, Path.Template.INDEX);
        };
    }

    public Route handleCreateProfile() {
        return (Request request, Response response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();
            profileService.createProfile(request);
            return ViewUtil.render(request, model, Path.Template.INDEX);

        };
    }
}