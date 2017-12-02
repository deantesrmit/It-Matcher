package com.itmatcher.service;

import com.itmatcher.domain.JobOffer;
import com.itmatcher.repository.JobOfferRepository;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import static java.lang.Integer.parseInt;

/**
 * JobOfferService Class - Repository for functions related to job offers
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class JobOfferService {

  @Autowired
  JobOfferRepository jobOfferRepository;

  public void createOrUpdateJobOffer(Request request) {
    final int freeLancerId = parseInt(getQueryParam(request, "freeLancerId"));
    final int jobId = parseInt(getQueryParam(request, "jobId"));
    final int offerStatus = parseInt(getQueryParam(request, "offerStatus"));
    final Optional<JobOffer> maybeOffer = jobOfferRepository.findOfferByFreeLancerIdJobId(freeLancerId, jobId);
    if(!maybeOffer.isPresent()) {
      jobOfferRepository.createJobOffer(mapJobOffer(request));
    } else {
      final JobOffer jobOffer = maybeOffer.get();
      jobOffer.setOfferStatus(offerStatus);
      jobOfferRepository.updateJobOffer(jobOffer);
    }
  }

  private JobOffer mapJobOffer(Request request) {
    JobOffer jobOffer = new JobOffer();
    jobOffer.setFreelancerID(parseInt(getQueryParam(request, "freeLancerId")));
    jobOffer.setJobID(parseInt(getQueryParam(request, "jobId")));
    jobOffer.setLastUpdated(new Date());
    jobOffer.setOfferStatus(parseInt(getQueryParam(request, "offerStatus")));
    return jobOffer;
  }
}
