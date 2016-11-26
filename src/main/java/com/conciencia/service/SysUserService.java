package com.conciencia.service;

import com.conciencia.pojo.SysUser;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con usuarios.
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface SysUserService {
    
    /**
     * Método que regresa una lista de usuarios. Utilizado por el grid de usuarios
     * 
     * @return una lista de usuarios.
     */
    public List<SysUser> findAll();
    
    /**
     * Método que obtiene un usuario por su id.
     * 
     * @param id el id de usuario a buscar
     * @return el objeto SysUser
     */
    public SysUser findById(Long recid);
    
    /**
     * Método que obtiene un usuario por su userName.
     * 
     * @param userName el nombre de usuario a buscar
     * @return el objeto SysUser
     */
    public SysUser findByUserName(String userName);
    
    /**
     * Método que da de alta un objeto SysUser
     * @param user Objeto a dar de alta
     * @return objeto insertado
     */
    public SysUser createUser(SysUser user) throws Exception;
    
    /**
     * Método que permite actualizar un objeto SysUser
     * @param user objeto a actualizar
     * @return Objeto actualizado
     */
    public SysUser updateUser(SysUser user) throws Exception;
    
    /**
     * Método que permite eliminar un objeto SysUser
     * @param user el id del objeto SysUser a eliminar
     * @return si la operación se realizó con éxito.
     */
    public Boolean deleteUser(Long user) throws Exception;
}
