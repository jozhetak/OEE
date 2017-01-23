package com.conciencia.controller.rest;


import com.conciencia.pojo.CRateProduccion;
import com.conciencia.service.CRateProduccionService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de las interacciones REST para el manejo de la tabla Rates Produccion.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/cRateProduccion")
public class CRateProduccionRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CRateProduccionRestService.class.getName());

    @Resource
    private CRateProduccionService service;
    
    /**
     * Método que regresa todos los rates existentes
     * @return lista de rates
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CRateProduccion> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los usuarios del sistema");
        return service.findAll();
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