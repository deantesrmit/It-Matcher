package com.itmatcher.repository;

import com.itmatcher.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by deant on 10/21/17.
 */
@Repository
public class JobRepository {
    @Autowired
    SkillRepository skillRepository;

    private NamedParameterJdbcTemplate template;

    @Autowired
    public JobRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public Optional<List<Job>> getJobsByUserId(int id) {

        String sql = "SELECT * FROM tblJobs";

        List<Job> list = template.query(
                sql,
                new HashMap<>(),
                jobRowMapper);

        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }

        return Optional.empty();
    }


    public Optional<Job> getJobById(int jobId) {
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobId", jobId);
        String sql = "SELECT * FROM tblJobs where jobsid = :jobId";

        List<Job> list = template.query(
                sql,
                paramMap,
                jobRowMapper);

        if (list != null && !list.isEmpty()) {
            addWeightedCriteria(list);
            return Optional.of(list.get(0));
        }

        return Optional.empty();
    }

    private void addWeightedCriteria(List<Job> jobs) {
        jobs.stream().forEach(job -> job.setSkills(skillRepository.getWeightedSkills(job.getId())));
    }

    private RowMapper<Job> jobRowMapper = (rs, rowNum) -> {
        Job job = new Job();

        job.setId(rs.getInt("jobsid"));
        job.setTitle(rs.getString("jobTitle"));
        job.setEducation(rs.getString("education"));
        job.setDueDate(rs.getDate("dueDate"));
        job.setBudget(rs.getString("budget"));
        job.setJobAccepted(rs.getBoolean("jobAccepted"));
        job.setJobCompleted(rs.getBoolean("jobCompleted"));
        job.setDeleteStatus(rs.getBoolean("deleteStatus"));
        job.setJobAcceptedDate(rs.getDate("jobAcceptedDate"));
        job.setJobCompletedDate(rs.getDate("jobCompletedDate"));

        return job;
    };

}
