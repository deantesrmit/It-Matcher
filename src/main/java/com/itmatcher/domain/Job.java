
package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class Job {
  private int id;
  private JobPoster jobPoster;
  private int jobPosterId;
  private List<Language> languages = new ArrayList<>();
  private List<Skill> skills = new ArrayList<>();
  private String title;
  private String description;
  private String budget;
  private String dueDate;
  private String education;
  private boolean jobAccepted = false;
  private Date jobAcceptedDate;
  private boolean jobCompleted = false;
  private Date jobCompletedDate;
  private boolean deleteStatus = false;
  private String status;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBudget() {
    return budget;
  }

  public void setBudget(String budget) {
    this.budget = budget;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public int getJobPosterId() {
    return jobPosterId;
  }

  public void setJobPosterId(int jobPosterId) {
    this.jobPosterId = jobPosterId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
