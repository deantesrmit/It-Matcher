package com.itmatcher.repository;

import com.itmatcher.domain.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.util.Optional;
import java.util.*;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by deant on 10/24/17.
 */
@Repository

public class LookupRepository {
    private NamedParameterJdbcTemplate template;
    public static final String LIST_ALL_EDUCATION = "SELECT*FROM tblEducation";
    @Autowired
    public LookupRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }


    public Optional <List<Education>> getAllEducations() {
        Map<String, Object> params = new HashMap<>();
        List<Education> list = template.query(LIST_ALL_EDUCATION, params, educationRowMapper);
        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }

        return Optional.empty();
    }

    private RowMapper<Education> educationRowMapper = (rs, rowNum) -> {
        Education p = new Education();
        p.setId(rs.getInt("id"));
        p.setValue(rs.getString("value"));
        return p;
    };

}



