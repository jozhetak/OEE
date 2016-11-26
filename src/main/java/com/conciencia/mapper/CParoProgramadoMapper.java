package com.conciencia.mapper;

import com.conciencia.pojo.CParoProgramado;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Maquinas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CParoProgramadoMapper {

    @Select("SELECT* FROM paros_programados")
    public List<CParoProgramado> findAll();

    
}