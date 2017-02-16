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
    
    /**
     * Método que permite ubicar un rate de produccion a partir de su máquina y
     * su producto.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener saber si existe un rate de produccion
     * para la maquina-producto dados
     * 
     * @param maquina el id de la máquina
     * @param producto el id del producto
     * @return true or false si existe o no el rate
     */
    public Boolean findByMaquinaProducto(Long maquina,Long producto);
    
}
