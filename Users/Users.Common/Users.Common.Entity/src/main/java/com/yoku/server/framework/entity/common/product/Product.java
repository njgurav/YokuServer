package com.yoku.server.framework.entity.common.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Master class for Product entity.
 */
@Entity
@Table(name = "product_master")
public class Product implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1700865438596937673L;
	
	@Id
	@Column(name = "product_id")
	private String productId;
	/**
	 * Merchant Id posting the product for display.
	 */
	@Column(name = "merchant_id")
	private String merchantId;

	@Column(name = "business_category")
	private String businessCategory;
	/**
	 * Inventory status for product.
	 */
	@Column(name = "in_stock")
	private Boolean inStock;
	
	/**
	 * OneToOne mapping with Product Restaurant
	 */
	@OneToOne(fetch=FetchType.EAGER, mappedBy="product", cascade=CascadeType.ALL)
	private ProductRestaurant productRestaurant;
	
	/**
	 * OneToOne mapping with Product Restaurant
	 */
	@OneToOne(fetch=FetchType.EAGER, mappedBy="product", cascade=CascadeType.ALL)
	private ProductFashion productFashion;
	
	/**
	 * OneToOne mapping with Product Restaurant
	 */
	@OneToOne(fetch=FetchType.EAGER, mappedBy="product", cascade=CascadeType.ALL)
	private ProductGrocery productGrocery;

	/**
	 * @return the productId
	 */
	
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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
	 * return the Restaurant product for the product ID
	 */
	
	public ProductRestaurant getProductRestaurant() {
		return productRestaurant;
	}

	public void setProductRestaurant(ProductRestaurant productRestaurant) {
		this.productRestaurant = productRestaurant;
	}
	
	/**
	 * return the Fashion product for the product ID
	 */
	public ProductFashion getProductFashion() {
		return productFashion;
	}

	public void setProductFashion(ProductFashion productFashion) {
		this.productFashion = productFashion;
	}

	/**
	 * return the Grocery product for the product ID
	 */
	public ProductGrocery getProductGrocery() {
		return productGrocery;
	}

	public void setProductGrocery(ProductGrocery productGrocery) {
		this.productGrocery = productGrocery;
	}

	/**
	 * @return the businessCategory
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}

	/**
	 * @param businessCategory
	 *            the businessCategory to set
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	/**
	 * @return the inStock
	 */
	public Boolean getInStock() {
		return inStock;
	}

	/**
	 * @param inStock
	 *            the inStock to set
	 */
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Product [key=" + key + ", BusinessCategory=" + BusinessCategory + ", inStock=" + inStock + "]";
	}*/

}
