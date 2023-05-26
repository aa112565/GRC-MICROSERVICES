package com.asymmetrix.grc.service;

import java.util.List;

import com.asymmetrix.grc.dto.CnfgPropertyDetailsDTO;

public interface CnfgPropertyDetailsService {

  public void saveExternalCnfgDetails(List<CnfgPropertyDetailsDTO> cnfgExternalAuthDetailsModel);

  public List<CnfgPropertyDetailsDTO> getAllCnfgDetailsByCnfgName(String cnfgName);

  boolean isAuthTypeByValue(String cnfgValue);

  List<String> getAllGradeAsList();

}
