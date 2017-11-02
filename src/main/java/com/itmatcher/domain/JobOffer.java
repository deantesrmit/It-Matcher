package com.itmatcher.domain;

import java.util.Date;

/**
 * @author Dean Tesoriero
 */
public class JobOffer {
  private int id;
  private int jobID;
  private int freelancerID;
  private int offerStatus;
  private Date lastUpdated;

  public int getId() {
    return id;
  }

  public int getJobID() {
    return jobID;
  }

  public int getFreelancerID() {
    return freelancerID;
  }

  public int getOfferStatus() {
    return offerStatus;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setJobID(int jobID) {
    this.jobID = jobID;
  }

  public void setFreelancerID(int freelancerID) {
    this.freelancerID = freelancerID;
  }

  public void setOfferStatus(int offerStatus) {
    this.offerStatus = offerStatus;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
