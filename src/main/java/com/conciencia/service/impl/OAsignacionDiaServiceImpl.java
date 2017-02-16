package com.conciencia.service.impl;

import com.conciencia.mapper.OAsignacionDiaMapper;
import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.service.CMaquinaService;
import com.conciencia.service.CProductoService;
import com.conciencia.service.OAsignacionDiaService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.conciencia.service.CTurnoService;
import com.conciencia.service.SysUserService;
import java.math.BigDecimal;

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
    
    @Resource
    CMaquinaService maquinaService;
    
    @Resource
    CProductoService productoService;
    
    @Resource
    SysUserService userService;
    
    @Resource
    CTurnoService turnoService;
    
    
    /**
     * Método que regresa una lista de asignaciones por máquina.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de asignaciones por máquina
     */
    @Override
    public List<OAsignacionDia> findAll(){
        return asignacionDiaMapper.findAll();
    }

    /**
     * Método que regresa una lista de asignaciones para un operador
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @param id id del operador
     * @return una lista de Asignaciones
     */
    @Override
    public List<OAsignacionDia> findAllByOperador(Long id) {
        return asignacionDiaMapper.findAllByOperador(id);
    }
    
    /**
     * Método que se encargará de validar e insertar las asignaciones del día así
     * como generar un reporte correspondiente.
     *
     * Pseudocódigo:
     * 
     * 1.- Ordenar la lista de asignaciones de la siguiente forma: maquina-turno-producto-operador
     * 2.- Una vez ordenada, recorro la lista, acumulando el tiempo asignado a la maquina turno
     * 3.- Para cada elemento de la lista verifico que la info del registro si exista
     * 4.- Procedo a incertar
     * 
     * @param asignacionesDia Lista de asignaciones
     */
    @Override
    public void insertAsignacionesIntoDataBase(List<OAsignacionDia> asignacionesDia){
    
        for(OAsignacionDia asignacion: asignacionesDia){
            
        }
        
    }
}
