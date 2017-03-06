package com.conciencia.mapper;

import com.conciencia.pojo.OReporteOperador;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Interfase que define las consultas relacionadas con la tabla de Reportes de Operador
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/02/2017
 */
public interface OReporteOperadorMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_BY_ASIGNACION = "SELECT reportes_operador.id AS recid," +
                                             "reportes_operador.asignacion," +
                                             "reportes_operador.tiempo_efectivo_produccion AS tiempoEfectivoProduccion," +
                                             "reportes_operador.unidades_producidas as unidadesProducidas," +
                                             "reportes_operador.unidades_aceptadas as unidadesAceptadas," +
                                             "reportes_operador.tiempo_paro AS tiempoParo," +
                                             "reportes_operador.informacion_adicional AS informacionAdicional " +
                                             "FROM reportes_operador " +
                                             "JOIN asignaciones_programa_produccion ON asignaciones_programa_produccion.id = reportes_operador.asignacion " +
                                             "WHERE reportes_operador.asignacion = #{asignacion}";
    
    static final String INSERT_REPORTE = "INSERT INTO reportes_operador(asignacion,tiempo_efectivo_prodccion,unidades_producidas,unidades_aceptadas,tiempo_paro,informacion_adicional) " +
                                         "VALUES (#{reporte.asignacion},#{reporte.tiempoEfectivoProduccion},#{reporte.unidadesProducidas},#{reporte.unidadesAceptadas},#{reporte.tiempoParo},#{reporte.informacionAdicional})";
    
    static final String UPDATE_REPORTE = "UPDATE reportes_operador SET" +
                                         " tiempo_efectivo_produccion = #{reporte.tiempoEfectivoProduccion},"+
                                         " unidades_producidas = #{reporte.unidadesProducidas}," +
                                         " unidades_aceptadas = #{reporte.unidadesAceptadas}," +
                                         " tiempo_paro = #{reporte.tiempoParo}," +
                                         " informacion_adicional = #{reporte.informacionAdiciona} " +
                                         " WHERE id = #{reporte.recid}";

    
    // </editor-fold>
    
    /**
     * Query que regresa todas las asignaciones del día de hoy para una máquina dada
     * @return lista de máquinas
     */
    @Select(FIND_BY_ASIGNACION)
    public OReporteOperador findByAsignacion(@Param("asignacion")Long asignacion); 
    
    @Insert(INSERT_REPORTE)
    public void insertReporte(@Param("reporte")OReporteOperador reporte);
        
    @Update(UPDATE_REPORTE)
    public void updateReporte(@Param("reporte")OReporteOperador reporte);
}