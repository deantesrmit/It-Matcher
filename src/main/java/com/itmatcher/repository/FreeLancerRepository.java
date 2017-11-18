
package com.itmatcher.repository;


import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Language;
import com.itmatcher.domain.Skill;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
               .forEach(fl -> fl.setSkills(skillRepository.getSkillsByUserId(fl.getUserID()).orElse(null)));
    return freeLancers;
  }

  private Optional<List<FreeLancer>> getFreeLancers() {
    Map<String, Object> params = new HashMap<>();
    String sql =
            "select * from tblProfile profile "+
            "JOIN tblUser u on u.id = profile.userId " +
            "where u.accountType = 'FREELANCER'";

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
    f.setId(rs.getInt("id"));
    f.setUserID(rs.getInt("userID"));
    f.setBio(rs.getString("bio"));
    f.setEducation(rs.getString("education"));
    f.setExperience(rs.getString("workExperience"));
    f.setName(rs.getString("firstName") + " " + rs.getString("lastName"));
    return f;
  };

}
