package com.asymmetrix.asset.common.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import com.asymmetrix.asset.common.constants.AssetConstants;
import com.asymmetrix.asset.common.constants.AssetErrorConstants;
import com.asymmetrix.asset.common.exception.AssetException;

public class AssetUtils {

	private AssetUtils() {
	}

	public static <T> void isValid(T t) {
		if (ObjectUtils.isEmpty(t)) {
			throw new AssetException(AssetErrorConstants.VALUE_IS_NULL);
		}
	}

	public static <T> void isValid(T t, String msg) {
		if (ObjectUtils.isEmpty(t)) {
			throw new AssetException(msg);
		}
	}

	public static String toUpperWithSpeChar(String str, String specialChar) {
		return str.replaceAll("()([A-Z])", "$1" + specialChar + "$2").toUpperCase();
	}

	public static String getAppUrl(HttpServletRequest request) {
		return new StringBuilder().append(AssetConstants.HTTP).append(request.getServerName())
				.append(AssetConstants.COLON).append(request.getServerPort()).append(request.getContextPath())
				.toString();
	}

	// need to find work around for update the properties files
	// As a work around we can move the application properties files to external
	// location.
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
			throw new AssetException("Error while updating the application.properties : " + ex.getLocalizedMessage());
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

	public static String maskUserEmailId(String emailId) {
		return emailId.replaceAll("(?<=.{3}).(?=.*@)", "*");
	}

	public static boolean isAdmin(String userLevel) {
		return AssetConstants.ADMIN_USER_LEVEL.equalsIgnoreCase(userLevel);
	}

	public static boolean isLevel1User(String userLevel) {
		return AssetConstants.LEVEL_1.equalsIgnoreCase(userLevel);
	}

}
