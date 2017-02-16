package com.conciencia.service.impl;

import com.conciencia.mapper.CMaquinaMapper;
import com.conciencia.pojo.CMaquina;
import com.conciencia.service.CMaquinaService;
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
@Service("CMaquinaService")
public class CMaquinaServiceImpl implements CMaquinaService {
    
    @Resource
    CMaquinaMapper maquinaMapper;
    
    /**
     * Método que regresa una lista de maquinas.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de Máquinas
     */
    public List<CMaquina> findAll(){
        return maquinaMapper.findAll();
    }

    /**
     * Método que permite ubicar una máquina a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener la máquina en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código de la máquina
     * @return id de la maquina
     */
    @Override
    public Long findByCode(String code) {
        Long idMaquina = maquinaMapper.findByCode(code);
        return idMaquina;
    }
    
}
