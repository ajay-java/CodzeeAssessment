package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.prodrepo",
                                                entityManagerFactoryRef = "oraEMF",
                                                transactionManagerRef = "oraTxMgmr")
public class OracleDBConfig {
	
	@Bean(name="oraDS")
	@Primary
	@ConfigurationProperties(prefix = "ora.ds")
	public   DataSource  createOraDs() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="oraEMF")
	@Primary
	public  LocalContainerEntityManagerFactoryBean   createOracleEMF(EntityManagerFactoryBuilder builder) {
		// prepare the required properites
		Map<String, Object> props = new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", false);
		//create  LocalContainerEntityManagerFactoryBean class object
		return builder.dataSource(createOraDs())
				                 .packages("com.nt.entity.product")
				                 .properties(props)
				                 .build();
	}
	
	@Bean(name="oraTxMgmr")
	@Primary
	public   JpaTransactionManager   createOraTxMgmr(@Qualifier("oraEMF") EntityManagerFactory factory) {
	   return new  JpaTransactionManager(factory);	
	}


}
