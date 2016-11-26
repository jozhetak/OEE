package com.conciencia.mapper;

import com.conciencia.pojo.CProducto;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Productos
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CProductoMapper {

    @Select("SELECT* FROM productos")
    public List<CProducto> findAll();

    
}