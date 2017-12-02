package com.itmatcher.controller;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.Profile;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.repository.ProfileRepository;
import com.itmatcher.service.JobOfferService;
import com.itmatcher.service.JobService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Route;
import spark.Spark;
import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * JobController - a class for handling the accepting and offering jobs
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Component
public class JobController {
    @Autowired
    JobService jobService;
    @Autowired
    JobOfferService offerService;
    @Autowired
    JobOfferRepository jobOfferRepository;
    @Autowired ProfileRepository profileRepository;

    /**Serves the view job page based on the users current session
     * @return the users current session for the view job page based on what type of user they are */
    public Route serveViewJobPage() {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            viewObjects.put("job", jobService.getJobById(Integer.parseInt(request.params(":jobid"))).get());
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_JOB);
        };
    }


    /**Handles the offering of a job to a freelancer by passing current job ID to the offer service
     * @return redirects the user after creating the job offer*/
    public Route handleOfferJobToFreelancer() {
        return (request, response) -> {
            offerService.createOrUpdateJobOffer(request);
            response.redirect("/viewFreelancers/" + getQueryParam(request, "jobId") + "/");
            return Spark.redirect;
        };
    };

    /**Handles the accepting and declining of a job by ta freelancer
     * @return returns the current freelancers job offers after an offer has been processed as accepted or declined*/
    public Route handerJobAcceptDecline () {
        return (request, response) -> {
            Map<String, Object> viewObjects = new HashMap<>();
            final String answer = getQueryParam (request, "answer");
            final String jobID = getQueryParam (request, "jobID");
            final String flID = getQueryParam(request, "freelancerID");
            jobOfferRepository.respondJobOffer(jobID, flID, answer);

            Profile profile = profileRepository.getProfileByUserID(RequestUtil.getSessionCurrentUser(request).getId()).get();
            int freelancerID = profile.getId();
            final List<Job> jobOffers = jobOfferRepository.getJobsForFreelancer(freelancerID);
            viewObjects.put("freelancerID", freelancerID);
            viewObjects.put("jobOffers", jobOffers);
            return ViewUtil.render(request, viewObjects, Path.Template.VIEW_MATCHES);
        };
    }
}
