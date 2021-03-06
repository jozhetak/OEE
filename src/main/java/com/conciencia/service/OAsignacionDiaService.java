package com.conciencia.service;

import com.conciencia.pojo.OAsignacionDia;
import java.util.Date;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos de asignacion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
public interface OAsignacionDiaService {
    
    /**
     * Método que encuentra una asignacion dado su id
     * @param id id de la asignacion
     * @return la signacion correspondiente;
     */
    public OAsignacionDia findOne(Long id);
    
    /**
     * Método que regresa una lista de asignaciones.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de Asignaciones
     */
    public List<OAsignacionDia> findAll();
    
    /**
     * Método que regresa una lista de asignaciones para un operador
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @param id del operador
     * @return una lista de Asignaciones
     */
    public List<OAsignacionDia> findAllByOperador(Long id);
    
    /**
     * Método que se encargará de validar e insertar las asignaciones del día así
     * como generar un reporte correspondiente
     * @param asignacionesDia Lista de asignaciones
     * @return 
     */
    public List<String> insertAsignacionesIntoDataBase(List<OAsignacionDia> asignacionesDia);
    
    public Date getUltimaFechaAsignacionGeneral();
    
    public Date getUltimaFechaAsignacionOperador(Long operador);
    
    public Integer getNumerAsignacionesGeneral(Date fecha);
    
    public Integer getNumerAsignacionesOperador(Date fecha,Long operador);
    
    public Integer getNumerReportadasGeneral(Date fecha);
    
    public Integer getNumerReportadasOperador(Date fecha,Long operador);
    
}
