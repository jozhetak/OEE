package com.conciencia.service.impl;

import com.conciencia.mapper.OAsignacionDiaMapper;
import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.service.OAsignacionDiaService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos asignacion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
@Service("OAsignacionDiaService")
public class OAsignacionDiaServiceImpl implements OAsignacionDiaService {
    
    @Resource
    OAsignacionDiaMapper asignacionDiaMapper;
    
    /**
     * Método que regresa una lista de asignaciones por máquina.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de asignaciones por máquina
     */
    public List<OAsignacionDia> findAll(Long maquina){
        return asignacionDiaMapper.findAll(maquina);
    }
    
}
