/*package com.asymmetrix.grc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.exception.GRCRestClientException;

@Service
public class ExternalRESTServiceImpl {

  private static final WebClient WEB_CLIENT = WebClient.create();

  private static final Logger LOG = LoggerFactory.getLogger(ExternalRESTServiceImpl.class);

  private static final String EMAIL_MICROSERVICE_ERROR =
      "Email Micro service Connection Error, ERRRO_MSG : ";

  public void getRiskByIds(String url, List<String> riskIds) {
    // restcall to Email microservice to trigger forgot password email
    try {
      ClientResponse spec = WEB_CLIENT.put().uri(url).bodyValue(mailDetails).exchange().block();
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

}
*/