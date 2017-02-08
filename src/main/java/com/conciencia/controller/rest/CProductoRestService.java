package com.conciencia.controller.rest;


import com.conciencia.pojo.CProducto;
import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.service.CProductoService;
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
 * Controlador de las interacciones REST para el manejo de la tabla Productos.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 22/01/2017
 */
@RestController
@RequestMapping(value = "/rest/cProducto")
public class CProductoRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(CProductoRestService.class.getName());

    @Resource
    private CProductoService service;
    
    /**
     * Método que regresa todos los productos existentes
     * @return lista de productos
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataTableJsonResponse<CProducto> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los productos del sistema");
        List<CProducto> productos = service.findAll();
        DataTableJsonResponse<CProducto> response = new DataTableJsonResponse<>();
        response.setData(productos);
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