package com.itmatcher.domain;

public class Profile {
    private int profileID;
    private int userId;
    private String location;
    private String address1;
    private String suburb;
    private String state;
    private String postcode;
    private String bio;
    private String education;
    private String workExperience;

    public int getProfileID() {return profileID;}
    public int getUserId() {return userId;}
    public String getLocation() {return location;}
    public String getAddress1() {return address1;}
    public String getSuburb() {return suburb;}
    public String getState() {return state;}
    public String getPostcode() {return postcode;}
    public String getBio() {return bio;}
    public String getEducation() {return education;}
    public String getWorkExperience() {return workExperience;}

    public void setProfileID(int profileID) {this.profileID = profileID;}
    public void setUserId(int userId) {this.userId = userId;}
    public void setLocation(String location) {this.location= location;}
    public void setAddress1 (String address1) {this.address1 = address1;}
    public void setSuburb(String suburb) {this.suburb = suburb;}
    public void setState(String state) {this.state = state;}
    public void setPostcode(String postcode) {this.postcode = postcode;}
    public void setBio(String bio) {this.bio = bio;}
    public void setEducation(String education) {this.education = education;}
    public void setWorkExperience(String workExperience) {this.workExperience = workExperience;}

}
