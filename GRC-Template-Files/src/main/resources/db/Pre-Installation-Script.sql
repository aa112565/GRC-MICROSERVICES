
-- QUESTIONS_TYPES INSERT STMT --
INSERT INTO "QUESTIONS_TYPES" (N_QTYPE_ID, V_QTYPE) VALUES ('1', 'Yes Or No');
INSERT INTO "QUESTIONS_TYPES" (N_QTYPE_ID, V_QTYPE) VALUES ('2', 'Rating');
INSERT INTO "QUESTIONS_TYPES" (N_QTYPE_ID, V_QTYPE) VALUES ('3', 'Statement');
INSERT INTO "QUESTIONS_TYPES" (N_QTYPE_ID, V_QTYPE) VALUES ('4', 'Date');
INSERT INTO "QUESTIONS_TYPES" (N_QTYPE_ID, V_QTYPE) VALUES ('5', 'Multi Choice');


-- QUESTION_TYPES_OPTIONS INSERT STMT --

INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('1', '1', 'R101', 'Yes / No');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('2', '1', 'R102', 'Yes / No / Not Applicable');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('3', '1', 'R103', 'Yes / No / Not Sure');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('4', '1', 'R104', 'Yes / No / Not Sure / Not Applicable');

INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('5', '2', 'R201', 'Strongly agree / Agree / Neutral / Disagree / Strongly disagree' );
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('6', '2', 'R202', 'Strongly agree / Agree / Neutral / Disagree / Strongly disagree / Not Applicable' );
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('7', '2', 'R203', 'Strongly agree / Agree / Neutral / Disagree / Strongly disagree / Not Sure' );
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('8', '2', 'R204', 'Strongly agree / Agree / Neutral / Disagree / Strongly disagree / Not Sure / Not Applicable' );

INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('9', '3', 'R301' ,'Text Box');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('10', '3', 'R302' ,'Text Area');

INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('11', '4', 'R401' ,'Show Past Date');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('12', '4', 'R402' ,'Show Future Date');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('13', '4', 'R403' ,'No Criteria');

INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('14', '5', 'R501' ,'Show as DropDown');
INSERT INTO "QUESTION_TYPES_OPTIONS" (N_QUEST_TYPE_OPT_ID, N_QTYPE_ID, V_QUEST_TYPE_OPT_KEY, V_QUEST_TYPE_OPT_VALUE) VALUES ('15', '5', 'R502' ,'Show as Button');


--- Below Insert Script Need To Be Moved To User Mgmt Micro-service ---
--- ROLES/MENU FOR VIEW AND CREATE TEMPLATE ---
INSERT INTO "CNFG_MENU" (V_MENU_ID, V_MENU_NAME, V_SUB_MENU_NAME, V_RW_ACCESS, V_ROLE_NAME) VALUES ('53', 'Template Management', 'View Template', 'R', 'ROLE_TEMPLATE_READ');
INSERT INTO "CNFG_MENU" (V_MENU_ID, V_MENU_NAME, V_SUB_MENU_NAME, V_RW_ACCESS, V_ROLE_NAME) VALUES ('54', 'Template Management', 'Create Template', 'W', 'ROLE_TEMPLATE_WRITE');


commit;