package com.conciencia.mapper;

import com.conciencia.pojo.OAsignacionDia;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla de Asignaciones Diarias
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
public interface OAsignacionDiaMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT " +
                                    "asignaciones_programa_produccion.id AS recid," +
                                    "asignaciones_programa_produccion.maquina," +
                                    "maquinas.codigo AS codigoMaquina," +
                                    "asignaciones_programa_produccion.producto," +
                                    "productos.codigo AS codigoProducto," +
                                    "asignaciones_programa_produccion.turno," +
                                    "turnos.codigo AS codigoTurno," +
                                    "asignaciones_programa_produccion.operador," +
                                    "usuarios.nombre AS nombreOperador," +
                                    "asignaciones_programa_produccion.duracion," +
                                    "asignaciones_programa_produccion.es_paro AS esParo," +
                                    "fecha " +
                                    "FROM oee_db.asignaciones_programa_produccion " +
                                    "LEFT JOIN maquinas ON asignaciones_programa_produccion.maquina = maquinas.id " +
                                    "LEFT JOIN productos ON asignaciones_programa_produccion.producto = productos.id " +
                                    "LEFT JOIN turnos ON asignaciones_programa_produccion.turno = turnos.id " +
                                    "LEFT JOIN usuarios ON asignaciones_programa_produccion.operador = usuarios.id_usuario " +
                                    "WHERE fecha = CURDATE() AND asignaciones_programa_produccion.es_paro = 0 " +
                                    "AND productos.codigo IS NOT NULL " +
                                    "UNION " +
                                    "SELECT " +
                                    "asignaciones_programa_produccion.id AS recid," +
                                    "asignaciones_programa_produccion.maquina," +
                                    "maquinas.codigo AS codigoMaquina," +
                                    "asignaciones_programa_produccion.producto," +
                                    "paros_programados.codigo AS codigoProducto," +
                                    "asignaciones_programa_produccion.turno," +
                                    "turnos.codigo AS codigoTurno," +
                                    "asignaciones_programa_produccion.operador," +
                                    "usuarios.nombre AS nombreOperador," +
                                    "asignaciones_programa_produccion.duracion," +
                                    "asignaciones_programa_produccion.es_paro AS esParo," +
                                    "fecha " +
                                    "FROM oee_db.asignaciones_programa_produccion " +
                                    "LEFT JOIN maquinas ON asignaciones_programa_produccion.maquina = maquinas.id " +
                                    "LEFT JOIN paros_programados ON asignaciones_programa_produccion.producto = paros_programados.id " +
                                    "LEFT JOIN turnos ON asignaciones_programa_produccion.turno = turnos.id " +
                                    "LEFT JOIN usuarios ON asignaciones_programa_produccion.operador = usuarios.id_usuario " +
                                    "WHERE fecha = CURDATE() AND asignaciones_programa_produccion.es_paro = 1 " +
                                    "AND paros_programados.codigo IS NOT NULL " +
                                    "ORDER BY recid";
    
    
    static final String FIND_ALL_BY_OPERADOR = "SELECT " +
                                    "asignaciones_programa_produccion.id AS recid," +
                                    "asignaciones_programa_produccion.maquina," +
                                    "maquinas.codigo AS codigoMaquina," +
                                    "asignaciones_programa_produccion.producto," +
                                    "productos.codigo AS codigoProducto," +
                                    "asignaciones_programa_produccion.turno," +
                                    "turnos.codigo AS codigoTurno," +
                                    "asignaciones_programa_produccion.operador," +
                                    "usuarios.nombre AS nombreOperador," +
                                    "asignaciones_programa_produccion.duracion," +
                                    "asignaciones_programa_produccion.es_paro AS esParo," +
                                    "fecha " +
                                    "FROM oee_db.asignaciones_programa_produccion " +
                                    "LEFT JOIN maquinas ON asignaciones_programa_produccion.maquina = maquinas.id " +
                                    "LEFT JOIN productos ON asignaciones_programa_produccion.producto = productos.id " +
                                    "LEFT JOIN turnos ON asignaciones_programa_produccion.turno = turnos.id " +
                                    "LEFT JOIN usuarios ON asignaciones_programa_produccion.operador = usuarios.id_usuario " +
                                    "WHERE fecha = CURDATE() AND asignaciones_programa_produccion.es_paro = 0 " +
                                    "AND productos.codigo IS NOT NULL " +
                                    "AND asignaciones_programa_produccion.operador = #{operador} " +
                                    "UNION " +
                                    "SELECT " +
                                    "asignaciones_programa_produccion.id AS recid," +
                                    "asignaciones_programa_produccion.maquina," +
                                    "maquinas.codigo AS codigoMaquina," +
                                    "asignaciones_programa_produccion.producto," +
                                    "paros_programados.codigo AS codigoProducto," +
                                    "asignaciones_programa_produccion.turno," +
                                    "turnos.codigo AS codigoTurno," +
                                    "asignaciones_programa_produccion.operador," +
                                    "usuarios.nombre AS nombreOperador," +
                                    "asignaciones_programa_produccion.duracion," +
                                    "asignaciones_programa_produccion.es_paro AS esParo," +
                                    "fecha " +
                                    "FROM oee_db.asignaciones_programa_produccion " +
                                    "LEFT JOIN maquinas ON asignaciones_programa_produccion.maquina = maquinas.id " +
                                    "LEFT JOIN paros_programados ON asignaciones_programa_produccion.producto = paros_programados.id " +
                                    "LEFT JOIN turnos ON asignaciones_programa_produccion.turno = turnos.id " +
                                    "LEFT JOIN usuarios ON asignaciones_programa_produccion.operador = usuarios.id_usuario " +
                                    "WHERE fecha = CURDATE() AND asignaciones_programa_produccion.es_paro = 1 " +
                                    "AND paros_programados.codigo IS NOT NULL " +
                                    "AND asignaciones_programa_produccion.operador = #{operador} " +
                                    "ORDER BY recid";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas las asignaciones del día de hoy para una máquina dada
     * @return lista de máquinas
     */
    @Select(FIND_ALL)
    public List<OAsignacionDia> findAll();

    @Select(FIND_ALL_BY_OPERADOR)
    public List<OAsignacionDia> findAllByOperador(@Param("operador")Long operador);    
}