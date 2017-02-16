package com.conciencia.service.impl;

import com.conciencia.mapper.CRateProduccionMapper;
import com.conciencia.pojo.CRateProduccion;
import com.conciencia.service.CRateProduccionService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos rate produccion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("CRateProduccionService")
public class CRateProduccionServiceImpl implements CRateProduccionService {

    @Resource
    CRateProduccionMapper rateMapper;
    
    /**
     * Método que regresa una lista de rates.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de rates de produccion
     */
    @Override
    public List<CRateProduccion> findAll(){
        return rateMapper.findAll();
    }

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
    @Override
    public Boolean findByMaquinaProducto(Long maquina, Long producto) {
        return rateMapper.
                findByMaquinaProducto(maquina, producto) == null;
    }
    
}
