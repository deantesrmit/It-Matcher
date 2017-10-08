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
    }

    public static class Template {
        public final static String INDEX = "/pages/home.ftl";
        public final static String LOGIN = "/pages/login.ftl";
        public final static String REGISTER = "/pages/register.ftl";
        public final static String PROFILE = "/pages/profile.ftl";
    }

}
