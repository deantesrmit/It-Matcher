package com.itmatcher.service;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.User;
import com.itmatcher.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by deant on 10/21/17.
 */
@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    public Optional<List<Job>> getJobsForUser(User user) {
        return jobRepository.getJobsByUserId(user.getId());
    }

    public Optional<Job> getJobById(int jobId) {
        return jobRepository.getJobById(jobId);
    }
}
