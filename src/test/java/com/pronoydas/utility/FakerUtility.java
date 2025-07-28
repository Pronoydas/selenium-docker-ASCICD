package com.pronoydas.utility;

import com.github.javafaker.Faker;

public class FakerUtility {
	

	private static Faker getFakerObject() {
		return new Faker();
	}
	
	
	
	public static String getFristName() {
		return getFakerObject().name().firstName();
	}
	
	public static String getLastName() {
		return getFakerObject().name().lastName();
	}
	
	public static String getEemail() {
		return getFakerObject().internet().emailAddress();
	}
	
	public static String generatePassword() {
		return getFakerObject().internet().password();
	}
}
