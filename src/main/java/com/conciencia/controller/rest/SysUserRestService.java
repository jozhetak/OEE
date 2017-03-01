package com.conciencia.controller.rest;


import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.pojo.SysUser;
import com.conciencia.service.SysUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de las interacciones REST para el manejo de la tabla Usuarios.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 26/11/2016
 */
@RestController
@RequestMapping(value = "/rest/sysUser")
public class SysUserRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(SysUserRestService.class.getName());

    @Resource
    private SysUserService service;
    
    /**
     * Método que genera la lista de objetos SysUser existentes
     * @return lista de procesos
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataTableJsonResponse<SysUser> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los usuarios del sistema");
        List<SysUser> users = service.findAll();
        DataTableJsonResponse<SysUser> response = new DataTableJsonResponse<>();
        response.setData(users);
        
        return response;
    }
    
    /**
     * Servicio rest que permite crear objetos SysUser en la base de datos
     * @param user
     * @return Status del insert.
     */
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody SysUser user) {
        LOG.log(Level.INFO,"Creando el objeto {0}",user);
        Map<String,Object> response = new HashMap<>();
        try{
            SysUser created = service.createUser(user);
            if(created != null){
                response.put("created_value",user);
                return new ResponseEntity<>(response,HttpStatus.CREATED);
            }
            else
                throw new Exception();
        }catch(Exception e){
            String message = e.getMessage();
            response.put("error",message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }    
    }
    
    /**
     * Servicio rest que permite crear objetos SysUser en la base de datos
     * @param user
     * @return Status del insert.
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity update(@RequestBody SysUser user) {
        
        LOG.log(Level.INFO,"Actualizando el objeto {0}",user);
        Map<String,Object> response = new HashMap<>();
        
        try{
            SysUser updated = service.updateUser(user);
            response.put("updated_value",updated);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            String message = e.getMessage();
            response.put("error",message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Servicio rest que permite crear objetos SysUSer en la base de datos
     * @param user
     * @return Status del delete.
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity delete(@RequestBody SysUser user) {
        
        LOG.log(Level.INFO,"Eliminando el objeto {0}",user);
        Map<String,Object> response = new HashMap<>();
        try{
            Boolean deleted = service.deleteUser(user.getRecid());
            if(deleted){
                response.put("deleted_value",user);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }else{
                throw new Exception("An error ocurred");
            }
        }catch(Exception e){
            String message = e.getMessage();
            response.put("error",message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Manejador de excepciones generadas por argumentos no válidos.
     * @param ex  Excepción lanzada al momento del error.
     * @return    Texto con el detalle del error. 
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
//        LOG. error(ex.getMessage(), ex);
        return ex.getMessage();
    }
}