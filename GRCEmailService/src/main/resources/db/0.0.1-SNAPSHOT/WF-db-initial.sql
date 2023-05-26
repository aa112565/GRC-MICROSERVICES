drop table CNFG_STATUS_ACTION;
drop table STG_WF_CUST_ALERT_DTL;
drop table ADT_WF_ALERT_ATTACHMENTS;
drop table ADT_WF_ALERT_USR_ACTION;
drop table MST_WF_CUST_ALERT_DTL;
drop table MST_CUST_USER_MAP;

create table CNFG_STATUS_ACTION(
N_SR integer primary key,
V_LEVEL varchar2(5),
V_LEVEL_TYPE varchar2(20),
V_STATUS varchar2(50),
V_ACTION varchar2(100),
V_NEXT varchar2(500)
);

create table STG_WF_CUST_ALERT_DTL	(
V_TYPE	varchar2(50),
V_ALERT_ID	varchar2(200) PRIMARY KEY,
N_EWI_ID	number(10),
V_EWI_DESC	varchar2(500),
V_SEVERITY	varchar2(50),
V_SOURCE	varchar2(50),
V_FREQUENCY	varchar2(50),
V_CUSTOMER_ID	varchar2(20),
V_CUSTOMER_NAME	varchar2(300),
N_CUST_EXPOSURE	number,
V_CUST_CLASSIFICATION	varchar2(50),
V_CUST_VERTICAL	varchar2(20),
V_BRANCH_ID	varchar2(20),
V_BRANCH_NAME	varchar2(300),
V_MESSAGE	varchar2(4000),
D_DATE	date,
D_CLOSEBY	date,
V_SIGNIFICANCE	varchar2(200),
V_RISK_MITIGATION	varchar2(200)
);

create table MST_WF_CUST_ALERT_DTL(
V_TYPE	varchar2(50),
V_ALERT_ID	varchar2(200),
N_EWI_ID	number(10),
V_EWI_DESC	varchar2(500),
V_SEVERITY	varchar2(50),
V_SOURCE	varchar2(50),
V_FREQUENCY	varchar2(50),
V_CUSTOMER_ID	varchar2(20),
V_CUSTOMER_NAME	varchar2(300),
N_CUST_EXPOSURE	number,
V_CUST_CLASSIFICATION	varchar2(50),
V_CUST_VERTICAL	varchar2(20),
V_BRANCH_ID	varchar2(20),
V_BRANCH_NAME	varchar2(300),
V_MESSAGE	varchar2(4000),
D_DATE	date,
D_CLOSEBY	date,
V_STATUS	varchar2(50),
V_ACTION	varchar2(100),
V_STAGE	varchar2(3),
N_SR number Primary key,
V_PAGE	varchar2(20),
V_ASSIGNED_USER_ID varchar2(20),
V_SIGNIFICANCE	varchar2(200),
V_RISK_MITIGATION	varchar2(200)
);

create table ADT_WF_ALERT_USR_ACTION(
N_ADT_ID number Primary key,
N_ALERT_SR number REFERENCES MST_WF_CUST_ALERT_DTL,
V_STATUS varchar2(50),
V_ACTION varchar2(100),
V_REMARKS varchar2(1000),
V_USER_ID varchar2(20),
V_LEVEL varchar2(3),
D_WHEN date);

create table ADT_WF_ALERT_ATTACHMENTS(
N_ADT_ID number REFERENCES ADT_WF_ALERT_USR_ACTION,
B_FILE Blob,
V_FILENAME varchar2(200),
V_FILETYPE varchar2(100)
);

create table MST_CUST_USER_MAP(
V_CUSTOMER_ID varchar2(20),
V_USER_ID_L1 varchar2(20),
V_USER_ID_L2	varchar2(20),
V_USER_ID_L3	varchar2(20),
V_USER_ID_L4	varchar2(20),
V_USER_ID_L5	varchar2(20),
V_USER_ID_L6	varchar2(20),
V_USER_ID_L7	varchar2(20),
V_USER_ID_L8	varchar2(20),
V_USER_ID_L9	varchar2(20),
V_USER_ID_L10	varchar2(20),
CONSTRAINT PK_USR_CUST_MAP PRIMARY KEY(V_CUSTOMER_ID,V_USER_ID_L1)
);

---------------------------------------------------------------------------------------------------------
INSERT INTO CNFG_STATUS_ACTION VALUES(1,'L0','Admin','Confirm Re-Assign','Approve','Move to New User');
INSERT INTO CNFG_STATUS_ACTION VALUES(2,'L0','Admin','Confirm Re-Assign','Reject','No Change');

INSERT INTO CNFG_STATUS_ACTION VALUES(3,'L1','BRANCH','Recommended for closure','Continue as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(4,'L1','BRANCH','Recommended for closure','Recommended for marking as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(5,'L1','BRANCH','Recommended for closure','Unmark existing RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(6,'L1','BRANCH','Recommended for closure','Not recommended for RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(7,'L1','BRANCH','Under Investigation','Intended for more information','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(8,'L1','BRANCH','Under Investigation','Information under process','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(9,'L1','BRANCH','False Positive','Mark As False Positive','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(10,'L1','BRANCH','Re-Assign Request','Request for Re-assignment of alert','Next Level');

INSERT INTO CNFG_STATUS_ACTION VALUES(11,'L2','REGION','Recommended for closure','Continue as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(12,'L2','REGION','Recommended for closure','Recommended for marking as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(13,'L2','REGION','Recommended for closure','Unmark existing RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(14,'L2','REGION','Recommended for closure','Not recommended for RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(15,'L2','REGION','Case Closed','Recommended for continuing existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(16,'L2','REGION','Case Closed','Recommended for marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(17,'L2','REGION','Case Closed','Recommended for unmarking of existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(18,'L2','REGION','Case Closed','Recommended for not marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(19,'L2','REGION','Under Investigation','Intended for more information','Same level');
INSERT INTO CNFG_STATUS_ACTION VALUES(20,'L2','REGION','Under Investigation','Information under process','Same level');
INSERT INTO CNFG_STATUS_ACTION VALUES(21,'L2','REGION','Confirm False Positive','Confirm as false positive','Alert Closure - False Positive');
INSERT INTO CNFG_STATUS_ACTION VALUES(22,'L2','REGION','Re-Assign Initiate','Initiate the request for re-assignment of alert','Move to Admin');
INSERT INTO CNFG_STATUS_ACTION VALUES(23,'L2','REGION','Re-Assign Request','Request for Re-assignment of alert','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(24,'L2','REGION','Rejected','Rejected','Previous Level');

INSERT INTO CNFG_STATUS_ACTION VALUES(25,'L3','ZONE','Recommended for closure','Continue as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(26,'L3','ZONE','Recommended for closure','Recommended for marking as RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(27,'L3','ZONE','Recommended for closure','Unmark existing RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(28,'L3','ZONE','Recommended for closure','Not recommended for RFA','Next Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(29,'L3','ZONE','Case Closed','Recommended for continuing existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(30,'L3','ZONE','Case Closed','Recommended for marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(31,'L3','ZONE','Case Closed','Recommended for unmarking of existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(32,'L3','ZONE','Case Closed','Recommended for not marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(33,'L3','ZONE','Under Investigation','Intended for more information','Same Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(34,'L3','ZONE','Under Investigation','Information under process','Same Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(35,'L3','ZONE','Re-Assign Initiate','Initiate the request for re-assignment','Move to Admin');
INSERT INTO CNFG_STATUS_ACTION VALUES(36,'L3','ZONE','Rejected','Rejected','Previous Level');

INSERT INTO CNFG_STATUS_ACTION VALUES(37,'L4','HO','Case Closed','Recommended for continuing existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(38,'L4','HO','Case Closed','Recommended for marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(39,'L4','HO','Case Closed','Recommended for unmarking of existing RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(40,'L4','HO','Case Closed','Recommended for not marking RFA','Alert Closure');
INSERT INTO CNFG_STATUS_ACTION VALUES(41,'L4','HO','Under Investigation','Intended for more information','Same Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(42,'L4','HO','Under Investigation','Information under process','Same Level');
INSERT INTO CNFG_STATUS_ACTION VALUES(43,'L4','HO','Re-Assign Initiate','Initiate the request for re-assignment','Move to Admin');
INSERT INTO CNFG_STATUS_ACTION VALUES(44,'L4','HO','Rejected','Rejected','Previous Level');

COMMIT;
