package com.asymmetrix.grc.entity.converter;

import javax.persistence.AttributeConverter;

import org.springframework.beans.factory.annotation.Value;
import com.asymmetrix.grc.common.utils.CipherUtils;

public class AttributeCipherConverter implements AttributeConverter<String, String> {

	@Value("${ews.cipher.salt}")
	private String grcCipherSalt;
	
	@Override
	public String convertToDatabaseColumn(String attribute) {	
		return CipherUtils.encryptByAES256(attribute, grcCipherSalt);
	}

	@Override
	public String convertToEntityAttribute(String attribute) {
		
		return  CipherUtils.decryptByAES256(attribute, grcCipherSalt);
	}

}
