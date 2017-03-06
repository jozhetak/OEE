package com.conciencia.controller.rest;


import com.conciencia.pojo.OReporteOperador;
import com.conciencia.service.OReporteOperadorService;
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
 * Controlador de las Prueba
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/oreporte")
public class OReporteOperadorRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(OReporteOperadorRestService.class.getName());

    @Resource
    private OReporteOperadorService service;
    
    /**
     * Método que regresa todas las maquinas existentes
     * @return lista de maquinas
     */
    @RequestMapping(value="/{reporte}",method = RequestMethod.GET)
    @ResponseBody
    public OReporteOperador getAll(@PathVariable("reporte")Long reporte) {
        LOG.log(Level.INFO,"Obteniendo el reporte del sistema");
        return service.findByAsignacion(reporte);
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