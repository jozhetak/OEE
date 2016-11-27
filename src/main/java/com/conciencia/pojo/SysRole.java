package com.conciencia.pojo;

import java.io.Serializable;

/**
 * Clase de Sistema que representa a los roles de usuarios que tienen acceso.
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long recid;
    private String codigo;
    private String descripcion;

    public SysRole() {
    }

    public SysRole(Long recid) {
        this.recid = recid;
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
        if (!(object instanceof SysRole)) {
            return false;
        }
        SysRole other = (SysRole) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.Roles[ id=" + recid + " ]";
    }
    
}
