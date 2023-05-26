package com.asymmetrix.grc.common.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Random;
//import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import com.asymmetrix.grc.common.exception.GRCException;

public class GRCUtils {
	
	private static final String DIGIT_REGEX = "-?\\d+(\\.\\d+)?";

	private static final String EMAIL_REGEX = "(?<=.{3}).(?=.*@)";

	private static final String MOBILE_REGEX = ".(?=.{4})";

	private static final String GENERAL_REGX = "(?<!^.?).(?!.?$)";

	private static Pattern pattern = Pattern.compile(DIGIT_REGEX);

 
   private GRCUtils() {}
 

  public static <T> void isValid(T t) {
    if (ObjectUtils.isEmpty(t)) {
      throw new GRCException(GRCErrorConstants.VALUE_IS_NULL);
    }
  }

  public static <T> void isValid(T t, String msg) {
    if (ObjectUtils.isEmpty(t)) {
      throw new GRCException(msg);
    }
  }

  public static String toUpperWithSpeChar(String str, String specialChar) {
    isValid(str);
    return str.replaceAll("()([A-Z])", "$1" + specialChar + "$2").toUpperCase();
  }

  public static String getAppUrl(HttpServletRequest request) {
    isValid(request);
    return new StringBuilder().append(GRCConstants.HTTP).append(request.getServerName())
        .append(GRCConstants.COLON).append(request.getServerPort()).append(request.getContextPath())
        .toString();
  }


  // need to find work around for update the properties files
  // As a work around we can move the application properties files to external location.
  public static void updateAppProperties(Map<String, String> editedPropMap) {
    try {
      File file = ResourceUtils.getFile("classpath:application.properties");
      Path path = file.toPath();
      try (Stream<String> lines = Files.lines(path)) {
        List<String> replaced = lines.map(line -> replaceKeyValuePair(line, editedPropMap))
            .collect(Collectors.toList());
        Files.write(path, replaced);
      }
    } catch (IOException ex) {
      throw new GRCException(
          "Error while updating the application.properties : " + ex.getLocalizedMessage());
    }
  }

  public static String replaceKeyValuePair(String line, Map<String, String> editedPropMap) {
    for (Map.Entry<String, String> entry : editedPropMap.entrySet()) {
      String key = entry.getKey();
      if (line.contains(key)) {
        CharSequence propValue = line.subSequence(key.length() + 1, line.length());
        line = line.replace(propValue.toString(), entry.getValue());
      }
    }
    return line;
  }
/*
  public static String maskUserEmailId(String emailId) {
    isValid(emailId);
    return emailId.replaceAll("(?<=.{3}).(?=.*@)", "*");
  }
*/
  public static boolean isAdmin(String userLevel) {
    return GRCConstants.ADMIN_USER_LEVEL.equalsIgnoreCase(userLevel);
  }

  public static boolean isLevel1User(String userLevel) {
    return GRCConstants.LEVEL_1.equalsIgnoreCase(userLevel);
  }

  public static List<String> csvToList(String csvString) {
    isValid(csvString);
    return Stream.of(csvString.trim().split(GRCConstants.COMMA)).collect(Collectors.toList());
  }
 
 
  /*
	public static String maskInput(String input) {
		if (ObjectUtils.isEmpty(input)) {
			return input;
		}
		return input.replaceAll("(?<=^.)[^@]*|(?<=@.).*(?=\\.[^.]+$)", "***");
	}

	public static String hashingInput(String input) {
		if (ObjectUtils.isEmpty(input)) {
			return input;
		}
		return BCryptUtils.hashInput(input);
	}
*/
  	static Random rnd = new Random();
	public static int getRandomOTP(int min, int max) {
		return rnd.ints(min, max).findFirst().getAsInt();
	}

  public static String maskInput(String input) {
		isValid(input);
		return input.replaceAll(isNumeric(input) ? MOBILE_REGEX : isEmail(input) ? EMAIL_REGEX : GENERAL_REGX, "*");
	}

	public static boolean isNumeric(String numberAsString) {
		return pattern.matcher(numberAsString).matches();
	}

	public static boolean isEmail(String input) {
		return input.contains("@");
	}
  
}

