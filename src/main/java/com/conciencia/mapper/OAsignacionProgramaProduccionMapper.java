package com.conciencia.mapper;

import com.conciencia.pojo.OAsignacionProgramaProduccion;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de asignaciones del programa 
 * de produccion
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface OAsignacionProgramaProduccionMapper {

    @Select("SELECT* FROM asignaciones_programa_produccion")
    public List<OAsignacionProgramaProduccion> findAll();

    
}