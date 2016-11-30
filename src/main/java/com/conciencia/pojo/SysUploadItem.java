package com.conciencia.pojo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * La Clase SysUploadItem.
 * @author RPacheco. 
 * ricardo.pacheco@aleph5.com
 * 
 * *************************************
 * 
 * Modified: Ernesto Cantú @ Conciencia
 * Notas: Elimino campo idEscenario
 * Conciencia
 * 30/11/2016
 */
public class SysUploadItem {

    /**
     * Nombre de la ruta o tipo de grid que se desea procesar.
     */
    private String ruta;

    /**
     * Archivo de datos.
     */
    private CommonsMultipartFile fileData;

    /**
     * Método de Acceso del atributo ruta.
     *
     * @return El atributo ruta.
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Método modificador del atributo ruta.
     *
     * @param ruta Valor que se desea asignar al atributo ruta.
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Método de Acceso del atributo fileData.
     *
     * @return El atributo fileData.
     */
    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    /**
     * Método modificador del atributo fileData.
     *
     * @param fileData Valor que se desea asignar al atributo fileData.
     */
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
}
