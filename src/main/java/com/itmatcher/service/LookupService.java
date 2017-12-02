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

    /**Returns a list of all education values
     * @return a list of all the education values in the database */
    public List <Education> getAllEducations() {
        return lookupRepository.getAllEducations();
    }

    /**Returns a list of all Work Exp values
     * @return a list of all the work experience values in the database */
    public List <WorkExp> getAllWorkExp() {
        return lookupRepository.getAllWorkExp();
    }
}
