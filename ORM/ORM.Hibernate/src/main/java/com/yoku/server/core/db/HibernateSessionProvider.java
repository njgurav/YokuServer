package com.yoku.server.core.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate ORM operations helper class.
 */
public class HibernateSessionProvider implements IORMSessionProvider<Session> {

	public HibernateSessionProvider() {
	}

	/**
	 * Session Instance to perform ORM operations. Thread-unsafe.
	 */
	private Session session;

	/**
	 * Heavy-weight sessionFactory instance to perform session operations.
	 * Static to share sessionFactory instance across all instances of
	 * HibernateSessionProvider class
	 */
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	/**
	 * Create current class instance.
	 * 
	 * @return {@link HibernateSessionProvider}
	 */
	public static HibernateSessionProvider getInstance() {
		return new HibernateSessionProvider();
	}

	/**
	 * Create a new Session. Physically open connection with the database.
	 * 
	 * @return Session
	 */
	public Session openSession() {
		session = sessionFactory.openSession();
		return session;
	}

	/**
	 * Return existing session. Null otherwise.
	 */
	public Session fetchCurrentSession() {
		if (session != null) {
			return session;
		}
		return null;
	}

	/**
	 * Return existing Session. Creates a new Session if existing session is
	 * null and 'newSession' flag is set to true.
	 * 
	 * @param newSession
	 *            flag to create a new Session.
	 * @return Session
	 */
	public Session fetchCurrentSession(boolean newSession) {
		if (session != null) {
			return session;
		}
		if (newSession) {
			session = openSession();
		}
		return session;
	}

	/**
	 * Closes current session.
	 */
	public void closeSession() {
		if (session != null) {
			session.close();
		}
	}

}
