package com.yoku.server.framework.core.orm.factory;

import com.yoku.server.core.db.adapter.HibernateRepositoryAdapter;
import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.db.utils.ORMProviderType;

/**
 * Factory to return repository adapters.
 */
public class RepositoryAdapterFactory {

	public static IRepositoryAdapter getRepositoryAdapter(ORMProviderType adapterType) {

		switch (adapterType) {
		
		case HIBERNATE:
			return HibernateRepositoryAdapter.getInstance();

		
			
		default:
			break;
		}

		return HibernateRepositoryAdapter.getInstance();
	}
}
