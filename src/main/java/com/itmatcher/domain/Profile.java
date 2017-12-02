package com.itmatcher.domain;

/**
 * Profile Class - represents a profile for a user
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */

public class Profile {
    private int id;
    private int userId;
    private String location;
    private String address1;
    private String suburb;
    private String state;
    private String postCode;
    private String bio;
    private int education;
    private int workExperience;

    /**Gets the ID of the profile
     * @return an int containing the ID of the profile */
    public int getId() {
        return id;
    }

    /**Sets the ID of the profile
     * @param id an int containing an ID for a profile*/
    public void setId(int id) {
        this.id = id;
    }

    /**Gets the postcode of the profile
     * @return a string containing the postcode of the profile */
    public String getPostCode() {
        return postCode;
    }

    /**Sets the postcode of the profile
     * @param postCode a string containing a postcode for a profile */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**Gets the user ID of the profile
     * @return an int containing the user ID of the profile */
    public int getUserId() {
        return userId;
    }

    /**Sets the user ID of the profile
     * @param userId an int containing a User ID for a profile*/
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**Gets the location of the profile
     * @return a string containing the location of the profile */
    public String getLocation() {
        return location;
    }

    /**Sets the location of the profile
     * @param location a str*/
    public void setLocation(String location) {
        this.location = location;
    }

    /**Gets the address of the profile
     * @return a string containing the address of the profile */
    public String getAddress1() {
        return address1;
    }

    /**Sets the address of the profile
     * @param address1 a string containing an address for a profile*/
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**Gets the profile of the profile
     * @return a string containing the profile of the profile */
    public String getSuburb() {
        return suburb;
    }

    /**Sets the suburb of the profile
     * @param suburb a string containing a suburb for a profile*/
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**Gets the state of the profile
     * @return a string containing the state of the profile */
    public String getState() {
        return state;
    }

    /**Sets the state of the profile
     * @param state a string containing a state for a profile*/
    public void setState(String state) {
        this.state = state;
    }

    /**Gets the postcode of the profile
     * @return a string containing the postcode of the profile */
    public String getPostcode() {return postCode;}

    /**Sets the postcode of the profile
     * @param postCode a string containing a postcode for a profile*/
    public void setPostcode(String postCode) {
        this.postCode = postCode;
    }

    /**Gets the bio of the profile
     * @return a string containing the bio of the profile */
    public String getBio() {
        return bio;
    }

    /**Sets the bio of the profile
     * @param bio a string containing a bio for a profile*/
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**Gets the education of the profile
     * @return a string containing the education of the profile */
    public int getEducation() {return education;}

    /**Sets the of education of the profile
     * @param education an int containing an education level for the profile*/
    public void setEducation(int education) {
        this.education = education;
    }

    /**Gets the work experience of the profile
     * @return a string containing the work experience of the profile */
    public int getWorkExperience() {
        return workExperience;
    }

    /**Sets the work experience of the profile
     * @param workExperience an int containing a work experience level for the profile*/
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
