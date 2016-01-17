package com.yoku.server.framework.entity.common.product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Product under restraunt category.
 */
@Entity
@Table(name = "product_restaurant")
public class ProductRestaurant implements IEntity {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 66515661334189054L;
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
	 * Cuisine.
	 */
	@Column(name = "cuisine")
	private String cuisine;
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
	
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Product product;
	
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
	 * @return the cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}

	/**
	 * @param cuisine
	 *            the cuisine to set
	 */
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
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
	 * Logging
	 */
/*	@Override
	public String toString() {
		return "ProductRestraunt [productId=" + key + ", category=" + category + ", cuisine=" + cuisine
				+ ", title=" + title + ", description=" + description + ", price=" + price + "]";
	}*/

}
