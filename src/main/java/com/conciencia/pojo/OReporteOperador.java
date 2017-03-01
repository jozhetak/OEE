package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Pojo que representa a un reporte de un operador. 
 *  
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/02/2017
 */
public class OReporteOperador implements Serializable,Comparable{
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES">
    
    /** Id único. */
    private Long recid;
    
    /** Id de la asignacion referenciada*/
    private Long asignacion;
        
    /** Duración en minutos de produccion*/
    private BigDecimal tiempoEfectivoProduccion;
    
    /** cantidad de unidades producidas*/
    private BigDecimal unidadesProducidas;
    
    /** cantidad de unidades aceptadas por calidad*/
    private BigDecimal unidadesAceptadas;
    
    /** cantidad de tiempo de paro en producción*/
    private BigDecimal tiempoParo;
    
    /** Comentarios adicionales del operador*/
    private String informacionAdicional;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    public OReporteOperador() {
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS Y SETTERS">

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public Long getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Long asignacion) {
        this.asignacion = asignacion;
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

    public BigDecimal getUnidadesAceptadas() {
        return unidadesAceptadas;
    }

    public void setUnidadesAceptadas(BigDecimal unidadesAceptadas) {
        this.unidadesAceptadas = unidadesAceptadas;
    }

    public BigDecimal getTiempoParo() {
        return tiempoParo;
    }

    public void setTiempoParo(BigDecimal tiempoParo) {
        this.tiempoParo = tiempoParo;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREESCRITOS">

    @Override
    public String toString() {
        return "OReporteOperador{" + "recid=" + recid + ", asignacion=" + asignacion + ", tiempoEfectivoProduccion=" + tiempoEfectivoProduccion + ", unidadesProducidas=" + unidadesProducidas + ", unidadesAceptadas=" + unidadesAceptadas + ", tiempoParo=" + tiempoParo + ", informacionAdicional=" + informacionAdicional + '}';
    }
    
    

    @Override
    public int compareTo(Object o) {
        OReporteOperador asingacion = (OReporteOperador)o;
        return this.recid < asingacion.getRecid()? -1: this.recid.equals(asingacion.getRecid())? 0:1;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.recid);
        hash = 97 * hash + Objects.hashCode(this.asignacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OReporteOperador other = (OReporteOperador) obj;
        if (!Objects.equals(this.recid, other.recid)) {
            return false;
        }
        if (!Objects.equals(this.asignacion, other.asignacion)) {
            return false;
        }
        return true;
    }
    
    // </editor-fold>
}
