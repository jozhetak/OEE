package com.conciencia.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * Pojo que apoya en la recepción de fechas de inicio y fin para parametrizar
 * búsquedas
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 13/03/2017
 */
public class SysFechasReporte {
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
    private Date fechaInicio;
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
    private Date fechaFin;

    public SysFechasReporte() {
    }
    
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
