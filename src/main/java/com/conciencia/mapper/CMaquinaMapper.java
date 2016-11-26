package com.conciencia.mapper;

import com.conciencia.pojo.CMaquina;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Maquinas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CMaquinaMapper {

    @Select("SELECT* FROM maquinas")
    public List<CMaquina> findAll();

    
}