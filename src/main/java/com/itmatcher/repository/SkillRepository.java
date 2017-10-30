package com.itmatcher.repository;

import com.itmatcher.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.itmatcher.domain.CriteriaWeight.fromScore;

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

    public Optional<List<Skill>> getSkillsByUserId(int userID) {
        Map<String, Object> params = new HashMap<>();
        params.put("userID", userID);

        String sql =
                "select skill.value from tblSkills_User skillUser " +
                "JOIN tblSkills skill on  skill.id = skillUser.skillID " +
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

    public List<Skill> getWeightedSkills(int jobsId) {

        Map<String, Object> params = new HashMap<>();
        params.put("jobsID", jobsId);

        String sql =

                "select s.value, js.weight from tblJobs_Skills js " +
                "JOIN tblSkills s on js.skillId = s.skill_id " +
                "WHERE jobsID = :jobsID";



        List<Skill> list = template.query(
                sql,
                params,
                wsMapper);
         return list;


    }

    private RowMapper<Skill> skillMapper = (rs, rowNum) -> new Skill(rs.getString("value"));
    private RowMapper<Skill> wsMapper = (rs, rowNum) -> new Skill(rs.getString("value"), fromScore(rs.getInt("weight")));
}
