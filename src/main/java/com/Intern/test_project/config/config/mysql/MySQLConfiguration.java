//package com.Intern.test_project.config.config.mysql;
//
//import java.util.HashMap;
//import java.util.Objects;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@PropertySource({ "classpath:application.properties" })
//@EnableJpaRepositories(
//        basePackages = "com.Intern.test_project.mysql.repository",
//        entityManagerFactoryRef = "mysqlEntityManager",
//        transactionManagerRef = "mysqlTransactionManager"
//)
//public class MySQLConfiguration {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("mysql.datasource.driver-class-name")));
//        dataSource.setUrl(env.getProperty("mysql.datasource.url"));
//        dataSource.setUsername(env.getProperty("mysql.datasource.username"));
//        dataSource.setPassword(env.getProperty("mysql.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean(name = "mysqlEntityManager")
//    public LocalContainerEntityManagerFactoryBean mysqlEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(mysqlDataSource());
//        em.setPackagesToScan("com.Intern.test_project.mysql.domain");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("mysql.jpa.hibernate.ddl-auto"));
//        properties.put("hibernate.dialect", env.getProperty("mysql.jpa.hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean(name = "mysqlTransactionManager")
//    public PlatformTransactionManager mysqlTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(mysqlEntityManager().getObject());
//        return transactionManager;
//    }
//}
