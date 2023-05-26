package com.asymmetrix.grc.entity.converter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.asymmetrix.grc.common.utils.GRCConstants;

@Converter
public class UserPreferencesConverter implements AttributeConverter<Set<String>, String> {

  public UserPreferencesConverter() {}

  @Override
  public String convertToDatabaseColumn(Set<String> columns) {
    return String.join(",", columns);
  }

  @Override
  public Set<String> convertToEntityAttribute(String csvColumnVal) {
    return Stream.of(csvColumnVal.trim().split(GRCConstants.COMMA)).collect(Collectors.toSet());
  }

}
