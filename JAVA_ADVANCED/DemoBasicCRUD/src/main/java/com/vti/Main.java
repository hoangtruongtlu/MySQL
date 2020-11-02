package com.vti;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vti.entity.Department;

public class Main {

	public static void main(String[] args) {
		Department department = new Department();
		department.setDepartmentName("ABC");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		validator.validate(department);
		Set<ConstraintViolation<Department>> violations = validator.validate(department);
		for (ConstraintViolation<Department> violation : violations) {
			System.out.println(violation.getMessage());
		}
	}

}
