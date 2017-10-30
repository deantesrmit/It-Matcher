/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.service;

import com.itmatcher.domain.JobOffer;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import java.util.Date;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * @author Dean Tesoriero
 */
@Service
public class JobOfferService {

  @Autowired
  JobOfferRepository jobOfferRepository;

    public Map<String, Object> mapNewJobOffer(String jobID, String freeLancerId) {
    Map<String, Object> params = new HashMap<>();
    Date now = new Date();
    params.put("jobId", jobID);
    params.put("freeLancerId", freeLancerId);
    params.put("offerStatus", 0);
    params.put("timeDate", now);
    return params;
  }
}
