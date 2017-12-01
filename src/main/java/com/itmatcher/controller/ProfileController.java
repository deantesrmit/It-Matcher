package com.itmatcher.controller;

import com.itmatcher.domain.Profile;
import com.itmatcher.domain.User;
import com.itmatcher.domain.WorkExp;
import com.itmatcher.domain.Education;
import com.itmatcher.domain.Job;
import com.itmatcher.domain.Skill;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.repository.SkillRepository;
import com.itmatcher.service.EducationService;
import com.itmatcher.service.JobService;
import com.itmatcher.service.LookupService;
import com.itmatcher.service.ProfileService;
import com.itmatcher.service.WorkExpService;
import com.itmatcher.service.EducationService;
import com.itmatcher.type.AccountType;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import static com.itmatcher.util.RequestUtil.getSessionCurrentUser;

/**
 * ProfileController - a class for handling the serving and posting of the profile feature
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Component
public class ProfileController {
    @Autowired
    JobService jobService;
    @Autowired
    ProfileService profileService;
    @Autowired
    LookupService lookupService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WorkExpService workExpService;
    @Autowired
    EducationService educationService;
    @Autowired
    SkillRepository skillRepository;

    public Route serveProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            final AccountType accountType = RequestUtil.getAccountType(request);
            Map<String, Object> params = new HashMap<>();
            final Optional<Profile> profile = profileService.getProfileByUserId(RequestUtil.getSessionCurrentUser(request).getId());
            String username1 = getSessionCurrentUser(request).getUsername();
            User test = (userRepository.getUserByUserName(username1)).get();
            if (!profile.isPresent()) {
                response.redirect(Path.Web.EDIT_PROFILE);
                return Spark.redirect;
            }

            int exp = profile.get().getWorkExperience();
            int edu = profile.get().getEducation();
            final Optional<WorkExp> workExp = workExpService.getValueWorkExperience(profile.get().getWorkExperience());
            final Optional<Education> education = educationService.getValueEducation(profile.get().getEducation());

            if (workExp.isPresent()) {
                params.put("workExp", workExp.get());
            } else {
                params.put("workExp", workExp);
            }
            if (education.isPresent()) {
                params.put("education", education.get());
            } else {
                params.put("education", education);
            }
            params.put("users", test);
            params.put("profile", profile.get());
            Optional <List<Job>> jobList = jobService.getJobsForUser(getSessionCurrentUser(request));
            if (jobList.isPresent()) {params.put("jobs", jobList.get());}
            else {params.put("jobs", null);}


            return ViewUtil.render(request, params, getProfilePath(accountType));
        };
    }

    private String getProfilePath(AccountType type) {
        if(AccountType.FREELANCER.equals(type)) {
            return Path.Template.FREELANCER_PROFILE;
        } else {
            return Path.Template.POSTER_PROFILE;
        }
    }

    /**Serves the edit profile page based on the users current session
     * @return the users current session for edit profile based on what type of user they are */
    public Route serveEditProfilePage() {
        return (request, response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> viewObjects = new HashMap<>();
            String username = getSessionCurrentUser(request).getUsername();
            User user = (userRepository.getUserByUserName(username)).get();
            final Optional<Profile> profile = profileService.getProfileByUserId(RequestUtil.getSessionCurrentUser(request).getId());
            if (profile.isPresent()) {viewObjects.put("profile", profile.get());}
            else {viewObjects.put("profile", profile); }
            viewObjects.put("user", user);
            viewObjects.put("skills", skillRepository.getAllSkills());
            viewObjects.put("educations", lookupService.getAllEducations());
            viewObjects.put("workExperiences", lookupService.getAllWorkExp());
            return ViewUtil.render(request, viewObjects, Path.Template.EDIT_PROFILE);
        };
    }

    /**Handles the POST function of the edit profile feature, when the user edits their profile and confirms
     * @return the users current session, redirects the user to profile page is proceeds correctly*/
    public Route handleEditProfile() {
        return (Request request, Response response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();
            profileService.updateProfile(request);
            int userID = getSessionCurrentUser(request).getId();
            if (request.queryParamsValues("skillsInput") != null) {
                final List <Skill> skills = jobService.mapFreelancerSkills(request);
                skillRepository.saveFreelancerSkills(userID, skills);
            }
            response.redirect("/profile/");
            return Spark.redirect;
        };
    }

    /**Handles the POST function of the create profile feature, when the user edits their profile and confirms
     * @return the users current session, redirects the user to profile page is proceeds correctly*/
    public Route handleCreateProfile() {
        return (Request request, Response response) -> {
            RequestUtil.ensureUserIsLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();
            profileService.createProfile(request);
            int userID = getSessionCurrentUser(request).getId();
            if (request.queryParamsValues("skillsInput") != null) {
                final List <Skill> skills = jobService.mapFreelancerSkills(request);
                skillRepository.saveFreelancerSkills(userID, skills);
            }
            response.redirect("/profile/");
            return Spark.redirect;
        };
    }
}