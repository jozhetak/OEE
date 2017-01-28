package com.conciencia.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Pojo que representa los Rates de produccion del sistema. 
 * 
 * Observaciones: 
 
 El Sistema deberá utilizar el código para comparar cuando
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
public class CRateProduccion implements Serializable,Comparable{
    
    // <editor-fold defaultstate="collapsed" desc="PROPIEDADES">
    
    /** Id único. */
    private Long recid;
    
    private Long maquina;
    
    private String codigoMaquina;
    
    private Long producto;
    
    private String codigoProducto;
    
    private BigDecimal unidadesMinuto;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    
    public CRateProduccion() {
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
    
    public String getCodigoMaquina(){
        return this.codigoMaquina;
    }
    
    public void setCodigoMaquina(String codigoMaquina){
        this.codigoMaquina = codigoMaquina;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }
    
    public String getCodigoProducto(){
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(String codigoProducto){
        this.codigoProducto = codigoProducto;
    }

    public BigDecimal getUnidadesMinuto() {
        return unidadesMinuto;
    }

    public void setUnidadesMinuto(BigDecimal unidadesMinuto) {
        this.unidadesMinuto = unidadesMinuto;
    }

    
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SOBREESCRITOS">
    
    
    @Override
    public String toString() {
        return "CRateProduccion{" + "maquina=" + maquina + ", producto=" + producto + '}';
    }

    @Override
    public int compareTo(Object o) {
        CRateProduccion rate = (CRateProduccion)o;
        return this.recid < rate.getRecid()? -1: this.recid.equals(rate.getRecid())? 0:1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.maquina);
        hash = 61 * hash + Objects.hashCode(this.producto);
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
        final CRateProduccion other = (CRateProduccion) obj;
        if (!Objects.equals(this.maquina, other.maquina)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }
    
    // </editor-fold>
    
}
