package com.asymmetrix.grc.service.impl;

import java.util.List;
//import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.constants.KRIConstants;
import com.asymmetrix.grc.common.exception.KRIRestClientException;
//import com.asymmetrix.grc.dto.CnfgUserWithManagerDTO;
//import com.asymmetrix.grc.dto.MailDetailsDTO;
//import com.asymmetrix.grc.dto.SMSDetailsDTO;
import com.google.common.net.HttpHeaders;

@Service
public class ExternalRESTService {

	private static final WebClient WEB_CLIENT = WebClient.create();

	private static final Logger LOG = LoggerFactory.getLogger(ExternalRESTService.class);

	private static final String USER_MGMT_ERROR = "USER MGMT Micro service Connection Error, ERRRO_MSG : ";

	@Loggable(action = KRIConstants.USR_MGMT_REST_CALL)
	public List<String> getLvl1BrncCodeFomUsrMgmt(String url, String tokenValue) {
		try {
			return WEB_CLIENT.get().uri(url).accept(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, tokenValue).retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<String>>() {
					}).block();
		} catch (Exception e) {
			LOG.error("REST service ERROR : ", e);
			throw new KRIRestClientException(USER_MGMT_ERROR + e);
		}
	}

	/*
	 * @Loggable(action = GRCConstants.USR_MGMT_REST_CALL) public
	 * List<CnfgUserWithManagerDTO> getUserWithMgrFromUsrMgmt(String url,
	 * Set<String> branchCode) { try { return
	 * WEB_CLIENT.post().uri(url).bodyValue(branchCode).accept(MediaType.
	 * APPLICATION_JSON) .retrieve().bodyToMono(new
	 * ParameterizedTypeReference<List<CnfgUserWithManagerDTO>>() {}) .block(); }
	 * catch (Exception e) { LOG.error("REST service ERROR : ", e); throw new
	 * GRCRestClientException(USER_MGMT_ERROR + e); } }
	 * 
	 * @Loggable(action = GRCConstants.EMAIL_MICRO_SERVICE_REST_CALL) public void
	 * postUserDtlToEmailService(String url, List<MailDetailsDTO> mailDetails) { //
	 * restcall to Email microservice to insert emaildetails try { ClientResponse
	 * spec = WEB_CLIENT.put().uri(url).bodyValue(mailDetails).exchange().block();
	 * LOG.info("spec = {}", spec.rawStatusCode()); } catch (Exception e) {
	 * LOG.error("REST service ERROR : ", e); throw new
	 * GRCRestClientException(USER_MGMT_ERROR + e); } }
	 * 
	 * @Loggable(action = GRCConstants.SMS_MICRO_SERVICE_REST_CALL) public void
	 * postUserDtlToSMSService(String url, List<SMSDetailsDTO> smsDetails) { //
	 * restcall to SMS microservice to insert smsdetails }
	 */
}
