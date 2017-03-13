package com.conciencia.service.impl;

import com.conciencia.mapper.OReporteOperadorMapper;
import com.conciencia.pojo.OReporteOperador;
import com.conciencia.service.OReporteOperadorService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos reporte
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 04/03/2017
 */
@Service("OReporteOperadorService")
public class OReporteOperadorServiceImpl implements OReporteOperadorService {
    
    @Resource
    OReporteOperadorMapper reporteMapper;
    
    @Override
    public OReporteOperador findByAsignacion(Long asignacion) {
        return reporteMapper.findByAsignacion(asignacion);
    }

    @Override
    public OReporteOperador createReporte(OReporteOperador reporte) {
        reporteMapper.insertReporte(reporte);
        return reporte;
    }

    @Override
    public OReporteOperador updateReporte(OReporteOperador reporte) {
        reporteMapper.updateReporte(reporte);
        return reporte;
    }
    
}
