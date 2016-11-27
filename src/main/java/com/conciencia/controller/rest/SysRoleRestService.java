package com.conciencia.controller.rest;


import com.conciencia.pojo.SysRole;
import com.conciencia.service.SysRoleService;
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
 * Controlador de las interacciones REST para el manejo de la tabla Roles.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 26/11/2016
 */
@RestController
@RequestMapping(value = "/rest/sysRole")
public class SysRoleRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(SysRoleRestService.class.getName());

    @Resource
    private SysRoleService service;
    
    /**
     * Método que genera la lista de Procesos Raci existentes
     * @return lista de procesos
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SysRole> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los roles del sistema");
        return service.findAll();
    }
    
    /**
     * Servicio rest que permite crear objetos SysRole en la base de datos
     * @param role
     * @return Status del insert.
     */
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody SysRole role) {
        LOG.log(Level.INFO,"Creando el objeto {0}",role);
        Map<String,Object> response = new HashMap<>();
        try{
            SysRole created = service.createRole(role);
            if(created != null){
                response.put("created_value",role);
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
     * Servicio rest que permite crear objetos SysRole en la base de datos
     * @param role
     * @return Status del insert.
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity update(@RequestBody SysRole role) {
        
        LOG.log(Level.INFO,"Actualizando el objeto {0}",role);
        Map<String,Object> response = new HashMap<>();
        
        try{
            SysRole updated = service.updateRole(role);
            response.put("updated_value",updated);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            String message = e.getMessage();
            response.put("error",message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Servicio rest que permite crear objetos SysRole en la base de datos
     * @param role
     * @return Status del delete.
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity delete(@RequestBody SysRole role) {
        
        LOG.log(Level.INFO,"Eliminando el objeto {0}",role);
        Map<String,Object> response = new HashMap<>();
        try{
            Boolean deleted = service.deleteRole(role.getRecid());
            if(deleted){
                response.put("deleted_value",role);
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