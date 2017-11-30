
package com.itmatcher.domain;

/**
 * @author Dean Tesoriero
 */
public class Skill extends WeightedCriteria{
  private int id;

  public Skill (int id) {
    this.id = id;
  }

  public Skill(int id, String value) {
    this.id = id;
    this.value = value;
  }
  
  public Skill(String value, CriteriaWeight weight) {
    this.value = value;
    this.weight = weight;
  }
  public Skill(int id, CriteriaWeight weight) {
    this.id = id;
    this.weight = weight;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

