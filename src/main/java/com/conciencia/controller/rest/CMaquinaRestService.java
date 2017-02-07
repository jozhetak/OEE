package com.conciencia.controller.rest;


import com.conciencia.pojo.CMaquina;
import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.service.CMaquinaService;
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
 * Controlador de las interacciones REST para el manejo de la tabla Maquinas.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/cMaquina")
public class CMaquinaRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CMaquinaRestService.class.getName());

    @Resource
    private CMaquinaService service;
    
    /**
     * Método que regresa todas las maquinas existentes
     * @return lista de maquinas
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataTableJsonResponse<CMaquina> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos las maquinas del sistema");
        List<CMaquina> maquinas = service.findAll();
        DataTableJsonResponse<CMaquina> response = new DataTableJsonResponse<>();
        response.setData(maquinas);
        
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