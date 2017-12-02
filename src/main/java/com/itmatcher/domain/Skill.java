
package com.itmatcher.domain;

/**
 * Skill Class - represents a Skill for a job
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */

public class Skill extends WeightedCriteria{
  private int id;

  /**Creates a skill without a name value
   * @param id an int containing an ID for a skill */
  public Skill (int id) {
    this.id = id;
  }

  /**Creates a language with the ID and value entered
   * @param id an int containing an ID for a skill
   * @param value a string containing the name of the language */
  public Skill(int id, String value) {
    this.id = id;
    this.value = value;
  }

  /**Creates a language with the value and weighting entered
   * @param weight a CriteriaWeight element with a weight for the skill
   * @param value a string containing the name of the language */
  public Skill(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }
  /**Creates a language with the ID and weighting entered
   * @param weight a CriteriaWeight element with a weight for the skill
   * @param id an int containing an ID for a skill */
  public Skill(int id, CriteriaWeight weight) {
    this.id = id;
    this.weight = weight;
  }

  /**Gets the ID of the Skill
   * @return an int containing the ID of the skill */
  public int getId() {
    return id;
  }

  /**Sets the ID of the Skill
   * @param id an int containing an ID for a skill*/
  public void setId(int id) {
    this.id = id;
  }
}

