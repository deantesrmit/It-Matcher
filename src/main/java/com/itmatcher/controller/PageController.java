package com.itmatcher.controller;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.JobOffer;
import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.repository.SkillRepository;
import com.itmatcher.service.JobOfferService;
import com.itmatcher.service.JobService;
import com.itmatcher.service.LookupService;
import com.itmatcher.service.MatchService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Route;
import spark.Spark;

import static com.itmatcher.util.RequestUtil.getQueryParam;

@Component
public class PageController {
    @Autowired
    MatchService matchService;
    @Autowired
    JobService jobService;
    @Autowired
    LookupService lookupService;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    JobOfferService jobOfferService;

    public Route serveCreateJobPage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("skills", skillRepository.getAllSkills());
            return ViewUtil.render(request, viewObjects, Path.Template.CREATE_JOB);
        };
    }
    public Route serveMatchesPage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_MATCHES);
        };
    }

    public Route serveFreelancersPage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> viewObjects = new HashMap<>();
            final List<ScoredFreeLancer> freelancersForJob = matchService.findFreelancersForJob(Integer.parseInt(request.params(":jobid")));
            final List<ScoredFreeLancer> sortedLancers = freelancersForJob.stream().sorted((f1, f2) -> Integer.compare(f2.getScore(), f1.getScore())).collect(Collectors.toList());
            viewObjects.put("freelancers", sortedLancers);
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(request.params(":jobid"))).get());
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


    public Route handleCreateJob() {
        return (request, response) -> {
            final Job job = jobService.createJob(request).get();
            response.redirect("/viewFreelancers/" + job.getId() + "/");
            return Spark.redirect;
        };
    }
}
