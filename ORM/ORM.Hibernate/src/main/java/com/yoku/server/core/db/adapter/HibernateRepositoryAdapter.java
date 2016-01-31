package com.yoku.server.core.db.adapter;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yoku.server.core.db.IORMSessionProvider;
import com.yoku.server.core.db.SessionProviderFactory;
import com.yoku.server.framework.entity.core.IEntity;
import com.yoku.server.framework.entity.core.IEntityKey;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;

/**
 * Perform ORM in DB
 * 
 * @param <IEntity>
 * @param <IEntityKey>
 */
public class HibernateRepositoryAdapter<T extends IEntity, K extends IEntityKey>
		implements IRepositoryAdapter<IEntity, IEntityKey> {
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(HibernateRepositoryAdapter.class);

	/**
	 * Instantiates Hibernate repository adapter.
	 * 
	 * @return repository adapter instance
	 */
	@SuppressWarnings("rawtypes")
	public static HibernateRepositoryAdapter<?, ?> getInstance() {
		return new HibernateRepositoryAdapter();
	}

	/**
	 * Save
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IEntity save(IEntity entity) {
		logger.info("inside local repository adapter with entity : " + entity);
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		session.save((T) entity);
		transaction.commit();
		return entity;
	}

	/**
	 * update
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IEntity update(IEntity entity) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		session.update((T) entity);
		transaction.commit();
		return entity;
	}

	/**
	 * Fetch
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IEntity fetch(Class<IEntity> entityClass, IEntityKey entityKey) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		IEntity entity = (IEntity) session.get(entityClass, (K) entityKey);
		transaction.commit();
		return entity;
	}

	/**
	 * Delete
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(IEntity entity) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete((T) entity);
		transaction.commit();
		return true;
	}
	
	

	/**
	 * Read Query
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeReadQuery(String queryString) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Query query = session.createQuery(queryString);
		List<T> result = query.list();
		return result;
	}

	/**
	 * Read Query with parameters
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeReadQuery(String queryString, Map<String, ?> params) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Query query = session.createQuery(queryString);
		if (!params.keySet().isEmpty()) {
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				query.setParameter(key, params.get(key));
			}
		}
		List<T> result = query.list();
		return result;

	}

	/**
	 * Execute sql query
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeSQLQuery(String queryString, Map<String, ?> params) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		SQLQuery query = session.createSQLQuery(queryString);

		if (!params.keySet().isEmpty()) {
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				query.setParameter(key, params.get(key));
			}
		}
		List<T> result = query.list();
		return result;
	}

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
	@Override
	public List<T> executeSQLQuery(String queryString, Class<?> entity, Map<String, ?> params) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		SQLQuery query = session.createSQLQuery(queryString);

		if (!params.keySet().isEmpty()) {
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				query.setParameter(key, params.get(key));
			}
		}
		query.addEntity(entity);
		List<T> result = query.list();
		return result;
	}

	@Override
	public boolean deleteById(Class<?> type, Serializable id) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		Object persistentInstance = session.load(type, id);
		if (persistentInstance != null) {
			session.delete(persistentInstance);
			transaction.commit();
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public IEntity fetchByID(Class<IEntity> entityClass, Serializable id) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Transaction transaction = session.beginTransaction();
		IEntity entity = (IEntity) session.get(entityClass, id);
		transaction.commit();
		return entity;
	}
/**
 * Execute update query like update or delete
 */
	@Override
	public int executeUpdateQuery(String queryString) {
		IORMSessionProvider<Session> sessionProvider = SessionProviderFactory.getORMProvider();
		Session session = sessionProvider.openSession();
		Query query = session.createQuery(queryString);
		int rowsUpdated = query.executeUpdate();
		return rowsUpdated;
	}

}
