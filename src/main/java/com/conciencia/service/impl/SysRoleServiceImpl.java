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

}
