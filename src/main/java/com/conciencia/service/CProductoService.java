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
    
    /**
     * Método que permite ubicar un producto a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener al producto en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código del producto
     * @return el id del producto
     */
    public Long findByCode(String code);
    
}
