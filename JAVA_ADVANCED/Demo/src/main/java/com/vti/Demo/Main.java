package com.vti.Demo;

import java.awt.Button;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[A-Z 0-9._%-+]+@[A-Z 0-9.-]+\\.[A-Z]{2,6}",Pattern.CASE_INSENSITIVE);
		String email = "hoangtruong@gmail.com";
		String email2 = "hoangtruong83834.com.vn";
		Matcher matcher = pattern.matcher(email2);
//		System.out.println(matcher.find());
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
