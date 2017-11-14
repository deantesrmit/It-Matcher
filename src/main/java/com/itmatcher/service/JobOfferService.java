package com.itmatcher.service;

import com.itmatcher.domain.JobOffer;
import com.itmatcher.repository.JobOfferRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import static com.itmatcher.util.RequestUtil.getQueryParam;
import static java.lang.Integer.parseInt;

/**
 * @author Dean Tesoriero
 */
@Service
public class JobOfferService {

  @Autowired
  JobOfferRepository jobOfferRepository;

  public void createJobOffer(Request request) {
    jobOfferRepository.createJobOffer(mapJobOffer(request));
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
