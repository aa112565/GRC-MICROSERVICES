--------------------------------------------------------
--  File created - Wednesday-March-09-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MULTI_CHOICE_OPTIONS
--------------------------------------------------------

  CREATE TABLE "MULTI_CHOICE_OPTIONS" 
   (	"N_MC_ID" NUMBER(10,0) GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"V_KEY" VARCHAR2(255 CHAR), 
	"V_QUESTION_ID" VARCHAR2(255 CHAR), 
	"V_VALUE" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table QUESTION_TYPES_OPTIONS
--------------------------------------------------------

  CREATE TABLE "QUESTION_TYPES_OPTIONS" 
   (	"N_QUEST_TYPE_OPT_ID" NUMBER(10,0), 
	"N_QTYPE_ID" NUMBER(10,0), 
	"V_QUEST_TYPE_OPT_KEY" VARCHAR2(255 CHAR), 
	"V_QUEST_TYPE_OPT_VALUE" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table QUESTIONS
--------------------------------------------------------

  CREATE TABLE "QUESTIONS" 
   (	"V_QUESTION_ID" VARCHAR2(255 CHAR), 
	"B_IS_MULTI_CHOICE" NUMBER(1,0), 
	"B_JUSTIFICATION" NUMBER(1,0), 
	"N_QSRNO" NUMBER(10,0), 
	"N_QTYPE_ID" NUMBER(10,0), 
	"N_QUEST_TYPE_OPT_ID" NUMBER(10,0), 
	"V_QUESTION" VARCHAR2(255 CHAR), 
	"B_QUESTION_HINT" NUMBER(1,0), 
	"V_TEMPLATE_ID" VARCHAR2(255 CHAR), 
	"V_TEMPLATE_SECTION_ID" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table QUESTIONS_TYPES
--------------------------------------------------------

  CREATE TABLE "QUESTIONS_TYPES" 
   (	"N_QTYPE_ID" NUMBER(10,0), 
	"V_QTYPE" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table TEMPLATE
--------------------------------------------------------

  CREATE TABLE "TEMPLATE" 
   (	"V_TEMPLATE_ID" VARCHAR2(255 CHAR), 
	"D_CREATED" TIMESTAMP (6), 
	"D_LAST_UPDATED" TIMESTAMP (6), 
	"V_CREATED_BY" VARCHAR2(255 CHAR), 
	"V_LAST_UPDATED_BY" VARCHAR2(255 CHAR), 
	"V_TEMPLATE_NAME" VARCHAR2(255 CHAR), 
	"V_TEMPLATE_STATUS" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table TEMPLATE_SECTION
--------------------------------------------------------

  CREATE TABLE "TEMPLATE_SECTION" 
   (	"V_TEMPLATE_SECTION_ID" VARCHAR2(255 CHAR), 
	"V_SECTION_NAME" VARCHAR2(255 CHAR), 
	"V_TEMPLATE_ID" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Index SYS_C0014942
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014942" ON "MULTI_CHOICE_OPTIONS" ("N_MC_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0014944
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014944" ON "QUESTION_TYPES_OPTIONS" ("N_QUEST_TYPE_OPT_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0014955
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014955" ON "QUESTIONS" ("V_QUESTION_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0014957
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014957" ON "QUESTIONS_TYPES" ("N_QTYPE_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0014964
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014964" ON "TEMPLATE" ("V_TEMPLATE_ID") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C0014968
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0014968" ON "TEMPLATE_SECTION" ("V_TEMPLATE_SECTION_ID") 
  ;
--------------------------------------------------------
--  Constraints for Table MULTI_CHOICE_OPTIONS
--------------------------------------------------------

  ALTER TABLE "MULTI_CHOICE_OPTIONS" MODIFY ("N_MC_ID" NOT NULL ENABLE);
  ALTER TABLE "MULTI_CHOICE_OPTIONS" MODIFY ("V_KEY" NOT NULL ENABLE);
  ALTER TABLE "MULTI_CHOICE_OPTIONS" MODIFY ("V_QUESTION_ID" NOT NULL ENABLE);
  ALTER TABLE "MULTI_CHOICE_OPTIONS" MODIFY ("V_VALUE" NOT NULL ENABLE);
  ALTER TABLE "MULTI_CHOICE_OPTIONS" ADD PRIMARY KEY ("N_MC_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table QUESTION_TYPES_OPTIONS
--------------------------------------------------------

  ALTER TABLE "QUESTION_TYPES_OPTIONS" MODIFY ("N_QUEST_TYPE_OPT_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTION_TYPES_OPTIONS" ADD PRIMARY KEY ("N_QUEST_TYPE_OPT_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table QUESTIONS
--------------------------------------------------------

  ALTER TABLE "QUESTIONS" MODIFY ("V_QUESTION_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("B_IS_MULTI_CHOICE" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("B_JUSTIFICATION" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("N_QSRNO" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("N_QTYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("N_QUEST_TYPE_OPT_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("V_QUESTION" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("B_QUESTION_HINT" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("V_TEMPLATE_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" MODIFY ("V_TEMPLATE_SECTION_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS" ADD PRIMARY KEY ("V_QUESTION_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table QUESTIONS_TYPES
--------------------------------------------------------

  ALTER TABLE "QUESTIONS_TYPES" MODIFY ("N_QTYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "QUESTIONS_TYPES" ADD PRIMARY KEY ("N_QTYPE_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TEMPLATE
--------------------------------------------------------

  ALTER TABLE "TEMPLATE" MODIFY ("V_TEMPLATE_ID" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" MODIFY ("D_CREATED" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" MODIFY ("D_LAST_UPDATED" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" MODIFY ("V_CREATED_BY" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" MODIFY ("V_TEMPLATE_NAME" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" MODIFY ("V_TEMPLATE_STATUS" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE" ADD PRIMARY KEY ("V_TEMPLATE_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table TEMPLATE_SECTION
--------------------------------------------------------

  ALTER TABLE "TEMPLATE_SECTION" MODIFY ("V_TEMPLATE_SECTION_ID" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE_SECTION" MODIFY ("V_SECTION_NAME" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE_SECTION" MODIFY ("V_TEMPLATE_ID" NOT NULL ENABLE);
  ALTER TABLE "TEMPLATE_SECTION" ADD PRIMARY KEY ("V_TEMPLATE_SECTION_ID")
  USING INDEX  ENABLE;
