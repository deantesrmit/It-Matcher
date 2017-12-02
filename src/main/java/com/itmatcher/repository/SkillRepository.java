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
 * SkillRepository Class - The repository for calling functions for Skills
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
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
                "select skill.id, skill.value from tblSkills_User skillUser " +
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

    /**Returns a list of all skills in the database
     * @return a list of all skills currently entered into the database */
    public List<Skill> getAllSkills() {
        Map<String, Object> params = new HashMap<>();
              String sql = "select * from tblSkills";

              List<Skill> list = template.query(
                      sql,
                      params,
                skillMapper);
               return list;
    }

    /**Returns a list of all weighted skills based on job ID entered
     * @param jobsId an int containing a jobs ID
     * @return a list containing the weighted skills for the chosen job*/
    public List<Skill> getWeightedSkills(int jobsId) {

        Map<String, Object> params = new HashMap<>();
        params.put("jobsID", jobsId);

        String sql =

                "select s.value, js.weight from tblJob_Skills js " +
                "JOIN tblSkills s on js.skillId = s.id " +
                "WHERE :jobsID = js.jobID";

        List<Skill> list = template.query(
                sql,
                params,
                wsMapper);
         return list;


    }

    /**Saves skills from the list of skills to a particular job
     * @param job an int containing a jobID
     * @param skills a list of required skills for a job*/
    public void saveAllSkills(int job, List<Skill> skills) {
        for (Skill skill : skills) {
            Map<String, Object> params = new HashMap<>();
            params.put("jobID", job);
            params.put("skillID", skill.getId());
            params.put("weight", skill.getWeight().score);
            template.update("insert into TBLJOB_SKILLS(jobID, skillID, weight) values (:jobID, :skillID, :weight) ", params);
        }
    }

    /**Saves freelancers skills from the list of skills
     * @param userID an int containing a user ID
     * @param skills a list of required skills for a job*/
    public void saveFreelancerSkills (int userID, List<Skill> skills) {
        for (Skill skill : skills) {
            Map <String, Object> params = new HashMap<>();
            params.put("userID", userID);
            params.put("skillID", skill.getId());
            template.update("insert into tblSkills_User(userID, skillID) values (:userID, :skillID)", params);
        }

    }
    private RowMapper<Skill> skillMapper = (rs, rowNum) -> new Skill(rs.getInt("id"), rs.getString("value"));
    private RowMapper<Skill> wsMapper = (rs, rowNum) -> new Skill(rs.getString("value"), fromScore(rs.getInt("weight")));



}
