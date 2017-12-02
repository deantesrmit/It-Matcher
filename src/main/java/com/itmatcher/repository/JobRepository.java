package com.itmatcher.repository;

import com.itmatcher.domain.Job;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * JobRepository Class - The repository for calling functions for Jobs
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Repository
public class JobRepository {
    @Autowired
    SkillRepository skillRepository;
    JdbcTemplate mJdbcTemplate;

    private NamedParameterJdbcTemplate template;

    @Autowired
    public JobRepository(DataSource ds) {

        template = new NamedParameterJdbcTemplate(ds);
        mJdbcTemplate = new JdbcTemplate(ds);
    }

    /**Returns a list of jobs based on user ID
     * @param id an int containing a user ID
     * @return a list of jobs based on the user ID entered*/
    public Optional<List<Job>> getJobsByUserId(int id) {
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        String sql = "SELECT * FROM tblJobs WHERE jobPosterID = :id";

        List<Job> list = template.query(
                sql,
                paramMap,
                jobRowMapper);

        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }

        return Optional.empty();
    }

    /**Returns a job based on the job ID entered
     * @param jobId an int containing a job ID number
     * @return return a Job based on the job ID entered*/
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

    /** Maps a row based on the row number, creates job based on the elements in that row number*/
    public RowMapper<Job> jobRowMapper = (rs, rowNum) -> {
        Job job = new Job();
        job.setId(rs.getInt("jobsid"));
        job.setTitle(rs.getString("jobTitle"));
        job.setDescription(rs.getString("jobdescription"));         // Added SC 07 Nov 2017
        job.setEducation(rs.getString("education"));
        job.setDueDate(rs.getString("dueDate"));
        job.setBudget(rs.getString("budget"));
        job.setJobAccepted(rs.getBoolean("jobAccepted"));
        job.setJobCompleted(rs.getBoolean("jobCompleted"));
        job.setDeleteStatus(rs.getBoolean("deleteStatus"));
        job.setJobAcceptedDate(rs.getDate("jobAcceptedDate"));
        job.setJobCompletedDate(rs.getDate("jobCompletedDate"));

        return job;
    };


    /**Saves a job based on a job entered
     * @param job a job element containing a job*/
    public Optional<Job> saveJob(Job job) {
        KeyHolder holder = new GeneratedKeyHolder();
        String SQL =
           "INSERT INTO tblJobs(jobPosterID, jobTitle, jobDescription, dueDate, education, budget) " +
           "values ( ?, ?, ?, ?, ?, ?)";
        mJdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, job.getJobPosterId());
            ps.setString(2, job.getTitle());
            ps.setString(3, job.getDescription());
            ps.setString(4, job.getDueDate());
            ps.setString(5, job.getEducation());
            ps.setString(6, job.getBudget());
            return ps;
        }, holder);
        return getJobById(holder.getKey().intValue());
    }

}
