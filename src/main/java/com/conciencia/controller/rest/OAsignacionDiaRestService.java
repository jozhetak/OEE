package com.conciencia.controller.rest;


import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.service.OAsignacionDiaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de las interacciones REST para el manejo de la tabla Asignaciones por día.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 28/01/2017
 */
@RestController
@RequestMapping(value = "/rest/oAsignacion")
public class OAsignacionDiaRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(OAsignacionDiaRestService.class.getName());

    @Resource
    private OAsignacionDiaService service;
    
    /**
     * Método que regresa todas las asignaciones para una maquinas dada
     * @return lista de asignaciones por maquinas
     */
    @RequestMapping(value="/{maquina}",method = RequestMethod.GET)
    @ResponseBody
    public List<OAsignacionDia> getAll(@PathVariable("maquina")Long maquina) {
        LOG.log(Level.INFO,"Obteniendo Todos las maquinas del sistema");
        return service.findAll(maquina);
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