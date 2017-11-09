package com.itmatcher.controller;

import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.service.JobOfferService;
import com.itmatcher.service.JobService;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import com.itmatcher.service.MatchService;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;
import spark.Spark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by deant on 10/21/17.
 */
@Component
public class JobController {
    @Autowired
    JobService jobService;
    @Autowired
    JobOfferService offerService;

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
    }

}
