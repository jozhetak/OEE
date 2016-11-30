package com.conciencia.controller.rest;


import com.conciencia.pojo.CPlanta;
import com.conciencia.service.CPlantaService;
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
 * Controlador de las interacciones REST para el manejo de la tabla CPlantas.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 29/11/2016
 */
@RestController
@RequestMapping(value = "/rest/cPlanta")
public class CPlantaRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CPlantaRestService.class.getName());

    @Resource
    private CPlantaService service;
    
    /**
     * Método que genera la lista de plantas existentes
     * @return lista de plantas
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CPlanta> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los roles del sistema");
        return service.findAll();
    }
    
    /**
     * Servicio rest que permite crear objetos CPlanta en la base de datos
     * @param planta
     * @return Status del insert.
     */
    @RequestMapping(value="/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody CPlanta planta) {
        LOG.log(Level.INFO,"Creando el objeto {0}",planta);
        Map<String,Object> response = new HashMap<>();
        try{
            CPlanta created = service.createPlanta(planta);
            if(created != null){
                response.put("created_value",planta);
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
     * Servicio rest que permite crear objetos CPlanta en la base de datos
     * @param planta
     * @return Status del insert.
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity update(@RequestBody CPlanta planta) {
        
        LOG.log(Level.INFO,"Actualizando el objeto {0}",planta);
        Map<String,Object> response = new HashMap<>();
        
        try{
            CPlanta updated = service.updatePlanta(planta);
            response.put("updated_value",updated);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e){
            String message = e.getMessage();
            response.put("error",message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
     * Servicio rest que permite crear objetos CPlanta en la base de datos
     * @param planta
     * @return Status del delete.
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity delete(@RequestBody CPlanta planta) {
        
        LOG.log(Level.INFO,"Eliminando el objeto {0}",planta);
        Map<String,Object> response = new HashMap<>();
        try{
            Boolean deleted = service.deletePlanta(planta.getRecid());
            if(deleted){
                response.put("deleted_value",planta);
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