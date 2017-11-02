drop table tblUser if exists;
create table tblUser (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  firstName varchar(50),
  lastName varchar(50),
  username varchar(220) not null,
  email varchar(100),
  password varchar(100) not null,
  salt varchar(100) not null,
  accountType varchar(50) NOT NULL
);

drop table tblSkills if exists;
-- Skills Table, holds the list of possible skills used by the system
create table tblSkills (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  value VARCHAR(250) NOT NULL
);

drop table tblSkills_User if exists;
-- Skills_User Table, holds the user id and a pointer to the skills they have
-- can also be used that if you have a skill id, you can find out which user id's have that skill
create table tblSkills_User (
  ID integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userID INT,     -- FK to tblUsers.id
  skillID INT     -- FK to tblSkills.id
);

drop table tblJobs if exists;
-- Jobs Table, holds all the jobs in the system and whether they are accepted, completed or deleted
create table tblJobs (
  jobsid integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  freelancerID INT,               -- FK to tblUsers.id
  jobPosterID INT NOT NULL,       -- FK to tblUsers.id
  jobTitle VARCHAR(250) NOT NULL,
  jobDescription VARCHAR(250) NOT NULL,
  dueDate VARCHAR(250),
  education VARCHAR(250),
  budget VARCHAR(250),
  jobAccepted bit,
  jobAcceptedDate DATETIME,
  jobCompleted bit,
  jobCompletedDate DATETIME,
  deleteStatus bit
);

drop table tblDeclined if exists;
-- Declined Table, holds what Jobs a Freelancer has declined, a Freelancer can decline many jobs over
-- a period of time, but only decline a single job once
create table tblDeclined (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userid INT NOT NULL,          -- FK to tblUser.id
  jobsid INT NOT NULL           -- FK to tblJobs.id
);

drop table tblProfile if exists;
-- Profile Table, holds a users profile both freelancer and job poster, although some fields will only relate to
-- one user type, others will be for both types
create table tblProfile (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  userID INT,
  location VARCHAR(25),
  address1 VARCHAR(50),
  suburb VARCHAR(50),
  state VARCHAR(10),
  postCode VARCHAR(12),
  bio VARCHAR(250),
  education INT,              -- FK to tblEducation.id
  workExperience INT          -- FK to tblWorkExp.id
);

drop table tblEducation if exists;
-- Education Table, holds the levels of education that a user can have, and that the job poster has the
-- option of selecting on a job
create table tblEducation (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  educationName VARCHAR(100)
);

drop table tblWorkExp if exists;
-- Work Experience Table, holds the levels of work experience that a user has, and that the job poster has the
-- option of selecting on a job
create table tblWorkExp (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  workexpName VARCHAR(100)
);

drop table tblJob_Skills if exists;
-- Links a job to to a skill and its weight for each user
create table tblJob_Skills (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  jobID INT,
  skillID INT,
  weight INT
);

drop table tblJob_Offers if exists;
-- Job Offers table to
create table tblJob_Offers (
  id integer primary key GENERATED BY DEFAULT AS IDENTITY(START WITH 100),
  jobID INT,                   -- FK to tblJobs.id
  freelancerID INT,
  offerStatus INT,             -- 0 = pending, 1 = accepted, 2 = declined
  timeDate DATETIME            -- Last Update Date Time
);

