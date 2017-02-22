package com.conciencia.service;

import com.conciencia.pojo.OAsignacionDia;
import java.util.List;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Interface que define las operaciones a realizar con los objetos de asignacion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
public interface OAsignacionDiaService {
    
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
     */
    public List<String> insertAsignacionesIntoDataBase(List<OAsignacionDia> asignacionesDia,SimpMessagingTemplate template);
    
}
