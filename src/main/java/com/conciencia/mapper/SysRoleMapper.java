package com.conciencia.mapper;

import com.conciencia.pojo.SysRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

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
    
    static final String INSERT_ROLE = "INSERT INTO `oee_db`.`roles`(" +
                                        "`codigo`," +
                                        "`descripcion`) " +
                                        "VALUES" +
                                        "(#{codigo}," +
                                        "#{descripcion});";
    
    static final String UPDATE_ROLE = "UPDATE `oee_db`.`roles` " +
                                      "SET " +
                                      "`codigo` = #{codigo}," +
                                      "`descripcion` = #{descripcion} " +
                                      "WHERE `id` = #{recid};";
    
    static final String DELETE_ROLE = "DELETE FROM `oee_db`.`roles` WHERE id = #{recid}";
    
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

    /**
     * Inserta un rol
     * @param rol el rol a insertar
     */
    @Insert(INSERT_ROLE)
    @Options(useGeneratedKeys = true, keyProperty = "recid", flushCache = true, keyColumn = "id")
    public void insert(SysRole rol);
    
    /**
     * Actualiza un rol dado
     * @param rol el rol a actualizar
     */
    @Transactional
    @Update(UPDATE_ROLE)
    public void update(SysRole rol);

    /**
     * elimina un rol
     * @param recid el id del rol a eliminar.
     */
    @Transactional
    @Delete(DELETE_ROLE)
    public void delete(Long recid);

}