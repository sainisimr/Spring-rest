package io.egan.Spring_rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:application.properties")
public class JPAConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("io.egan.Spring_rest.entity");
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	public DataSource getDataSource(){
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setDriverClassName("com.mysql.jdbc.Driver");
		dms.setUrl(env.getProperty("db.url"));
		dms.setUsername(env.getProperty("db.user"));
		dms.setPassword(env.getProperty("db.password", "root"));
		return dms;
	}
	
	@Bean
	public PlatformTransactionManager transmanager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	
	
	private Properties jpaProperties(){
		Properties pros = new Properties();
		pros.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
		pros.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pros.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		pros.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		return pros;
	}
	
	
	
}
