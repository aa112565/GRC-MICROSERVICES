package com.grc.email.service;

import java.util.List;

import com.grc.email.dto.MstCustAlertDtlDTO;

public interface MstCustAlertDtlService {
	public List<MstCustAlertDtlDTO> getAllAlerts();
	public Integer saveAlerts(List<MstCustAlertDtlDTO> alerts);
	public void saveAlert(MstCustAlertDtlDTO alert);
	public List<MstCustAlertDtlDTO> getAllAlertsForUser(String userid);
}
