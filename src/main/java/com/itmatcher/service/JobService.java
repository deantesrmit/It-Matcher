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
 * JobService Class - Repository for functions related to Job Services
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    SkillRepository mSkillRepository;

    /**Returns the current jobs for a user based on user presented
     * @param user a filled user class
     * @return returns a list of the matched jobs for that user based on ID*/
    public Optional<List<Job>> getJobsForUser(User user) {
        return jobRepository.getJobsByUserId(user.getId());
    }

    /**Returns the current job based on job ID presented
     * @param jobId an int containing a job ID
     * @return returns the matched job */
    public Optional<Job> getJobById(int jobId) {
        return jobRepository.getJobById(jobId);
    }

    /**Creates the current job based on the parameters in the html form
     * @param request a request with the users current session
     * @return returns the saved job once completed */
    public Optional<Job> createJob(Request request) {
      Job job = new Job();
      job.setJobPosterId(RequestUtil.getSessionCurrentUser(request).getId());
      job.setTitle(getQueryParam(request, "title"));
      job.setDescription(getQueryParam(request, "description"));
      job.setEducation(getQueryParam(request, "education"));
      job.setDueDate(getQueryParam(request, "dueDate"));
      job.setBudget(getQueryParam(request, "budget"));
      job.setTitle(getQueryParam(request, "title"));
      final Optional<Job> savedJob = jobRepository.saveJob(job);
      mSkillRepository.saveAllSkills(savedJob.get().getId(), mapSkills(request));
      return  savedJob;
    }

  private List<Skill> mapSkills(Request request) {
    return Arrays.stream(request.queryParamsValues("skillsInput"))
    .map(s -> new Skill(Integer.parseInt(s), CriteriaWeight.REQUIRED))
    .collect(Collectors.toList());
  }

  /**Maps the freelancer skills
   * @param request a request with the users current session
   * @return Sets the required skills to the freelancer based on the HTML form */
  public List<Skill> mapFreelancerSkills(Request request) {
      return Arrays.stream(request.queryParamsValues("skillsInput"))
              .map(s -> new Skill(Integer.parseInt(s)))
              .collect(Collectors.toList());
  }
}
