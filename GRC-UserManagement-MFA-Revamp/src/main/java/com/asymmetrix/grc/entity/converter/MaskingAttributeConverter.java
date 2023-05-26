package com.asymmetrix.grc.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.asymmetrix.grc.common.utils.GRCUtils;

@Converter
public class MaskingAttributeConverter implements AttributeConverter<String, String> {

	public MaskingAttributeConverter() {
	}

	@Override
	public String convertToDatabaseColumn(String column) {
		return column;
	}

	@Override
	public String convertToEntityAttribute(String column) {
		return GRCUtils.maskInput(column);
	}

}
