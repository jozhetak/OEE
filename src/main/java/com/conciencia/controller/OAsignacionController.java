package com.conciencia.controller;

import com.conciencia.eCSV.Reader.CSVReader;
import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.pojo.OReporteOperador;
import com.conciencia.pojo.SysUser;
import com.conciencia.service.OAsignacionDiaService;
import com.conciencia.service.OReporteOperadorService;
import com.conciencia.service.SysUserService;
import com.conciencia.service.csv.OAsignacionesCsvReaderImpl;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
public class OAsignacionController {
    
    @Resource
    OAsignacionDiaService asignacionesService;
    
    @Resource
    OReporteOperadorService reporteService;
        
//    @Autowired
//    private SimpMessagingTemplate template;
    
    @Resource
    SysUserService sysUserService;
    
    @RequestMapping(value={"/oAsignacionDiaCSVLoad"},method = RequestMethod.GET)
    public String loadCSV(ModelMap model,HttpServletRequest request) {
        CSVReader<OAsignacionDia> reader = new OAsignacionesCsvReaderImpl((String)model.get("csvFile"),true);
        reader.readFile();
        List<OAsignacionDia> asignaciones = reader.getListOfObjects();
        List<String> loadLog = asignacionesService.insertAsignacionesIntoDataBase(asignaciones);
        model.addAttribute("loadLog", loadLog);
         String userName = 
                SecurityContextHolder.getContext().
                        getAuthentication().getName();
        
        SysUser user = sysUserService.findByUserName(userName);
        model.addAttribute("user", user);
        model.addAttribute("role",user.getRolName());
        
        //post message to client on notification list
        //this.template.convertAndSend("/notify/oAsignacionLoaded", new LoadCSVMessage("Loaded"));
        return "asignaciones";
    }

    @RequestMapping(value={"OAsignacion/reporte/{asignacion}"},method = RequestMethod.GET)
    public String reportar(@PathVariable("asignacion")Long asignacion,ModelMap model,HttpServletRequest request) {
        String userName = 
                SecurityContextHolder.getContext().
                        getAuthentication().getName();
        
        SysUser user = sysUserService.findByUserName(userName);
        model.addAttribute("user", user);
        model.addAttribute("role",user.getRolName());
        
        OAsignacionDia asignacionOperador = asignacionesService.findOne(asignacion);
        model.addAttribute("asignacion", asignacionOperador);
        
        OReporteOperador reporte = reporteService.findByAsignacion(asignacion);
        model.addAttribute("reporte",reporte);
        
        return "reporte";
    }
}
