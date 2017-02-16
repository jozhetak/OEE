package com.conciencia.mapper;

import com.conciencia.pojo.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para consultas relacionadas con la tabla Usuarios
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface SysUserMapper {
    
    // <editor-fold defaultstate="collapsed" desc="CONSULTAS DEFINIDAS">
    static final String FIND_ALL = "SELECT " +
                                    "usuarios.id_usuario as recid," +
                                    "usuarios.user_name as userName,"+
                                    "usuarios.password as password,"+
                                    "usuarios.nombre as name," +
                                    "usuarios.rol_id as rolId," +
                                    "roles.codigo as rolName " +
                                    "FROM usuarios " +
                                    "JOIN roles ON " +
                                    "usuarios.rol_id = roles.id ";
    
    static final String FIND_BY_ID = "SELECT " +
                                            "usuarios.id_usuario as recid," +
                                            "usuarios.user_name as userName,"+
                                            "usuarios.password as password,"+
                                            "usuarios.nombre as name," +
                                            "usuarios.rol_id as rolId," +
                                            "roles.codigo as rolName " +
                                            "FROM usuarios " +
                                            "JOIN roles ON " +
                                            "usuarios.rol_id = roles.id " +
                                            "WHERE id_usuario = #{recid}";
    
    static final String FIND_BY_USER_NAME = "SELECT " +
                                            "usuarios.id_usuario as recid," +
                                            "usuarios.user_name as userName,"+
                                            "usuarios.password as password,"+
                                            "usuarios.nombre as name," +
                                            "usuarios.rol_id as rolId," +
                                            "roles.codigo as rolName " +
                                            "FROM usuarios " +
                                            "JOIN roles ON " +
                                            "usuarios.rol_id = roles.id " +
                                            "WHERE user_name = #{userName}";
    
    static final String FIND_USER_ID_BY_USER_NAME =   "SELECT "
                                                    + " usuarios.id_usuario "
                                                    + "FROM usuarios WHERE usuarios.user_name = #{code}";
    
    static final String INSERT_USER = "INSERT INTO `oee_db`.`usuarios`(" +
                                        "`user_name`," +
                                        "`password`," +
                                        "`nombre`," +
                                        "`rol_id`) " +
                                        "VALUES" +
                                        "(#{userName}," +
                                        "#{password}," +
                                        "#{name}," +
                                        "#{rolId});";
    
    static final String UPDATE_USER = "UPDATE `oee_db`.`usuarios` " +
                                      "SET " +
                                      "`user_name` = #{userName}," +
                                      "`password` = #{password}," +
                                      "`nombre` = #{name}," +
                                      "`rol_id` = #{rolId} " +
                                      "WHERE `id_usuario` = #{recid};";
    
    static final String DELETE_USER = "DELETE FROM `oee_db`.`usuarios` WHERE id_usuario = #{recid}";
    
    // </editor-fold>

    /**
     * Regresa la lista de usuarios existentes
     * @return 
     */
    @Select(FIND_ALL)
    public List<SysUser> findAll();
    
    /**
     * Busca un usuario por su id
     * @param recid el id de usuario
     * @return el usuario encontrado
     */
    @Select(FIND_BY_ID)
    public SysUser findById(Long recid);
    
    /**
     * Busca un usuario por su user name
     * @param userName el nombre del usuario
     * @return el usuario encontrado
     */
    @Select(FIND_BY_USER_NAME)
    public SysUser findByUserName(String userName);

    /**
     * Query que me permite ubicar un registro de la tabla de Usuarios a partir de
     * un código. 
     * @param code el código bajo el cual se busca
     * @return el id del registro.
     */
    @Select(FIND_USER_ID_BY_USER_NAME)
    public Long findByCode(String code);
    
    /**
     * Inserta un usuario nuevo al sistema
     * @param usuario el usuario a insertar
     */
    @Insert(INSERT_USER)
    @Options(useGeneratedKeys = true, keyProperty = "recid", flushCache = true, keyColumn = "id")
    public void insert(SysUser usuario);
    
    /**
     * Actualiza un usuario dado
     * @param usuario el usuario a actualizar
     */
    @Transactional
    @Update(UPDATE_USER)
    public void update(SysUser usuario);

    /**
     * Elimina un usuario del sistema
     * @param recid el id del usuario
     */
    @Transactional
    @Delete(DELETE_USER)
    public void delete(Long recid);
}