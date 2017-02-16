package com.conciencia.service;

import com.conciencia.pojo.CTurno;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos turno
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CTurnoService {
    
    /**
     * Método que regresa una lista de turnos.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de turnos
     */
    public List<CTurno> findAll();
    
    /**
     * Método que permite ubicar un turno a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener el turno en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código del turno
     * @return el id del turno
     */
    public Long findByCode(String code);
}
