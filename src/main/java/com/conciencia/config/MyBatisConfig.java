package com.conciencia.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Clase encargada de la configuración de los beans  de la capa de persistencia.
 * 
 * @author rpacheco
 */
@Configuration
@PropertySource("classpath:application.properties")
public class MyBatisConfig {

    /**
     * La constante PROPERTY_NAME_DATABASE_URL.
     */
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";

    /**
     * La constante PROPERTY_NAME_DATABASE_DRIVER.
     */
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";

    /**
     * La constante PROPERTY_NAME_DATABASE_USERNAME.
     */
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    /**
     * La constante PROPERTY_NAME_DATABASE_PASSWORD.
     */
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

    /**
     * La constante BATCH_SQL_SESSION_TEMPLATE define el nombre del bean de procesamiento
     * batch para MyBatis.
     */
    public static final String BATCH_SQL_SESSION_TEMPLATE = "batchSqlSessionTemplate";
    
    /**
     * El atributo environment.
     */
    @Resource
    private Environment environment;

    /**
     * Definición de los parámetros y configuración de acceso a la base de datos.
     *
     * @return El Origen de Datos para la aplicación.
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        hikariConfig.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL)); 
        hikariConfig.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        hikariConfig.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        
        return dataSource;
    }

    /**
     * Manejador de transacciones que permite manejar automáticamente la funcionalidad de
     * Roll-Back en caso de algún error durante la ejecución de procesos anotados como
     * transaccionales.
     *
     * @return El manejador de transacciones.
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Metodo encargado de crear la sessión de acceso a la base de datos, indicada por la
     * fuente de datos (datasource).
     *
     * @return La instancia del generadorr de sesiones sql.
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(), ExecutorType.REUSE);
    }

    @Bean(name=BATCH_SQL_SESSION_TEMPLATE)
    public SqlSessionTemplate batchSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(), ExecutorType.BATCH);
    }

}
