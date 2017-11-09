
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class ScoredFreeLancer {
  FreeLancer freeLancer;
  int score;
  boolean hasOffer;

  public ScoredFreeLancer(FreeLancer freeLancer, int weight) {
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

  public boolean isHasOffer() {
    return hasOffer;
  }

  public void setHasOffer(boolean hasOffer) {
    this.hasOffer = hasOffer;
  }
}
