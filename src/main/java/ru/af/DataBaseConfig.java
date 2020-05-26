package ru.af;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.af.dao.repo")
@PropertySource("classpath:db.properties")
@ComponentScan("ru.af")
public class DataBaseConfig {

    @Value("${hibernate.connection.username}")
    private String userName;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new
                LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("ru.af.dao.entity");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setShowSql(true);
        entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        Properties prop = new Properties();
        prop.setProperty("hibernate.default_schema", "shapka");
        entityManagerFactory.setJpaProperties(prop);
        return entityManagerFactory;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/shapka");
        dataSource.setUsername(userName);
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        HibernateJpaDialect hibernateJpaDialect = new HibernateJpaDialect();
        transactionManager.setJpaDialect(hibernateJpaDialect);
        return transactionManager;
    }
}
