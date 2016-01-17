package com.yoku.server.framework.entity.merchant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.yoku.server.framework.entity.core.IEntityKey;

/**
 * Primary Key for Merchant master
 */
@Embeddable
public class MerchantMasterKey implements IEntityKey {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -802562531171596490L;

	/**
	 * Merchant Yoku Id.
	 */
	@Column(name = "merchant_id")
	private String merchantId;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantMasterKey [merchantId=" + merchantId + "]";
	}

}
