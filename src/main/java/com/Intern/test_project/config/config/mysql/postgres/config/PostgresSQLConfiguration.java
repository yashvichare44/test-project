//package com.Intern.test_project.config.config.mysql.postgres.config;
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
//        basePackages = "com.Intern.test_project.postgres.repository",
//        entityManagerFactoryRef = "postgresEntityManager",
//        transactionManagerRef = "postgresTransactionManager"
//)
//public class PostgresSQLConfiguration {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource postgresDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("postgres.datasource.driver-class-name")));
//        dataSource.setUrl(env.getProperty("postgres.datasource.url"));
//        dataSource.setUsername(env.getProperty("postgres.datasource.username"));
//        dataSource.setPassword(env.getProperty("postgres.datasource.password"));
//        return dataSource;
//    }
//
//    @Bean(name = "postgresEntityManager")
//    public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(postgresDataSource());
//        em.setPackagesToScan("com.Intern.test_project.postgres.domain");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("postgres.jpa.hibernate.ddl-auto"));
//        properties.put("hibernate.dialect", env.getProperty("postgres.jpa.hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    @Bean(name = "postgresTransactionManager")
//    public PlatformTransactionManager postgresTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(postgresEntityManager().getObject());
//        return transactionManager;
//    }
//}
