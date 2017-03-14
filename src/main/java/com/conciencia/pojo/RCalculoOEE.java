package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Pojo que representa a un recurso con su cálculo de OEE. 
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 12/03/2017
 */
public class RCalculoOEE implements Serializable{
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES">
    
    /** Id único del Recurso */
    private Long recid;
    
    /** Código del recurso*/
    private String codigo;
    
    /** Disponibilidad del recurso */
    private BigDecimal disponibilidad;
    
    /** Rendimiento del recurso */
    private BigDecimal rendimiento;
    
    /** Calidad del recurso */
    private BigDecimal calidad;
    
    /** OEE del recurso */
    private BigDecimal oee;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    public RCalculoOEE() {
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS Y SETTERS">
    
    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getDisponibilidad() {
        return disponibilidad.multiply(new BigDecimal(100L));
    }

    public void setDisponibilidad(BigDecimal disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public BigDecimal getRendimiento() {
        return rendimiento.multiply(new BigDecimal(100L));
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }

    public BigDecimal getCalidad() {
        return calidad.multiply(new BigDecimal(100L));
    }

    public void setCalidad(BigDecimal calidad) {
        this.calidad = calidad;
    }

    public BigDecimal getOee() {
        return oee.multiply(new BigDecimal(100L));
    }

    public void setOee(BigDecimal oee) {
        this.oee = oee;
    }
    
    // </editor-fold>

}
