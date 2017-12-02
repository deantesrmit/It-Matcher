package com.itmatcher.repository;

import com.itmatcher.domain.Profile;

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
 * ProfileRepository Class - The repository for calling functions for Profiles
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Repository
public class ProfileRepository {
    private NamedParameterJdbcTemplate template;
    public static final String UPDATE_PROFILE_SQL =
            "UPDATE tblProfile " +
                    "SET userID=:userID, location=:location, address1=:address1, suburb=:suburb, state=:state, " +
                    "postCode=:postCode, bio=:bio, education=:education, workExperience=:workExperience " +
                    "WHERE userID=:userID";

    public static final String SELECT_PROFILE_BY_ID_SQL = "SELECT * FROM tblProfile WHERE userID=:userID";

    public static final String INSERT_NEW_PROFILE =
            "INSERT INTO tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience) " +
                    "VALUES (:userID, :location, :address1, :suburb, :state, :postCode, :bio, :education, :workExperience)";

    @Autowired
    public ProfileRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    /**Returns a Profile based on the profile ID
     * @param userID an int containing a user ID
     * @return returns a profile based on the user ID presented*/
    public Optional<Profile> getProfileByUserID(int userID) {
        Map<String, Object> params = new HashMap<>();
        params.put("userID", userID);
        List<Profile> result = template.query(SELECT_PROFILE_BY_ID_SQL, params, profileRowMapper);
        if (result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        }
        return Optional.empty();
    }

    /**Updates the users profile based on the profile presented
     * @param profile a profile created through the Profile class */
    public void updateProfile(Profile profile) {
        Map<String, Object> params = mapProfileParams(profile);
        template.update(UPDATE_PROFILE_SQL, params);
    }

    /**Creates the users profile based on the profile presented
     * @param profile a profile created through the Profile class*/
    public void createProfile(Profile profile) {
        Map<String, Object> params = mapProfileParams(profile);
        template.update(INSERT_NEW_PROFILE, params);
    }

    private Map<String, Object> mapProfileParams(Profile profile) {
        Map<String, Object> params = new HashMap<>();
        params.put("userID", profile.getUserId());
        params.put("location", profile.getLocation());
        params.put("address1", profile.getAddress1());
        params.put("suburb", profile.getSuburb());
        params.put("state", profile.getState());
        params.put("postCode", profile.getPostcode());
        params.put("bio", profile.getBio());
        params.put("education", profile.getEducation());
        params.put("workExperience", profile.getWorkExperience());
        return params;
    }

    private RowMapper<Profile> profileRowMapper = (rs, rowNum) -> {
        Profile p = new Profile();
        p.setId(rs.getInt("id"));
        p.setUserId(rs.getInt("userID"));
        p.setLocation(rs.getString("location"));
        p.setAddress1(rs.getString("address1"));
        p.setSuburb(rs.getString("suburb"));
        p.setState(rs.getString("state"));
        p.setPostcode(rs.getString("postCode"));
        p.setBio(rs.getString("bio"));
        p.setEducation(rs.getInt("education"));
        p.setWorkExperience(rs.getInt("workExperience"));
        return p;
    };

}
