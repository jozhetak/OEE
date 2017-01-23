package com.conciencia.mapper;

import com.conciencia.pojo.CProducto;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Productos
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CProductoMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion,"
                                 + " unidad_produccion as unidadProduccion "
                                 + "FROM productos";
    
    // </editor-fold>
    
    /**
     * Query que regresa todos los productos existentes
     * @return lista de productos
     */
    @Select(FIND_ALL)
    public List<CProducto> findAll();    
}