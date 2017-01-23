package com.conciencia.service;

import com.conciencia.pojo.CRateProduccion;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos rate produccion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CRateProduccionService {
    
    /**
     * Método que regresa una lista de rates.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de rates de produccion
     */
    public List<CRateProduccion> findAll();
    
}
