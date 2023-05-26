package com.asymmetrix.grc.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class HashingAttributeConverter implements AttributeConverter<String, String> {

	public HashingAttributeConverter() {
	}

	@Override
	public String convertToDatabaseColumn(String column) {
		return column;
	}

	@Override
	public String convertToEntityAttribute(String column) {
	//	return GRCUtils.hashingInput(column);
		return column;
	}

}
