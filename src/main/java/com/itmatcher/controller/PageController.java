package com.itmatcher.controller;

import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.repository.FreeLancerRepository;
import com.itmatcher.repository.SkillRepository;
import com.itmatcher.service.JobService;
import com.itmatcher.service.MatchService;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by deant on 10/4/17.
 */
@Component
public class PageController {
    @Autowired
    MatchService matchService;
    @Autowired
    JobService jobService;

    public Route serveCreateJobPage() {
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

    public Route serveFreelancersPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("freelancers", matchService.findFreelancersForJob(Long.parseLong(request.params(":jobid"))));
            viewObjects.put("job", jobService.getJobById(Long.parseLong(request.params(":jobid"))).get());
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_FREELANCER);
        };
    }
    public Route serveAboutUsPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.ABOUT_US);
        };
    }
    public Route serveHowItWorksPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.HOW_IT_WORKS);
        };
    }

    public Route serverFreeLancerProfile() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.FREELANCER_PROFILE);
        };
    }

    public Route serveOfferJob() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.OFFER_JOB);
        };
    }



}
