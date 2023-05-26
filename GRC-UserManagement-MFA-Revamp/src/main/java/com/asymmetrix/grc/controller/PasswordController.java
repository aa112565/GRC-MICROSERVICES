package com.asymmetrix.grc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.PasswordDTO;
import com.asymmetrix.grc.service.PasswordService;
import com.asymmetrix.grc.service.UserService;

@RestController
public class PasswordController {

 // public static final String MAIL_FORGOT_PASSWORD_TOKEN_SUCCESS =
 //     "Forgot Password link has been send to the Registered Mail id : ";
  public static final String PASSWORD_UPDATED_SUCCESS = "Password Updated Successfully";

  @Resource
  UserService userServiceImpl;

  @Resource
  PasswordService passwordServiceImpl;

  @PostMapping("/forgotPassword/{userId}")
  public ResponseEntity<GRCResponse<?>> forgotPassword(final HttpServletRequest request,
      @PathVariable(name = "userId", required = true) final String userId) {
	  
  //  CnfgUserDTO cnfgUserModel = userServiceImpl.getUserById(userId);
  //  String maskedEmailId = passwordServiceImpl.mailForgotPasswordTokenUrl(cnfgUserModel);
  //  return GRCResponseEntity.success(MAIL_FORGOT_PASSWORD_TOKEN_SUCCESS.concat(maskedEmailId));
	  
	  CnfgUserDTO cnfgUserModel = userServiceImpl.getUserByIdWithOutException(userId);
	    return GRCResponseEntity.success(passwordServiceImpl.mailForgotPasswordTokenUrl(cnfgUserModel));
  }

  @PostMapping("/resetPassword")
  public ResponseEntity<GRCResponse<?>> resetPassword(
      @RequestBody(required = true) PasswordDTO passwordModel) {
    passwordServiceImpl.updatePassword(passwordModel);
    return GRCResponseEntity.success(PASSWORD_UPDATED_SUCCESS);
  }

}
