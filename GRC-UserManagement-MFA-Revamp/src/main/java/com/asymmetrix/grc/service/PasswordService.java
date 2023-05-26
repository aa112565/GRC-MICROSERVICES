package com.asymmetrix.grc.service;

import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.PasswordDTO;

public interface PasswordService {

  String mailForgotPasswordTokenUrl(CnfgUserDTO cnfgUserModel);

  void updatePassword(PasswordDTO passwordModel);

  boolean isForgotPasswordTokenValid(String token);

}
