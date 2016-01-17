package com.yoku.server.framework.entity.merchant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Merchant master table contains data related to dashboard rendering.
 */
@Entity
@Table(name = "merchant_master")
public class MerchantMaster implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 7857845705221715941L;
	/**
	 * Primary Key
	 */
	@EmbeddedId
	private MerchantMasterKey key;

	/**
	 * Merchant Registration Id.
	 */
	@Column(name = "registration_id")
	private String registrationId;

	/**
	 * Merchant rating 1 to 5
	 */
	@Column(name = "rating")
	private int rating;
	/**
	 * Number of orders placed today.
	 */
	@Column(name = "orders_today")
	private int ordersToday;
	/**
	 * Total number of orders pending.
	 */
	@Column(name = "orders_pending")
	private int ordersPending;
	/**
	 * Number of products in stock.
	 */
	@Column(name = "listing_in_stock")
	private int listingInStock;
	/**
	 * Number of products that went out of stock.
	 */
	@Column(name = "listing_out_of_stock")
	private int listingOutOfStock;
	/**
	 * Last paid payment to the merchant.
	 */
	@Column(name = "payment_settled")
	private double paymentSettled;
	/**
	 * Total unpaid amount, to be paid to the merchant.
	 */
	@Column(name = "payment_unsettled")
	private double paymentUnSettled;

	/**
	 * @return the key
	 */
	public MerchantMasterKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(MerchantMasterKey key) {
		this.key = key;
	}

	/**
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
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
	 * @param rating
	 *            the rating to set
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
	 * @param ordersToday
	 *            the ordersToday to set
	 */
	public void setOrdersToday(int ordersToday) {
		this.ordersToday = ordersToday;
	}

	/**
	 * @return the ordersPending
	 */
	public int getOrdersPending() {
		return ordersPending;
	}

	/**
	 * @param ordersPending
	 *            the ordersPending to set
	 */
	public void setOrdersPending(int ordersPending) {
		this.ordersPending = ordersPending;
	}

	/**
	 * @return the listingInStock
	 */
	public int getListingInStock() {
		return listingInStock;
	}

	/**
	 * @param listingInStock
	 *            the listingInStock to set
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
	 * @param listingOutOfStock
	 *            the listingOutOfStock to set
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
	 * @param paymentSettled
	 *            the paymentSettled to set
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
	 * @param paymentUnSettled
	 *            the paymentUnSettled to set
	 */
	public void setPaymentUnSettled(double paymentUnSettled) {
		this.paymentUnSettled = paymentUnSettled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantMaster [key=" + key + ", registrationId=" + registrationId + ", rating=" + rating
				+ ", ordersToday=" + ordersToday + ", ordersPending=" + ordersPending + ", listingInStock="
				+ listingInStock + ", listingOutOfStock=" + listingOutOfStock + ", paymentSettled=" + paymentSettled
				+ ", paymentUnSettled=" + paymentUnSettled + "]";
	}

}
