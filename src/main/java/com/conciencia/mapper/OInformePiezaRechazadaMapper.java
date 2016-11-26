package com.conciencia.mapper;

import com.conciencia.pojo.OInformePiezasRechazadas;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para consultas relacionadas con la tabla de informes de piezas rechazadas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface OInformePiezaRechazadaMapper {

    @Select("SELECT* FROM informe_piezas_rechazadas")
    public List<OInformePiezasRechazadas> findAll();

    
}