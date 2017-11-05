package com.itmatcher.controller;

import com.itmatcher.domain.Job;
import com.itmatcher.repository.JobRepository;
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
    JobRepository jobRepository;

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
            final Job job = populateJob(request);

            if isNullOrEmpty(job.getTitle()) || isNullOrEmpty(job.getDescription() || isNullOrEmpty(job.getDueDate()) || isNullOrEmpty(job.getSkills())) {
                model.put("error","Please fill out all required job details");
                return ViewUtil.render(request, model, Path.Template.POSTER_PROFILE);
            }
            else{
                jobService.createJob(request);
                return ViewUtil.render(request, model, Path.Template.INDEX);
            }
        };
    }

    private Job populateJob(Request request) {
        final Job job = new Job();
        job.setTitle(getQueryParam(request, "title"));
        job.setDescription(getQueryParam(request, "description"));
        job.setDueDate(getQueryParam(request, "date"));
        job.setSkills(getQueryParam(request, "skills"));
        job.setEducation(getQueryParam(request, "education"));
        job.setBudget(getQueryParam(request, "budget"));
        return job;
    }
}
