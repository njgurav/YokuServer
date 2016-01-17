package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Fashion Product
 */
@Entity
@Table(name = "product_fashion")
public class ProductFashion implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 946238020341950667L;
	
	/**
	 * Product Id
	 */
	@Id
	@Column(name = "product_id")
	private String productId;
	
/*	@EmbeddedId
	private ProductFashionKey key;*/
	/**
	 * Product Category
	 */
	@Column(name = "category")
	private String category;
	/**
	 * Product subcategory
	 */
	@Column(name = "subcategory")
	private String subCategory;
	/**
	 * Title
	 */
	@Column(name = "title")
	private String title;
	/**
	 * Description
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Price
	 */
	@Column(name = "price")
	private Double price;
	/**
	 * Dimensions
	 */
	@Column(name = "dimension")
	private float size;
	/**
	 * Quantity
	 */
	@Column(name = "quantity")
	private Double quantity;
	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Product product;
	
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory
	 *            the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the size
	 */
	public float getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(float size) {
		this.size = size;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the key
	 *//*
	public ProductFashionKey getKey() {
		return key;
	}

	*//**
	 * @param key
	 *            the key to set
	 *//*
	public void setKey(ProductFashionKey key) {
		this.key = key;
	}
*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
}
