package com.conciencia.mapper;

import com.conciencia.pojo.CUnidadProductiva;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de unidades productivas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CUnidadProductivaMapper {

    @Select("SELECT* FROM unidades_productivas")
    public List<CUnidadProductiva> findAll();

    
}