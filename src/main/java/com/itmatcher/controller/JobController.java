package com.itmatcher.controller;

import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.service.JobOfferService;
import com.itmatcher.service.JobService;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;
import spark.Spark;
import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * Created by deant on 10/21/17.
 */
@Component
public class JobController {
    @Autowired
    JobService jobService;
    @Autowired
    JobOfferService offerService;
    @Autowired
    JobOfferRepository jobOfferRepository;

    public Route serveViewJobPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(request.params(":jobid"))).get());
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_JOB);
        };
    }


    public Route handleOfferJob() {
        return (request, response) -> {
            offerService.createJobOffer(request);
            response.redirect("/viewFreelancers/" + getQueryParam(request, "jobId") + "/");
            return Spark.redirect;
        };
    };

    public Route handerJobAcceptDecline () {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            final String answer = getQueryParam (request, "answer");
            final String jobID = getQueryParam (request, "jobID");
            final String freelancerID = getQueryParam(request, "freelancerID");
            jobOfferRepository.respondJobOffer(jobID, freelancerID, answer);
            return ViewUtil.render(request, viewObjects, Path.Template.INDEX);
        };
    }
}
