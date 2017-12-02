
package com.itmatcher.domain;

/**
 * WeightedCriteria Class - represents the weighted criteria for a posted job
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class WeightedCriteria {
  String value;
  CriteriaWeight weight;

  public WeightedCriteria() {
  }

  /**Creates a Weighted Criteria element with the following parameters
   * @param value a string containing the value of the weighted criteria
   * @param weight a CriteriaWeight instance*/
  public WeightedCriteria(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }

  /**Gets the weight
   * @return a CriteriaWeight instance containing the weight*/
  public CriteriaWeight getWeight() {
    return weight;
  }

  /**Sets the weight of the CriteriaWeight instance
   * @param weight a CriteriaWeight instance containing the weight */
  public void setWeight(CriteriaWeight weight) {
    this.weight = weight;
  }

  /**Gets the value
   * @return a string containing the value of the Weighted Criteria*/
  public String getValue() {
    return value;
  }

  /**Sets the value of the WeightedCriteria instance
   * @param value a string containing a value for a WeightedCriteria*/
  public void setValue(String value) {
    this.value = value;
  }
}
