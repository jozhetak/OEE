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

    @Select(FIND_ALL)
    public List<SysUser> findAll();
    
    @Select(FIND_BY_ID)
    public SysUser findById(Long recid);
    
    @Select(FIND_BY_USER_NAME)
    public SysUser findByUserName(String userName);

    @Insert(INSERT_USER)
    @Options(useGeneratedKeys = true, keyProperty = "recid", flushCache = true, keyColumn = "id")
    public int insert(SysUser usuario);
    
    @Transactional
    @Update(UPDATE_USER)
    public void update(SysUser usuario);

    @Transactional
    @Delete(DELETE_USER)
    public int delete(Long recid);
}