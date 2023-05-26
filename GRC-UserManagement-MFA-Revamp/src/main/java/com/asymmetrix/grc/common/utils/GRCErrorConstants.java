package com.asymmetrix.grc.common.utils;

public class GRCErrorConstants {

  private GRCErrorConstants() {}
  
  public static final String ENTITY_ORG_NOT_FOUND = "Records not found for Organization";
  public static final String ENTITY_ORG_SUBS_DEPT_NOT_FOUND = "Records not found for Organizaion-Department Mapping";
  public static final String WORKFLOW_ORG_SUBS_DEPT_NOT_FOUND = "Records not found for Organizaion-Department Workflow Mapping";
  public static final String ENTITY_ORG_SUBS_NOT_FOUND = "Records not found for Organization-Subsidiary";
  public static final String ENTITY_DEPT_NOT_FOUND = "Records not found for Department";
  public static final String ENTITY_NOT_FOUND = "Records not found for given id =";
  public static final String IN_VALID_TYPE = "Not a valid type ie type = ";
  public static final String NOT_VALID = "Records not found / empty";
  public static final String VALUE_IS_NULL = "Value cannot be null";
  public static final String INVALID_EXCEL_FILE_FORMAT = "Please upload an excel file!";
  public static final String USER_NOT_FOUND = "User Not Found";
  public static final String ERROR_SEND_FORGOT_PASSWORD_TOKEN_MAIL =
      "Error while sending forgot password token mail";
  public static final String ERROR_INVALID_FORGOT_PWD_RESET_TOKEN =
      "Invalid forgot password reset token";
  public static final String ERROR_USER_ID_OR_PASSWORD_NOT_MATCHED =
      "UserId or Password is Not Matched";
  public static final String ERROR_USER_ALREAD_EXISITS = "User Already Exists";
  public static final String ERROR_GROUP_NAME_ALREAD_EXISITS = "GroupName Already Exists";
  public static final String ERROR_GROUP_NAME_IS_INVALID = "Following Group name are invalid : ";
  public static final String ERROR_GROUP_NAME_IN_EXCEL_IS_EMPTY =
      "Group name in the uploaded excel is empty";
  public static final String ERROR_GROUP_NAME_IN_EXCEL_IS_INVALID =
      "Group name in the uploaded excel is invalid ";
  public static final String ERROR_GRADE_IN_EXCEL_IS_EMPTY = "Grade in the uploaded excel is empty";
  public static final String ERROR_GRADE_IN_EXCEL_IS_INVALID =
      "Grade in the uploaded excel is invalid ";
  public static final String ERROR_GRADE_IS_INVALID = "Following Grade are invalid : ";

  public static final String FAILED = "Failed";
  public static final String ERROR = "Error";
  public static final String SERVER_ERROR = "Server Error";

  public static final String LOG_FAILED_DUE_TO = "Failed due to :";
  public static final String LOG_DB_RELATED_EXCEPTION = "DB Related Exception : ";
  public static final String LOG_ERROR = "Error : ";

  public static final String MAXIMUM_LICENSE_USER_LIMIT_EXCEEDED =
      "Maximum licensed user limit exceeded, Kindly updagrade your license";


}
