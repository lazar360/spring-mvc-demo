package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Pour implémenter les méthodes de l'interface clic droit>source>implement override methods
//Sélectionner toutes les méthodes pour implémentation
public class CourseCodeConstraintValidator 
implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		//theCourseCode.value() renvoie à CourseCode.java value = "LUV"
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
	//Ici, on met ce qu'en veut au noveau de la règle de validation /!\	
				//Attention, il faut faire un null check sinon null pointer exception
				//Autre solution : annotation not null
		return theCode != null ?  theCode.startsWith(coursePrefix) : true;
	}

}
