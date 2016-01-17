package com.yoku.server.core.db;

import org.hibernate.Session;

public class SessionProviderFactory {

	public static IORMSessionProvider<Session> getORMProvider(){
		
		IORMSessionProvider<Session> sessionProvider = HibernateSessionProvider.getInstance();
			
		return sessionProvider;
	}
	
}
