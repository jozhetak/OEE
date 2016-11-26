package com.conciencia.mapper;

import com.conciencia.pojo.COperador;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Operadores
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface COperadorMapper {

    @Select("SELECT* FROM operadores")
    public List<COperador> findAll();

    
}