/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class ScoredFreeLancer {
  FreeLancer freeLancer;
  int score;

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
}
