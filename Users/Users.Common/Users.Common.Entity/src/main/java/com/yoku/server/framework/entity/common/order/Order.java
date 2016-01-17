package com.yoku.server.framework.entity.common.order;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Order master table
 */
@Entity
@Table(name = "order_master")
public class Order implements IEntity {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -2689890475037095392L;
	/**
	 * Primary Key
	 */
	@EmbeddedId
	private OrderKey key;
	/**
	 * Order plced date.
	 */
	@Column(name = "date")
	private Timestamp date;
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
	 * Order delivery address.
	 */
	@Column(name = "delivery_address")
	private String address;
	/**
	 * Order Total amount.
	 */
	@Column(name = "amount")
	private double amount;

	/**
	 * @return the key
	 */
	public OrderKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(OrderKey key) {
		this.key = key;
	}

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
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [key=" + key + ", status=" + status + ", date=" + date + ", lastUpdated=" + lastUpdated
				+ ", address=" + address + ", amount=" + amount + "]";
	}

}
