package com.itmatcher.controller;

import com.itmatcher.service.JobService;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deant on 10/21/17.
 */
@Component
public class JobController {
    @Autowired
    JobService jobService;
    JobOfferRepository jobOfferRepository;

    public Route serveViewJobPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(request.params(":jobid"))).get());
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_JOB);
        };
    }

    public Route handleJobOffer() {
        return (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            final String jobId = getQueryParam (request, "jobId" );
            final String freeLancerId = getQueryParam(request, "freeLancerId");
            jobOfferRepository.createJobOffer(jobId, freeLancerId);

            //model.put(jobId, "jobId");
            //model.put(freeLancerId, "freeLancerId");
            return ViewUtil.render(request, model, Path.Template.OFFER_JOB);
        };
    };
}
