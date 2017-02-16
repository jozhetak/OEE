package com.conciencia.service.impl;

import com.conciencia.mapper.CTurnoMapper;
import com.conciencia.pojo.CTurno;
import com.conciencia.service.CTurnoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos turno
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
@Service("CTurnoService")
public class CTurnoServiceImpl implements CTurnoService {
    
    @Resource
    CTurnoMapper turnoMapper;
    
    /**
     * Método que regresa una lista de turnos.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de turnos
     */
    public List<CTurno> findAll(){
        return turnoMapper.findAll();
    }

    /**
     * Método que permite ubicar un turno a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener el turno en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código del turno
     * @return el id de turno
     */
    @Override
    public Long findByCode(String code) {
        Long turno = turnoMapper.findByCode(code);
        return turno;
    }
}
