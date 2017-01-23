package com.conciencia.controller.rest;


import com.conciencia.pojo.CTurno;
import com.conciencia.service.CTurnoService;
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
 * Controlador de las interacciones REST para el manejo de la tabla Turnos.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/cTurno")
public class CTurnoRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CTurnoRestService.class.getName());

    @Resource
    private CTurnoService service;
    
    /**
     * Método que regresa todos los turnos existentes
     * @return lista de turnos
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CTurno> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los turnos del sistema");
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