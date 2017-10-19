package com.itmatcher.controller;

import com.itmatcher.domain.Language;
import com.itmatcher.domain.User;
import com.itmatcher.repository.UserRepository;
import com.itmatcher.repository.FreeLancerRepository;

import com.itmatcher.domain.FreeLancer;
import com.itmatcher.repository.FreeLancerRepository;
import com.itmatcher.service.AuthService;
import com.itmatcher.util.Path;
import com.itmatcher.util.RequestUtil;
import com.itmatcher.util.ViewUtil;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import spark.Request;
import spark.Response;
import spark.Route;

import java.lang.reflect.Array;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


import static com.google.common.base.Strings.isNullOrEmpty;
import static com.itmatcher.util.RequestUtil.*;


/**
 * Created by deant on 10/4/17.
 */
@Component
public class FreeLancerController {

    @Autowired
    FreeLancerRepository freelancerRepository;
    @Autowired
    UserRepository userRepository;




}