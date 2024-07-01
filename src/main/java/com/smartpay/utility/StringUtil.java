package com.smartpay.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtil {

	public static String generateLastSixDigit(String input) {
		String result = input.substring(4);
		return result;

	}

	public static Date convertStringToDate(String dateOfBirth) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException ex) {
			log.error(ex.getMessage());
		}
		return date;

	}

	public static String generateDefaultPassword(String input) {
		String password = null;
		password = input + "12345";
		return password;
	}

	public static long generateRandomNumber() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));

	}

}
