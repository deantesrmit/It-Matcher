/*
 * Copyright (c) 2013-2014 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package com.itmatcher.repository;


import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Language;
import com.itmatcher.domain.Skill;
import com.itmatcher.domain.User;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * @author Dean Tesoriero
 */
@Repository
public class FreeLancerRepository {
  private NamedParameterJdbcTemplate template;
  @Autowired
  SkillRepository skillRepository;

  @Autowired
  public FreeLancerRepository(DataSource ds) {
    template = new NamedParameterJdbcTemplate(ds);
  }


  public List<FreeLancer> findFreeLancersByRequired(List<Language> requiredLanguages, List<Skill> requiredSkills) {
    final Optional<List<FreeLancer>> maybeFreeLancers = getFreeLancers();
    if (!maybeFreeLancers.isPresent()) {
      return new ArrayList<>();
    }
    final List<FreeLancer> freeLancers = maybeFreeLancers.get();
    freeLancers.stream()
            .forEach(freeLancer -> {
              freeLancer.setSkills(skillRepository.getSkillsByUserId(freeLancer.getUserID()).get());
            });
    return freeLancers;
  }

  private Optional<List<FreeLancer>> getFreeLancers() {
    Map<String, Object> params = new HashMap<>();
    String sql =
            "select * from tblFreelancer flancer "+
                    "JOIN tblProfile profile on flancer.userId = profile.userId " +
                    "JOIN tblUser u on u.id = flancer.userId";

    List<FreeLancer> list = template.query(
            sql,
            params,
            userMapper);

    if (list != null && !list.isEmpty()) {
      return Optional.of(list);
    }

    return Optional.empty();
  }

  public void createFreelancerProfile(Long userID, FreeLancer profile) {
    Map<String, Object> params = new HashMap<>();
    String SQL;
    params.put ("userID", userID);
    params.put ("location", profile.getLocation());
    params.put ("address1", profile.getAddress1());
    params.put ("suburb", profile.getSuburb());
    params.put ("state", profile.getState());
    params.put ("postCode", profile.getPostCode());
    //params.put ("languages", profile.getLanguages());
    //params.put ("skills", profile.getSkills());
    params.put("experience", profile.getExperience());
    params.put("education", profile.getEducation());
    params.put("bio", profile.getBio());

    String userSql = "SELECT id FROM TblProfile WHERE userID:=userID";
    List<FreeLancer> result = template.query(userSql, params, userMapper);

    if (result != null && !result.isEmpty()) {
      FreeLancer returned = result.get(0);
      Long id = returned.getId();

      SQL = "update tblProfile SET (location, address1, suburb, state, postcode, languages, skills, experience, education," +
              " bio) values (:location, :address1, :suburb, :state, :postcode, :languages, :skills, :experience, :education, " +
              ":bio) WHERE id:=id";

    }
    else {
      SQL = "insert into tblProfile(userID, location, address1, suburb, state, postcode, languages, skills, experience, " +
              "education, bio) values (:userID, :location, :address1, :suburb, :state, :postcode, :languages, :skills, :experience, " +
              ":education, :bio)";
    }

    template.update(SQL, params);
  }


  private RowMapper<FreeLancer> userMapper = (rs, rowNum) -> {
    FreeLancer f = new FreeLancer();
    f.setUserID(rs.getInt("userID"));
    f.setId(rs.getInt("freelancerID"));
    f.setBio(rs.getString("bio"));
    f.setEducation(rs.getString("education"));
    f.setExperience(rs.getString("workExperience"));
    f.setName(rs.getString("firstName") + " " + rs.getString("lastName"));
    return f;
  };

}
