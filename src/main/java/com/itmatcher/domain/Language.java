
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class Language extends WeightedCriteria{
  public Language(String value) {
    this.value = value;
  }

  public Language(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }
}
