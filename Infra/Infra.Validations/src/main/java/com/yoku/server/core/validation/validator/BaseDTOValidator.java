package com.yoku.server.core.validation.validator;

import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.validation.validators.IValidator;
import com.yoku.server.infra.validation.validators.ValidationError;
/**
 * Validator for {@link BaseDTO}
 */
public class BaseDTOValidator implements IValidator {

	/**
	 * Validate object.
	 */
	public <T> ValidationError[] validate(T object) {
		//TO-DO add validation logic		
		return null;
	}
	
	/**
	 * Generate Validator instance
	 * @return {@link BaseDTOValidator} instace.
	 */
	public static IValidator getInstance(){
		return new BaseDTOValidator();
	}
	
	

}
