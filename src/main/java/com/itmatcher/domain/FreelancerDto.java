
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class FreelancerDto {
  FreeLancer freeLancer;
  int score;
  JobOffer offer;

  public FreelancerDto(FreeLancer freeLancer, int weight) {
    this.freeLancer = freeLancer;
    this.score = weight;
  }

  public FreeLancer getFreeLancer() {
    return freeLancer;
  }

  public void setFreeLancer(FreeLancer freeLancer) {
    this.freeLancer = freeLancer;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public JobOffer getOffer() {
    return offer;
  }

  public void setOffer(JobOffer offer) {
    this.offer = offer;
  }
}
