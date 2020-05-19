/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     17/05/2020 3:32:30 p. m.                     */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_APPOINTM_U_EN_B_BRANCH') then
    alter table APPOINTMENT
       delete foreign key FK_APPOINTM_U_EN_B_BRANCH
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_APPOINTM_U_EN_B2_USER') then
    alter table APPOINTMENT
       delete foreign key FK_APPOINTM_U_EN_B2_USER
end if;

drop index if exists ADMIN.ADMIN_PK;

drop table if exists ADMIN;

drop index if exists APPOINTMENT.U_EN_B_FK;

drop index if exists APPOINTMENT.U_EN_B2_FK;

drop index if exists APPOINTMENT.APPOINTMENT_PK;

drop table if exists APPOINTMENT;

drop index if exists BRANCH.BRANCH_PK;

drop table if exists BRANCH;

drop index if exists "USER".USER_PK;

drop table if exists "USER";

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
create table ADMIN 
(
   ID_ADMIN             integer                        not null,
   USERNAME_A           char(12)                       not null,
   PASSWORD_A           char(14)                       not null,
   constraint PK_ADMIN primary key (ID_ADMIN)
);

/*==============================================================*/
/* Index: ADMIN_PK                                              */
/*==============================================================*/
create unique index ADMIN_PK on ADMIN (
ID_ADMIN ASC
);

/*==============================================================*/
/* Table: APPOINTMENT                                           */
/*==============================================================*/
create table APPOINTMENT 
(
   ID_BRANCH            integer                        not null,
   ID_USER              integer                        not null,
   "DATE"               char(50)                       not null,
   "TIME"               char(50)                       not null,
   STATE                smallint                       not null,
   constraint PK_APPOINTMENT primary key (ID_BRANCH, ID_USER)
);

/*==============================================================*/
/* Index: APPOINTMENT_PK                                        */
/*==============================================================*/
create unique index APPOINTMENT_PK on APPOINTMENT (
ID_BRANCH ASC,
ID_USER ASC
);

/*==============================================================*/
/* Index: U_EN_B2_FK                                            */
/*==============================================================*/
create index U_EN_B2_FK on APPOINTMENT (
ID_USER ASC
);

/*==============================================================*/
/* Index: U_EN_B_FK                                             */
/*==============================================================*/
create index U_EN_B_FK on APPOINTMENT (
ID_BRANCH ASC
);

/*==============================================================*/
/* Table: BRANCH                                                */
/*==============================================================*/
create table BRANCH 
(
   ID_BRANCH            integer                        not null,
   NAME_B               char(255)                      not null,
   ADDRESS              char(255)                      not null,
   PLACE                char(255)                      null,
   PASSWORD_B           char(14)                       not null,
   constraint PK_BRANCH primary key (ID_BRANCH)
);

/*==============================================================*/
/* Index: BRANCH_PK                                             */
/*==============================================================*/
create unique index BRANCH_PK on BRANCH (
ID_BRANCH ASC
);

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table "USER" 
(
   ID_USER              integer                        not null,
   USERNAME_U           char(12)                       not null,
   NAME_U               char(50)                       not null,
   LAST_NAME_U          char(50)                       not null,
   PASSWORD_U           char(14)                       not null,
   constraint PK_USER primary key (ID_USER)
);

/*==============================================================*/
/* Index: USER_PK                                               */
/*==============================================================*/
create unique index USER_PK on "USER" (
ID_USER ASC
);

alter table APPOINTMENT
   add constraint FK_APPOINTM_U_EN_B_BRANCH foreign key (ID_BRANCH)
      references BRANCH (ID_BRANCH)
      on update restrict
      on delete restrict;

alter table APPOINTMENT
   add constraint FK_APPOINTM_U_EN_B2_USER foreign key (ID_USER)
      references "USER" (ID_USER)
      on update restrict
      on delete restrict;

