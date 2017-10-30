
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class Skill extends WeightedCriteria{

  public Skill(String value) {
    this.value = value;
  }
  
  public Skill(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }
}
