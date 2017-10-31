package com.itmatcher.service;

import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Job;
import com.itmatcher.domain.Language;
import com.itmatcher.domain.ScoredFreeLancer;
import com.itmatcher.domain.Skill;
import com.itmatcher.domain.WeightedCriteria;
import com.itmatcher.repository.FreeLancerRepository;
import com.itmatcher.repository.JobRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.itmatcher.domain.CriteriaWeight.REQUIRED;

/**
 * @author Dean Tesoriero
 */
@Service
public class MatchService {

  @Autowired
  private FreeLancerRepository lancerRepository;
  @Autowired
  private JobRepository jobRepository;

  public List<ScoredFreeLancer> findFreelancersForJob(int jobId) {
    final Job job = jobRepository.getJobById(jobId).get();
//    job.setLanguages(asList(new Language("Java", CriteriaWeight.REQUIRED)));
//    job.setSkills(asList(new Skill("Sql", CriteriaWeight.HIGH_PREFERENCE)));
    final List<Language> requiredLanguages = getRequiredFields(job.getLanguages(), Language.class);
    final List<Skill> requiredSkills = getRequiredFields(job.getSkills(), Skill.class);
    final List<FreeLancer> flByRequired = lancerRepository.findFreeLancersByRequired(requiredLanguages, requiredSkills);

    return calculateFLWeight(job, flByRequired);
  }

  private List<ScoredFreeLancer> calculateFLWeight(Job job, List<FreeLancer> flByRequired) {
    List<ScoredFreeLancer> scoredFreeLancers = new ArrayList<>(flByRequired.size());
    for (FreeLancer freeLancer : flByRequired) {
      final int langScore = calculatePoints(job.getLanguages(), freeLancer.getLanguages(), freeLancer);
      final int skillScore = calculatePoints(job.getSkills(), freeLancer.getSkills(), freeLancer);
      scoredFreeLancers.add(new ScoredFreeLancer(freeLancer, langScore + skillScore));
    }
    return scoredFreeLancers;
  }

  private int calculatePoints(List<? extends WeightedCriteria> jobCriterias, List<? extends WeightedCriteria> flCriterias, FreeLancer freeLancer) {
    int weight = 0;
    for (WeightedCriteria jobCriteria : jobCriterias) {
      final boolean containsJobCriteria = flCriterias.stream().anyMatch(fc -> jobCriteria.getValue().equalsIgnoreCase(fc.getValue()));
      if(flCriterias != null && containsJobCriteria){
        weight += jobCriteria.getWeight().score;
        freeLancer.getMatchedSkills().add((Skill)jobCriteria);
      }
    }
    return weight;
  }
  private <T> List<T> getRequiredFields(List<? extends WeightedCriteria> criterias, Class<T> clazz) {
    return criterias.stream().filter(l -> REQUIRED.equals(l.getWeight())).map(clazz::cast).collect(Collectors.toList());
  }
}
