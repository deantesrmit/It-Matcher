package com.itmatcher.util;

import com.itmatcher.domain.User;
import spark.Request;
import spark.Response;

/**
 * Created by deant on 10/8/17.
 */
public class RequestUtil {
    public static User getSessionCurrentUser(Request request) {
        return request.session().attribute("currentUser");
    }

    public static void setSessionCurrentUser(Request request, String currentUsername) {
        request.session().attribute("currentUser", currentUsername);
    }

    public static void setSessionRedirect(Request request, String redirect) {
        request.session().attribute("loginRedirect", redirect);
    }

    public static String getSessionRedirect(Request request) {
        return request.session().attribute("loginRedirect");
    }


    public static void clearSessionRedirect(Request request) {
        request.session().removeAttribute("loginRedirect");
    }

    public static String getQueryParam(Request request, String param) {
        return request.queryParams(param);
    }

    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (getSessionCurrentUser(request) == null) {
            setSessionRedirect(request, request.pathInfo());
            response.redirect(Path.Web.LOGIN);
        }
    }
}
