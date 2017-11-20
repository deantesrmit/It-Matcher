package com.itmatcher.service;

import com.itmatcher.domain.Education;
import com.itmatcher.repository.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import java.util.List;

/**
 * Created by deant on 10/24/17.
 */
@Service
public class EducationService {
    private NamedParameterJdbcTemplate template;
    @Autowired
    LookupRepository lookupRepository;
    @Autowired
    public EducationService(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }


    public List <Education> getAllEducations() {return lookupRepository.getAllEducations();}

    public Optional <Education> getValueEducation(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        String sql = "SELECT * from tblEducation WHERE id=:id";
        List<Education> list = template.query(sql, params, educationMapper);
        if (list != null && !list.isEmpty()) {
            return java.util.Optional.of(list.get(0));
        }
        return java.util.Optional.empty();
    }

    private RowMapper<Education> educationMapper = (rs, rowNum) -> {
        Education education = new Education();
        education.setId(rs.getInt("id"));
        education.setValue(rs.getString("educationName"));
        return education;
    };
}
