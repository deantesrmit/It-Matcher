package com.itmatcher.util;

import com.google.common.base.Strings;
import com.itmatcher.domain.User;
import com.itmatcher.type.AccountType;
import spark.Request;
import spark.Response;

/**
 * Created by deant on 10/8/17.
 */
public class RequestUtil {
    public static User getSessionCurrentUser(Request request) {
        return request.session().attribute("currentUser");
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
    public static String getQueryParams(Request request, String param) {
        return request.params(param);
    }

    public static void ensureUserIsLoggedIn(Request request, Response response) {
        if (getSessionCurrentUser(request) == null) {
            setSessionRedirect(request, request.pathInfo());
            response.redirect(Path.Web.LOGIN);
        }
    }

    public static AccountType getAccountType(Request request) {
        final String accountType = getSessionCurrentUser(request).getAccountType();
        if(!Strings.isNullOrEmpty(accountType))
            return AccountType.valueOf(accountType);
        throw new RuntimeException("Not logged in");
    }
}
