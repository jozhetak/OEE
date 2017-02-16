package com.conciencia.service.impl;

import com.conciencia.mapper.SysUserMapper;
import com.conciencia.pojo.SysUser;
import com.conciencia.service.SysUserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Implementacion de SysUserService
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    private static final Logger LOG = Logger.getLogger(SysUserServiceImpl.class.getName());
    
    /* RECURSO QUE PERMITE LA INTERACCIÓN CON BASE DE DATOS PARA LA TABLA DE USUARIOS */
    @Resource
    SysUserMapper sysUserMapper;

    public SysUserServiceImpl() {
        LOG.setLevel(Level.ALL);
    }
    
    /**
     * Método que regresa una lista de usuarios. Utilizado por el grid de usuarios
     * 
     * @return una lista de usuarios.
     */
    @Override
    public List<SysUser> findAll(){
        LOG.info("OBTENIENDO TODOS LOS USUARIOS DISPONIBLES");
        return sysUserMapper.findAll();
    }

    /**
     * Método que obtiene un usuario por su id.
     * 
     * @param recid el id de usuario a buscar
     * @return el objeto SysUser
     */
    @Override
    public SysUser findById(Long recid) {
        LOG.log(Level.INFO, "BUSCANDO AL USUARIO CON ID: {0}", recid);
        return sysUserMapper.findById(recid);
    }
    
    /**
     * Método que obtiene un usuario por su userName.
     * 
     * @param userName el nombre de usuario a buscar
     * @return el objeto SysUser
     */
    @Override
    public SysUser findByUserName(String userName) {
        LOG.log(Level.INFO, "BUSCANDO AL USUARIO CON USERNAME: {0}", userName);
        return sysUserMapper.findByUserName(userName);
    }
    
    /**
     * Método que permite ubicar un usuario a partir de su código.
     * 
     * Utilizado por:
     * 
     * OAsignacionServiceImpl -> Permite obtener el usuario en la carga del archivo
     * de asignaciones.
     * 
     * @param code el código del usuario
     * @return el id de usuario
     */
    @Override
    public Long findByCode(String code) {
        Long user = sysUserMapper.findByCode(code);
        return user;
    }

    /**
     * Método que da de alta un objeto SysUser
     * @param user Objeto a dar de alta
     * @return objeto insertado
     */
    @Override
    public SysUser createUser(SysUser user) throws Exception {
        LOG.log(Level.INFO,"INSERTANDO UN USUARIO NUEVO");
        SysUser exists = findByUserName(user.getUserName());
        if(exists == null){
            sysUserMapper.insert(user);
            return findByUserName(user.getUserName());
        }else{
            LOG.log(Level.SEVERE, "EL USUARIO YA EXISTE");
            throw new Exception("usuario ya existe en el sistema");
        }
    }

    /**
     * Método que permite actualizar un objeto SysUser
     * @param user objeto a actualizar
     * @return Objeto actualizado
     */
    @Override
    public SysUser updateUser(SysUser user) throws Exception{
        LOG.log(Level.INFO,"EDITANDO AL USUARIO {0}",user.getRecid());
        SysUser exists = findById(user.getRecid());
        if(exists == null){
        LOG.log(Level.SEVERE, "EL USUARIO NO EXISTE");
            throw new Exception("usuario no encontrado");
        }
        sysUserMapper.update(user);
        return user;
    }

    /**
     * Método que permite eliminar un objeto SysUser
     * @param user el id del objeto SysUser a eliminar
     * @return si la operación se realizó con éxito.
     */
    @Override
    public Boolean deleteUser(Long user) throws Exception{
        LOG.log(Level.INFO,"ELIMINANDO AL USUARIO {0}",user);
        SysUser exists = findById(user);
        if(exists == null){
        LOG.log(Level.SEVERE, "EL USUARIO NO EXISTE");
            throw new Exception("usuario no encontrado");
        }
        sysUserMapper.delete(user);
        return true;
    }    
}
