package com.conciencia.config;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Permite mapear el Dispachador de Servlets a '/' y a recursos estáticos.
 * Equivale a la etiqueta mvc:default-servlet-handler
 */
@Configuration
@ComponentScan(basePackages = {"com.conciencia.config",
                               "com.conciencia.controller",
                               "com.conciencia.controller.rest",
                               "com.conciencia.service"})
@ImportResource("classpath:applicationContext.xml")
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    /**
     * Constantes de configuración
     */
    private static final String ASYNC_DEFAULT_TIMEOUT = "async.default.timeout";
    private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
    private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";


    /**
     * Constantes para vistas JSP
    private static final String JSP_VIEW_RESOLVER_PREFIX = "jsp.resolver.prefix";
    private static final String JSP_VIEW_RESOLVER_SUFFIX = "jsp.resolver.suffix";
     */

    /**
     * Constantes para vistas Freemarker
     *
     */
    private static final String FTL_VIEW_RESOLVER_PREFIX = "freemarker.resolver.prefix";
    private static final String FTL_VIEW_RESOLVER_SUFFIX = "freemarker.resolver.suffix";
    private static final String FTL_TEMPLATES_PATH = "freemarker.templates.path";
    private static final String FTL_CONTENT_TYPE = "freemarker.content.type";  
    private static final String FTL_ENCODING = "freemarker.encoding";
    private static final String FTL_CONTEXT_ATTRIBUTE = "freemarker.context.attribute";
    private static final String FTL_SPRING_HELPER = "freemarker.spring.helper";
    private static final String FTL_AUTO_IMPORT = "freemarker.auto.import";
    private static final String FTL_SPRING_MACROS = "freemarker.spring.macros";
    
    /**
     * El atributo environment.
     */
    @Resource
    private Environment environment;

    
    /**
     * Registra los convertidores de POJO's de la aplicación, dando de alta 
     * clases que implementan la interface HttpMessageConverter o descendientes, 
     * tales como AbstractHttpMessageConverter, e indicando el o los formatos 
     * que soporta.
     * 
     * @param httpMessageConverters 
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> httpMessageConverters){
       // httpMessageConverters.add(new BookCaseMessageConverter(new MediaType("text", "csv")));
    }
    /**
     * Configuración de los recursos estáticos.
     *
     * @param registry Variable que almacena el registro del manejador de
     * recursos.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/");
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/goodbye").setViewName("/goodbye");
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureAsyncSupport(org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer)
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(environment.getRequiredProperty(ASYNC_DEFAULT_TIMEOUT,Long.class));
    }

    /**
     * Remplazamos configuración por defecto de manejo de rutas, a fin de 
     * incluir texto completo, incluyendo puntos, en vez de que se consideren 
     * inicio de extensiones. Para ello se requiere manejar configuración con
     * extender WebMvcConfigurationSupport.
     * 
     * @return El manejador de Mapeos.
     */
    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = super.requestMappingHandlerMapping();
        handlerMapping.setUseSuffixPatternMatch(false);
        
        return handlerMapping;
    }

    /**
     * Definición de los parámetros y configuración de acceso a los mensajes
     * tropicalizados de la aplicación de acuerdo al idioma default..
     *
     * @return El Origen de Mensajes para la aplicación.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
        messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));

        return messageSource;
    }

    /**
     * Método que permite asociar las rutas de las vistas a los archivos JSP
     * correspondientes.
     *
     * @return La entidad de asociación de Vistas.
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(environment.getRequiredProperty(JSP_VIEW_RESOLVER_PREFIX));
        viewResolver.setSuffix(environment.getRequiredProperty(JSP_VIEW_RESOLVER_SUFFIX));

        return viewResolver;
    }
     */

    /**
     * Método que permite asociar las rutas de las vistas a los archivos FTL
     * correspondientes.Debe existir un bean FreeMarkerConfigurer.
     *
     * @return La entidad de asociación de Vistas.
     */ 
    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix(environment.getRequiredProperty(FTL_VIEW_RESOLVER_PREFIX));
        resolver.setSuffix(environment.getRequiredProperty(FTL_VIEW_RESOLVER_SUFFIX));
        resolver.setContentType(environment.getRequiredProperty(FTL_CONTENT_TYPE));
        resolver.setExposeSpringMacroHelpers(environment.getRequiredProperty(FTL_SPRING_HELPER, Boolean.class));
        resolver.setRequestContextAttribute(environment.getRequiredProperty(FTL_CONTEXT_ATTRIBUTE));
        return resolver;
    }

    /**
     * Método que permite configurar la transformación de páginas Freemaker.
     * Debe existir un bean FreeMarkerViewResolver.
     * 
     * @return Regresa la instancia de configuración de Freemaker.
     * @throws IOException
     * @throws TemplateException 
     */ 
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(environment.getRequiredProperty(FTL_TEMPLATES_PATH));
        configurer.setDefaultEncoding(environment.getRequiredProperty(FTL_ENCODING));
        Properties settings = new Properties();
        settings.put(environment.getRequiredProperty(FTL_AUTO_IMPORT), environment.getRequiredProperty(FTL_SPRING_MACROS)); 
        configurer.setFreemarkerSettings(settings);
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setConfiguration(configurer.createConfiguration());
        return result;
    }
    
    /**
     * Método que permite generar un bean que procesa la carga de archivos.
     *
     * @return La instancia de manejo de carga de archivos.
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(20971520);
        resolver.setMaxInMemorySize(1048576);
        return resolver;
    }

    /**
     * Locale resolver.
     *
     * @return el valor cookie locale resolver
     */
    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("es"));
        return resolver;
    }

}
