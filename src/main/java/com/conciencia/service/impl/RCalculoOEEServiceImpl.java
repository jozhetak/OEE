package com.conciencia.service.impl;

import com.conciencia.mapper.RCalculoOEEMapper;
import com.conciencia.pojo.RCalculoOEE;
import com.conciencia.pojo.SysFechasReporte;
import com.conciencia.service.RCalculoOEEService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos máquina
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("RCalculoOeeService")
public class RCalculoOEEServiceImpl implements RCalculoOEEService {
    
    @Resource
    RCalculoOEEMapper mapper;
    
    /**
     * Método que regresa una lista de maquinas.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de Máquinas
     */
    @Override
    public List<RCalculoOEE> findOeeMaquinas(SysFechasReporte fechasReporte){
        return mapper.findOeeMaquinas(fechasReporte);
    }   
    
}
