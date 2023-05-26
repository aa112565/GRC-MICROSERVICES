package com.asymmetrix.grc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.asymmetrix.grc.common.config.service.IAuthenticationDetails;
import com.asymmetrix.grc.common.exception.GRCRestClientException;
import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.dto.CnfgUserDTO;
import com.asymmetrix.grc.dto.DepartmentDTO;
import com.asymmetrix.grc.dto.EmployeeDTO;
import com.asymmetrix.grc.service.ExternalRESTService;

@Service
public class ExternalRESTServiceImpl implements ExternalRESTService{

  private static final WebClient WEB_CLIENT = WebClient.create();

  private static final Logger LOG = LoggerFactory.getLogger(ExternalRESTServiceImpl.class);
  
  private static final String USER_MGMT_ERROR = "USER MGMT Micro service Error, Check the error log";
  
  @Value("${usermgmt.endpoint}")
  private String userMgmtEndpoint;
  
  @Value("${usermgmt.resource.url.get.all.users}")
  private String getAllUsersUrl;
  
  @Value("${usermgmt.resource.url.get.all.departments}")
  private String getAllDepartmentsUrl;
  
  @Value("${usermgmt.resource.url.get.all.employees}")
  private String getAllEmployeesUrl;
  
  @Resource
  IAuthenticationDetails authDetails;

  private static final String EMAIL_MICROSERVICE_ERROR =
      "Email Micro service Connection Error, ERRRO_MSG : ";

  public void getRiskByIds(String url, List<String> riskIds) {
    // restcall to Email microservice to trigger forgot password email
    try {
      ClientResponse spec = WEB_CLIENT.put().uri(url).bodyValue("").exchange().block();
      LOG.info("spec = {}", spec.rawStatusCode());
      spec.statusCode();
      if (spec.statusCode() != HttpStatus.OK) {
        throw new GRCRestClientException(EMAIL_MICROSERVICE_ERROR + spec.statusCode());
      }
    } catch (Exception e) {
      LOG.error("REST service ERROR : ", e);
      throw new GRCRestClientException(EMAIL_MICROSERVICE_ERROR + e);
    }
  }
  
  public List<CnfgUserDTO> getAllUserDetailsFromUserMgmt() {
		try {
			LOG.info("Rest call to UserMGMT : getAllUserFromUserMgmt");
			GRCResponse<List<CnfgUserDTO>> response = WEB_CLIENT.get().uri(userMgmtEndpoint.concat(getAllUsersUrl))
					.accept(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, authDetails.getOAuthBearerToken()).retrieve()  
					.bodyToMono(new ParameterizedTypeReference<GRCResponse<List<CnfgUserDTO>>>() {
					}).block();
			return response.getResult();
		} catch (Exception e) {
			LOG.error("USMG MGMT MICROSERVICE ERROR - getAllUserFromUserMgmt : ", e);
			throw new GRCRestClientException(USER_MGMT_ERROR);
		}
  }
  
  public List<DepartmentDTO> getAllDepartmentsFromUserMgmt() {
		try {
			LOG.info("Rest call to UserMGMT : getAllDepartmentsFromUserMgmt");
			GRCResponse<List<DepartmentDTO>> response = WEB_CLIENT.get().uri(userMgmtEndpoint.concat(getAllDepartmentsUrl))
					.accept(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, authDetails.getOAuthBearerToken()).retrieve()  
					.bodyToMono(new ParameterizedTypeReference<GRCResponse<List<DepartmentDTO>>>() {
					}).block();
			return response.getResult();
		} catch (Exception e) {
			LOG.error("USMG MGMT MICROSERVICE ERROR - getAllDepartmentsFromUserMgmt : ", e);
			throw new GRCRestClientException(USER_MGMT_ERROR);
		}
	}
  
    public List<EmployeeDTO> getAllEmployeesFromUserMgmt(){
    	try {
			LOG.info("Rest call to UserMGMT : getAllEmployeesFromUserMgmt");
			GRCResponse<List<EmployeeDTO>> response = WEB_CLIENT.get().uri(userMgmtEndpoint.concat(getAllEmployeesUrl))
					.accept(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, authDetails.getOAuthBearerToken()).retrieve()  
					.bodyToMono(new ParameterizedTypeReference<GRCResponse<List<EmployeeDTO>>>() {
					}).block();
			return response.getResult();
		} catch (Exception e) {
			LOG.error("USMG MGMT MICROSERVICE ERROR - getAllEmployeesFromUserMgmt : ", e);
			throw new GRCRestClientException(USER_MGMT_ERROR);
		}
    	
    }

}
