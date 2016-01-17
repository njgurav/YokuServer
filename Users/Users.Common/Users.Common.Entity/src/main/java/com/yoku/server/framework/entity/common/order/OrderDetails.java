package com.yoku.server.framework.entity.common.order;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Individual Product details in the order.
 */
@Entity
@Table(name = "order_details")
public class OrderDetails implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3619614532725887969L;
	/**
	 * Primary key
	 */
	@EmbeddedId
	private OrderDetailsKey key;
	/**
	 * Number of pieces of the Product identified by productId in this order.
	 */
	@Column(name = "quantity")
	private Double quantity;
	/**
	 * Price per piece of the Product identified by productId in this order.
	 */
	@Column(name = "price_per_unit")
	private Double price;
	/**
	 * Discount in value on total amount.
	 */
	@Column(name = "discount")
	private Double discount;
	/**
	 * OfferId of any offer if applied during order placement.
	 */
	@Column(name = "offer_id")
	private String offerId;
	/**
	 * Tax amount in value on total amount.
	 */
	@Column(name = "tax")
	private Double tax;
	/**
	 * Total calculated amount.
	 */
	@Column(name = "total")
	private Double total;

	/**
	 * Ninja Id for which the order is assigned for delivery.
	 */
	@Column(name = "ninja_id")
	private String ninjaId;

	/**
	 * Merchant Id for which the order is placed.
	 */
	@Column(name = "merchant_id")
	private String merchantId;

	/**
	 * Status of delivery.
	 */
	@Column(name = "status")
	private String status;
	/**
	 * Last status updated date.
	 */
	@Column(name = "last_updated_on")
	private Timestamp lastUpdated;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastUpdated
	 */
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated
	 *            the lastUpdated to set
	 */
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the ninjaId
	 */
	public String getNinjaId() {
		return ninjaId;
	}

	/**
	 * @param ninjaId
	 *            the ninjaId to set
	 */
	public void setNinjaId(String ninjaId) {
		this.ninjaId = ninjaId;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}

	/**
	 * @param offerId
	 *            the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the key
	 */
	public OrderDetailsKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(OrderDetailsKey key) {
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDetails [key=" + key + ", quantity=" + quantity + ", price=" + price + ", discount=" + discount
				+ ", offerId=" + offerId + ", tax=" + tax + ", total=" + total + ", ninjaId=" + ninjaId
				+ ", merchantId=" + merchantId + ", status=" + status + ", lastUpdated=" + lastUpdated + "]";
	}
}
