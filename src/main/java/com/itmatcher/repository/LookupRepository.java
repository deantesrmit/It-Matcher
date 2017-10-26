package com.itmatcher.repository;

import com.itmatcher.domain.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by deant on 10/24/17.
 */
@Repository
public class LookupRepository {
    private NamedParameterJdbcTemplate template;
    @Autowired
    public LookupRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }


    public List<Education> getAllEducations() {
        return null;
    }
}
