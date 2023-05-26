package com.asymmetrix.grc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.asymmetrix.grc.common.exception.GRCRestClientException;
import com.asymmetrix.grc.dto.MailDetailsDTO;

@Service
public class ExternalRESTService {

  private static final WebClient WEB_CLIENT = WebClient.create();

  @SuppressWarnings("unused")
private static final Logger LOG = LoggerFactory.getLogger(ExternalRESTService.class);

  private static final String EMAIL_MICROSERVICE_ERROR =
      "Email Micro service Connection Error, ERRRO_MSG : ";
/*
  public void sendForgotPasswordMail(String url, MailDetailsDTO mailDetails) {
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
*/
  
	public void sendMail(final String url, final MailDetailsDTO mailDetails) {
		try {
			ClientResponse spec = WEB_CLIENT.put().uri(url).bodyValue(mailDetails).exchange().block();
			spec.statusCode();
			if (spec.statusCode() != HttpStatus.OK) {
				throw new GRCRestClientException(EMAIL_MICROSERVICE_ERROR + spec.statusCode());
			}
		} catch (Exception e) {
			throw new GRCRestClientException(EMAIL_MICROSERVICE_ERROR, e);
		}
	}
}
