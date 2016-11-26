package com.conciencia.mapper;

import com.conciencia.pojo.CTurno;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Turnos
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CTurnoMapper {

    @Select("SELECT* FROM turnos")
    public List<CTurno> findAll();

    
}