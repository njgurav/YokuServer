package com.yoku.server.core.validation.validator;

import com.yoku.server.framework.dto.BaseRequestDTO;
import com.yoku.server.infra.validation.validators.IValidator;
import com.yoku.server.infra.validation.validators.ValidationError;

/**
 * Validator for {@link BaseRequestDTO}
 */
public class ResponseDTOValidator implements IValidator {
	/**
	 * Validate object
	 */
	public <T> ValidationError[] validate(T object) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Generate Validator instance
	 * @return {@link ResponseDTOValidator} instace.
	 */
	public static IValidator getInstance() {
		return new ResponseDTOValidator();
	}
}
