package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Pojo que representa las asignaciones diarias a máquinas. 
 *  
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
public class OAsignacionDia implements Serializable,Comparable{
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES">
    
    /** Id único. */
    private Long recid;
    
    /** Id de la máquina referenciada*/
    private Long maquina;
    
    /** Código de la máquina correspondiente */
    private String codigoMaquina;
    
    /** Producto de la asignación */
    private Long producto;
    
    /** Código del producto */
    private String codigoProducto;
    
    /** Turno correspondiente de la asignación */
    private Long turno;
    
    /** Código del turno correspondiente */
    private String codigoTurno;
    
    /** Usuario quien tiene asignada esta tarea. */
    private Long operador;
    
    /** Operador quien se espera realice la asignación*/
    private String nombreOperador;
    
    /** Duración en minutos de la asignación*/
    private BigDecimal duracion;
    
    /** Indicador de si la asignación corresponde a un paro programado */
    private Boolean esParo;
    
    /** Fecha de la asignacion */
    private Date fecha;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    public OAsignacionDia() {
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS Y SETTERS">
    
    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public Long getMaquina() {
        return maquina;
    }

    public void setMaquina(Long maquina) {
        this.maquina = maquina;
    }

    public String getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(String codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Long getTurno() {
        return turno;
    }

    public void setTurno(Long turno) {
        this.turno = turno;
    }

    public String getCodigoTurno() {
        return codigoTurno;
    }

    public void setCodigoTurno(String codigoTurno) {
        this.codigoTurno = codigoTurno;
    }

    public Long getOperador() {
        return operador;
    }

    public void setOperador(Long operador) {
        this.operador = operador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREESCRITOS">
    
    @Override
    public String toString() {
        return "OAsignacionDia{" + "recid=" + recid + ", maquina=" + maquina + ", producto=" + producto + ", turno=" + turno + ", fecha=" + fecha + '}';
    }

    @Override
    public int compareTo(Object o) {
        OAsignacionDia asingacion = (OAsignacionDia)o;
        return this.recid < asingacion.getRecid()? -1: this.recid.equals(asingacion.getRecid())? 0:1;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigoMaquina);
        hash = 23 * hash + Objects.hashCode(this.codigoProducto);
        hash = 23 * hash + Objects.hashCode(this.codigoTurno);
        hash = 23 * hash + Objects.hashCode(this.esParo);
        hash = 23 * hash + Objects.hashCode(this.fecha);
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
        final OAsignacionDia other = (OAsignacionDia) obj;
        if (!Objects.equals(this.codigoMaquina, other.codigoMaquina)) {
            return false;
        }
        if (!Objects.equals(this.codigoProducto, other.codigoProducto)) {
            return false;
        }
        if (!Objects.equals(this.codigoTurno, other.codigoTurno)) {
            return false;
        }
        if (!Objects.equals(this.esParo, other.esParo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    // </editor-fold>
}
