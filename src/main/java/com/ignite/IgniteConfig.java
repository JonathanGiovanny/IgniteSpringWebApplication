package com.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.dialect.H2Dialect;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ignite.model.Student;
import com.ignite.persistence.H2DataSourceFactory;
import com.ignite.utilities.IgniteAutoConfig;

@Component
@EnableIgniteRepositories
public class IgniteConfig {

	@Autowired
	private Ignite igniteInstance;
	
	@Bean
	public Ignite igniteInstance() {
		try {
			IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
			igniteConfiguration.setClientMode(false);

			CacheConfiguration<Long, Student> cacheConfig = new CacheConfiguration<>();

			/**
			 * https://apacheignite.readme.io/docs/3rd-party-store#section-read-through-and-write-through
			 */
			cacheConfig.setReadThrough(true);
			cacheConfig.setWriteThrough(true);
			cacheConfig.setWriteBehindEnabled(true);
			cacheConfig.setWriteBehindFlushFrequency(250);

			cacheConfig.setName("StudentCache");
			cacheConfig.setAtomicityMode(CacheAtomicityMode.ATOMIC);
			cacheConfig.setBackups(0);

			// DS Factory for the Caches
			 H2DataSourceFactory dsFactory = H2DataSourceFactory.getInstance();

			IgniteAutoConfig.addClass(Student.class);

			CacheJdbcPojoStoreFactory<Object, Object> storeFactory = new CacheJdbcPojoStoreFactory<>();
			storeFactory.setDataSourceFactory(dsFactory);
			storeFactory.setDialect(new H2Dialect());
			storeFactory.setTypes(IgniteAutoConfig.getJDBCTypes());

			cacheConfig.setCacheStoreFactory(storeFactory);

//			cacheConfig.setQueryEntities(IgniteAutoConfig.getQueryEntities());

			igniteConfiguration.setCacheConfiguration(cacheConfig);

			Ignite ignite = Ignition.start(igniteConfiguration);
			System.out.println("[IgniteServerNode] Node started");
			IgniteCache<Long, Student> cache = ignite.getOrCreateCache("StudentCache");
			cache.loadCache(null);

			return ignite;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Bean
	public IgniteCache<?, ?> igniteCache() {
		return igniteInstance.getOrCreateCache("StudentCache");
	}
}
