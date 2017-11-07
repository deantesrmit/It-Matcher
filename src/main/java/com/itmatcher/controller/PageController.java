package com.itmatcher.controller;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.domain.Skill;
import com.itmatcher.repository.SkillRepository;
import com.itmatcher.service.JobService;
import com.itmatcher.service.LookupService;
import com.itmatcher.service.MatchService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import freemarker.template.SimpleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static com.google.common.base.Strings.isNullOrEmpty;
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
/**
 * Created by deant on 10/4/17.
 */
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

    public Route serveOfferJob() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            return ViewUtil.render(request, viewObjects, Path.Template.OFFER_JOB);
        };
    }

    public Route handleCreateJob() {
        return (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            final String jobTitle = getQueryParam(request, "title");
            final String jobDescription = getQueryParam(request,"description");
            final String education = getQueryParam(request, "education");
            final String dueDate = getQueryParam(request, "dueDate");
            final String budget = getQueryParam(request,"budget");
            final Date today = new Date();

            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");

            /*Todays date */
            today.setHours(0);
            today.setMinutes(0);
            today.setSeconds(0);

            model.put("skills", skillRepository.getAllSkills());

            /*Check for symbols in title + description, only allow dates in the future, no negative budgets */

            if (isNullOrEmpty(jobTitle) || isNullOrEmpty(jobDescription) || isNullOrEmpty(education) || isNullOrEmpty(dueDate) || isNullOrEmpty(budget)) {
                model.put("error","Please fill in all required details");
                return ViewUtil.render(request, model, Path.Template.CREATE_JOB);
            }
            else if (isDouble(budget)  == false) {
                model.put("error","Budget must be entered correctly");
                return ViewUtil.render(request, model, Path.Template.CREATE_JOB);
            }
            else if ((isDouble(budget) == true) && (Double.parseDouble(budget) < 0)) {
                model.put("error","Budget must be a positive number");
                return ViewUtil.render(request, model, Path.Template.CREATE_JOB);
            }
            else if (today.after(format.parse(dueDate)) == true) {
                model.put("error","Due date must be set in the future");
                return ViewUtil.render(request, model, Path.Template.CREATE_JOB);
            }
            else {
                System.err.println(format.parse(dueDate));
                System.err.println(today);
                System.err.println("LOL NOU");
                final Job job = jobService.createJob(request).get();
                response.redirect("/viewFreelancers/" + job.getId() + "/");
                return Spark.redirect;
            }
        };
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

}
