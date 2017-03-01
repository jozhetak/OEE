package com.conciencia.mapper;

import com.conciencia.pojo.SysRole;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla Roles
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 26/11/2016
 */
public interface SysRoleMapper {
    
    static final String FIND_ALL = "SELECT id AS recid,codigo,descripcion FROM roles";
    
    
    static final String FIND_BY_ID = "SELECT id AS recid,codigo,descripcion FROM roles WHERE id = #{recid}";
    
    static final String FIND_BY_CODE = "SELECT id AS recid,codigo,descripcion FROM roles WHERE codigo = #{codigo}";
    
    
    /**
     * Regresa todos los roles existentes
     * @return regresa una lista de roles
     */
    @Select(FIND_ALL)
    public List<SysRole> findAll();
    
    /**
     * Busca un rol por su id
     * @param recid el id del rol
     * @return el rol encontrado
     */
    @Select(FIND_BY_ID)
    public SysRole findById(Long recid);
    
    /**
     * Busca un rol por su codigo
     * @param codigo el codigo del rol
     * @return el rol encontrado
     */
    @Select(FIND_BY_CODE)
    public SysRole findByCodigo(String codigo);

}