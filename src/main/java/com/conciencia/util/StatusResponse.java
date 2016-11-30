package com.conciencia.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * Un POJO que contiene los estatus de una acción y una {@link Lista} de
 * mensajes. Se utiliza principalmente como un DTO para la capa de presentación
 */
public class StatusResponse {

    /** El atributo success. */
    private Boolean success;
    
    /** El atributo message. */
    private final List<String> message;

    /**
     * Genera una nueva instancia de la clase StatusResponse.
     */
    public StatusResponse() {
        this.message = new ArrayList<>();
    }

    /**
     * Genera una nueva instancia de la clase StatusResponse.
     *
     * @param success el parámetro success
     */
    public StatusResponse(Boolean success) {
        this.success = success;
        this.message = new ArrayList<>();
    }

    /**
     * Genera una nueva instancia de la clase StatusResponse.
     *
     * @param success el parámetro success
     * @param message el parámetro message
     */
    public StatusResponse(Boolean success, String message) {
        this.success = success;
        this.message = new ArrayList<>();
        this.message.add(message);
    }

    /**
     * Genera una nueva instancia de la clase StatusResponse.
     *
     * @param success el parámetro success
     * @param message el parámetro message
     */
    public StatusResponse(Boolean success, List<String> message) {
        this.success = success;
        this.message = message;
    }

    /**
     * Método de Acceso del atributo success.
     *
     * @return El atributo success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Método modificador del atributo success.
     *
     * @param success Valor que se desea asignar al atributo success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Método de Acceso del atributo message.
     *
     * @return El atributo message
     */
    public List<String> getMessage() {
        return message;
    }

    /**
     * Método modificador del atributo message.
     *
     * @param message Valor que se desea asignar al atributo message
     */
    public void setMessage(String message) {
        this.message.add(message);
    }

    /**
     * Método genérico para la conversión de objetos a String.
     *
     * @return Representación del Objeto en formato String
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
