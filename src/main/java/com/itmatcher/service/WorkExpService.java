package com.itmatcher.service;

import com.itmatcher.domain.Profile;
import com.itmatcher.domain.User;
import com.itmatcher.domain.WorkExp;
import com.itmatcher.repository.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

/**
 * WorkExpService Class - Repository for functions related to Work experience
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Service
public class WorkExpService {
    private NamedParameterJdbcTemplate template;

    @Autowired
    LookupRepository lookupRepository;
    @Autowired
    public WorkExpService(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    /**Returns a list of all the work experience in the database
     * @return returns a list of all the work experience values in the database */
    public List<WorkExp> getAllWorkExp() {return lookupRepository.getAllWorkExp();}

    /**Returns a value for a work experience based on the ID provided
     * @param id an int containing an ID for a Work Experience class
     * @return return a Work experience element matched by the ID*/
    public Optional<WorkExp> getValueWorkExperience(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = "SELECT * from tblWorkExp WHERE id=:id";
        List<WorkExp> list = template.query(sql, params, workMapper);
        if (list != null && !list.isEmpty()) {
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }

    private RowMapper<WorkExp> workMapper = (rs, rowNum) -> {
        WorkExp workExp = new WorkExp();
        workExp.setId(rs.getInt("id"));
        workExp.setValue(rs.getString("workexpName"));
        return workExp;
    };
}