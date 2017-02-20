package com.conciencia.service.impl;

import com.conciencia.mapper.CParoProgramadoMapper;
import com.conciencia.pojo.CParoProgramado;
import com.conciencia.service.CParoProgramadoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos paro_programado
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("CParoProgramadoService")
public class CParoProgramadoServiceImpl implements CParoProgramadoService {
    
    @Resource
    CParoProgramadoMapper paroMapper;
    
    /**
     * Método que regresa una lista de paros programados.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de turnos
     */
    @Override
    public List<CParoProgramado> findAll(){
        return paroMapper.findAll();
    }
    
    /**
     * Método que permite ubicar un paro a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener al paro en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código de paro
     * @return id de paro
     */
    @Override
    public Long findByCode(String code) {
        Long idProducto = paroMapper.findByCode(code);
        return idProducto;
    }
}
