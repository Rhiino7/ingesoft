--==============================================================
-- DBMS name:      ANSI Level 2
-- Created on:     17/05/2020 3:39:10 p. m.
--==============================================================


drop index ADMIN_PK;

drop table ADMIN cascade;

drop index U_EN_B_FK;

drop index U_EN_B2_FK;

drop index APPOINTMENT_PK;

drop table APPOINTMENT cascade;

drop index BRANCH_PK;

drop table BRANCH cascade;

drop index USER_PK;

drop table "USER" cascade;

--==============================================================
-- Table: ADMIN
--==============================================================
create table ADMIN (
ID_ADMIN             INTEGER              not null,
USERNAME_A           CHAR(12)             not null,
PASSWORD_A           CHAR(14)             not null,
primary key (ID_ADMIN)
);

--==============================================================
-- Index: ADMIN_PK
--==============================================================
create unique index ADMIN_PK on ADMIN (
ID_ADMIN ASC
);

--==============================================================
-- Table: "USER"
--==============================================================
create table "USER" (
ID_USER              INTEGER              not null,
USERNAME_U           CHAR(12)             not null,
NAME_U               CHAR(50)             not null,
LAST_NAME_U          CHAR(50)             not null,
PASSWORD_U           CHAR(14)             not null,
primary key (ID_USER)
);

--==============================================================
-- Table: BRANCH
--==============================================================
create table BRANCH (
ID_BRANCH            INTEGER              not null,
NAME_B               CHAR(255)            not null,
ADDRESS              CHAR(255)            not null,
PLACE                CHAR(255),
PASSWORD_B           CHAR(14)             not null,
primary key (ID_BRANCH)
);

--==============================================================
-- Table: APPOINTMENT
--==============================================================
create table APPOINTMENT (
ID_BRANCH            INTEGER              not null,
ID_USER              INTEGER              not null,
"DATE"               CHAR(50)             not null,
TIME                 CHAR(50)             not null,
STATE                smallint             not null,
primary key (ID_BRANCH, ID_USER),
foreign key (ID_USER)
      references "USER" (ID_USER),
foreign key (ID_BRANCH)
      references BRANCH (ID_BRANCH)
);

--==============================================================
-- Index: APPOINTMENT_PK
--==============================================================
create unique index APPOINTMENT_PK on APPOINTMENT (
ID_BRANCH ASC,
ID_USER ASC
);

--==============================================================
-- Index: U_EN_B2_FK
--==============================================================
create  index U_EN_B2_FK on APPOINTMENT (
ID_USER ASC
);

--==============================================================
-- Index: U_EN_B_FK
--==============================================================
create  index U_EN_B_FK on APPOINTMENT (
ID_BRANCH ASC
);

--==============================================================
-- Index: BRANCH_PK
--==============================================================
create unique index BRANCH_PK on BRANCH (
ID_BRANCH ASC
);

--==============================================================
-- Index: USER_PK
--==============================================================
create unique index USER_PK on "USER" (
ID_USER ASC
);

