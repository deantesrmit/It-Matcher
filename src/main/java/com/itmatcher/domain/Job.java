
package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class Job {
  private long id;
  private JobPoster jobPoster;
  private List<Language> languages = new ArrayList<>();
  private List<Skill> skills = new ArrayList<>();
  private String description;
  private boolean jobAccepted = false;
  private Date jobAcceptedDate;
  private boolean jobCompleted = false;
  private Date jobCompletedDate;
  private boolean deleteStatus = false;

  public JobPoster getJobPoster() {
    return jobPoster;
  }

  public void setJobPoster(JobPoster jobPoster) {
    this.jobPoster = jobPoster;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isJobAccepted() {
    return jobAccepted;
  }

  public void setJobAccepted(boolean jobAccepted) {
    this.jobAccepted = jobAccepted;
  }

  public Date getJobAcceptedDate() {
    return jobAcceptedDate;
  }

  public void setJobAcceptedDate(Date jobAcceptedDate) {
    this.jobAcceptedDate = jobAcceptedDate;
  }

  public boolean isJobCompleted() {
    return jobCompleted;
  }

  public void setJobCompleted(boolean jobCompleted) {
    this.jobCompleted = jobCompleted;
  }

  public Date getJobCompletedDate() {
    return jobCompletedDate;
  }

  public void setJobCompletedDate(Date jobCompletedDate) {
    this.jobCompletedDate = jobCompletedDate;
  }

  public boolean isDeleteStatus() {
    return deleteStatus;
  }

  public void setDeleteStatus(boolean deleteStatus) {
    this.deleteStatus = deleteStatus;
  }
}
