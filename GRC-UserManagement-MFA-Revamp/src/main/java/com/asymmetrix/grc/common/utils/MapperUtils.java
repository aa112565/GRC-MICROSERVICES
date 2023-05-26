package com.asymmetrix.grc.common.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

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

  public static <S, T> List<T> mapToTargetClass(List<S> sourceList, Class<T> targetClazz,
      String[] ignoreFields) {
    GRCUtils.isValid(sourceList, GRCErrorConstants.NOT_VALID);
    GRCUtils.isValid(ignoreFields, GRCErrorConstants.NOT_VALID);
    ObjectMapper mapperWithFilter = getMapperObjWithFilter(ignoreFields);
    return sourceList.stream().map(source -> mapperWithFilter.convertValue(source, targetClazz))
        .collect(Collectors.toList());
  }

  public static <S, T> T mapToTargetClass(S source, Class<T> targetClazz, String[] ignoreFields) {
    GRCUtils.isValid(source, GRCErrorConstants.NOT_VALID);
    GRCUtils.isValid(ignoreFields, GRCErrorConstants.NOT_VALID);
    return getMapperObjWithFilter(ignoreFields).convertValue(source, targetClazz);
  }

  private static ObjectMapper getMapperObjWithFilter(String[] ignoreFields) {
    ObjectMapper mapperWithFilter = new ObjectMapper();
    FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterClass",
        SimpleBeanPropertyFilter.serializeAllExcept(ignoreFields));
    mapperWithFilter.setFilterProvider(filterProvider);
    return mapperWithFilter;
  }

}
