package com.conciencia.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Pojo que representa las unidades productivas del sistema. 
 * 
 * Observaciones: 
 
 El Sistema deberá utilizar el código para comparar paros cuando
 información provenga de un archivo CSV o del usuario.
 
 El sistema internamente utilizará en la base de datos el recid para hacer
 referencia a el en el proceso de cálculo de OEE.
 
 El ordenamiento basado en Comparable está centrado en el recid. Este
 será la propiedad usada para ordenar. Dos objetos son iguales si tienen el mismo recid
 
 Las comparaciones de objetos de la clase están centradas en el código, ya que 
 no puede haber dos objetos con el mísmo código. 
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public class CUnidadProductiva implements Serializable,Comparable{
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES">
    
    /** Id único */
    private Long recid;
    
    /** Código que será utilizado para que el usuario lo referencie*/
    private String codigo;
    
    /** Descripcion. Brinda información extra en el catálogo.*/
    private String descripcion;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    public CUnidadProductiva() {
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS Y SETTERS">
    
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
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREESCRITOS">
    
    @Override
    public String toString() {
        return "CUnidadProductiva{" + "id=" + recid + ", codigo=" + codigo + '}';
    }
    
    @Override
    public int compareTo(Object o) {
        CUnidadProductiva up = (CUnidadProductiva)o;
        return this.recid < up.getRecid()? -1: this.recid.equals(up.getRecid())? 0:1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final CUnidadProductiva other = (CUnidadProductiva) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    // </editor-fold>

    
}
