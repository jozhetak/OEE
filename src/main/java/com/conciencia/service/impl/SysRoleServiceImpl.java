package com.conciencia.service.impl;

import com.conciencia.mapper.SysRoleMapper;
import com.conciencia.pojo.SysRole;
import com.conciencia.service.SysRoleService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Implementacion de SysRoleService
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 26/11/2016
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

    private static final Logger LOG = Logger.getLogger(SysRoleServiceImpl.class.getName());
    
    /* RECURSO QUE PERMITE LA INTERACCIÓN CON BASE DE DATOS PARA LA TABLA DE ROLS */
    @Resource
    SysRoleMapper sysRoleMapper;

    public SysRoleServiceImpl() {
        LOG.setLevel(Level.ALL);
    }
    
    /**
     * Método que regresa una lista de rols. Utilizado por el grid de rols
     * 
     * @return una lista de rols.
     */
    @Override
    public List<SysRole> findAll(){
        LOG.info("OBTENIENDO TODOS LOS ROLS DISPONIBLES");
        return sysRoleMapper.findAll();
    }
    
    /**
     * Método que obtiene un rol por su id.
     * 
     * @param id el id de rol a buscar
     * @return el objeto SysRole
     */
    @Override
    public SysRole findById(Long recid) {
        LOG.log(Level.INFO, "BUSCANDO AL ROL CON ID: {0}", recid);
        return sysRoleMapper.findById(recid);
    }
    
    /**
     * Método que obtiene un rol por su codigo.
     * 
     * @param codigo el nombre de rol a buscar
     * @return el objeto SysRole
     */
    @Override
    public SysRole findByCodigo(String codigo) {
        LOG.log(Level.INFO, "BUSCANDO AL ROL CON CODIGO: {0}", codigo);
        return sysRoleMapper.findByCodigo(codigo);
    }

    /**
     * Método que da de alta un objeto SysRole
     * @param rol Objeto a dar de alta
     * @return objeto insertado
     */
    @Override
    public SysRole createRole(SysRole rol) throws Exception {
        LOG.log(Level.INFO,"INSERTANDO UN ROL NUEVO");
        SysRole exists = findByCodigo(rol.getCodigo());
        if(exists == null){
            sysRoleMapper.insert(rol);
            return findByCodigo(rol.getCodigo());
        }else{
            LOG.log(Level.SEVERE, "EL ROL YA EXISTE");
            throw new Exception("rol ya existe en el sistema");
        }
    }

    /**
     * Método que permite actualizar un objeto SysRole
     * @param rol objeto a actualizar
     * @return Objeto actualizado
     */
    @Override
    public SysRole updateRole(SysRole rol) throws Exception{
        LOG.log(Level.INFO,"EDITANDO AL ROL {0}",rol.getRecid());
        SysRole exists = findById(rol.getRecid());
        if(exists == null){
        LOG.log(Level.SEVERE, "EL ROL NO EXISTE");
            throw new Exception("rol no encontrado");
        }
        sysRoleMapper.update(rol);
        return rol;
    }

    /**
     * Método que permite eliminar un objeto SysRole
     * @param rol el id del objeto SysRole a eliminar
     * @return si la operación se realizó con éxito.
     */
    @Override
    public Boolean deleteRole(Long rol) throws Exception{
        LOG.log(Level.INFO,"ELIMINANDO AL ROL {0}",rol);
        SysRole exists = findById(rol);
        if(exists == null){
        LOG.log(Level.SEVERE, "EL ROL NO EXISTE");
            throw new Exception("rol no encontrado");
        }
        sysRoleMapper.delete(rol);
        return true;
    }    
}
