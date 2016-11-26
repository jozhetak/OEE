package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Clase de Operación que representa a los registros en la tabla de informes de piezas rechazadas
 * reportados por el operador en la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class OInformePiezasRechazadas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private BigInteger idInformeOperador;
    private BigDecimal unidadesRechazadas;
    private String justificacion;

    public OInformePiezasRechazadas() {
    }

    public OInformePiezasRechazadas(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdInformeOperador() {
        return idInformeOperador;
    }

    public void setIdInformeOperador(BigInteger idInformeOperador) {
        this.idInformeOperador = idInformeOperador;
    }

    public BigDecimal getUnidadesRechazadas() {
        return unidadesRechazadas;
    }

    public void setUnidadesRechazadas(BigDecimal unidadesRechazadas) {
        this.unidadesRechazadas = unidadesRechazadas;
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
        if (!(object instanceof OInformePiezasRechazadas)) {
            return false;
        }
        OInformePiezasRechazadas other = (OInformePiezasRechazadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.InformePiezasRechazadas[ id=" + id + " ]";
    }
    
}
