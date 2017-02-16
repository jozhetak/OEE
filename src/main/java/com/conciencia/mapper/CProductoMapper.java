package com.conciencia.mapper;

import static com.conciencia.mapper.CMaquinaMapper.FIND_BY_CODE;
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
                                 + " productos.id as recid,"
                                 + " productos.codigo,"
                                 + " productos.descripcion,"
                                 + " productos.unidad_produccion as unidadProductiva, "
                                 + " unidades_productivas.codigo AS codigoUnidadProduccion "
                                 + "FROM productos "
                                 + "LEFT JOIN unidades_productivas ON "
                                 + "unidades_productivas.id = productos.unidad_produccion";
    
    static final String FIND_BY_CODE = "SELECT "
                                 + " productos.id "
                                 + "FROM productos WHERE productos.codigo = #{code}";
    
    // </editor-fold>
    
    /**
     * Query que regresa todos los productos existentes
     * @return lista de productos
     */
    @Select(FIND_ALL)
    public List<CProducto> findAll();    
    
    /**
     * Query que me permite ubicar un registro de la tabla de productos a partir de
     * un código. 
     * @param code el código bajo el cual se busca
     * @return el id del registro.
     */
    @Select(FIND_BY_CODE)
    public Long findByCode(String code);
}