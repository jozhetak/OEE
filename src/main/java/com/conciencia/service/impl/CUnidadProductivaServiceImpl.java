package com.conciencia.service.impl;

import com.conciencia.mapper.CUnidadProductivaMapper;
import com.conciencia.pojo.CUnidadProductiva;
import com.conciencia.service.CUnidadProductivaService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos unidad productiva
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("CUnidadProductiva")
public class CUnidadProductivaServiceImpl implements CUnidadProductivaService {
    
    @Resource
    CUnidadProductivaMapper unidadProductivaMapper;
    
    /**
     * Método que regresa una lista de unidades productivas.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de unidades productivas
     */
    public List<CUnidadProductiva> findAll(){
        return unidadProductivaMapper.findAll();
    }
    
}
