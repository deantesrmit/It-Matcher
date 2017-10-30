
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class WeightedCriteria {
  String value;
  CriteriaWeight weight;

  public CriteriaWeight getWeight() {
    return weight;
  }

  public void setWeight(CriteriaWeight weight) {
    this.weight = weight;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
