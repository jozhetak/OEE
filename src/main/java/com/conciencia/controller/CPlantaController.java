package com.conciencia.controller;

import static com.conciencia.controller.SysUploadController.MODEL_ATTRIBUTE_CSVFILE;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controlador de Plantas
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 30/11/2016
 */
@Controller
@RequestMapping(value={"/plantas"})
public class CPlantaController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String plantas(ModelMap model,HttpServletRequest request) {
        return "plantas";
    }
    
    
    @RequestMapping(value = "/procesaCSV", method = RequestMethod.GET)
    @ResponseBody
    public String uploadCSV(
            @ModelAttribute(MODEL_ATTRIBUTE_CSVFILE) String newFilePath) {
        
        return "cargado";
    }
    
}
