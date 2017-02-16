package com.conciencia.controller;

import static com.conciencia.controller.SysUploadController.PROCESS_CSV_PATH;
import com.conciencia.eCSV.Reader.CSVReader;
import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.service.SysUserService;
import com.conciencia.service.csv.OAsignacionesCsvReaderImpl;
import java.util.List;
import javax.annotation.Resource;
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
public class OAsignacionController {
    
    @Resource
    SysUserService sysUserService;
        
    
    @RequestMapping(value={"/oAsignacionDiaCSVLoad"},method = RequestMethod.GET)
    public String loadCSV(ModelMap model,HttpServletRequest request) {
        CSVReader<OAsignacionDia> reader = new OAsignacionesCsvReaderImpl((String)model.get(PROCESS_CSV_PATH));
        reader.readFile();
        List<OAsignacionDia> asignaciones = reader.getListOfObjects();
        return "main";
    }
    
    
}
