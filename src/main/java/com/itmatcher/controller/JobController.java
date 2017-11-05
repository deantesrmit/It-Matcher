package com.itmatcher.controller;

import com.itmatcher.repository.UserRepository;
import com.itmatcher.service.JobService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * Created by deant on 10/21/17.
 */
@Component
public class JobController {
    @Autowired
    JobService jobService;
    @Autowired
    UserRepository userRepository;

    public Route serveViewJobPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(request.params(":jobid"))).get());
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_JOB);
        };
    }

    public Route handleJobOffer() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.OFFER_JOB);
        };
    };

    public Route handleCreateJob() {
        return (Request request, Response response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();

            final String jobTitle = getQueryParam(request,"title");
            final String jobDescription = getQueryParam(request, "description");
            final String jobDate = getQueryParam(request, "date");
            final String skills = getQueryParam(request, "skills");

            if isNullOrEmpty(jobTitle) || isNullOrEmpty(jobDescription || isNullOrEmpty(jobDate) || isNullOrEmpty(skills)) {
                model.put("error","Please fill out all required job details");
                return ViewUtil.render(request, model, Path.Template.POSTER_PROFILE);
            }
            else {

            }

            jobService.createJob(request);
            return ViewUtil.render(request, model, Path.Template.INDEX);

        };
    }
}
