package com.asymmetrix.grc.service.impl;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.asymmetrix.grc.common.utils.GRCConstants;
import com.asymmetrix.grc.common.utils.GRCUtils;
import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.CnfgPropertyDetailsDTO;
import com.asymmetrix.grc.entity.CnfgPropertyDetails;
import com.asymmetrix.grc.repository.CnfgPropertyDetailsRepository;
import com.asymmetrix.grc.service.CnfgPropertyDetailsService;

@Service
public class CnfgPropertyDetailsServiceImpl implements CnfgPropertyDetailsService {

  @Resource
  CnfgPropertyDetailsRepository cnfgExternalRepo;

  @Override
  public void saveExternalCnfgDetails(List<CnfgPropertyDetailsDTO> model) {
    cnfgExternalRepo.saveAll(MapperUtils.mapToTargetClass(model, CnfgPropertyDetails.class));
    // updateAppProperties(model);
  }

  @Override
  public List<CnfgPropertyDetailsDTO> getAllCnfgDetailsByCnfgName(String cnfgName) {
    return MapperUtils.mapToTargetClass(cnfgExternalRepo.findByCnfgNameIgnoreCase(cnfgName),
        CnfgPropertyDetailsDTO.class);
  }

  @Override
  public boolean isAuthTypeByValue(String authType) {
    return cnfgExternalRepo.isExistsByCnfgKeyAndCnfgValue(GRCConstants.AUTH_TYPE, authType);
  }

  @Override
  public List<String> getAllGradeAsList() {
    CnfgPropertyDetails entity = cnfgExternalRepo.findByCnfgNameIgnoreCaseAndCnfgKeyIgnoreCase(
        GRCConstants.PROP_CNFG_NAME_GRADE, GRCConstants.PROP_CNFG_KEY_USER_GRADE_LIST);
    if (!ObjectUtils.isEmpty(entity) && !ObjectUtils.isEmpty(entity.getCnfgValue())) {
      return GRCUtils.csvToList(entity.getCnfgValue());
    }
    return Collections.emptyList();
  }

  /*
   * private void updateAppProperties(List<CnfgExternalAuthDetailsModel> models) {
   * GRCUtils.updateAppProperties(models.stream().collect(Collectors.toMap(
   * CnfgExternalAuthDetailsModel::getCnfgKey, CnfgExternalAuthDetailsModel::getCnfgValue))); }
   */

}
