package com.conciencia.controller.rest;


import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.pojo.RCalculoOEE;
import com.conciencia.pojo.SysFechasReporte;
import com.conciencia.service.RCalculoOEEService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de las interacciones REST para el manejo de la tabla Calculos de OEE.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 13/03/2017
 */
@RestController
@RequestMapping(value = "/rest/rCalculoOEE")
public class RCalculoOEERestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(RCalculoOEERestService.class.getName());

    @Resource
    private RCalculoOEEService service;
    
    /**
     * Método que regresa todas las maquinas existentes
     * @return lista de maquinas
     */
    @RequestMapping(value="/maquinas",method = RequestMethod.POST)
    @ResponseBody
    public DataTableJsonResponse<RCalculoOEE> getAll(@RequestBody SysFechasReporte fechasReporte) {
        LOG.log(Level.INFO,"Obteniendo Todos las maquinas del sistema");
        List<RCalculoOEE> calculosOEEMaquinas = service.findOeeMaquinas(fechasReporte);
        DataTableJsonResponse<RCalculoOEE> response = new DataTableJsonResponse<>();
        response.setData(calculosOEEMaquinas);
        
        return response;
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