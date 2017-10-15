/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public enum CriteriaWeight {
  REQUIRED(10),
  HIGH_PREFERENCE(5),
  LOW_PREFERENCE(1);

  public int score;

  CriteriaWeight(int score) {
    this.score = score;
  }
}
