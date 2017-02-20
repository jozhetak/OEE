package com.conciencia.service;

import com.conciencia.pojo.CParoProgramado;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos paro_programado
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CParoProgramadoService {
    
    /**
     * Método que regresa una lista de paros programados.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de turnos
     */
    public List<CParoProgramado> findAll();
    
    /**
     * Método que permite ubicar un paro a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener al paro en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código del paro
     * @return el id del paro
     */
    public Long findByCode(String code);
}
