package com.itmatcher.controller;

import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.service.JobService;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.util.Path;
import com.itmatcher.util.ViewUtil;
import com.itmatcher.service.MatchService;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;

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
    JobOfferRepository jobOfferRepository;
    MatchService matchService;

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
            final String jobID = getQueryParam (request, "jobID" );
            final String freelancerID = getQueryParam(request, "freelancerID");
            jobOfferRepository.createJobOffer(jobID, freelancerID);

            final List<ScoredFreeLancer> freelancersForJob = matchService.findFreelancersForJob(Integer.parseInt(jobID));
            final List<ScoredFreeLancer> sortedLancers = freelancersForJob.stream().sorted((f1, f2) -> Integer.compare(f2.getScore(), f1.getScore())).collect(Collectors.toList());
            viewObjects.put("freelancers", sortedLancers);
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(jobID)));

            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_FREELANCER);
        };
    };
}
