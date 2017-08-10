package com.conciencia.service;

import com.conciencia.pojo.RCalculoOEE;
import com.conciencia.pojo.SysFechasReporte;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con los objetos Reporte OEE
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * * 13/03/2017
 */
public interface RCalculoOEEService {
    
    /**
     * Método que regresa una lista de calculos OEE.
     * 
     * Utilizado por:
     * 
     * @param fechas
     * @return una lista de calculos OEE por rango fecha para todas las maquinas
     */
    public List<RCalculoOEE> findOeeMaquinas(SysFechasReporte fechas);
    
    
    
}
