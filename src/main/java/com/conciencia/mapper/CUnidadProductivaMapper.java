package com.conciencia.mapper;

import com.conciencia.pojo.CUnidadProductiva;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Unidades_productivas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CUnidadProductivaMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion "
                                 + "FROM unidades_productivas";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las unidades_productivas existentes
     * @return lista de turnos
     */
    @Select(FIND_ALL)
    public List<CUnidadProductiva> findAll();    
}