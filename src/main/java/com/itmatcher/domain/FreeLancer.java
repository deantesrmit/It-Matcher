/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class FreeLancer {
  private long id;
  private long userID;
  private List<Language> languages;
  private List<Skill> skills;
  private String experience;
  private String education;
  private String name;
  private String bio;

  public List<Language> getLanguages() {
    if(languages == null)
      languages = new ArrayList<>();
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  public List<Skill> getSkills() {
    if(skills == null)
      skills = new ArrayList<>();
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public long getUserID() {
    return userID;
  }

  public void setUserID(long userID) {
    this.userID = userID;
  }
}
