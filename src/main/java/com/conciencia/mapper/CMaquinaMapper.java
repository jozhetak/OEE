package com.conciencia.mapper;

import com.conciencia.pojo.CMaquina;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Maquinas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CMaquinaMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion,"
                                 + " unidad_produccion as unidadProduccion "
                                 + "FROM maquinas";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las maquinas existentes
     * @return lista de máquinas
     */
    @Select(FIND_ALL)
    public List<CMaquina> findAll();    
}