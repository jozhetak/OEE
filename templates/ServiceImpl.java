<#include "Configs.java">
<#include "Macros.java">
package ${package};

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Esta implementación de la interfase ${object}Service.
 */
@Service
public class ${object}ServiceImpl implements ${object}Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(${object}ServiceImpl.class);

    
    @Resource
    PropertiesService propertiesService;
   
    @Resource
    private ${object}Mapper ${object?uncap_first}Mapper;

    @Override
    public void cargaLista(List<${object}> dtosList)
            throws FileNotFoundException {

        LOGGER.info("Exportando ${object} a CSV");

        String filePath = propertiesService.getFileName${id_name?upper_case}();
        try (PrintWriter out = new PrintWriter(filePath)) {
            for (int i = 0; i < dtosList.size(); i++) {
                if (i < dtosList.size() - 1) {
                    out.println(dtosList.get(i).toCSV());
                } else {
                    out.print(dtosList.get(i).toCSV());
                }
            }
        }
        ${object?uncap_first}Mapper.loadCSV(propertiesService);
    }
}