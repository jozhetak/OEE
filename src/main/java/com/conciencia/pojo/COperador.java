package com.conciencia.pojo;

import java.io.Serializable;

/**
 * Clase Catálogo que representa a los registros en la tabla de operadores de la bd
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public class COperador implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombre;

    public COperador() {
    }

    public COperador(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof COperador)) {
            return false;
        }
        COperador other = (COperador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.conciencia.pojo.Operadores[ id=" + id + " ]";
    }
    
}
