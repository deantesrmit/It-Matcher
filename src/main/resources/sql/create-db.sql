drop table tblUser if exists;
create table tblUser (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  username varchar(220) not null,
  firstName varchar(50),
  lastName varchar(50),
  email varchar(100),
  password varchar(100) not null,
  salt varchar(100) not null,
  accountType varchar(50) NOT NULL
);

drop table tblSkills if exists;
-- Skills Table, holds the list of possible skills used by the system
create table tblSkills (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  value  VARCHAR(250) NOT NULL
);

drop table tblSkills_User if exists;
-- Skills_User Table, holds the user id and a pointer to the skills they have
-- can also be used that if you have a skill id, you can find out which user id's have that skill
create table tblSkills_User (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userID INT,
  skillID INT
);

drop table tblJobs if exists;
-- Jobs Table, holds all the jobs in the system and whether they are accepted, completed or deleted
create table tblJobs (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  freelancerID INT,
  jobPosterID INT NOT NULL,
  jobDescription VARCHAR(250) NOT NULL,
  jobAccepted bit,
  jobAcceptedDate DATETIME,
  jobCompleted bit,
  jobCompletedDate DATETIME,
  deleteStatus bit
);

drop table tblJob_Skills if exists;
-- Jobs_Skills Table, holds all the skills that are required for a job
create table tblJob_Skills (
  id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  jobsID INT,    -- FK to tblJobs.jobsID
  skill_ID INT   -- FK to tblSkills.skill_ID
);

-- not required / don't know what this table is for? so commented it out
-- drop table tblFreelancer if exists;
-- create table tblFreelancer (
--   freelancerID integer primary key GENERATED BY DEFAULT AS IDENTITY (START WITH 100),
--   userId INT
-- );

drop table tblDeclined if exists;
-- Declined Table, holds what Jobs a Freelancer has declined, a Freelancer can decline many jobs over
-- a period of time, but only decline a single job once
create table tblDeclined (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  freelancerID INT NOT NULL,
  jobsID INT NOT NULL
);

drop table tblProfile if exists;
-- Profile Table, holds a users profile both freelancer and job poster, although some fields will only relate to
-- one user type, others will be for both types
create table tblProfile (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userId INT,
  location VARCHAR(25),
  address1 VARCHAR(50),
  suburb VARCHAR(50),
  state VARCHAR(10),
  postCode VARCHAR(12),
  bio VARCHAR(250),
  education INT,              -- FK to tblProfile_Education.profile_ID
  workExperience INT          -- FK to tblProfile_WorkExp.profile_ID
);


drop table tblEducation if exists;
-- Education Table, holds the levels of education that a user can have, and that the job poster has the
-- option of selecting on a job
create table tblEducation (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  education_name VARCHAR(100)
);

drop table tblWorkExp if exists;
-- Work Experience Table, holds the levels of work experience that a user has, and that the job poster has the
-- option of selecting on a job
create table tblWorkExp (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  workexp_name VARCHAR(100)
);

drop table tblProfile_Education if exists;
-- User Education Table, holds the education levels
create table tblProfile_Education (
  id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  profile_ID INT,    -- FK to tblProfile.profileID
  education_ID INT   -- FK to tblEducation.education_ID
);

drop table tblProfile_WorkExp if exists;
-- User Work Experience Table, holds all the work experience levels
create table tblProfile_WorkExp (
  id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  profile_ID INT,       -- FK to tblUser.ID
  workexp_ID INT     -- FK to tblWorkExp.workexp_ID
);

drop table tblJobs_Skills if exists;
-- Links a job to to a skill and its weight for each user
create table tblJobs_Skills (
  userID INT,
  jobID INT,
  skillID INT,
  weight INT
);
