
package com.itmatcher.domain;

/**
 * Language Class - represents a language for use in job requirements
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class Language extends WeightedCriteria{

  /**Creates a language without weighting
   * @param value a string containing the name of the language */
  public Language(String value) {
    this.value = value;
  }

  /**Creates a language with the specified value and weight
   * @param value a string containing the name of the language
   * @param weight a CriteriaWeight instance that contains the weighting of the language for a job*/
  public Language(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }
}
