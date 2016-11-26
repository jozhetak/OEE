package com.conciencia.config;

import static com.conciencia.config.MyBatisConfig.BATCH_SQL_SESSION_TEMPLATE;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The MapperScannerConfigurer is a implementation of BeanFactoryPostProcessor. Having a
 * BeanFactoryPostProcessor in a @Configuration class breaks the default post-processing
 * of that @Configuration class.Separating the MapperScannerConfigurer bean method from
 * MyBatisConfig into it's own class solves the problem.
 *
 * @author rpacheco
 */
@Configuration
public class MyBatisScanConfig {

    /**
     * Ruta a escanear para generar los mappers de acceso simple.
     */
    private static final String DEFAULT_MAPPERS_PACKAGE_NAME = "com.conciencia.mapper";

    /**
     * Ruta a escanear para generar los mappers de accesos tipo batch.
     */
    private static final String BATCH_MAPPERS_PACKAGE_NAME = "com.conciencia.mapper.batch";

    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(DEFAULT_MAPPERS_PACKAGE_NAME);
        return mapperScannerConfigurer;
    }
    

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurerBatch() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(BATCH_MAPPERS_PACKAGE_NAME);
        configurer.setSqlSessionTemplateBeanName(BATCH_SQL_SESSION_TEMPLATE);
        return configurer;
    }    

}
