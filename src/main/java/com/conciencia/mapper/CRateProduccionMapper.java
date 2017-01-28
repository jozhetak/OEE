package com.conciencia.mapper;

import com.conciencia.pojo.CRateProduccion;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Rates_produccion
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CRateProduccionMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " rates_produccion.id as recid,"
                                 + " rates_produccion.maquina,"
                                 + " maquinas.codigo as codigoMaquina,"
                                 + " rates_produccion.producto,"
                                 + " productos.codigo as codigoProducto,"
                                 + " rates_produccion.unidades_minuto "
                                 + "FROM rates_produccion "
                                 + "LEFT JOIN maquinas ON "
                                 + "maquinas.id = rates_produccion.maquina "
                                 + "LEFT JOIN productos ON "
                                 + "productos.id = rates_produccion.producto ";
    
    // </editor-fold>
    
    /**
     * Query que regresa todos los rates existentes
     * @return lista de rates
     */
    @Select(FIND_ALL)
    public List<CRateProduccion> findAll();    
}