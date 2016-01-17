package com.yoku.server.core.validation.factory;

import com.yoku.server.core.validation.validator.BaseDTOValidator;
import com.yoku.server.core.validation.validator.RequestDTOValidator;
import com.yoku.server.core.validation.validator.ResponseDTOValidator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.infra.validation.validators.IValidator;
import com.yoku.setver.infra.validation.factory.AbstractValidatorFactory;
import com.yoku.setver.infra.validation.factory.ValidatorType;

/**
 * DTO validator factory, provides validators for BaseRequestDTO,
 * BaseResponseDTO and BaseDTO. Create another factory for other type of
 * validators.
 */
public class DTOValidatorFactory extends AbstractValidatorFactory {
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(DTOValidatorFactory.class);

	/**
	 * Returns validator instance for BaseReauestDTO, BaseResponseDTO and
	 * BaseDTO based on the requested validator type.
	 */
	@Override
	public IValidator getValidator(ValidatorType type) {
		IValidator validator = null;
		switch (type) {
		case REQUEST_DTO:
			validator = RequestDTOValidator.getInstance();
			break;
		case RESPONSE_DTO:
			validator = ResponseDTOValidator.getInstance();
			break;
		case BASE_DTO:
			validator = BaseDTOValidator.getInstance();
			break;
		default:
			logger.error(
					"DTOValidator cannot instantiate a validator of type : " + type.name()
							+ ". Please use appropriate validator generator.",
					new Exception("Invalid validation instantiation"));
		}
		return validator;
	}

	/**
	 * Return Factory instance to generate validator.
	 * 
	 * @return
	 */
	public static DTOValidatorFactory getInstance() {
		return new DTOValidatorFactory();
	}

}
