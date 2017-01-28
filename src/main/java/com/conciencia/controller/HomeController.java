package com.conciencia.controller;

import javax.servlet.http.HttpServletRequest;
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
    
    
    @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
    public String index(ModelMap model,HttpServletRequest request) {
        //<editor-fold>
        //String message = utilMessageLocale.getMessageLocale("screen.welcome.message");
        //model.put("greeting");
//        String role = 
//                ((List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().
//                        getAuthentication().getAuthorities()).get(0).getAuthority();
//        model.addAttribute("role", role);
//        if(role.equals("SA")){
//            model.addAttribute("role", role);
//            return "main";
//        }
//        
//        if(role.equals("ADMIN")){
//            return "main";
//        }
//        
//        if(role.equals("OPER")){
//            return "main";
//        }
//        
//        if(role.equals("CAL")){
//            return "main";
//        }
        //</editor-fold>
        return "main";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de usuarios.
     * @param model
     * @param request
     * @return la pantalla de usuarios
     */
    @RequestMapping(value={"/users"},method = RequestMethod.GET)
    public String users(ModelMap model,HttpServletRequest request) {
        return "users";
    }
    
    /**
     * Controlador que responde a la solicitud de la pantalla de roles.
     * @param model
     * @param request
     * @return la pantalla de roles.
     */
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
    @RequestMapping(value={"/crates"},method = RequestMethod.GET)
    public String ratesProduccion(ModelMap model,HttpServletRequest request) {
        return "rates_produccion";
    }
}
