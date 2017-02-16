package com.conciencia.mapper;

import static com.conciencia.mapper.CMaquinaMapper.FIND_BY_CODE;
import com.conciencia.pojo.CTurno;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Interfase que define las consultas relacionadas con la tabla Turnos
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 22/01/2017
 */
public interface CTurnoMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    
    static final String FIND_ALL = "SELECT "
                                 + " id as recid,"
                                 + " codigo,"
                                 + " descripcion,"
                                 + " duracion "
                                 + "FROM turnos";
    
    static final String FIND_BY_CODE = "SELECT "
                                 + " turnos.id "
                                 + "FROM turnos WHERE turnos.codigo = #{code}";
    
    // </editor-fold>
    
    /**
     * Query que regresa todas los turnos existentes
     * @return lista de turnos
     */
    @Select(FIND_ALL)
    public List<CTurno> findAll();    
    
    /**
     * Query que me permite ubicar un registro de la tabla de turnos a partir de
     * un código. 
     * @param code el código bajo el cual se busca
     * @return el id del registro.
     */
    @Select(FIND_BY_CODE)
    public Long findByCode(String code);
}