package com.itmatcher.service;/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */

import com.itmatcher.domain.*;
import com.itmatcher.repository.FreeLancerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.itmatcher.domain.CriteriaWeight.REQUIRED;

/**
 * @author Dean Tesoriero
 */
public class MatchService {

  private FreeLancerRepository lancerRepository = new FreeLancerRepository();

  public List<ScoredFreeLancer> findFreelancersForJob(Job job) {
    final List<Language> requiredLanguages = getRequiredFields(job.getLanguages(), Language.class);
    final List<Skill> requiredSkills = getRequiredFields(job.getSkills(), Skill.class);
    final List<FreeLancer> flByRequired = lancerRepository.findFreeLancersByRequired(requiredLanguages, requiredSkills);

    return calculateFLWeight(job, flByRequired);
  }

  private List<ScoredFreeLancer> calculateFLWeight(Job job, List<FreeLancer> flByRequired) {
    List<ScoredFreeLancer> scoredFreeLancers = new ArrayList<>(flByRequired.size());
    for (FreeLancer freeLancer : flByRequired) {
      final int langScore = calculatePoints(job.getLanguages(), freeLancer.getLanguages());
      final int skillScore = calculatePoints(job.getSkills(), freeLancer.getSkills());
      scoredFreeLancers.add(new ScoredFreeLancer(freeLancer, langScore + skillScore));
    }
    return scoredFreeLancers;
  }

  private int calculatePoints(List<? extends WeightedCriteria> jobCriterias, List<? extends WeightedCriteria> flCriterias) {
    int weight = 0;
    for (WeightedCriteria jobCriteria : jobCriterias) {
      if(flCriterias != null && flCriterias.stream().anyMatch(fc -> jobCriteria.getValue().equalsIgnoreCase(fc.getValue()))){
        weight += jobCriteria.getWeight().score;
      }
    }
    return weight;
  }
  private <T> List<T> getRequiredFields(List<? extends WeightedCriteria> criterias, Class<T> clazz) {
    return criterias.stream().filter(l -> REQUIRED.equals(l.getWeight())).map(clazz::cast).collect(Collectors.toList());
  }

  public void setLancerRepository(FreeLancerRepository lancerRepository) {
    this.lancerRepository = lancerRepository;
  }
}
