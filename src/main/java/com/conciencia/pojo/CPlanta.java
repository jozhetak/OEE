package com.conciencia.pojo;

import java.io.Serializable;

/**
 * Clase Catálogo que representa a los registros en la tabla de plantas de la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class CPlanta implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Long recid;
    private String codigo;
    private String descripcion;

    public CPlanta() {
    }

    public CPlanta(Long id) {
        this.recid = id;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the recid fields are not set
        if (!(object instanceof CPlanta)) {
            return false;
        }
        CPlanta other = (CPlanta) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.Plantas[ id=" + recid + " ]";
    }
    
}
