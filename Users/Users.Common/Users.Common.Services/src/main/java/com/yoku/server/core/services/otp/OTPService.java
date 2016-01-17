package com.yoku.server.core.services.otp;

import java.sql.Timestamp;
import java.util.Random;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.services.AbstractService;
import com.yoku.server.framework.alerts.AlertsManager;
import com.yoku.server.framework.alerts.events.Event;
import com.yoku.server.framework.assembler.common.OTPAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.entity.common.OTP;
import com.yoku.server.framework.entity.common.OTPKey;
import com.yoku.server.infra.dtos.UserContext;
import com.yoku.server.infra.idgeneration.generators.OTPGenerator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.sms.dto.OTPRequestDTO;
import com.yoku.server.sms.dto.OTPResponseDTO;
import com.yoku.server.sms.dto.OTPValidateRequestDTO;

/**
 * Service to generate and Verify OTP operations
 */
public class OTPService extends AbstractService {

	/**
	 * OTP timeout duration in seconds
	 */
	private final static int duration = 60;
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(OTPService.class);

	/**
	 * Create OTP. Send Key in Response or notification and Value in SMS. Client
	 * will validate OTP based on certain mathematical operation and send
	 * validation status.
	 * 
	 * otpValEncodingNumber value should always be between 2 and 9, both
	 * inclusive.
	 */
	@SuppressWarnings("unchecked")
	public OTPResponseDTO create(OTPRequestDTO request) {
		UserContext context = null;
		OTPResponseDTO response = new OTPResponseDTO();
		Integer otpKey = OTPGenerator.getInstance().nextOTPKey();
		Integer otpValEncodingNumber = (new Random().nextInt(7)) + 2;
		Integer otpVal = new Integer(otpKey >>> otpValEncodingNumber);

		OTP otp = new OTPAssembler().toEntity(request.getMobileNo(), otpVal, otpKey, duration);

		IRepositoryAdapter<OTP, OTPKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.otp.OTPService.create"));
		logger.info("Calling adapter.save() in core OTPService");
		adapter.save(otp);

		context = new UserContext();
		context.setDeviceId(request.getDeviceId());
		context.setMobileNo(request.getMobileNo());
		AlertsManager.getInstance().alert(context, Event.MOBILE_VERIFICATION,
				"OTP for mobile number verification : " + otpKey);

		response.setGuild(otpValEncodingNumber.toString());
		// Temp add to response otp key. It should only be sent in SMS.
		response.setOtpkey(otpKey.toString());

		return response;
	}

	/**
	 * Method to validate OTP against the provided mobile number.
	 * 
	 * @param request
	 *            contains validation data.
	 * @return status of validation operation.
	 * 
	 * Add one more parameter for callback to the method requesting OTP validation.
	 */
	@SuppressWarnings("unchecked")
	public boolean validate(OTPValidateRequestDTO request) {
		IRepositoryAdapter<OTP, OTPKey> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.otp.OTPService.validate"));
		OTPKey key = new OTPKey();
		key.setMobileNo(request.getMobileNo());
		key.setOtpVal(request.getOtp());
		OTP otp = adapter.fetch(OTP.class, key);
		if (otp != null) {
			// OTP entity found, means OTP is valid.
			Timestamp createdOn = otp.getCreatedOn();
			Integer expiryDuration = otp.getDuration();
			// check if OTP is expired.
			if (((int) (new Timestamp(System.currentTimeMillis()).getTime() - createdOn.getTime())) > (expiryDuration
					* 1000)) {
				logger.error("OTP expired. Regenerate OTP", null);
				adapter.delete(otp);
				return false;
			} else {
				logger.info("Valid OTP");
				adapter.delete(otp);
				//callback 
			}
		}
		return false;
	}
}
