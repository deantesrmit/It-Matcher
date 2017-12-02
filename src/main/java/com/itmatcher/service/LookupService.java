package com.itmatcher.service;

import com.itmatcher.domain.Education;
import com.itmatcher.domain.WorkExp;
import com.itmatcher.repository.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

/**
 * LookupService Class - Repository for functions related to lookups
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class LookupService {
    @Autowired

    LookupRepository lookupRepository;

    public List <Education> getAllEducations() {
        return lookupRepository.getAllEducations();
    }

    public List <WorkExp> getAllWorkExp() {
        return lookupRepository.getAllWorkExp();
    }
}
