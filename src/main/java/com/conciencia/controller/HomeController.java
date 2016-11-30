package com.conciencia.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    
    
    @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
    public String index(ModelMap model,HttpServletRequest request) {
        //String message = utilMessageLocale.getMessageLocale("screen.welcome.message");
        //model.put("greeting");
        String role = 
                ((List<SimpleGrantedAuthority>) SecurityContextHolder.getContext().
                        getAuthentication().getAuthorities()).get(0).getAuthority();
        model.addAttribute("role", role);
        if(role.equals("SA")){
            model.addAttribute("role", role);
            return "main";
        }
        
        if(role.equals("ADMIN")){
            return "main";
        }
        
        if(role.equals("OPER")){
            return "main";
        }
        
        if(role.equals("CAL")){
            return "main";
        }
        return "main";
    }
    
    @RequestMapping(value={"/users"},method = RequestMethod.GET)
    public String users(ModelMap model,HttpServletRequest request) {
        return "users";
    }
    
    @RequestMapping(value={"/roles"},method = RequestMethod.GET)
    public String roles(ModelMap model,HttpServletRequest request) {
        return "roles";
    }

}
