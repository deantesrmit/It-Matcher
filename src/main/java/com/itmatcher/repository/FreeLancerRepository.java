/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.repository;


import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Language;
import com.itmatcher.domain.Skill;

import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class FreeLancerRepository {
  public List<FreeLancer> findFreeLancersByRequired(List<Language> requiredLanguages, List<Skill> requiredSkills) {
    return null;
  }
}
