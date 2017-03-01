package com.conciencia.controller.rest;


import com.conciencia.pojo.DataTableJsonResponse;
import com.conciencia.pojo.SysRole;
import com.conciencia.service.SysRoleService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador de las interacciones REST para el manejo de la tabla Roles.
 * 
 * @author Ernesto Cantu
 * Conciencia
 * 26/11/2016
 */
@RestController
@RequestMapping(value = "/rest/sysRole")
public class SysRoleRestService {

    /* Variable que apunta a la bitácora de la clase */
    private static final Logger LOG = Logger.getLogger(SysRoleRestService.class.getName());

    @Resource
    private SysRoleService service;
    
    /**
     * Método que genera la lista de objetos SysRole existentes
     * @return lista de procesos
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DataTableJsonResponse<SysRole> getAll() {
        LOG.log(Level.INFO,"Obteniendo Todos los roles del sistema");
        List<SysRole> roles = service.findAll();
        DataTableJsonResponse<SysRole> response = new DataTableJsonResponse<>();
        response.setData(roles);
        
        return response;
    }
    
}