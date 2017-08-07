package com.conciencia.controller;

import com.conciencia.pojo.SysUploadItem;
import com.conciencia.service.csv.FileValidatorService;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.Resource;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * La Clase Y03UploadController.Controlador que recibe las peticiones de los
 * grids para cargar archivos CSV y redirecciona a la implementación correspondiente
 * de carga en los controladores.
 */
@Controller
@RequestMapping(value = "/uploadFile")
public class SysUploadController {

    /**
     * Variable que apunta a la bitácora de la clase.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(SysUploadController.class);

    /**
     * Constante que hace referencia a la ruta de para carga de archivos CSV.
     */
    public static final String PROCESS_CSV_PATH = "/oAsignacionDiaCSVLoad";

    /**
     * Constante que hace referencia a la ruta de vista base para Z02Escenarios.
     */
    private static final String UPLOAD_SAVE_DIRECTORY = "/home/ernesto/Conciencia/files/";    
    
    /**
     * Constante con el valor del prefijo de redireccionamiento de vistas.
     */
    private static final String VIEW_REDIRECT_PREFIX = "redirect:";
    
    /**
     * Constante que hace referencia al nombre del atributo que guarda el nombre del
     * archivos CSV cargado.
     */
    protected static final String MODEL_ATTRIBUTE_CSVFILE = "csvFile";
    
    /**
     * Recurso que se encarga del la validación de los archivos cargados.
     */
    @Resource
    FileValidatorService fileValidator;


    /**
     * Pantalla de prueba de la carga Asíncrona de Archivos.
     *
     * @return La ruta a la vista para Carga Asíncrona de Archivos.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUploadAsync() {
        return "uploadAsync";
    }
    
    /**
     * Crea una ruta para redireccionar la vista para una acción específica del
     * controlador.
     *
     * @param path La ruta precedida del método del controlador.
     * @return Una ruta de la vista para una método dado del controlador.
     */
    protected String createRedirectViewPath(String path) {
        StringBuilder builder = new StringBuilder();
        builder.append(VIEW_REDIRECT_PREFIX);
        builder.append(path);
        return builder.toString();
    }

    /**
     * Procesa las peticiones de pruebas de carga asíncrona de archivos.
     *
     * @param uploadItem Objeto UploadItm que contiene el archivo CSV que se va a cargar,
     * así como la información del escenario y ruta que lo procesará.
     * @param attributes Atributos de mensajes y errores que se intercambio entre la vista
     * y el controlador.
     * @return La ruta a la vista principal de la aplicación.
     */
    @RequestMapping(method = RequestMethod.POST)
    public Callable<String> uploadFile(final SysUploadItem uploadItem,
            final RedirectAttributes attributes) {
        
        
        return () -> {
            CommonsMultipartFile originalFile = uploadItem.getFileData(); //el archivo cargado
            String ruta = uploadItem.getRuta(); //tabla destino
            LOGGER.debug("Ruta del archivo : {}", ruta);
            Validate.isTrue(ruta != null, "No fue posible encontrar la Ruta");
            
            if (!originalFile.isEmpty()) {
                String originalFileName = originalFile.getOriginalFilename(); //nombre original del archivo
                String uuid = UUID.randomUUID().toString().concat("_"); //Prefijo random para renombrar el archivo
                File newFile = new File(UPLOAD_SAVE_DIRECTORY + uuid + originalFileName);
                if (newFile.exists()) {
                    LOGGER.debug("Se re-escribira el archivo: " + newFile);
                }
                if (!originalFileName.equals("")) {
                    originalFile.transferTo(newFile);
                    LOGGER.debug("Se cargó el archivo: " + originalFileName + " como " + newFile);
                    attributes.addFlashAttribute(MODEL_ATTRIBUTE_CSVFILE, newFile.getPath());
                    
                    String nuevaRuta = ruta; //Redireccion.
                    return createRedirectViewPath(nuevaRuta);
                }
            }
            return createRedirectViewPath("/");
        };
    }
}
