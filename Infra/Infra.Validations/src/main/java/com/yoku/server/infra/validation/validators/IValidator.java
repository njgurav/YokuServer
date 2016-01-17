package com.yoku.server.infra.validation.validators;

/**
 * Parent class for Validators of different types.
 */
public interface IValidator {
	/**
	 * Validates Object of a generic Type.
	 * 
	 * @param object
	 *            Object instance to validate.
	 * @return An Array of {@link ValidationError} containing data of the object
	 *         content that failed validation. Returns null Array if validation
	 *         is successful.
	 */
	public <T> ValidationError[] validate(T object);
}
