<#include "Configs.java">
<#include "Macros.java">
package ${package};

import java.io.Reader;
import java.util.List;
import javax.annotation.Resource;
import org.csveed.api.CsvClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlados de las interacciones mediante vistas para el manejo de instancias de la
 * clase ${object}.
 *
 * @author ${user}
 * created on ${.now?datetime}
 */
@Controller
@RequestMapping("/${id_name}")
public class ${object}Controller extends YAbstractController {

    /**
     * Variable que apunta a la bitácora de la clase.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${object}Controller.class);

    /**
     * Constante que hace referencia al grid que contiene el listado de instancias de la
     * clase ${object}.
     */
    protected static final String GRID_VIEW = "${id_name}_grid";

<#if !object?starts_with("V")>

    @Resource
    private ${object}Mapper ${object?uncap_first}Mapper;
</#if>

<#if main_key??>
    /**
     * Procesa la petición al grid de soluciones disponibles.
     *
     * @param ${main_class?uncap_first} Escenario al que pertenece las instancias a desplegar.
     * @return El nombre de la vista con el listado de instancias de la clase ${object}.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showGrid(
            @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first}) {

        LOGGER.debug("Mostrando el grid de ${object} con ${main_class}: {}", ${main_class?uncap_first});
        return GRID_VIEW;
    }
    <#if !object?starts_with("S") && !object?starts_with("V")>

    /**
     * Procesa las peticiones de carga asíncrona de datos a partir de un archivo CSV.
     *
     * @param ${main_class?uncap_first} ${main_class} al que pertenece la información.
     * @param newFilePath el parámetro new file path
     * @return La ruta a la vista principal de la aplicación.
     */
    @RequestMapping(value = "/procesaCSV", method = RequestMethod.GET)
    public String uploadCSV(
            @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first},
            @ModelAttribute(MODEL_ATTRIBUTE_CSVFILE) String newFilePath) {
        String nuevaRuta;
        if (${main_class?uncap_first} != null && newFilePath != null) {
            LOGGER.debug("cargando registros del Archivo: {}", newFilePath);
            Reader reader = CsvUtils.generaReader(newFilePath);
            CsvClient<${object}DTO> csvClient
                    = new CsvClientImpl<>(reader, ${object}DTO.class);
            List<${object}DTO> listaDTOs = csvClient.readBeans();
            List<Long> idsList
                    = ${object?uncap_first}Mapper.findAllIdsByIdEscenario(${main_class?uncap_first}.getId());
            for (${object}DTO dto : listaDTOs) {
                ${object} dao${object}
                        = ${object?uncap_first}Mapper.findByIdEscenarioAndCodigo(
                                ${main_class?uncap_first}.getId(), dto.getCodigo());
                // Agregar busqueda de llaves relacionadas en base a códigos
                if (dao${object} != null) { // update
                    dao${object}.setDescripcion(dto.getDescripcion());
                    // Actualizar ids de llaves relacionadas

                    ${object?uncap_first}Mapper.update(dao${object});
                    idsList.remove(dao${object}.getId());
                } else { // insert
                    dao${object} = ${object}.getBuilder()
                            .idEscenario(${main_class?uncap_first}.getId())
                            .codigo(dto.getCodigo())
                            .descripcion(dto.getDescripcion())
                    // Actualizar campos restantes
                            .build();
                    ${object?uncap_first}Mapper.insert(dao${object});
                }
            }
            if (idsList.size() > 0) {
                ${object?uncap_first}Mapper.deleteAllById(idsList);
            }
            nuevaRuta = String.format("/${main_id}/%d/${id_name}", ${main_class?uncap_first}.getId());
        } else {
            nuevaRuta = "/${id_name}";
        }
        return createRedirectViewPath(nuevaRuta);
    }
    </#if>    
</#if>    

}
