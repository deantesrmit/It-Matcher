package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean Tesoriero
 */
public class FreeLancer {
    private int id;
    private int userID;
    private String location;
    private String address1;
    private String suburb;
    private String state;
    private String postCode;
    private List<Language> languages;
    private List<Skill> skills;
    private List<Skill> matchedSkills;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBio() {return bio;}
    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getAddress1() {return address1;}
    public void setAddress1(String address1) {this.address1 = address1; }

    public String getSuburb() {return suburb;}
    public void setSuburb(String suburb) {this.suburb = suburb;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public String getPostCode() {return postCode;}
    public void setPostCode(String postcode) {this.postCode = postCode;}

    public List<Skill> getMatchedSkills() {
        if(matchedSkills == null)
            this.matchedSkills = new ArrayList<>();
        return matchedSkills;
    }
    
    public void setMatchedSkills(List<Skill> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }
}