package com.yoku.server.order.dto;

import java.sql.Timestamp;

import com.yoku.server.framework.dto.BaseDTO;
/**
 * Contains Order details for both request and response.
 */
public class OrderDTO extends BaseDTO {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7239143486511626233L;

	/**
	 * Order Id.
	 */
	private String orderId;
	/**
	 * Product Id.
	 */
	private String productId;
	/**
	 * Number of pieces of the Product identified by productId in this order.
	 */
	private Double quantity;
	/**
	 * Price per piece of the Product identified by productId in this order.
	 */
	private Double price;
	/**
	 * Discount in value on total amount.
	 */
	private Double discount;
	/**
	 * OfferId of any offer if applied during order placement.
	 */
	private String offerId;
	/**
	 * Tax amount in value on total amount.
	 */
	private Double tax;
	/**
	 * Total calculated amount.
	 */
	private Double total;

	/**
	 * Ninja Id for which the order is assigned for delivery.
	 */
	private String ninjaId;

	/**
	 * Merchant Id for which the order is placed.
	 */
	private String merchantId;

	/**
	 * Status of delivery.
	 */
	private String status;
	/**
	 * Last status updated date.
	 */
	private Timestamp lastUpdated;
	/**
	 * Date of order placement.
	 */
	private Timestamp orderPlacementDate;
	/**
	 * Delivery address.
	 */
	private String deliveryAddress;
	/**
	 * @return the orderPlacementDate
	 */
	public Timestamp getOrderPlacementDate() {
		return orderPlacementDate;
	}
	/**
	 * @param orderPlacementDate the orderPlacementDate to set
	 */
	public void setOrderPlacementDate(Timestamp orderPlacementDate) {
		this.orderPlacementDate = orderPlacementDate;
	}
	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
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
	 * @param price the price to set
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
	 * @param discount the discount to set
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
	 * @param offerId the offerId to set
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
	 * @param tax the tax to set
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
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	/**
	 * @return the ninjaId
	 */
	public String getNinjaId() {
		return ninjaId;
	}
	/**
	 * @param ninjaId the ninjaId to set
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
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
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
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + ", discount=" + discount + ", offerId=" + offerId + ", tax=" + tax + ", total=" + total
				+ ", ninjaId=" + ninjaId + ", merchantId=" + merchantId + ", status=" + status + ", lastUpdated="
				+ lastUpdated + ", orderPlacementDate=" + orderPlacementDate + ", deliveryAddress=" + deliveryAddress
				+ "]";
	}

}
