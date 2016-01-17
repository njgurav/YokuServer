package com.yoku.server.core.services;

import com.yoku.server.core.db.utils.ORMProviderType;
import com.yoku.server.core.db.utils.PersistenceUtil;
import com.yoku.server.core.validation.factory.DTOValidatorFactory;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.framework.dto.BaseRequestDTO;
import com.yoku.server.framework.dto.BaseResponseDTO;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.infra.validation.validators.IValidator;
import com.yoku.server.infra.validation.validators.ValidationError;
import com.yoku.setver.infra.validation.factory.ValidatorType;

/**
 * Parent for all core services.
 */
public class AbstractService {
	/**
	 * Logger instance for logging.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(AbstractService.class);

	/**
	 * Provide appropriate Persistence provider to requesting rest services
	 * based on configuration.
	 * 
	 * @param requestingResource
	 *            fully qualified service name.
	 * @return PersistenceProvider like Hibernate Provider, Local Storage
	 *         Provider, etc.
	 */
	public ORMProviderType getORMProvider(String requestingResource) {
		ORMProviderType provider = null;
		provider = new PersistenceUtil().getORMProvider(requestingResource);
		return provider;
	}

	/**
	 * Base DTO Validator.
	 * 
	 * @param dto
	 *            object to validate.
	 * @return validation status.
	 */
	public boolean validate(BaseDTO dto) {
		IValidator validator = DTOValidatorFactory.getInstance().getValidator(ValidatorType.BASE_DTO);
		ValidationError[] errors = validator.validate(dto);
		if (errors != null) {
			logger.error("Validation failed for " + dto, new Exception("Validation failed in DTO"));
			for (ValidationError error : errors) {
				logger.info(error.toString());
			}
			return false;
		}
		return true;
	}

	/**
	 * Request DTO validator.
	 * 
	 * @param request
	 *            request dto to validate.
	 * @return validation status.
	 */
	public boolean validateRequest(BaseRequestDTO request) {
		return validate(request);
	}

	/**
	 * Response DTO validator.
	 * 
	 * @param response
	 *            response dto to validate.
	 * @return validation status.
	 */
	public boolean validateResponse(BaseResponseDTO response) {
		return validate(response);
	}
}
