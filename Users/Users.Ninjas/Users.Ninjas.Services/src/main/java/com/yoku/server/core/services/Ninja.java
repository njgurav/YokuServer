package com.yoku.server.core.services;

import com.mysql.jdbc.Constants;
import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.framework.dto.BaseDTO;

/**
 * Service for Ninja operations.
 */
public class Ninja extends AbstractService {

	public Ninja() {
	}
	/**
	 * Read all orders for Ninja for the required status from all merchants not
	 * assigned to any Ninja or with a specific status stating that orders are
	 * ready to be picked by Ninjas within the specified radius of Ninja current
	 * Location.
	 * 
	 * @return order list
	 */
	public void readAll( String status,  String radius,
			 LocationDTO currentLocation) {
		return;
	}

	/**
	 * Read all orders for Ninja for the required status from all merchants
	 * serviced or assigned to current ninja.
	 * 
	 * @return order list
	 */
	public void readSelfAll( String ninjaId,  String status) {
		return;
	}

	/**
	 * Read order details for Ninja to decide to pick a delivery.
	 * 
	 * @return order list
	 */
	public void readOrder( String ninjaId) {
		return;
	}

	/**
	 * Update Current Order status. Select Order for delivery.
	 * 
	 * @return order list
	 */
	public void updateStatus( String ninjaId,  String status) {
		return;
	}

	
}
