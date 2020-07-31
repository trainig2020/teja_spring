package com.Controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.springframework.messaging.handler.annotation.Payload;

@Documented

@Constraint(validatedBy=HobbyValidator.class)

@Target({ElementType.FIELD})

@Retention(RetentionPolicy.RUNTIME)

public @interface IsValidHobby {
	String listOfValidHobbies() default "Music|Dance|Sports";

 String message() default "Please enter valid Hobby :"+

"Accepted Hobbies are : Music, Dance, Sports(choose any)";

Class<?>[] groups() default {};

Class<? extends Payload>[] payload() default {};



}

