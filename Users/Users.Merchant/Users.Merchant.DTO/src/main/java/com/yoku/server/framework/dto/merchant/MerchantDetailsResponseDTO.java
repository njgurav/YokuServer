package com.yoku.server.framework.dto.merchant;

import com.yoku.server.framework.dto.BaseResponseDTO;

/**
 * Provides data for merchant dashboard rendering.
 */
public class MerchantDetailsResponseDTO extends BaseResponseDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 2589171649902928199L;
	/**
	 * Merchant Registration Id.
	 */
	private String registrationId;
	
	/**
	 * Merchant Ratings
	 */
	private int rating;
	/**
	 * Orders placed today.
	 */
	private int ordersToday;
	/**
	 * Total pending orders.
	 */
	private int pendingOrders;
	/**
	 * Number Products in stock.
	 */
	private int listingInStock;
	/**
	 * Number of Products that went out of stock
	 */
	private int listingOutOfStock;
	/**
	 * Amount settled in last payment.
	 */
	private double paymentSettled;
	/**
	 * Unsettled payment.
	 */
	private double paymentUnSettled;
	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}
	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the ordersToday
	 */
	public int getOrdersToday() {
		return ordersToday;
	}
	/**
	 * @param ordersToday the ordersToday to set
	 */
	public void setOrdersToday(int ordersToday) {
		this.ordersToday = ordersToday;
	}
	/**
	 * @return the pendingOrders
	 */
	public int getPendingOrders() {
		return pendingOrders;
	}
	/**
	 * @param pendingOrders the pendingOrders to set
	 */
	public void setPendingOrders(int pendingOrders) {
		this.pendingOrders = pendingOrders;
	}
	/**
	 * @return the listingInStock
	 */
	public int getListingInStock() {
		return listingInStock;
	}
	/**
	 * @param listingInStock the listingInStock to set
	 */
	public void setListingInStock(int listingInStock) {
		this.listingInStock = listingInStock;
	}
	/**
	 * @return the listingOutOfStock
	 */
	public int getListingOutOfStock() {
		return listingOutOfStock;
	}
	/**
	 * @param listingOutOfStock the listingOutOfStock to set
	 */
	public void setListingOutOfStock(int listingOutOfStock) {
		this.listingOutOfStock = listingOutOfStock;
	}
	/**
	 * @return the paymentSettled
	 */
	public double getPaymentSettled() {
		return paymentSettled;
	}
	/**
	 * @param paymentSettled the paymentSettled to set
	 */
	public void setPaymentSettled(double paymentSettled) {
		this.paymentSettled = paymentSettled;
	}
	/**
	 * @return the paymentUnSettled
	 */
	public double getPaymentUnSettled() {
		return paymentUnSettled;
	}
	/**
	 * @param paymentUnSettled the paymentUnSettled to set
	 */
	public void setPaymentUnSettled(double paymentUnSettled) {
		this.paymentUnSettled = paymentUnSettled;
	}
	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "MerchantDetailsResponseDTO [registrationId=" + registrationId + ", rating=" + rating + ", ordersToday="
				+ ordersToday + ", pendingOrders=" + pendingOrders + ", listingInStock=" + listingInStock
				+ ", listingOutOfStock=" + listingOutOfStock + ", paymentSettled=" + paymentSettled
				+ ", paymentUnSettled=" + paymentUnSettled + "]";
	}
	
	

}
