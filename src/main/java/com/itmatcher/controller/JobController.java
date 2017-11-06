package com.itmatcher.controller;

import com.itmatcher.service.JobService;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import com.itmatcher.repository.JobOfferRepository;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deant on 10/21/17.
 */
@Component
public class JobController {
    @Autowired
    JobOfferRepository jobOfferRepository;
    JobService jobService;


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
            int jobID = Integer.parseInt(getQueryParam(request, "jobID"));
            int freelancerID = Integer.parseInt(getQueryParam(request, "freelancerID"));
            jobOfferRepository.createJobOffer(jobID, freelancerID);
            return ViewUtil.render(request, viewObjects, Path.Template.OFFER_JOB);
        };
    };
}
