package com.itmatcher.repository;

import com.itmatcher.domain.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;

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

    public static final String CREATE_NEW_JOB_OFFER = "insert into tblJob_Offers (jobID, freelancerID, offerStatus, timeDate) values (:jobID, :freelancerID, :offerStatus, :timeDate)";


    public static final String ACCEPT_JOB_OFFER = "update tblJob_Offers (offerStatus, timeDate) values (1, :timeDate) "+
            "WHERE jobID=:jobID AND freelancerID=:freelancerID";
    public static final String NOTIFY_JOBS_ACCEPTED = "update tblJob (jobAccepted) values (1)";


    public static final String DECLINE_JOB_OFFER = "update tblJob_Offers (offerStatus, timeDate) values (2, :timeDate) "+
            "WHERE jobID=:jobID AND freelancerID=:freelancerID";




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

    public void createJobOffer(String jobID, String freelancerID) {
        Map<String, Object> params = new HashMap<>();
        Date now = new Date();
        params.put("jobID", Integer.parseInt(jobID));
        params.put("freelancerID", Integer.parseInt(freelancerID));
        params.put("offerStatus", 0);
        params.put("timeDate", now);
        template.update(CREATE_NEW_JOB_OFFER, params);
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
