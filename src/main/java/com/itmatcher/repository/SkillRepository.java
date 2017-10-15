package com.itmatcher.repository;

import com.itmatcher.domain.Skill;
import com.itmatcher.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by deant on 10/15/17.
 */
@Repository
public class SkillRepository {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public SkillRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public Optional<List<Skill>> getSkillsByUserId(long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userID", userId);

        String sql =
                "select skill.value from tblSkills_User skillUser " +
                "JOIN tblSkills skill on  skill.skillID = skillUser.skillID " +
                "WHERE userID = :userID";

        List<Skill> list = template.query(
                sql,
                params,
                skillMapper);

        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }
        return Optional.empty();
    }

    private RowMapper<Skill> skillMapper = (rs, rowNum) -> new Skill(rs.getString("value"));
}
