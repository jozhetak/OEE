/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Clase de Operación que representa a los registros en la tabla de paros no programados
 * reportados por el operador en la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class OParoNoProgramados implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private BigInteger idAsignacion;
    private BigDecimal tiempoParo;
    private String justificacion;

    public OParoNoProgramados() {
    }

    public OParoNoProgramados(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(BigInteger idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public BigDecimal getTiempoParo() {
        return tiempoParo;
    }

    public void setTiempoParo(BigDecimal tiempoParo) {
        this.tiempoParo = tiempoParo;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OParoNoProgramados)) {
            return false;
        }
        OParoNoProgramados other = (OParoNoProgramados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.ParosNoProgramados[ id=" + id + " ]";
    }
    
}
