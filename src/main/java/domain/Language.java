/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package domain;

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
