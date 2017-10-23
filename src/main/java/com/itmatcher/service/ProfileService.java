/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.service;

import com.itmatcher.domain.Profile;
import com.itmatcher.repository.ProfileRepository;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spark.Request;
import static com.itmatcher.util.RequestUtil.getQueryParam;

/**
 * @author Dean Tesoriero
 */
@Service
public class ProfileService {

  @Autowired
  ProfileRepository profileRepository;

  public Profile getProfileByUserId(int userId) {
    return profileRepository.getProfileByUserID(userId);
  }

  public void updateProfile(Request request) {
    Profile profile = profileRepository.getProfileByUserID(RequestUtil.getSessionCurrentUser(request).getId());
    mapProfile(request, profile);
    profileRepository.updateProfile(profile);
  }

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
    profile.setPostcode(getQueryParam (request, "Postcode"));
    profile.setWorkExperience(getQueryParam (request, "experience"));
    profile.setEducation(getQueryParam (request, "education"));
    profile.setBio(getQueryParam (request, "bio"));
  }
}
