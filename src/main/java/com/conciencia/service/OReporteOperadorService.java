package com.conciencia.service;

import com.conciencia.pojo.OReporteOperador;


/**
 * Interface que define las operaciones a realizar con los objetos de reportes de operador
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 04/03/2017
 */
public interface OReporteOperadorService {
    
    /**
     * Método que se encarga de ubicar un reporte dada la asignacion a la que 
     * pertenece.
     * 
     * @param asignacion id de la asignacion
     * @return el reporte correspondiente.
     */
    public OReporteOperador findByAsignacion(Long asignacion);
    
    /**
     * Método que se encarga de insertar un reporte para una asignacion
     * @param reporte el reporte a insertar en la base de datos
     * @return el reporte insertado
     */
    public OReporteOperador createReporte(OReporteOperador reporte);
    
    /**
     * Método que se encarga de actualizar un reporte en la bd.
     * @param reporte el reporte a actualizar
     * @return el reporte actualizado
     */
    public OReporteOperador updateReporte(OReporteOperador reporte);
    
}
