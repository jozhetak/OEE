package com.conciencia.service;

import com.conciencia.pojo.CMaquina;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos máquina
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CMaquinaService {
    
    /**
     * Método que regresa una lista de maquinas.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de Máquinas
     */
    public List<CMaquina> findAll();
    
}
