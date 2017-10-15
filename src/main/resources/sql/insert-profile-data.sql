--CREATE FREELANCER RECORDS
INSERT INTO tblFreelancer (freelancerID, userId)
VALUES (100, 1);
INSERT INTO tblProfile ( profileID, userId , location,address1, suburb, state, postCode,bio,education,workExperience)
  VALUES (100, 1, 'SYDNEY', '123 fake street', 'Sydney', 'NSW', 2000, 'Best web builder with the lowest price.', 'Bachelor of IT', '20 years IT Experience');
INSERT INTO tblFreelancer (freelancerID, userId)
  VALUES (101, 3);
INSERT INTO tblProfile ( profileID, userId , location, address1, suburb, state, postCode, bio, education, workExperience)
  VALUES (101, 3, 'MELBOURNE', '123 fake street', 'Melbourne', 'VIC', 3000, '15 years of web building experience.', 'Masters of IT', '20 years IT Experience');


-- Insert some skills
INSERT INTO tblSkills(skillID, value)
  VALUES (100, 'sql');
INSERT INTO tblSkills(skillID, value)
  VALUES (101, 'css');
INSERT INTO tblSkills(skillID, value)
  VALUES (102, 'design');
INSERT INTO tblSkills(skillID, value)
  VALUES (103, 'ux');

INSERT INTO tblSkills_User(id, userID, skillID)
  VALUES (100, 1, 100);
INSERT INTO tblSkills_User(id, userID, skillID)
  VALUES (101, 1, 101);
INSERT INTO tblSkills_User(id, userID, skillID)
  VALUES (102, 3, 102);
INSERT INTO tblSkills_User(id, userID, skillID)
  VALUES (103, 3, 103);