package com.app;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.app")
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource ds() {
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.un"));
		d.setPassword(env.getProperty("db.pwd"));
		return d;
	}
	
	@Bean
	public Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		p.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		p.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
		return p;
	}
	
	@Bean
	public LocalSessionFactoryBean lsfb() {
		LocalSessionFactoryBean l = new LocalSessionFactoryBean();
		l.setDataSource(ds());
		l.setAnnotatedClasses(Instructor.class,InstructorDetails.class);
		l.setHibernateProperties(props());
		return l;
	}
	
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate templet = new HibernateTemplate();
		templet.setSessionFactory(lsfb().getObject());
		return templet;
	}
	
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager t = new HibernateTransactionManager();
		t.setSessionFactory(lsfb().getObject());
		return t;
	}

}
