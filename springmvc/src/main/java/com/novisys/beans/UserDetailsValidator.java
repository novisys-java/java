package com.novisys.beans;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDetailsValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		boolean flag = arg0.equals(Emp.class);
		return flag;
	}

	public void validate(Object cmdObj, Errors errors) {
		Emp emp = (Emp) cmdObj;
		
		if(emp.getEname().length() > 5) {
			errors.reject("ename", "EMP Name must not be greater than 5 chars...");
		}
		
	}

}
