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
                                 + " maquinas.id AS recid,"
                                 + " maquinas.codigo,"
                                 + " maquinas.descripcion,"
                                 + " maquinas.unidad_produccion AS unidadProduccion,"
                                 + " unidades_productivas.codigo AS codigoUnidadProduccion "
                                 + "FROM maquinas "
                                 + "LEFT JOIN unidades_productivas ON "
                                 + "unidades_productivas.id = maquinas.unidad_produccion";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las maquinas existentes
     * @return lista de máquinas
     */
    @Select(FIND_ALL)
    public List<CMaquina> findAll();    
}