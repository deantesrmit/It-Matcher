package com.itmatcher.service;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.User;
import com.itmatcher.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import spark.Request;
import static com.itmatcher.util.RequestUtil.getQueryParam;

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

    public void createJob(Request request) {
      final String title = getQueryParam(request, "title");
      final String description = getQueryParam(request, "description");
      final String skills = getQueryParam(request, "skills");
      final String education = getQueryParam(request, "education");
      final String dateRequired = getQueryParam(request, "dateRequired");
      final String dueDate = getQueryParam(request, "dueDate");
      final String budget = getQueryParam(request, "budget");
    }
}
