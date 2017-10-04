package com.itmatcher.util;

/**
 * Created by deant on 10/4/17.
 */
public class Path {
    public static class Web {
        public static final String INDEX = "/";
        public static final String LOGIN = "/login/";

        public String getINDEX() {
            return INDEX;
        }

        public String getLOGIN() {
            return LOGIN;
        }
    }

    public static class Template {
        public final static String INDEX = "/home.ftl";
        public final static String LOGIN = "/login.ftl";
    }

}
