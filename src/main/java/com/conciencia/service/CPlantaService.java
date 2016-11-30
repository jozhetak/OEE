package com.conciencia.service;

import com.conciencia.pojo.CPlanta;
import java.util.List;

/**
 * Interface que define las operaciones a realizar con plantas.
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 29/11/2016
 */
public interface CPlantaService {
    
    /**
     * Método que regresa una lista de plantas. Utilizado por el grid de plantas
     * 
     * @return una lista de plantas.
     */
    public List<CPlanta> findAll();
    
    /**
     * Método que obtiene una planta por su id.
     * 
     * @param id el id de planta a buscar
     * @return el objeto CPlanta
     */
    public CPlanta findById(Long recid);
    
    /**
     * Método que obtiene una planta por su codigo.
     * 
     * @param codigo el nombre de CPlanta a buscar
     * @return el objeto CPlanta
     */
    public CPlanta findByCodigo(String codigo);
    
    /**
     * Método que da de alta un objeto CPlanta
     * @param planta Objeto a dar de alta
     * @return objeto insertado
     */
    public CPlanta createPlanta(CPlanta planta) throws Exception;
    
    /**
     * Método que permite actualizar un objeto CPlanta
     * @param planta objeto a actualizar
     * @return Objeto actualizado
     */
    public CPlanta updatePlanta(CPlanta planta) throws Exception;
    
    /**
     * Método que permite eliminar un objeto CPlanta
     * @param planta el id del objeto CPlanta a eliminar
     * @return si la operación se realizó con éxito.
     */
    public Boolean deletePlanta(Long planta) throws Exception;
    
}
