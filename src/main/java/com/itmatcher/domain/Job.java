
package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Job Class - represents a job posted by a job poster
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
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

  /**Gets the jobPoster of the job
   * @return an instance of a jobPoster for a job*/
  public JobPoster getJobPoster() {
    return jobPoster;
  }

  /**Sets the job poster instance of the job
   * @param jobPoster an instance of a job poster */
  public void setJobPoster(JobPoster jobPoster) {
    this.jobPoster = jobPoster;
  }

  /**Gets the languages required for the job
   * @return a list containing the required languages for a job*/
  public List<Language> getLanguages() {
    return languages;
  }

  /**Sets the languages required of the job
   * @param languages a list containing a selection of languages for a job*/
  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  /**Gets the required skills of the job
   * @return a list containing the required skills for a job*/
  public List<Skill> getSkills() {
    return skills;
  }

  /**Sets the skills required of the job
   * @param skills a list containing the required skills for a job */
  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  /**Gets the ID of the job
   * @return a int containing the ID for a job*/
  public int getId() {
    return id;
  }

  /**Sets the ID of the job
   * @param id an int containing an id for a job*/
  public void setId(int id) {
    this.id = id;
  }

  /**Gets the description of the job
   * @return a string containing the description for a job*/
  public String getDescription() {
    return description;
  }

  /**Sets the description of the job
   * @param description a string containing a description for a job */
  public void setDescription(String description) {
    this.description = description;
  }

  /**Gets the Accepted status of the job
   * @return a boolean containing the accepted status for a job*/
  public boolean isJobAccepted() {
    return jobAccepted;
  }

  /**Sets the job accepted status of the job
   * @param jobAccepted a boolean containing the accepted status of a job*/
  public void setJobAccepted(boolean jobAccepted) {
    this.jobAccepted = jobAccepted;
  }

  /**Gets the accepted date of the job
   * @return a date containing the accepted date for a job*/
  public Date getJobAcceptedDate() {
    return jobAcceptedDate;
  }

  /**Sets the accepted date of a job of the job
   * @param jobAcceptedDate a date containing the accepted date for a job*/
  public void setJobAcceptedDate(Date jobAcceptedDate) {
    this.jobAcceptedDate = jobAcceptedDate;
  }

  /**Gets the completion status of the job
   * @return a boolean containing the completed status for a job*/
  public boolean isJobCompleted() {
    return jobCompleted;
  }

  /**Sets the completed status of the job
   * @param jobCompleted a boolean containing the completed status of a job*/
  public void setJobCompleted(boolean jobCompleted) {
    this.jobCompleted = jobCompleted;
  }

  /**Gets the completed date of the job
   * @return a date containing the completed date for a job*/
  public Date getJobCompletedDate() {
    return jobCompletedDate;
  }

  /**Sets the job completed date of the job
   * @param jobCompletedDate a date containing the completed date for a job*/
  public void setJobCompletedDate(Date jobCompletedDate) {
    this.jobCompletedDate = jobCompletedDate;
  }

  /**Gets the deleted status of the job
   * @return a boolean containing the deleted status for a job*/
  public boolean isDeleteStatus() {
    return deleteStatus;
  }

  /**Sets the deleted status of the job
   * @param deleteStatus a boolean containing the deleted status for a job*/
  public void setDeleteStatus(boolean deleteStatus) {
    this.deleteStatus = deleteStatus;
  }

  /**Gets the title of the job
   * @return a string containing the title for a job*/
  public String getTitle() {
    return title;
  }

  /**Sets the title of the job
   * @param title a string containing a title for the job*/
  public void setTitle(String title) {
    this.title = title;
  }

  /**Gets the budget of the job
   * @return a string containing the budget for a job*/
  public String getBudget() {
    return budget;
  }

  /**Sets the budget of the job
   * @param budget a string containing the budget for the job*/
  public void setBudget(String budget) {
    this.budget = budget;
  }

  /**Gets the due date of the job
   * @return a string containing the due date for a job*/
  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  /**Gets the education level of the job
   * @return a string containing the education level required for a job*/
  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  /**Gets the job posted IF of the job
   * @return an int containing the job poster ID for a job*/
  public int getJobPosterId() {
    return jobPosterId;
  }

  /**Sets the job posted IF of the job
   * @param jobPosterId an int containing a job posted ID for a job*/
  public void setJobPosterId(int jobPosterId) {
    this.jobPosterId = jobPosterId;
  }

  /**Gets the status of the job
   * @return a string containing the status for a job*/
  public String getStatus() {
    return status;
  }

  /**Sets the status of the job
   * @param status a string containing the status for a job*/
  public void setStatus(String status) {
    this.status = status;
  }
}
