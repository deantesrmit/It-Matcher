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

    public List<WorkExp> getAllWorkExp() {return lookupRepository.getAllWorkExp();}

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