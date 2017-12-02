package com.itmatcher.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Freelancer Class - represents a freelancer user
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
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


    /** A list containing a list of all the languages
     * @return a list containing a list of all the languages */
    public List<Language> getLanguages() {
        if(languages == null)
            languages = new ArrayList<>();
        return languages;
    }
    /**Sets the languages for the current freelancer
     * @param languages a list containing a selection of languages */
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    /**Returns the skills for the current selected freelancer
     * @return a list of skills for the currently selected freelancer */
    public List<Skill> getSkills() {
        if(skills == null)
            skills = new ArrayList<>();
        return skills;
    }

    /**Sets the skills for the current selected freelancer
     * @param skills a list of skills that will be entered for the freelancer */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**Return the current freelancers ID
     * @return an int that contains the current freelancers ID */
    public int getId() {
        return id;
    }

    /**Sets the ID for the current freelancer
     * @param id an int that represents a freelancer ID number */
    public void setId(int id) {
        this.id = id;
    }

    /**Gets the experience level of the freelancer
     * @return a string containing the experience level */
    public String getExperience() {
        return experience;
    }

    /**Sets the experience level for the freelancer
     * @param experience a string containing an the experience for a freelancer */
    public void setExperience(String experience) {
        this.experience = experience;
    }

    /**Gets the education level of the freelancer
     * @return a string containing the education level of the freelancer */
    public String getEducation() {
        return education;
    }

    /**Sets the education level of the freelancer
     * @param education a string containing an education level for a freelancer */
    public void setEducation(String education) {
        this.education = education;
    }

    /**Gets the name of the freelancer
     * @return a string with the name of the freelancer */
    public String getName() {
        return name;
    }

    /**Sets the name of the freelancer
     * @param name a string containing the name of the freelancer */
    public void setName(String name) {
        this.name = name;
    }

    /**Gets the bio of the freelancer
     * @return a string containing the bio of the freelancer */
    public String getBio() {return bio;}

    /**Sets the bio for a freelancer
     * @param bio a string containing a bio for a freelancer */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**Gets the userID for the current freelancer to match with the User class
     * @return an int containing the freelancers user ID */
    public int getUserID() {
        return userID;
    }

    /**Sets the userID
     * @param userID an int containing a userID for a freelancer */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**Gets the location of the freelancer
     * @return a string containing the location of the freelancer */
    public String getLocation() {return location;}

    /**Sets the location of the freelancer
     * @param location a string containing a location for a freelancer */
    public void setLocation(String location) {this.location = location;}

    /**Gets the address of the freelancer
     * @return a string containing the address of a freelancer */
    public String getAddress1() {return address1;}

    /**Sets the address of a freelancer
     * @param address1 a string containing a location for a freelancer */
    public void setAddress1(String address1) {this.address1 = address1; }

    /**Gets the suburb of a freelancer
     * @return a string containing the suburb of a freelancer */
    public String getSuburb() {return suburb;}

    /**Sets the suburb for a freelancer
     * @param suburb a string containing a suburb for a freelancer */
    public void setSuburb(String suburb) {this.suburb = suburb;}

    /**Gets the current state (NSW/QLD etc) for a freelancer
     * @return the state for a freelancer*/
    public String getState() {return state;}

    /**Sets the current state (NSW/QLD etc) for a freelancer
     * @param state a string containing a state for a freelancer */
    public void setState(String state) {this.state = state;}

    /**Gets the postcode for a freelancer
     * @return a string containing a postcode for a freelancer */
    public String getPostCode() {return postCode;}

    /**Sets the postcode for a freelancer
     * @param postcode a string containing a postcode for a freelancer */
    public void setPostCode(String postcode) {this.postCode = postCode;}

    /**Gets the matched skills for a freelancer and a job
     * @return a list containing the matched skills for a freelancer and a job */
    public List<Skill> getMatchedSkills() {
        if(matchedSkills == null)
            this.matchedSkills = new ArrayList<>();
        return matchedSkills;
    }

    /**Sets the matched skills for a freelancer and a job
     * @param matchedSkills a list containing matched skills for a freelancer */
    public void setMatchedSkills(List<Skill> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }
}