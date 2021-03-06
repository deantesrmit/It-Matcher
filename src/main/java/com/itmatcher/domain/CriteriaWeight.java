
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

  public static CriteriaWeight fromScore(int score) {
    for (CriteriaWeight crit : CriteriaWeight.values()) {
      if(crit.score == score) return crit;
    }
    throw new RuntimeException("Unable to find code for Weighted criteria for score " + score);
  }
}
