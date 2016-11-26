package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Clase Catálogo que representa a los registros en la tabla de rates de produccion de la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class CRateProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private BigInteger idPlanta;
    private BigInteger idMaquina;
    private BigInteger idProducto;
    private Long unidadesHora;

    public CRateProduccion() {
    }

    public CRateProduccion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(BigInteger idPlanta) {
        this.idPlanta = idPlanta;
    }

    public BigInteger getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(BigInteger idMaquina) {
        this.idMaquina = idMaquina;
    }

    public BigInteger getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigInteger idProducto) {
        this.idProducto = idProducto;
    }

    public Long getUnidadesHora() {
        return unidadesHora;
    }

    public void setUnidadesHora(Long unidadesHora) {
        this.unidadesHora = unidadesHora;
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
        if (!(object instanceof CRateProduccion)) {
            return false;
        }
        CRateProduccion other = (CRateProduccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.RatesProduccion[ id=" + id + " ]";
    }
    
}
