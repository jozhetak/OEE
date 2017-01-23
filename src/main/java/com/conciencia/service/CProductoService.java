package com.conciencia.service;

import com.conciencia.pojo.CProducto;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos producto
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CProductoService {
    
    /**
     * Método que regresa una lista de productos.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de productos
     */
    public List<CProducto> findAll();
    
}
