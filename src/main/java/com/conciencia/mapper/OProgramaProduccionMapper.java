package com.conciencia.mapper;

import com.conciencia.pojo.OProgramaProduccion;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de programas de produccion
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface OProgramaProduccionMapper {

    @Select("SELECT* FROM paros_programados")
    public List<OProgramaProduccion> findAll();

    
}