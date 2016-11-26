package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Clase de Operación que representa a los registros en la tabla de asignaciones
 * de produccion de la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class OAsignacionProgramaProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private BigInteger idPrograma;
    private BigInteger idPlanta;
    private BigInteger maquina;
    private BigInteger producto;
    private BigInteger turno;
    private BigInteger operador;
    private BigDecimal duracion;
    private Boolean esParo;
    private String informacionAdicional;

    public OAsignacionProgramaProduccion() {
    }

    public OAsignacionProgramaProduccion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(BigInteger idPrograma) {
        this.idPrograma = idPrograma;
    }

    public BigInteger getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(BigInteger idPlanta) {
        this.idPlanta = idPlanta;
    }

    public BigInteger getMaquina() {
        return maquina;
    }

    public void setMaquina(BigInteger maquina) {
        this.maquina = maquina;
    }

    public BigInteger getProducto() {
        return producto;
    }

    public void setProducto(BigInteger producto) {
        this.producto = producto;
    }

    public BigInteger getTurno() {
        return turno;
    }

    public void setTurno(BigInteger turno) {
        this.turno = turno;
    }

    public BigInteger getOperador() {
        return operador;
    }

    public void setOperador(BigInteger operador) {
        this.operador = operador;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public Boolean getEsParo() {
        return esParo;
    }

    public void setEsParo(Boolean esParo) {
        this.esParo = esParo;
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
        if (!(object instanceof OAsignacionProgramaProduccion)) {
            return false;
        }
        OAsignacionProgramaProduccion other = (OAsignacionProgramaProduccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.AsignacionesProgramaProduccion[ id=" + id + " ]";
    }
    
}
