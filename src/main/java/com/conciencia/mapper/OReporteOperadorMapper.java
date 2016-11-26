package com.conciencia.mapper;

import com.conciencia.pojo.OReporteOperador;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de informes de operador
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface OReporteOperadorMapper {

    @Select("SELECT* FROM reportes_operador")
    public List<OReporteOperador> findAll();

    
}