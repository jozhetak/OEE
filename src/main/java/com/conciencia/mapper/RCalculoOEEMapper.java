package com.conciencia.mapper;

import com.conciencia.pojo.RCalculoOEE;
import com.conciencia.pojo.SysFechasReporte;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    
    static final String FIND_OEE_MAQUINAS = "SELECT " +
                                            "OEE.MAQUINA as recid, " +
                                            "OEE.CODIGO_MAQUINA as codigo, " +
                                            "TRUNCATE((OEE.TIEMPO_EFECTIVO_PROD / OEE.TIEMPO_DISPONIBLE),5) AS disponibilidad, " +
                                            "TRUNCATE((OEE.CANTIDAD_PRODUCIDA/OEE.CANTIDAD_ESPERADA),5) AS rendimiento, " +
                                            "TRUNCATE((OEE.ACEPTADAS/OEE.CANTIDAD_PRODUCIDA),5) AS calidad, " +
                                            "TRUNCATE(( " +
                                            "	TRUNCATE((OEE.TIEMPO_EFECTIVO_PROD / OEE.TIEMPO_DISPONIBLE),5)  * " +
                                            "   TRUNCATE((OEE.CANTIDAD_PRODUCIDA/OEE.CANTIDAD_ESPERADA),5) * " +
                                            "   TRUNCATE((OEE.ACEPTADAS/OEE.CANTIDAD_PRODUCIDA),5) " +
                                            "),5) AS oee " +
                                            "FROM " +
                                            "( " +
                                            "	SELECT " +
                                            "       m.ID AS MAQUINA, " +
                                            "       m.codigo AS CODIGO_MAQUINA, " +
                                            "       SUM(rep.tiempo_efectivo_produccion) AS TIEMPO_EFECTIVO_PROD, " +
                                            "       (SELECT " +
                                            "           (SELECT SUM(turnos.duracion) FROM turnos) - " +
                                            "           SUM(asignaciones_programa_produccion.duracion) tiempo_disponible_maquina " +
                                            "       FROM asignaciones_programa_produccion " +
                                            "  	    WHERE asignaciones_programa_produccion.es_paro = 1 " +
                                            "       AND asignaciones_programa_produccion.fecha >= #{sysFechasReporte.fechaInicio} " +
                                            "       AND asignaciones_programa_produccion.fecha <= #{sysFechasReporte.fechaFin} " +
                                            "       AND maquina = m.id " +
                                            "       ) AS TIEMPO_DISPONIBLE, " +
                                            "   SUM(rep.unidades_producidas) AS CANTIDAD_PRODUCIDA, " +
                                            "   SUM(rep.tiempo_efectivo_produccion*r.unidades_minuto) AS CANTIDAD_ESPERADA, " +
                                            "	SUM(rep.unidades_aceptadas) AS ACEPTADAS  " +
                                            "	FROM asignaciones_programa_produccion a " +
                                            "	JOIN maquinas m ON a.maquina = m.id " +
                                            "	JOIN productos p ON a.producto = p.id " +
                                            "	JOIN reportes_operador rep ON a.id = rep.asignacion " +
                                            "	JOIN rates_produccion r ON a.maquina = r.maquina AND a.producto = r.producto " +
                                            "	WHERE a.es_paro = 0 AND a.fecha >= #{sysFechasReporte.fechaInicio} AND a.fecha <= #{sysFechasReporte.fechaFin} " +
                                            "	GROUP BY a.maquina " +
                                            ")OEE";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las maquinas existentes
     * @param fechasReporte
     * @return lista de máquinas
     */
    @Select(FIND_OEE_MAQUINAS)
    public List<RCalculoOEE> findOeeMaquinas(@Param("sysFechasReporte")SysFechasReporte fechasReporte); 
    
}