package com.ignite.persistence;

import javax.cache.configuration.Factory;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Datasource to use.
 * https://github.com/apache/ignite/blob/master/modules/core/src/test/java/org/apache/ignite/cache/store/jdbc/H2DataSourceFactory.java
 */
@Component
public class H2DataSourceFactory implements Factory<DataSource> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8932237228334074493L;

	/** DB connection URL. */
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;
	
	@Value("${spring.datasource.password}")
	private String pass;
	
	/** Instance */
	private static H2DataSourceFactory instance;

	/**
	 * Singleton Instance
	 * 
	 * @return
	 */
	public static H2DataSourceFactory getInstance() {
		if (instance == null) {
			instance = new H2DataSourceFactory();
		}
		return instance;
	}

	/** {@inheritDoc} */
	@Override
	public DataSource create() {
		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("Url: " + url);
		System.out.println("User: " + user);
		System.out.println("Pass: " + pass);
		System.out.println("\n\n\n\n\n\n\n\n");
		return JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/data/seviper", "admin", "Asdf963.");
	}

}