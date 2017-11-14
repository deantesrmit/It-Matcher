package com.itmatcher.repository;

import com.itmatcher.domain.JobOffer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by deant on 10/21/17.
 */
@Repository
public class JobOfferRepository {

    private NamedParameterJdbcTemplate template;

    @Autowired
    public JobOfferRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public static final String CREATE_NEW_JOB_OFFER = "insert into tblJob_Offers (jobID, freelancerID, offerStatus, timeDate) " +
            "values (:jobID, :freelancerID, :offerStatus, :timeDate)";

    public static final String ACCEPT_JOB_OFFER = "update tblJob_Offers SET offerStatus = 1, timeDate = :timeDate " +
            "WHERE jobID = :jobID AND freelancerID = :freelancerID";

    public static final String DECLINE_JOB_OFFER = "update tblJob_Offers SET offerStatus = 2, timeDate = :timeDate " +
            "WHERE jobID = :jobID AND freelancerID = :freelancerID";


    public Optional<List<JobOffer>> getJobOffers() {
        String sql = "SELECT * FROM tblJob_Offers";
        List<JobOffer> list = template.query(
                sql,
                new HashMap<>(),
                jobRowMapper);
        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }
        return Optional.empty();
    }

    public Optional <List<JobOffer>> getJobOfferByProfile(int freelancerID) {
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("freelancerID", freelancerID);

        //select J.jobTitle, J.jobDescription, J.duedate, J.budget from tblJobs as J
        //left outer join tbljob_offers as JO on JO.jobid = J.jobsid
        //where JO.offerstatus = 0 and JO.jobid = :jobsid and JO.freelancerid = :freelancer

        String sql = "SELECT * FROM TBLJOB_OFFERS WHERE freelancerID = :freelancerID";
        List <JobOffer> list = template.query(sql, paramMap, jobRowMapper);
        if (list != null && !list.isEmpty()) {
            return Optional.of(list);
        }
        return Optional.empty();
    }

    public void createJobOffer(JobOffer jobOffer) {
        Map<String, Object> params = new HashMap<>();
        params.put("jobID", jobOffer.getJobID());
        params.put("freelancerID", jobOffer.getFreelancerID());
        params.put("offerStatus", jobOffer.getOfferStatus());
        params.put("timeDate", jobOffer.getLastUpdated());
        template.update(CREATE_NEW_JOB_OFFER, params);
    }

    public Optional<JobOffer> hasJobOffer(int freeLancerId, int status, int jobId) {
        final HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("freelancerId", freeLancerId);
        paramMap.put("offerStatus", status);
        paramMap.put("jobID", jobId);
        String sql =
                "Select * " +
                "From TBLJOB_OFFERS As o " +
                "Inner Join (" +
                "  Select max(timeDate) as timeDate, freelancerId, jobId " +
                "  From TBLJOB_OFFERS " +
                "  Group By freelancerId, jobId) As u " +
                "On o.freelancerId = u.freelancerId " +
                "and o.timeDate = u.timeDate " +
                "and o.freelancerId = :freelancerId " +
                "and o.jobId = :jobID " +
                "and o.offerStatus = :offerStatus ";
        List<JobOffer> list = template.query(
                sql,
                paramMap,
                jobRowMapper);
        if (list != null && !list.isEmpty()) {
            return Optional.of(list.get(0));
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
      if (response == 1) {template.update(ACCEPT_JOB_OFFER, params);}
      else if (response == 2) {template.update(DECLINE_JOB_OFFER, params);}
  }

    private RowMapper<JobOffer> jobRowMapper = (rs, rowNum) -> {
        JobOffer jobOffer = new JobOffer();
        jobOffer.setJobID(rs.getInt("jobID"));
        jobOffer.setFreelancerID(rs.getInt("freelancerID"));
        jobOffer.setOfferStatus(rs.getInt("offerStatus"));
        jobOffer.setLastUpdated(rs.getDate("timeDate"));
        return jobOffer;
    };

}
