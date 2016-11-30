package com.conciencia.service.csv;


import com.conciencia.pojo.SysUploadItem;
import com.conciencia.util.StatusResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 * La Clase FileValidatorService.
 */
@Service
public class FileValidatorService {
    
    
    /**
     * Constante que hace referencia al mensaje localizado que indica que no se
     * proporcionó el archivo que se desea cargar.
     */

    protected static final String ERROR_MESSAGE_FILE_NOT_FOUND 
            = "upload.error.noFile";

    /**
     * Constante que hace referencia al mensaje localizado que indica que no se
     * proporcionó el nombre del archivo que se desea cargar.
     */

    protected static final String ERROR_MESSAGE_FILE_NAME_NOT_FOUND 
            = "upload.error.noName";

    /**
     * Constante que hace referencia al objeto que representa el archivo 
     * a validar.
     */
    protected static final String MODEL_ATTRIBUTE_FILE = "fileData";

    /**
     * Constante que hace referencia al objeto que representa el archivo 
     * a validar.
     */
    protected static final String MODEL_ATTRIBUTE_FILE_NAME = "name";


    /**
     * Validate.
     *
     * @param uploadedFile el parámetro uploaded file
     * @return el valor status response
     */
    public StatusResponse validate(Object uploadedFile) {
        SysUploadItem file = (SysUploadItem) uploadedFile;
        
        List<String> messages = new ArrayList<>();
        
        // Checo tamaño
        if (file.getFileData().getSize() == 0) {
            messages.add(ERROR_MESSAGE_FILE_NAME_NOT_FOUND);
        }
        
        // otras validaciones ....
        
        //Resultado:
        Boolean result = messages.isEmpty();
        
        if (result) {
            return new StatusResponse(result);
        } else {
            return new StatusResponse(result, messages);
        }
    }
}