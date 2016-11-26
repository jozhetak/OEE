<#include "Configs.java">
<#include "Macros.java">
package ${package};

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Declara los métodos auxiliares relacionados con ${object}.
 */
public interface ${object}Service {

    /**
     * Método encargado de cargar una lista con instancias de ${object} 
     * a la base de datos, apoyandose en un archivo de paso tipo csv.
     *
     * @param lista${object}
     * @throws FileNotFoundException
     */
    public void cargaLista(List<${object}> lista${object})
            throws FileNotFoundException;

}