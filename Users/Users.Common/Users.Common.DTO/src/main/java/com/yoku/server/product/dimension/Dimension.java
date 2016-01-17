package com.yoku.server.product.dimension;
/**
 * Dimension and size of Products.
 */
public class Dimension {

private float length;
	
	private float breadth;
	
	private float height;
	
	private float weight;

	/**
	 * @return the length
	 */
	public float getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(float length) {
		this.length = length;
	}

	/**
	 * @return the breadth
	 */
	public float getBreadth() {
		return breadth;
	}

	/**
	 * @param breadth the breadth to set
	 */
	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}

	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "Dimension [length=" + length + ", breadth=" + breadth + ", height=" + height + ", weight=" + weight
				+ "]";
	}
	
}
