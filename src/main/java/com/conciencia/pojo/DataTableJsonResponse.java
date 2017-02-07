package com.conciencia.pojo;

import java.util.List;

/**
 * Objeto que representa la respuesta esperada
 * de DataTable Plugin
 * 
 * @author Ernesto Cantu Valle
 */
public class DataTableJsonResponse<T> {
    List<T> data;

    public DataTableJsonResponse() {
    }
    
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
    
}
