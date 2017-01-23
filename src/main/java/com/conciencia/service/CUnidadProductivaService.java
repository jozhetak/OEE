package com.conciencia.service;

import com.conciencia.pojo.CUnidadProductiva;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos unidad productiva
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CUnidadProductivaService {
    
    /**
     * Método que regresa una lista de unidades productivas.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de unidades productivas
     */
    public List<CUnidadProductiva> findAll();
    
}
