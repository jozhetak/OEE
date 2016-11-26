package com.conciencia.mapper;

import com.conciencia.pojo.CRateProduccion;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Rates de Produccion
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CRateProduccionMapper {

    @Select("SELECT* FROM rates_produccion")
    public List<CRateProduccion> findAll();

    
}