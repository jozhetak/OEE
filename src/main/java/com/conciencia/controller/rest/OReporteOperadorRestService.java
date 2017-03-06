package com.conciencia.controller.rest;


import com.conciencia.pojo.OReporteOperador;
import com.conciencia.service.OReporteOperadorService;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/rest/oReporte")
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
     * Servicio rest que permite crear objetos SysUser en la base de datos
     * @param user
     * @return Status del insert.
     */
    @RequestMapping(value="/reporte",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity reportar(@RequestBody OReporteOperador reporte) {
        LOG.log(Level.INFO,"Creando el objeto {0}",reporte);
        Map<String,Object> response = new HashMap<>();
        if(reporte.getRecid() != null){
            JOptionPane.showMessageDialog(null,"Update");
        }else{
            JOptionPane.showMessageDialog(null,"Create");
        }
//        try{
//            
//            if(created != null){
//                response.put("created_value",user);
//                return new ResponseEntity<>(response,HttpStatus.CREATED);
//            }
//            else
//                throw new Exception();
//        }catch(Exception e){
//            String message = e.getMessage();
//            response.put("error",message);
//            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//        }    
        return new ResponseEntity<>(response,HttpStatus.CREATED);
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