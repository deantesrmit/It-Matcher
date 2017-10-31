package com.itmatcher.service;

import com.itmatcher.domain.CriteriaWeight;
import com.itmatcher.domain.Job;
import com.itmatcher.domain.Skill;
import com.itmatcher.domain.User;
import com.itmatcher.repository.JobRepository;
import com.itmatcher.repository.SkillRepository;
import com.itmatcher.util.RequestUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * Created by deant on 10/21/17.
 */
@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    SkillRepository mSkillRepository;

    public Optional<List<Job>> getJobsForUser(User user) {
        return jobRepository.getJobsByUserId(user.getId());
    }

    public Optional<Job> getJobById(int jobId) {
        return jobRepository.getJobById(jobId);
    }

    public Optional<Job> createJob(Request request) {
      Job job = new Job();
      job.setJobPosterId(RequestUtil.getSessionCurrentUser(request).getId());
      job.setTitle(getQueryParam(request, "title"));
      job.setDescription(getQueryParam(request, "description"));
      job.setEducation(getQueryParam(request, "education"));
      job.setDueDate(getQueryParam(request, "dueDate"));
      job.setBudget(getQueryParam(request, "title"));
      job.setTitle(getQueryParam(request, "title"));
      final Optional<Job> savedJob = jobRepository.saveJob(job);
      mSkillRepository.saveAllSkills(savedJob.get().getId(), mapSkills(request));
//      return job1;
      return  savedJob;
    }

  private List<Skill> mapSkills(Request request) {
    return Arrays.stream(request.queryParamsValues("skills"))
    .map(s -> new Skill(Integer.parseInt(s), CriteriaWeight.REQUIRED))
    .collect(Collectors.toList());
  }
}
