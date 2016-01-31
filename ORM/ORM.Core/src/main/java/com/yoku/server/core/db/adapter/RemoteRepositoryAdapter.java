package com.yoku.server.core.db.adapter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Persist data into other services. Future use case.
 * @param <AbstractEntity>
 * @param <AbstractEntityKey>
 */
@SuppressWarnings("hiding")
public class RemoteRepositoryAdapter<AbstractEntity,AbstractEntityKey> implements IRepositoryAdapter<AbstractEntity,AbstractEntityKey> {
	/**
	 * Return instance of current class.
	 * 
	 * @return RemoteRepositoryAdapter
	 */
	public static RemoteRepositoryAdapter getInstance() {
		return new RemoteRepositoryAdapter();
	}

	public AbstractEntity save(AbstractEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractEntity update(AbstractEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractEntity fetch(Class<AbstractEntity> entityClass, AbstractEntityKey entityKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(AbstractEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List executeReadQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List executeSQLQuery(String queryString, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List executeSQLQuery(String queryString, Class<?> entity, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List executeReadQuery(String query, Map<String, ?> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Class<?> type, Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AbstractEntity fetchByID(Class<AbstractEntity> entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdateQuery(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

}
