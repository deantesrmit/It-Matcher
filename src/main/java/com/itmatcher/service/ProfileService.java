
package com.itmatcher.service;

import com.itmatcher.domain.Profile;
import com.itmatcher.repository.ProfileRepository;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;

import java.util.Optional;

import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * ProfileService Class - Repository for functions related to profiles
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class ProfileService {

  @Autowired
  ProfileRepository profileRepository;

  /**Returns a profile based on the user ID presented
   * @param userId an int containing a user ID
   * @return a profile based on the user ID that was entered*/
  public Optional<Profile> getProfileByUserId(int userId) {
    return profileRepository.getProfileByUserID(userId);
  }


  /**Updates the profile with the current session elements
   * @param request the users current request session */
  public void updateProfile(Request request) {
    Profile profile = profileRepository.getProfileByUserID(RequestUtil.getSessionCurrentUser(request).getId()).get();
    mapProfile(request, profile);
    profileRepository.updateProfile(profile);
  }

  /**Creates the profile with the current session elements
   * @param request the users current request session */
  public void createProfile(Request request) {
    Profile profile = new Profile();
    mapProfile(request, profile);
    profileRepository.createProfile(profile);
  }

  private void mapProfile(Request request, Profile profile) {
    profile.setUserId(RequestUtil.getSessionCurrentUser(request).getId());
    profile.setLocation(getQueryParam(request, "location"));
    profile.setAddress1(getQueryParam(request, "address1"));
    profile.setSuburb(getQueryParam(request, "suburb"));
    profile.setState(getQueryParam (request, "state"));
    profile.setPostcode(getQueryParam (request, "postCode"));
    if (getQueryParam(request, "workExperience") != null) {profile.setWorkExperience(Integer.parseInt(getQueryParam(request, "workExperience")));}
    if (getQueryParam(request, "education") != null) {profile.setEducation(Integer.parseInt(getQueryParam(request, "education")));}
    profile.setBio(getQueryParam (request, "bio"));
  }
}
