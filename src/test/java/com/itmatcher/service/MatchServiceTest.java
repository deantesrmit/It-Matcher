/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.service;

import com.itmatcher.domain.CriteriaWeight;
import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Job;
import com.itmatcher.domain.Language;
import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.domain.Skill;
import com.itmatcher.domain.WeightedCriteria;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.itmatcher.repository.FreeLancerRepository;
import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Dean Tesoriero
 */
public class MatchServiceTest {
  @Spy
  private FreeLancerRepository lancerRepository;
  @InjectMocks
  private MatchService matchService;
    
  @Before
  public void initMocks() {
      MockitoAnnotations.initMocks(this);
   }

  @Test
  public void findOneFreeLancerWithRequiredJava(){
//    when(lancerRepository.findFreeLancersByRequired(any(),any())).thenReturn(asList(mockFreeLancer("JAVA", "Sql")));

    Job job = new Job();
    job.setLanguages(asList(new Language("Java", CriteriaWeight.REQUIRED)));
    job.setSkills(asList(new Skill("Sql", CriteriaWeight.HIGH_PREFERENCE)));

    final List<ScoredFreeLancer> scoredFreeLancers = matchService.findFreelancersForJob(job);
    Assert.assertEquals(1, scoredFreeLancers.size());
    Assert.assertTrue(hasCriteria(scoredFreeLancers.get(0).getFreeLancer().getLanguages(), "Java"));
    Assert.assertEquals(5, scoredFreeLancers.get(0).getScore());
  }

  private boolean hasCriteria(List<? extends WeightedCriteria> criterias, String value) {
    if(criterias == null )return false;
    return criterias.stream().anyMatch(c -> c.getValue().equalsIgnoreCase(value));
  }

  private FreeLancer mockFreeLancer(String language, String skill) {
    FreeLancer javaFreeLancer = new FreeLancer();
    javaFreeLancer.setLanguages(asList(new Language(language)));
    javaFreeLancer.setSkills(asList(new Skill(skill)));
    return javaFreeLancer;
  }
}


