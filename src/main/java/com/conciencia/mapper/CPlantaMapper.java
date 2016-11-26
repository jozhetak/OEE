package com.conciencia.mapper;

import com.conciencia.pojo.CPlanta;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Plantas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CPlantaMapper {
    
    @Select("SELECT* FROM plantas")
    public List<CPlanta> findAll(String name);

    
}