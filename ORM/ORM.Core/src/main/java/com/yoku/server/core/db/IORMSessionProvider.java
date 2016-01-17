package com.yoku.server.core.db;

/**
 * Parent class for Session Provider.
 * Initially written for hibernate.
 * @author njgurav
 *
 * @param <T> 
 */

public interface IORMSessionProvider<T> {
	
	/**
	 * Create a new Session. Physically open connection with the database.
	 * 
	 * @return Session
	 */
	public T openSession();

	/**
	 * Return existing session. Null otherwise.
	 */
	public T fetchCurrentSession() ;

	/**
	 * Return existing Session. Creates a new Session if existing session is
	 * null and 'newSession' flag is set to true.
	 * 
	 * @param newSession
	 *            flag to create a new Session.
	 * @return Session
	 */
	public T fetchCurrentSession(boolean newSession);

	/**
	 * Closes current session.
	 */
	public void closeSession();
}
