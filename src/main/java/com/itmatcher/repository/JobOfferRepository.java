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
 * JobOfferRepository Class - The repository for calling functions for Job Offers
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
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

    public static final String UPDATE_JOB = "UPDATE tblJobs SET freelancerID = :freelancerID, jobAcceptedDate = :timeDate, " +
            "jobAccepted = 1 WHERE jobsid = :jobID";

    private NamedParameterJdbcTemplate template;

    @Autowired
    JobService jobService;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    public JobOfferRepository(DataSource ds) {template = new NamedParameterJdbcTemplate(ds);}

    /**Returns the job offer based on the freelancers profile ID
     * @param freelancerID an int containing the freelancer ID of a freelancer
     * @return the correct profile ID or a null list if no match found*/
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

    /**Responds to the job offer, based on the job ID, freelancer ID and the answer the freelancer gives
     * @param jobID a string containing a job ID
     * @param freelancerID a string containing a freelancer ID
     * @param answer the response the freelaner gives to the job offer*/
    public void respondJobOffer(String jobID, String freelancerID, String answer) {

        Map<String, Object> params = new HashMap<>();
        Date now = new Date();
        int response = Integer.parseInt(answer);
        params.put("jobID", Integer.parseInt(jobID));
        params.put("freelancerID", Integer.parseInt(freelancerID));
        params.put("timeDate", now);
        if (response == 1) {
            template.update(UPDATE_JOB_OFFER, params);
            template.update(UPDATE_JOB, params);
        } else if (response == 2) {
            template.update(DECLINE_JOB_OFFER, params);
        }
    }

    /**Returns the offer status for a freelancer based on job ID
     * @param freeLancerId an int containing a freelancers ID
     * @param status an int containing the status of the job offer
     * @return a JobOffer based on the parameters*/
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

    /**Creates a job offer with the specified fields from the on screen form
     * @param jobOffer a jobOffer class that needs to be created based on form*/
    public void createJobOffer(JobOffer jobOffer) {
        Map<String, Object> params = new HashMap<>();
        params.put("jobID", jobOffer.getJobID());
        params.put("offerStatus", jobOffer.getOfferStatus());
        params.put("freelancerID", jobOffer.getFreelancerID());
        params.put("timeDate", jobOffer.getLastUpdated());
        template.update(CREATE_NEW_JOB_OFFER, params);
    }

    /**Updates a job offer with the specified fields from the on screen form
     * @param jobOffer a jobOffer class that needs to be updated based on form*/
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

    /**Returns a list of the current jobs for a freelancer based on ID
     * @param freelancerID an int containing a freelancer iD
     * @return returns the list of jobs for the freelancer*/
    public List <Job> getJobsForFreelancer(int freelancerID)
    {
        List<Job> freelancersJobs = new ArrayList<Job>();
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("freelancerID", freelancerID);
        String sql = "SELECT * FROM tblJob_Offers WHERE freelancerID = :freelancerID";
        List<JobOffer> list = template.query(sql,paramMap,jobRowMapper);
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                final JobOffer jobOffer = list.get(i);
                int id = jobOffer.getJobID();
                HashMap<String, Object> param = new HashMap<>();
                param.put("jobsID", id);
                String query = "SELECT * FROM tblJobs WHERE jobsid = :jobsID";
                List<Job> job = template.query(query, param, jobRepository.jobRowMapper);
                final Job e = job.get(0);
                e.setStatus(mapStatus(jobOffer.getOfferStatus()));
                freelancersJobs.add(e);
                i++;
            }
        }
        return freelancersJobs;
    }

    private String mapStatus(int status) {
        if(status == 0) {
            return "Pending";
        } else if(status == 2){
            return "Declined";
        }else {
            return "Accepted";
        }
    }


}
