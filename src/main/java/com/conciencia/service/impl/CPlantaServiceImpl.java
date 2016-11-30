package com.conciencia.service.impl;

import com.conciencia.mapper.CPlantaMapper;
import com.conciencia.pojo.CPlanta;
import com.conciencia.service.CPlantaService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Implementacion de CPlantaService
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 26/11/2016
 */
@Service
public class CPlantaServiceImpl implements CPlantaService{

    private static final Logger LOG = Logger.getLogger(CPlantaServiceImpl.class.getName());
    
    /* RECURSO QUE PERMITE LA INTERACCIÓN CON BASE DE DATOS PARA LA TABLA DE ROLS */
    @Resource
    CPlantaMapper cPlantaMapper;

    public CPlantaServiceImpl() {
        LOG.setLevel(Level.ALL);
    }
    
    /**
     * Método que regresa una lista de rols. Utilizado por el grid de rols
     * 
     * @return una lista de rols.
     */
    @Override
    public List<CPlanta> findAll(){
        LOG.info("OBTENIENDO TODAS LAS PLANTAS DISPONIBLES");
        return cPlantaMapper.findAll();
    }
    
    /**
     * Método que obtiene una planta por su id.
     * 
     * @param id el id de planta a buscar
     * @return el objeto CPlanta
     */
    @Override
    public CPlanta findById(Long recid) {
        LOG.log(Level.INFO, "BUSCANDO A LA PLANTA CON ID: {0}", recid);
        return cPlantaMapper.findById(recid);
    }
    
    /**
     * Método que obtiene una planta por su codigo.
     * 
     * @param codigo el nombre de planta a buscar
     * @return el objeto CPlanta
     */
    @Override
    public CPlanta findByCodigo(String codigo) {
        LOG.log(Level.INFO, "BUSCANDO AL ROL CON CODIGO: {0}", codigo);
        return cPlantaMapper.findByCodigo(codigo);
    }

    /**
     * Método que da de alta un objeto CPlanta
     * @param planta Objeto a dar de alta
     * @return objeto insertado
     */
    @Override
    public CPlanta createPlanta(CPlanta planta) throws Exception {
        LOG.log(Level.INFO,"INSERTANDO UNA PLANTA NUEVA");
        CPlanta exists = findByCodigo(planta.getCodigo());
        if(exists == null){
            cPlantaMapper.insert(planta);
            return findByCodigo(planta.getCodigo());
        }else{
            LOG.log(Level.SEVERE, "LA PLANTA YA EXISTE");
            throw new Exception("La planta ya existe en el sistema");
        }
    }

    /**
     * Método que permite actualizar un objeto CPlanta
     * @param planta objeto a actualizar
     * @return Objeto actualizado
     */
    @Override
    public CPlanta updatePlanta(CPlanta planta) throws Exception{
        LOG.log(Level.INFO,"EDITANDO A LA PLANTA {0}",planta.getRecid());
        CPlanta exists = findById(planta.getRecid());
        if(exists == null){
        LOG.log(Level.SEVERE, "LA PLANTA NO EXISTE");
            throw new Exception("planta no encontrado");
        }
        cPlantaMapper.update(planta);
        return planta;
    }

    /**
     * Método que permite eliminar un objeto CPlanta
     * @param planta el id del objeto cPlanta a eliminar
     * @return si la operación se realizó con éxito.
     */
    @Override
    public Boolean deletePlanta(Long planta) throws Exception{
        LOG.log(Level.INFO,"ELIMINANDO A LA PLANTA {0}",planta);
        CPlanta exists = findById(planta);
        if(exists == null){
        LOG.log(Level.SEVERE, "LA PLANTA NO EXISTE");
            throw new Exception("planta no encontrada");
        }
        cPlantaMapper.delete(planta);
        return true;
    } 
}
