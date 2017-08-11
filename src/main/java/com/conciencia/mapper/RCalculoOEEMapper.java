package com.conciencia.mapper;

import com.conciencia.pojo.RCalculoOEE;
import com.conciencia.pojo.SysFechasReporte;
import java.util.List;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * Interfase que define las consultas relacionadas con los reportes OEE
 * Segun el rol que consulta
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 13/03/2017
 */
public interface RCalculoOEEMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_OEE_MAQUINAS = "CALL SELECT_OEE(#{sysFechasReporte.fechaInicio,mode=IN},#{sysFechasReporte.fechaFin,mode=IN})";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las maquinas existentes
     * @param fechasReporte
     * @return lista de máquinas
     */
    @Select(FIND_OEE_MAQUINAS)
    @Options(statementType = StatementType.CALLABLE)
    public List<RCalculoOEE> findOeeMaquinas(@Param("sysFechasReporte")SysFechasReporte fechasReporte); 
    
}