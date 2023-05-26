package com.grc.email.common.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grc.email.common.constants.GRCErrorConstants;

public class MapperUtils {

  static ObjectMapper mapper = new ObjectMapper();

  private MapperUtils() {}

  public static <S, T> List<T> mapToTargetClass(List<S> sourceList, Class<T> targetClazz) {
    GRCUtils.isValid(sourceList, GRCErrorConstants.NOT_VALID);
    return sourceList.stream().map(source -> mapToTargetClass(source, targetClazz))
        .collect(Collectors.toList());
  }

  public static <S, T> T mapToTargetClass(S source, Class<T> targetClazz) {
    GRCUtils.isValid(source, GRCErrorConstants.NOT_VALID);
    return mapper.convertValue(source, targetClazz);
  }

  public static <S, T> T mapToTargetClass(Map<String, S> map, Class<T> targetClazz) {
    GRCUtils.isValid(map, GRCErrorConstants.NOT_VALID);
    return mapper.convertValue(map, targetClazz);
  }

}
