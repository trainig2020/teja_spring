package com.Controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

     public String listOfValidHobbies;

	 @Override

	   public void initialize(IsValidHobby isValidHobby) {
		 this.listOfValidHobbies=isValidHobby.listOfValidHobbies();
}

    @Override
    public boolean isValid(String studentHobby, ConstraintValidatorContext arg1) {

	 if(studentHobby==null){

	  return false;
     }

	 else if(studentHobby.matches(listOfValidHobbies)){

	  return true;

	 }

	 else{

	  return false;

	 }



	 }



	}

