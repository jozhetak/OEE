package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Clase de Operación que representa a los registros en la tabla de reportes del operador de la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class OReporteOperador implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private BigInteger idAsignacion;
    private BigDecimal tiempoEfectivoProduccion;
    private BigDecimal unidadesProducidas;
    private String informacionAdicional;

    public OReporteOperador() {
    }

    public OReporteOperador(Long id) {
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

    public BigDecimal getTiempoEfectivoProduccion() {
        return tiempoEfectivoProduccion;
    }

    public void setTiempoEfectivoProduccion(BigDecimal tiempoEfectivoProduccion) {
        this.tiempoEfectivoProduccion = tiempoEfectivoProduccion;
    }

    public BigDecimal getUnidadesProducidas() {
        return unidadesProducidas;
    }

    public void setUnidadesProducidas(BigDecimal unidadesProducidas) {
        this.unidadesProducidas = unidadesProducidas;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
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
        if (!(object instanceof OReporteOperador)) {
            return false;
        }
        OReporteOperador other = (OReporteOperador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.ReportesOperador[ id=" + id + " ]";
    }
    
}
