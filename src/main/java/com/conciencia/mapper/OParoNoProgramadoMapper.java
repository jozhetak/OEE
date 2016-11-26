package com.conciencia.mapper;

import com.conciencia.pojo.OParoNoProgramados;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de informes de paros no programados
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface OParoNoProgramadoMapper {

    @Select("SELECT* FROM paros_no_programados")
    public List<OParoNoProgramados> findAll();

    
}