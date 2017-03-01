package com.conciencia.mapper;

import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.pojo.OReporteOperador;
import java.util.List;
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
    
    static final String FIND_ALL = "SELECT * FROM reportes_operador";
    
    static final String INSERT_REPORTE = "INSERT INTO reportes_operador(asignacion,tiempo_efectivo_prodccion,unidades_producidas,unidades_aceptadas,tiempo_paro,informacion_adicional) " +
                                         "VALUES (#{reporte.asignacion},#{reporte.tiempoEfectivoProduccion},#{reporte.unidadesProducidas},#{reporte.unidadesAceptadas},#{reporte.tiempoParo},#{reporte.informacionAdicional})";
    
    static final String REQUEST_UPDATE_REPORTE = "";
    
    static final String UPDATE_REPORTE = "UPDATE reportes_operador SET" +
                                         " tiempo_efectivo_produccion = #{reporte.tiempoEfectivoProduccion},"+
                                         " unidades_producidas = #{reporte.unidadesProducidas}," +
                                         " unidades_aceptadas = #{reporte.unidadesAceptadas}," +
                                         " tiempo_paro = #{reporte.tiempoParo}," +
                                         " informacion_adicional = #{reporte.informacionAdiciona} " +
                                         " WHERE id = #{reporte.idReporte}";

    
    // </editor-fold>
    
    /**
     * Query que regresa todas las asignaciones del día de hoy para una máquina dada
     * @return lista de máquinas
     */
    @Select(FIND_ALL)
    public List<OAsignacionDia> findAll(); 
    
    @Insert(INSERT_REPORTE)
    public void insertReporte(@Param("reporte")OReporteOperador reporte);
    
    @Insert(REQUEST_UPDATE_REPORTE)
    public void requestUpdateRepote();
    
    @Update(UPDATE_REPORTE)
    public void updateReporte();
}