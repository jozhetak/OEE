package com.conciencia.controller.rest;


import com.conciencia.pojo.CUnidadProductiva;
import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.service.CUnidadProductivaService;
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
 * Controlador de las interacciones REST para el manejo de la tabla Unidad Productivas.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/cUnidadProductiva")
public class CUnidadProductivaRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CUnidadProductivaRestService.class.getName());

    @Resource
    private CUnidadProductivaService service;
    
    /**
     * Método que regresa todas las unidades productivas existentes
     * @return lista de unidades productivas
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataTableJsonResponse<CUnidadProductiva> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos las unidades productivas del sistema");
        List<CUnidadProductiva> unidadesProductivas = service.findAll();
        DataTableJsonResponse<CUnidadProductiva> response = new DataTableJsonResponse<>();
        response.setData(unidadesProductivas);
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