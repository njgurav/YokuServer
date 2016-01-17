package com.yoku.server.infra.idgeneration.factory;

import com.yoku.server.infra.idgeneration.generators.AlertIdGen;
import com.yoku.server.infra.idgeneration.generators.ComplaintIdGen;
import com.yoku.server.infra.idgeneration.generators.CustomerIdGen;
import com.yoku.server.infra.idgeneration.generators.CustomerRegistrationIdGen;
import com.yoku.server.infra.idgeneration.generators.IIdGenerator;
import com.yoku.server.infra.idgeneration.generators.MerchantIdGen;
import com.yoku.server.infra.idgeneration.generators.MerchantRegistrationIdGen;
import com.yoku.server.infra.idgeneration.generators.NinjaIdGen;
import com.yoku.server.infra.idgeneration.generators.NinjaRegistrationIdGen;
import com.yoku.server.infra.idgeneration.generators.NotificationIdGen;
import com.yoku.server.infra.idgeneration.generators.OrderIdGen;
import com.yoku.server.infra.idgeneration.generators.ProductIdGen;

/**
 * IDGenerator factory provides instances of Generators
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractIdGeneratorFactory {

	/**
	 * IDGenerator reference to hold generator instances
	 */
	private static IIdGenerator generator;

	/**
	 * Provides generator instance based on the generator type supplied.
	 * 
	 * @param generatorType
	 *            ID Generator identifier
	 * @return Id generator instance
	 */
	public static IIdGenerator getIdGenerator(GeneratorType generatorType) {
		// switch arranged in ascending order
		switch (generatorType) {
		case ALERT_ID:
			generator = AlertIdGen.getInstance();
			break;
		case COMPLAINT_ID:
			generator = ComplaintIdGen.getInstance();
			break;
		case CUSTOMER_ID:
			generator = CustomerIdGen.getInstance();
			break;
		case CUSTOMER_ONBOARD_ID:
			generator = CustomerRegistrationIdGen.getInstance();
			break;
		case MERCHANT_ID:
			generator = MerchantIdGen.getInstance();
			break;
		case MERCHANT_ONBOARD_ID:
			generator = MerchantRegistrationIdGen.getInstance();
			break;
		case NINJA_ID:
			generator = NinjaIdGen.getInstance();
			break;
		case NINJA_ONBOARD_ID:
			generator = NinjaRegistrationIdGen.getInstance();
			break;
		case NOTIFICATION_ID:
			generator = NotificationIdGen.getInstance();
			break;
		case ORDER_ID:
			generator = OrderIdGen.getInstance();
			break;
		case PRODUCT_ID:
			generator = ProductIdGen.getInstance();
			break;
		default:
			break;
		}

		return generator;
	}

}
