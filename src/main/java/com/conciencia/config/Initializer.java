package com.conciencia.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Clase de configuración de laAplicaciones Web.<br>
 * Cuando se arranca un ServletContainer, como Tomcat, desplegar y cargar las
 * aplicaciones web. Por cada aplicación(servlet) cargada el ServletContainer
 * creará un ServletContext y lo mantendrá en memoria. Posteriormente se
 * realizarán las inicializaciones instanciando esta clase y llevando a cabo las
 * tareas definidas en ella. El ServletContext define un conjunto de métodos que
 * un servlet utiliza para comunicarse con su contenedor de servlets, por
 * ejemplo, para obtener el tipo MIME de un archivo, las solicitudes de
 * despacho, o escribir en un archivo de registro.<br>
 * Esta clase remplaza el uso del archivo WEB.xml.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * La constante MVC_DISPATCHER_SERVLET_MAPPING.
     */
    private static final String MVC_DISPATCHER_SERVLET_MAPPING = "/";

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
            SecurityConfig.class,
            MyBatisScanConfig.class,
            MyBatisConfig.class
        };
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
            WebMvcConfiguration.class
        };
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{MVC_DISPATCHER_SERVLET_MAPPING};
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#customizeRegistration(javax.servlet.ServletRegistration.Dynamic)
     */
    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setInitParameter("dispatchOptionsRequest", "true");
        registration.setAsyncSupported(true);
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
