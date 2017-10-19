package com.itmatcher.util;

/**
 * Created by deant on 10/4/17.
 */
public class Path {
    public static class Web {
        public static final String INDEX = "/";
        public static final String LOGIN = "/login/";
        public static final String LOGOUT = "/logout/";
        public static final String REGISTER = "/register/";
        public static final String PROFILE = "/profile/";
        public static final String CREATE_JOB ="/create_job/";
        public static final String VIEW_MATCHES ="/viewMatches/";
        public static final String VIEW_FREELANCERS ="/viewFreelancers/:jobid/";
        public static final String ABOUT_US ="/aboutus/";
        public static final String HOW_IT_WORKS ="/howitworks/";


        public static final String FREELANCER_PROFILE = "/freelancer_profile/";
        public static final String EDIT_FREELANCER_PROFILE = "/edit_profile/";

    }

    public static class Template {
        public final static String INDEX = "/pages/home.ftl";
        public final static String LOGIN = "/pages/login.ftl";
        public final static String REGISTER = "/pages/register.ftl";
        public final static String POSTER_PROFILE = "/pages/poster-profile.ftl";
        public final static String CREATE_JOB = "/pages/create_job.ftl";
        public final static String VIEW_MATCHES = "/pages/view_matches.ftl";
        public final static String ABOUT_US = "/pages/aboutus.ftl";
        public final static String HOW_IT_WORKS = "/pages/howitworks.ftl";
        public static final String VIEW_FREELANCER = "/pages/list_freelancer.ftl";


        public final static String EDIT_FREELANCER_PROFILE = "/pages/edit_freelancer_profile.ftl";
        public final static String FREELANCER_PROFILE = "/pages/freelancer_profile.ftl";
    }

}
