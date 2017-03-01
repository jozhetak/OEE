package com.conciencia.service;

import com.conciencia.pojo.SysRole;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con roles.
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 26/11/2016
 */
public interface SysRoleService {
    
    /**
     * Método que regresa una lista de roles. Utilizado por el grid de roles
     * 
     * @return una lista de roles.
     */
    public List<SysRole> findAll();
    
    /**
     * Método que obtiene un rol por su id.
     * 
     * @param id el id de rol a buscar
     * @return el objeto SysRole
     */
    public SysRole findById(Long recid);
    
    /**
     * Método que obtiene un rol por su codigo.
     * 
     * @param roleName el nombre de rol a buscar
     * @return el objeto SysRole
     */
    public SysRole findByCodigo(String codigo);
    
   
}
