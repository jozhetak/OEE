package com.conciencia.mapper;

import com.conciencia.pojo.CParoProgramado;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Paros Programados
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CParoProgramadoMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion "
                                 + "FROM paros_programados";
    
    static final String FIND_BY_CODE = "SELECT "
                                 + " paros_programados.id "
                                 + "FROM paros_programados WHERE paros_programados.codigo = #{code}";
    // </editor-fold>
    
    /**
     * Query que regresa todos los paros existentes
     * @return lista de paros
     */
    @Select(FIND_ALL)
    public List<CParoProgramado> findAll();    
    
    /**
     * Query que me permite ubicar un registro de la tabla de paros a partir de
     * un código. 
     * @param code el código bajo el cual se busca
     * @return el id del registro.
     */
    @Select(FIND_BY_CODE)
    public Long findByCode(String code);
}