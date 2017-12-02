package com.itmatcher.service;

import com.itmatcher.domain.*;
import com.itmatcher.repository.FreeLancerRepository;
import com.itmatcher.repository.JobOfferRepository;
import com.itmatcher.repository.JobRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.itmatcher.domain.CriteriaWeight.REQUIRED;

/**
 * MatchService Class - Repository for functions related to the Matchmaking function
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class MatchService {

  @Autowired
  private FreeLancerRepository lancerRepository;
  @Autowired
  private JobRepository jobRepository;
  @Autowired
  private JobOfferRepository offerRepository;

  /**Finds freelancers for a particular job based on ID
   * @param jobId an int containing a job ID
   * @return returns a List of FreelancerDto's for the particular job*/
  public List<FreelancerDto> findFreelancersForJob(int jobId) {
    final Job job = jobRepository.getJobById(jobId).get();
    final List<Language> requiredLanguages = getRequiredFields(job.getLanguages(), Language.class);
    final List<Skill> requiredSkills = getRequiredFields(job.getSkills(), Skill.class);
    final List<FreeLancer> freeLancers = lancerRepository.findFreeLancersByRequired(requiredLanguages, requiredSkills);
    final List<FreelancerDto> freelancerDtos = calculateFLWeight(job, freeLancers);
    freelancerDtos.stream().forEach(
        f -> f.setOffer(offerRepository.findOfferByFreeLancerIdJobId(f.getFreeLancer().getId(), jobId).orElse(null))
    );
    return freelancerDtos;
  }

  private List<FreelancerDto> calculateFLWeight(Job job, List<FreeLancer> flByRequired) {
    List<FreelancerDto> freelancerDtos = new ArrayList<>(flByRequired.size());
    for (FreeLancer freeLancer : flByRequired) {
      final int langScore = calculatePoints(job.getLanguages(), freeLancer.getLanguages(), freeLancer);
      final int skillScore = calculatePoints(job.getSkills(), freeLancer.getSkills(), freeLancer);
      freelancerDtos.add(new FreelancerDto(freeLancer, langScore + skillScore));
    }
    return freelancerDtos;
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
