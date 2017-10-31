package com.itmatcher.service;

import com.itmatcher.domain.JobOffer;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import java.util.Date;


import java.util.Optional;

import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * @author Dean Tesoriero
 */
@Service
public class JobOfferService {

  @Autowired
  JobOfferRepository jobOfferRepository;

  public void CreateJobOffer(Request request) {
    JobOffer jobOffer = new JobOffer();
    mapNewJobOffer(request, jobOffer);
    jobOfferRepository.createJobOffer(jobOffer);
  }

  private void mapNewJobOffer(Request request, JobOffer jobOffer) {
    String jobID = getQueryParam(request, "jobID");
    String freelancerID = getQueryParam(request, "freelancerID");
    Date now = new Date();

    jobOffer.setJobID(Integer.parseInt(jobID.trim()));
    jobOffer.setFreelancerID(Integer.parseInt(freelancerID.trim()));
    jobOffer.setOfferStatus(0);
    jobOffer.setLastUpdated(now);
  }
}
