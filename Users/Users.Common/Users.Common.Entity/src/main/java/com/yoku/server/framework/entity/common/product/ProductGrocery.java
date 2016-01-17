package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Product under Grocery category.
 */
@Entity
@Table(name = "product_grocery")
public class ProductGrocery implements IEntity {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1263330433300449129L;
	/**
	 * Primary key
	 *//*
	@EmbeddedId
	private ProductGroceryKey key;*/
	
	/**
	 * Product Id
	 */
	@Id
	@Column(name="product_id")
	private String productId;
	/**
	 * Product Category
	 */
	@Column(name = "category")
	private String category;
	/**
	 * Product sub-category
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
	 * Quantity
	 */
	@Column(name = "quantity")
	private Double quantity;
	/**
	 * Unit of measurement.
	 */
	@Column(name = "unit")
	private String unit;
	
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Product product;

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
	 * @return the units
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnit(String units) {
		this.unit = units;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductGrocery [category=" + category + ", subCategory=" + subCategory + ", title="
				+ title + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", units="
				+ unit + "]";
	}

}
