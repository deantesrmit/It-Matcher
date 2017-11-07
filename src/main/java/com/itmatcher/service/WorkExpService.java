package com.itmatcher.service;

import com.itmatcher.domain.WorkExp;
import com.itmatcher.repository.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

/**
 * Created by deant on 10/24/17.
 */
@Service
public class WorkExpService {
    @Autowired
    LookupRepository lookupRepository;

    public Optional <List<WorkExp>> getAllWorkExp() {
        return lookupRepository.getAllWorkExp();
    }
}
