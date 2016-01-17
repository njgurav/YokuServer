package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Master class for Product entity.
 */
@Entity
@Table(name = "product_sub_category")
public class ProductSubCategory implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1700865438596937673L;
	/**
	 * Business Category
	 */
	@Column(name = "business_category")
	private String businessCategory;
	
	/**
	 * SubCategory for product.
	 */
	@Id
	@Column(name = "sub_category")
	private String subCategory;
	
	/**
	 * Dimensions for product.
	 */
	@Column(name = "dimension")
	private String dimension;

	public String getBusinessCategory() {
		return businessCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public String getDimension() {
		return dimension;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	

}
