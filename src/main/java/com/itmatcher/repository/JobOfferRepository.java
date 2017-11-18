package com.itmatcher.repository;

import com.itmatcher.domain.Job;
import com.itmatcher.domain.JobOffer;
import com.itmatcher.repository.JobRepository;

import java.util.*;
import javax.sql.DataSource;
import java.util.Iterator;
import java.util.Scanner;

import com.itmatcher.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by deant on 10/21/17.
 */
@Repository
public class JobOfferRepository {
    public static final String FIND_OFFER_BY_FREELANCER_ID_AND_JOB_ID =
            "SELECT * FROM tblJob_Offers " +
                    "WHERE jobId = :jobId " +
                    "AND freelancerID = :freelancerId";
    public static final String CREATE_NEW_JOB_OFFER =
            "INSERT INTO tblJob_Offers (jobID, freelancerID, offerStatus, timeDate) " +
                    "VALUES (:jobID, :freelancerID, :offerStatus, :timeDate)";

    public static final String UPDATE_JOB_OFFER =
            "UPDATE tblJob_Offers SET offerStatus = 1, timeDate = :timeDate " +
                    "WHERE jobID = :jobID AND freelancerID = :freelancerID";

    public static final String DECLINE_JOB_OFFER =
            "UPDATE tblJob_Offers SET offerStatus = 2, timeDate = :timeDate " +
                    "WHERE jobID = :jobID AND freelancerID = :freelancerID";

    private NamedParameterJdbcTemplate template;

    @Autowired
    JobService jobService;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    public JobOfferRepository(DataSource ds) {template = new NamedParameterJdbcTemplate(ds);}


    public Optional<List<JobOffer>> getJobOfferByProfile(int freelancerID) {
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("freelancerID", freelancerID);
        String sql = "SELECT * FROM TBLJOB_OFFERS WHERE freelancerID = :freelancerID";
        List<JobOffer> list = template.query(
                sql,
                paramMap,
                jobRowMapper);

        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }

        return Optional.empty();
    }

    public void respondJobOffer(String jobID, String freelancerID, String answer) {

        Map<String, Object> params = new HashMap<>();
        Date now = new Date();
        int response = Integer.parseInt(answer);
        params.put("jobID", Integer.parseInt(jobID));
        params.put("freelancerID", Integer.parseInt(freelancerID));
        params.put("timeDate", now);
        if (response == 1) {
            template.update(UPDATE_JOB_OFFER, params);
        } else if (response == 2) {
            template.update(DECLINE_JOB_OFFER, params);
        }
    }

    public Optional<JobOffer> findOfferByFreeLancerIdJobId(int freeLancerId, int status) {
        Map<String, Object> params = new HashMap<>();
        params.put("jobId", freeLancerId);
        params.put("freelancerId", status);
        final List<JobOffer> result = template.query(
                FIND_OFFER_BY_FREELANCER_ID_AND_JOB_ID,
                params,
                jobRowMapper);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        }
        return Optional.empty();
    }

    public void createJobOffer(JobOffer jobOffer) {
        Map<String, Object> params = new HashMap<>();
        params.put("jobID", jobOffer.getJobID());
        params.put("offerStatus", jobOffer.getOfferStatus());
        params.put("freelancerID", jobOffer.getFreelancerID());
        params.put("timeDate", jobOffer.getLastUpdated());
        template.update(CREATE_NEW_JOB_OFFER, params);
    }

    public void updateJobOffer(JobOffer jobOffer) {
        Map<String, Object> params = new HashMap<>();
        params.put("jobID", jobOffer.getJobID());
        params.put("freelancerID", jobOffer.getFreelancerID());
        params.put("timeDate", jobOffer.getLastUpdated());
        params.put("offerStatus", jobOffer.getOfferStatus());
        template.update(UPDATE_JOB_OFFER, params);
    }

    private RowMapper<JobOffer> jobRowMapper = (rs, rowNum) -> {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setJobID(rs.getInt("jobID"));
        jobOffer.setFreelancerID(rs.getInt("freelancerID"));
        jobOffer.setOfferStatus(rs.getInt("offerStatus"));
        jobOffer.setLastUpdated(rs.getDate("timeDate"));
        return jobOffer;
    };

    public List <Job> getJobsForFreelancer(int freelancerID)
    {
        List<Job> freelancersJobs = new ArrayList<Job>();
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("freelancerID", freelancerID);
        String sql = "SELECT * FROM tblJob_Offers WHERE freelancerID = :freelancerID AND offerStatus = 0";
        List<JobOffer> list = template.query(sql,paramMap,jobRowMapper);
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                int id = list.get(i).getJobID();
                HashMap<String, Object> param = new HashMap<>();
                param.put("jobsID", id);
                String query = "SELECT * FROM tblJobs WHERE jobsid = :jobsID";
                List<Job> job = template.query(query, param, jobRepository.jobRowMapper);
                freelancersJobs.add(job.get(0));
                i++;
            }
        }
        return freelancersJobs;
    }




}
