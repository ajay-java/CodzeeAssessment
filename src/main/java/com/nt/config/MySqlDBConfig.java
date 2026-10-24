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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.offersrepo",
                                             entityManagerFactoryRef = "mysqlEMF",
                                             transactionManagerRef = "mysqlTxMgmr")

public class MySqlDBConfig {
	
	@Bean(name="mysqlDS")
	@ConfigurationProperties(prefix = "mysql.ds")
	public   DataSource  createMysqlDs() {
		return  DataSourceBuilder.create().build();
		}
	
	@Bean(name="mysqlEMF")
	public  LocalContainerEntityManagerFactoryBean   createMySqlEMF(EntityManagerFactoryBuilder builder) {
		// prepare the required properites
		Map<String,Object>  props=new HashMap();
	    props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		//create  LocalContainerEntityManagerFactoryBean class object
		return builder.dataSource(createMysqlDs())
				                 .packages("com.nt.entity.offers")
				                 .properties(props)
				                 .build();
	}
	
	@Bean(name="mysqlTxMgmr")
	public   JpaTransactionManager   createMysqlTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory) {
	   return new  JpaTransactionManager(factory);	
	}


}
