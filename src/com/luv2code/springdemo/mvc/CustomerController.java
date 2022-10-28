package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//add an initbinder ...pour supprimer les espaces avant et après le mot
	//! SUPPRIMER LES ESPACES ET CONVERTIR EN NULL!!!!!
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		//true = null si rien 
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		//A l'origine
//		if (theBindingResult.hasErrors()) {
//			return "customer-form";
//		} else {
//		
//		return "customer-confirmation";}
		//Permet de voir le nom de l'erreur à modifier avec le fichier message.properties
		System.out.println("Binding result : "+theBindingResult);
		
		//Autre manière de faire
		return theBindingResult.hasErrors() ?  "customer-form" : "customer-confirmation";
		
	}
	
	
}
