package com.asymmetrix.grc.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.ObjectUtils;
public class CipherUtils {
	private static final String AES = "AES";
	private static final int KEY_LENGTH = 256;
	private static final int ITERATION = 7598;
	private static final String AES_CBC_PKCSPADDING = "AES/CBC/PKCS5Padding";
	private static final String SECRET_KEY = "bct1bnco#";
	private static final String PBKDF2WITH_HMAC_SHA256 = "PBKDF2WithHmacSHA256";
//	private static final String REG_EX_FOR_MOBILE_NUMBER = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
//			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	
	private static final String REG_EX_FOR_MOBILE_NUMBER = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$"
			+"|^([+]\\d{2})?\\d{10}$/"+ "|^[0-9]*$";
	
	private CipherUtils() {
	}

	public static String encryptByAES256(String plaintext, String salt) {
		try {
			if (ObjectUtils.isEmpty(plaintext)) {
				return plaintext;
			}
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCSPADDING);
			cipher.init(Cipher.ENCRYPT_MODE, getSceretKeySpec(salt, SECRET_KEY), generateIv());
			return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decryptByAES256(String cipherText, String salt) {
		try {
			if (ObjectUtils.isEmpty(cipherText) || !isValidEncryptedData(cipherText)) {
				return cipherText;
			}
			System.out.println("cipherText"+cipherText);
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCSPADDING);
			cipher.init(Cipher.DECRYPT_MODE, getSceretKeySpec(salt, SECRET_KEY), generateIv());
			return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// TODO
	// need to be removed because some data in DB are not encrypted.
	// if we try to decrypt the plain text we will get exception so
	// for testing purpose we have handle the exception returning the actual
	// text
/*	private static boolean isValidEncryptedData(String input) {
		try {
			Base64.getDecoder().decode(input);
			return Boolean.TRUE;
		} catch (IllegalArgumentException e) {
			return Boolean.FALSE;
		}
	}
*/
	private static boolean isValidEncryptedData(String input) {
		try {
			if (isMobileNumber(input)) {
				return Boolean.FALSE;
			}
			Base64.getDecoder().decode(input.getBytes());
			return Boolean.TRUE;
		} catch (IllegalArgumentException e) {
			return Boolean.FALSE;
		}
	}

	private static boolean isMobileNumber(String mobileNumber) {
		Pattern pattern = Pattern.compile(REG_EX_FOR_MOBILE_NUMBER);
		Matcher matcher = pattern.matcher(mobileNumber);
		return matcher.matches();
	}
	
	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		return new IvParameterSpec(iv);
	}

	private static SecretKeySpec getSceretKeySpec(String salt, String secretKey)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2WITH_HMAC_SHA256);
		KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), ITERATION, KEY_LENGTH);
		SecretKey tmp = factory.generateSecret(spec);
		return new SecretKeySpec(tmp.getEncoded(), AES);
	}
	
	
	public static void main(String[] args) {
		System.out.println(isValidEncryptedData("9962622893"));
		System.out.println(isValidEncryptedData("test@email.com"));
	}

}
