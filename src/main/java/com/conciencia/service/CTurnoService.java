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
    
}
