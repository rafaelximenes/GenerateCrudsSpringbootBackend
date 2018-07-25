package com.rafaelximenes.creator;

import com.rafaelximenes.domain.Table;

public class ManagerBuilder {
	
	private static ManagerBuilder builder;

	public static ManagerBuilder getInstance() {
		if (builder == null) {
			builder = new ManagerBuilder();
			return builder;
		} else
			return builder;
	}
	
	public void createClass(Table table) {
		/** Creating Domain **/
		DomainBuilder builder = DomainBuilder.getInstance();
		builder.createDomainClass(table);
		/** Creating Repository **/
		RepositoryBuilder repositoryBuilder = RepositoryBuilder.getInstance();
		repositoryBuilder.createRepository(table);
	}

}
