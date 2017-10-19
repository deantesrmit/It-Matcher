package com.itmatcher.repository;
import com.itmatcher.domain.FreeLancer;
import com.itmatcher.domain.Profile;
import com.itmatcher.domain.User;
import com.itmatcher.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static com.itmatcher.util.RequestUtil.getQueryParam;

@Repository
public class ProfileRepository {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public ProfileRepository(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    public void createProfile(int userID, Profile profile) {
        Map<String, Object> params = new HashMap<>();
        String SQL;
        params.put ("userID", userID);
        params.put ("location", profile.getLocation());
        params.put ("address1", profile.getAddress1());
        params.put ("suburb", profile.getSuburb());
        params.put ("state", profile.getState());
        params.put ("postCode", profile.getPostcode());
        params.put("bio", profile.getBio());
        params.put("education", profile.getEducation());
        params.put("workExperience", profile.getWorkExperience());

        String userSql = "SELECT profileID FROM TblProfile WHERE userID=:userID";
        List<Profile> result = template.query(userSql, params, userMapper);

        if (result != null && !result.isEmpty()) {
            Profile returned = result.get(0);
            int profileID = returned.getProfileID();

            SQL = "update tblProfile SET (userID, location, address1, suburb, state, postCode, bio, education, workExperience) " +
                    "values (:userID, :location, :address1, :suburb, :state, :postCode, bio, education, workExperience) WHERE profileID =:profileID;";

        }
        else {
            SQL = "insert into tblProfile(userID, location, address1, suburb, state, postcode, bio, education, workExperience) " +
                    "values (:userID, :location, :address1, :suburb, :state, :postcode, :bio, :education, :workExperience)";
        }

        template.update(SQL, params);
    }

    public <Optional>Profile profileByUserID (int userID) {
        Profile profile = new Profile();
        String userSql = "SELECT profileID FROM TblProfile WHERE userID=:userID";
        List<Profile> result = template.query(userSql, userMapper);
        profile = result.get(0);
        return profile;
    }

    private RowMapper<Profile> userMapper = (rs, rowNum) -> {
        Profile p = new Profile();
        p.setProfileID(rs.getInt("profileID"));
        p.setUserId(rs.getInt("userID"));
        p.setLocation(rs.getString("location"));
        p.setAddress1 (rs.getString("address1"));
        p.setSuburb(rs.getString("suburb"));
        p.setState(rs.getString("state"));
        p.setPostcode(rs.getString("postcode"));
        p.setBio(rs.getString("bio"));
        p.setEducation(rs.getString("education"));
        p.setWorkExperience(rs.getString("workExperience"));
        return p;
    };

}
