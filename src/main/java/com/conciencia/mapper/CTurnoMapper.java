package com.conciencia.mapper;

import com.conciencia.pojo.CTurno;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Turnos
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CTurnoMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion,"
                                 + " duracion "
                                 + "FROM turnos";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas los turnos existentes
     * @return lista de turnos
     */
    @Select(FIND_ALL)
    public List<CTurno> findAll();    
}