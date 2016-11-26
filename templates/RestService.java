<#include "Configs.java">
<#include "Macros.java">
package ${package};

import java.util.List;
import javax.annotation.Resource;
import org.csveed.bean.BeanProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controlados de las interacciones REST para el manejo de instancias de la clase ${object}.
 *
 * @author ${user}
 * created on ${.now?datetime}
 */
@Controller
@RequestMapping(value = "/rest/${id_name}")
public class ${object}RestService extends YAbstractRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(${object}RestService.class);
    
    @Resource
<#if object?starts_with("V")>
    private ${main_class}Mapper ${main_class?uncap_first}Mapper;
<#else>
    private ${object}Mapper ${object?uncap_first}Mapper;
</#if>

<#if main_key??>
    /**
     * Método encargado de generar un archivo CSV con la información de los registros de la clase ${object}.
     * 
     * @param ${main_class?uncap_first} al que pertenece la instancia.
     * @return Un texto en formato csv
     */
    @RequestMapping(value = "/${object}.csv", method = RequestMethod.GET, produces = "text/csv")
    @ResponseBody
    public String downloadCSV(
           @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first}) throws IOException {
        LOGGER.debug("Descargando CSV de ${object} de ${main_class}");
        StringWriter writer = new StringWriter();
<#if object?starts_with("V")>
        List<${object}> dtosList = ${main_class?uncap_first}Mapper.find${id_name?upper_case}(${main_class?uncap_first}.getId());
<#else>
        List<${object}DTO> dtosList = ${object?uncap_first}Mapper.findAllBy${main_key?cap_first}DTO(${main_class?uncap_first}.getId());
</#if>

        CsvClient<${object}<#if !object?starts_with("V")>DTO</#if>> client = new CsvClientImpl<>(writer, ${object}<#if !object?starts_with("V")>DTO</#if>.class);
        client.writeBeans(dtosList);
        writer.close();
        return writer.getBuffer().toString();                 
    } 
<#if !object?starts_with("V")>

    /**
     * Acción index Procesa la petición de desplegar la lista completa de ${object} en JSON.
     *
     * @param ${main_class?uncap_first} al que pertenece la instancia.
     * @return La lista completa de ${object} en JSON.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<${object}> index(
           @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first}) {
        LOGGER.debug("Generando listado de ${object} de ${main_class} en JSON");
        return ${object?uncap_first}Mapper.findAllBy${main_key?cap_first}(${main_class?uncap_first}.getId());
    }

    /**
     * Acción indexDTO Procesa la petición de desplegar la lista completa de ${object}DTO en
     * JSON.
     *
     * @param ${main_class?uncap_first} al que pertenece la instancia.
     * @return La lista completa de ${object}DTO en JSON.
     */
    @RequestMapping(value = "/dto", method = RequestMethod.GET)
    @ResponseBody
    public List<${object}DTO> indexDTO(
            @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first}) {
        LOGGER.debug("Generando listado de ${object}DTO de ${main_class} en JSON");
        return ${object?uncap_first}Mapper.findAllBy${main_key?cap_first}DTO(${main_class?uncap_first}.getId());
    }           
</#if>
</#if>
    
    /**
     * Manejador de excepciones generadas por argumentos no válidos.
     *
     * @param ex Excepción lanzada al momento del error.
     * @return Texto con el detalle del error.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }

    /**
     * Manejador de excepciones generadas por errores con origen no determinado.
     *
     * @param ex Excepción lanzada al momento del error.
     * @return Texto con el detalle del error.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }

}
