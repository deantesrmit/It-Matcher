package com.itmatcher.controller;

import com.itmatcher.domain.Language;
import com.itmatcher.domain.User;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.repository.FreeLancerRepository;

import com.itmatcher.domain.FreeLancer;
import com.itmatcher.repository.FreeLancerRepository;
import com.itmatcher.service.AuthService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import spark.Request;
import spark.Response;
import spark.Route;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.*;


/**
 * Created by deant on 10/4/17.
 */
@Component
public class FreeLancerController {

    @Autowired
    FreeLancerRepository freelancerRepository;
    @Autowired
    UserRepository userRepository;

    public Route serverEditProfilePage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.EDIT_PROFILE);
        };
    }

    public Route handleEditProfile() {
        return (Request request, Response response) -> {
            Map<String, Object> model = new HashMap<>();
            final User user = RequestUtil.getSessionCurrentUser(request);
            Long userID = user.getId();
            FreeLancer profile = new FreeLancer();

            profile.setLocation(getQueryParam(request, "location"));
            profile.setAddress1(getQueryParam(request, "address1"));
            profile.setSuburb(getQueryParam(request, "suburb"));
            profile.setState(getQueryParam (request, "state"));
            profile.setPostCode(getQueryParam (request, "Postcode"));
            profile.setExperience(getQueryParam (request, "experience"));
            profile.setEducation(getQueryParam (request, "education"));
            profile.setBio(getQueryParam (request, "bio"));

            createProfile(Long userID, FreeLancer profile);

            return ViewUtil.render(request, model, Path.Template.FREELANCER_PROFILE);
        };
    }


}