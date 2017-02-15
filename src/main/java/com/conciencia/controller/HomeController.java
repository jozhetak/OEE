package com.conciencia.controller;

import com.conciencia.pojo.SysUser;
import com.conciencia.service.SysUserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador principal de la Aplicación.
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
@Controller
public class HomeController {
    
    @Resource
    SysUserService sysUserService;
        
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN') or hasAuthority('OPER')")
    @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
    public String index(ModelMap model,HttpServletRequest request) {
        String userName = 
                SecurityContextHolder.getContext().
                        getAuthentication().getName();
        
        SysUser user = sysUserService.findByUserName(userName);
        
        model.addAttribute("user", user);
        
        
        return "main";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de usuarios.
     * @param model
     * @param request
     * @return la pantalla de usuarios
     */
    @PreAuthorize("hasAuthority('SA')")
    @RequestMapping(value={"/users"},method = RequestMethod.GET)
    public String users(ModelMap model,HttpServletRequest request) {
        return "users";
    }
    
    
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/oasignacionesLoad"},method = RequestMethod.POST)
    public String loadFile(ModelMap model,HttpServletRequest request) {
        return "users";
    }
    
    
    /**
     * Controlador que responde a la solicitud de la pantalla de roles.
     * @param model
     * @param request
     * @return la pantalla de roles.
     */
    @PreAuthorize("hasAuthority('SA')")
    @RequestMapping(value={"/roles"},method = RequestMethod.GET)
    public String roles(ModelMap model,HttpServletRequest request) {
        return "roles";
    }

    /**
     * Controlador que responde a la solicitud de la pantalla de máquinas.
     * @param model
     * @param request
     * @return la pantalla de máquinas.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/cmaquinas"},method = RequestMethod.GET)
    public String maquinas(ModelMap model,HttpServletRequest request) {
        return "maquinas";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de turnos.
     * @param model
     * @param request
     * @return la pantalla de turnos.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/cturnos"},method = RequestMethod.GET)
    public String turnos(ModelMap model,HttpServletRequest request) {
        return "turnos";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de turnos.
     * @param model
     * @param request
     * @return la pantalla de turnos.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/cparosProgramados"},method = RequestMethod.GET)
    public String paros(ModelMap model,HttpServletRequest request) {
        return "paros_programados";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de productos.
     * @param model
     * @param request
     * @return la pantalla de productos.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/cproductos"},method = RequestMethod.GET)
    public String productos(ModelMap model,HttpServletRequest request) {
        return "productos";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de unidades productivas.
     * @param model
     * @param request
     * @return la pantalla de unidades productivas.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/cunidades"},method = RequestMethod.GET)
    public String unidades(ModelMap model,HttpServletRequest request) {
        return "unidades_productivas";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de rates de produccion.
     * @param model
     * @param request
     * @return la pantalla de unidades productivas.
     */
    @PreAuthorize("hasAuthority('SA') or hasAuthority('ADMIN')")
    @RequestMapping(value={"/crates"},method = RequestMethod.GET)
    public String ratesProduccion(ModelMap model,HttpServletRequest request) {
        return "rates_produccion";
    }
}
