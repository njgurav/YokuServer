package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Master class for Product entity.
 */
@Entity
@Table(name = "Merchant_Business")
public class MerchantBusinessViewEntity implements IEntity {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7986867925029586920L;
	
	/**
	 * Merchant ID
	 */
	@Id
	@Column(name = "Merchant_ID")
	private String merchantID;
	/**
	 *  The business category under which the product is displayed.
	 */
	@Column(name = "Business_Category")
	private String businessCategory;
	
	
	public String getMerchantID() {
		return merchantID;
	}
	
	public String getBusinessCategory() {
		return businessCategory;
	}
	
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	
	public void setBusinessCategory(String businnessCategory) {
		this.businessCategory = businnessCategory;
	}

}
