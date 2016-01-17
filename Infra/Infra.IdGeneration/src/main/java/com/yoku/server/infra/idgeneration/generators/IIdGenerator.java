package com.yoku.server.infra.idgeneration.generators;

/**
 * Parent Id Generator.
 * @param <T> Generic Type.
 */
public interface IIdGenerator<T> {

	/**
	 * Generate next Id.
	 * @return id of generic type T.
	 */
	public T nextId();
	
}
