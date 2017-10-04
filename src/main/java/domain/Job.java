/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package domain;

import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class Job {
  private JobPoster jobPoster;
  private List<Language> languages;
  private List<Skill> skills;

  public JobPoster getJobPoster() {
    return jobPoster;
  }

  public void setJobPoster(JobPoster jobPoster) {
    this.jobPoster = jobPoster;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }
}
