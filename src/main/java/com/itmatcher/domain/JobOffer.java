package com.itmatcher.domain;

import java.util.Date;

/**
 * JobOffer Class - represents a Job Offer status for a job
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class JobOffer {
  private int id;
  private int jobID;
  private int freelancerID;
  private int offerStatus;
  private Date lastUpdated;


  /**Gets the ID of the job offer
   * @return an int containing the ID of the job offer */
  public int getId() {
    return id;
  }

  /**Gets the job ID of the job offer
   * @return an int containing job ID of the job offer */
  public int getJobID() {
    return jobID;
  }

  /**Gets the freelancerID of the job offer
   * @return an int containing freelancer ID of the job offer */
  public int getFreelancerID() {
    return freelancerID;
  }

  /**Gets the offer status of the job offer
   * @return an int containing offer status of the job offer */
  public int getOfferStatus() {
    return offerStatus;
  }

  /**Gets the last updated date of the job offer
   * @return a date containing last updated date of the job offer */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**Sets the ID of the job offer
   * @param id an int containing an ID for a job offer*/
  public void setId(int id) {
    this.id = id;
  }

  /**Sets the jobID of the job offer
   * @param jobID an int containg the jobID for a job offer*/
  public void setJobID(int jobID) {
    this.jobID = jobID;
  }

  /**Sets the freelancer ID of the job offer
   * @param freelancerID an int containing the freelancerID for a job offer*/
  public void setFreelancerID(int freelancerID) {
    this.freelancerID = freelancerID;
  }

  /**Sets the offer status of the job offer
   * @param offerStatus an int containing the offer status of the job offer*/
  public void setOfferStatus(int offerStatus) {
    this.offerStatus = offerStatus;
  }

  /**Sets the last updated date of the job offer
   * @param lastUpdated a date containing a last updated date for a job offer*/
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
