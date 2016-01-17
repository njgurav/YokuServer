package com.yoku.server.core.validation.validator;

import com.yoku.server.framework.dto.BaseRequestDTO;
import com.yoku.server.infra.validation.validators.IValidator;
import com.yoku.server.infra.validation.validators.ValidationError;

/**
 * Validator for {@link BaseRequestDTO}
 */
public class RequestDTOValidator implements IValidator {

	/**
	 * Validate object
	 */
	public <T> ValidationError[] validate(T object) {
		// TO_DO add validation logic here

		return null;
	}
	/**
	 * Generate Validator instance
	 * @return {@link RequestDTOValidator} instace.
	 */
	public static IValidator getInstance() {
		return new RequestDTOValidator();
	}
}
