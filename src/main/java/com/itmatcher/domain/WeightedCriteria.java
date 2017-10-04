/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
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
