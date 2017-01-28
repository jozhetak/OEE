package com.conciencia.service;

import com.conciencia.pojo.OAsignacionDia;
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
     * Método que regresa una lista de asignaciones.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de Asignaciones
     */
    public List<OAsignacionDia> findAll(Long maquina);
    
}
