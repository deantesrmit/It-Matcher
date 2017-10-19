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


  private RowMapper<FreeLancer> userMapper = (rs, rowNum) -> {
    FreeLancer f = new FreeLancer();
    return f;
  };

}