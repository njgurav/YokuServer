package com.yoku.server.product.dimension;

public class FashionProductDimension extends Dimension {

	private float size;

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

	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "FashionProductDimension [size=" + size + "]";
	}

}
