package com.conciencia.service.impl;

import com.conciencia.mapper.CProductoMapper;
import com.conciencia.pojo.CProducto;
import com.conciencia.service.CProductoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos producto
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("CProductoService")
public class CProductoServiceImpl implements CProductoService {
    
    @Resource
    CProductoMapper productoMapper;
    
    /**
     * Método que regresa una lista de productos.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de productos
     */
    public List<CProducto> findAll(){
        return productoMapper.findAll();
    }
    
}
