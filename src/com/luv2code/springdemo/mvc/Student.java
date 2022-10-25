package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String[] operatingSytems;
		
	public Student() {
		
		// populate country options : used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil"); 
		countryOptions.put("FR", "France"); 
		countryOptions.put("DE", "Germany"); 
		countryOptions.put("IN", "India"); 
		countryOptions.put("US", "United States of America"); 
	
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}
	
	//Setter d'origine
//	public void setCountry(String country) {
//		
//		this.country = country;
//	}
	
	//Autre manière de faire pour éviter l'affichage du code pays
	public void setCountry(String country) {
		
		this.country = countryOptions.get(country);
	}

	//Quand le formulaire est chargé, Spring appelle la méthode student.getCountryOtions()
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String[] getOperatingSytems() {
		return operatingSytems;
	}

	public void setOperatingSytems(String[] operatingSytems) {
		this.operatingSytems = operatingSytems;
	}
	
}
