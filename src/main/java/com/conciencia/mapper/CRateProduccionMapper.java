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
                                 + " id as recid,"
                                 + " maquina,"
                                 + " producto,"
                                 + " unidades_minuto "
                                 + "FROM rates_produccion";
    
    // </editor-fold>
    
    /**
     * Query que regresa todos los rates existentes
     * @return lista de rates
     */
    @Select(FIND_ALL)
    public List<CRateProduccion> findAll();    
}