package com.yoku.server.core.db.adapter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Parent for repository adapters.
 */
public interface IRepositoryAdapter<T, K> {
	/**
	 * Persist to datastore : Insert
	 */
	public T save(T entity);

	/**
	 * Persist to datastore : Update
	 */
	public T update(T entity);

	/**
	 * Persist to datastore : Select
	 */
	public T fetch(Class<T> entityClass, K entityKey);

	/**
	 * Persist to datastore : Delete
	 */
	public Integer delete(T entity);

	/**
	 * Execute Hibernate query
	 * 
	 * @param query
	 *            query to execute.
	 * @return
	 */
	public List executeReadQuery(String query);

	/**
	 * Execute Hibernate query
	 * 
	 * @param query
	 *            query to execute.
	 * @return
	 */
	public List executeReadQuery(String query, Map<String, ?> params);

	/**
	 * Execute native sql query
	 * 
	 * @param queryString
	 *            query to execute
	 * @param params
	 *            Parameter map to add to query
	 * @return
	 */
	public List executeSQLQuery(String queryString, Map<String, ?> params);

	/**
	 * Execute native sql query
	 * 
	 * @param queryString
	 *            query to execute
	 * @param entity
	 *            The entity class type to fetch
	 * @param params
	 *            Parameter map to add to query
	 * @return
	 */
	public List executeSQLQuery(String queryString, Class<?> entity, Map<String, ?> params);
	
	/**
	 * Delete an Entity on the basis of ID
	 */
	public boolean deleteById(Class<?> type, Serializable id);
	
	/**
	 * Fetch entity with ID
	 */
	public T fetchByID(Class<T> entityClass, Serializable id);

}
