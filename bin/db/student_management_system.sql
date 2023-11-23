CREATE TABLE students (
  id CHAR(10) PRIMARY KEY,
  name VARCHAR(255),
  birthday VARCHAR(255),
  gender VARCHAR(255),
  address VARCHAR(255),
  major VARCHAR(255),
  class VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE instructors (
  id CHAR(10) PRIMARY KEY,
  name VARCHAR(255),
  level VARCHAR(255),
  nationality VARCHAR(255),
  gender VARCHAR(255),
  major VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE majors (
  id CHAR(10) PRIMARY KEY,
  name VARCHAR(255),
  khoi_nganh VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE classes (
  id CHAR(10) PRIMARY KEY,
  adviser VARCHAR(255),
  major VARCHAR(255),
  note VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE users (
  username VARCHAR(255)  PRIMARY KEY,
  password VARCHAR(255),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

