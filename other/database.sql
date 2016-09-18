CREATE TABLE DRUG."USERS"
(
    ID varchar2(32) PRIMARY KEY NOT NULL,
    username varchar2(64),
    PASSWORD varchar2(100),
    SALT varchar2(100),
    CREATE_ID varchar2(32),
    CREATE_TIME TIMESTAMP,
    UPDATE_ID varchar2(32),
    UPDATE_TIME TIMESTAMP,
    DEL_FLAG char(1) DEFAULT 0
);

create table DRUG."ROLE"
(
    ID VARCHAR2(32) PRIMARY KEY NOT NULL,
    NAME VARCHAR2(32),
    ENAME VARCHAR2(32),
    PID VARCHAR2(32),
    TYPE VARCHAR2(2),
    ICON VARCHAR2(32),
    CREATE_ID varchar2(32),
    CREATE_TIME TIMESTAMP,
    UPDATE_ID varchar2(32),
    UPDATE_TIME TIMESTAMP,
    DEL_FLAG char(1) DEFAULT 0
)

CREATE TABLE  DRUG."MENU"
(
    ID varchar2(32) PRIMARY KEY NOT NULL,
    MENU_NAME VARCHAR2(32),
    ENAME VARCHAR2(32),
    PID VARCHAR2(32),
    PIDS VARCHAR2(1000),
    URL VARCHAR2(64),
    SORT NUMERIC(20),
    TYPE VARCHAR2(2),
    ICON VARCHAR2(32),
    CREATE_ID varchar2(32),
    CREATE_TIME TIMESTAMP,
    UPDATE_ID varchar2(32),
    UPDATE_TIME TIMESTAMP,
    DEL_FLAG char(1) DEFAULT 0
)

    Drop TABLE ROLE_MENU;
    Drop TABLE USER_ROLE;
create TABLE ROLE_MENU (
    ID VARCHAR2(32) PRIMARY KEY NOT NULL,
    ROLE_ID VARCHAR2(32),
    MENU_ID VARCHAR2(32),
    CREATE_ID varchar2(32),
    CREATE_TIME TIMESTAMP,
    UPDATE_ID varchar2(32),
    UPDATE_TIME TIMESTAMP,
    DEL_FLAG char(1) DEFAULT 0
);


create TABLE USER_ROLE (
    ID VARCHAR2(32) PRIMARY KEY NOT NULL,
    USER_ID VARCHAR2(32),
    ROLE_ID VARCHAR2(32),
    CREATE_ID varchar2(32),
    CREATE_TIME TIMESTAMP,
    UPDATE_ID varchar2(32),
    UPDATE_TIME TIMESTAMP,
    DEL_FLAG char(1) DEFAULT 0
);