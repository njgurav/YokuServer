package com.yoku.setver.infra.validation.factory;

import com.yoku.server.infra.validation.validators.IValidator;
/**
 * Abstract Validator Factory. Parent for Validator Factories.
 */
public abstract class AbstractValidatorFactory {
	
	/**
	 * Provide validator based on the {@link ValidatorType} requested.
	 * @param type {@link ValidatorType}
	 * @return {@link IValidator}
	 */
	public abstract IValidator getValidator(ValidatorType type);
	
	
}
