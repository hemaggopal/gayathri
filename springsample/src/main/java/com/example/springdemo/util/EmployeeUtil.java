package com.example.springdemo.util;

import java.text.MessageFormat;

public class EmployeeUtil {

	public static String formatMsg(String msg, Object... value) {
		return MessageFormat.format(msg, value);
	}
}
