package com.itmatcher.util;

import com.itmatcher.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

/**
 * Created by deant on 10/4/17.
 */
public class ViewUtil {

    @Autowired
    ProfileRepository profileRepository;

    public static String render(Request request, Map<String, Object> model, String templatePath) {

        model.put("userProfile", RequestUtil.getSessionCurrentProfile(request));
        model.put("userDetails", RequestUtil.getSessionCurrentUser(request));
        return new FreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

}
