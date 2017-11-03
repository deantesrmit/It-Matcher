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

@Repository
public class ProfileRepository {
    private NamedParameterJdbcTemplate template;
    public static final String UPDATE_PROFILE_SQL =
      "update tblProfile SET (userID, location, address1, suburb, state, postCode, bio, education, workExperience) " +
      "values (:userID, :location, :address1, :suburb, :state, :postCode, bio, education, workExperience) WHERE userID=:userID";

    public static final String SELECT_PROFILE_BY_ID_SQL = "SELECT * FROM tblProfile WHERE userID=:userID";

    public static final String INSERT_NEW_PROFILE =
      "insert into tblProfile(userID, location, address1, suburb, state, postCode, bio, education, workExperience) " +
      "values (:userID, :location, :address1, :suburb, :state, :postCode, :bio, :education, :workExperience)";

    @Autowired
    public ProfileRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public Optional<Profile> getProfileByUserID(int userID) {
        Map<String, Object> params = new HashMap<>();
        params.put ("userID", userID);
        List<Profile> result = template.query(SELECT_PROFILE_BY_ID_SQL, params, profileRowMapper);
        if(result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        }
        return Optional.empty();
    }

    public void updateProfile(Profile profile) {
        Map<String, Object> params = mapProfileParams(profile);
        template.query(UPDATE_PROFILE_SQL, params, profileRowMapper);
    }

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
        p.setProfileID(rs.getInt("id"));
        p.setUserId(rs.getInt("userID"));
        p.setLocation(rs.getString("location"));
        p.setAddress1 (rs.getString("address1"));
        p.setSuburb(rs.getString("suburb"));
        p.setState(rs.getString("state"));
        p.setPostcode(rs.getString("postCode"));
        p.setBio(rs.getString("bio"));
        p.setEducation(rs.getString("education"));
        p.setWorkExperience(rs.getString("workExperience"));
        return p;
    };

}
