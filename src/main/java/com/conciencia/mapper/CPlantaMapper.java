package com.conciencia.mapper;

import com.conciencia.pojo.CPlanta;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase para consultas relacionadas con la tabla Plantas
 *
 * @author Ernesto Cantu Valle
 * Conciencia
 * 18/11/2016
 */
public interface CPlantaMapper {
    
    static final String FIND_ALL = "SELECT id AS recid,codigo,descripcion FROM plantas";
    
    
    static final String FIND_BY_ID = "SELECT id AS recid,codigo,descripcion FROM plantas WHERE id = #{recid}";
    
    static final String FIND_BY_CODE = "SELECT id AS recid,codigo,descripcion FROM plantas WHERE codigo = #{codigo}";
    
    static final String INSERT_PLANT = "INSERT INTO `oee_db`.`plantas`(" +
                                        "`codigo`," +
                                        "`descripcion`) " +
                                        "VALUES" +
                                        "(#{codigo}," +
                                        "#{descripcion});";
    
    static final String UPDATE_PLANT = "UPDATE `oee_db`.`plantas` " +
                                      "SET " +
                                      "`codigo` = #{codigo}," +
                                      "`descripcion` = #{descripcion} " +
                                      "WHERE `id` = #{recid};";
    
    static final String DELETE_PLANT = "DELETE FROM `oee_db`.`plantas` WHERE id = #{recid}";
    
    /**
     * Regresa todos las plantas existentes
     * @return regresa una lista de plantas
     */
    @Select(FIND_ALL)
    public List<CPlanta> findAll();
    
    /**
     * Busca un plantas por su id
     * @param recid el id del rol
     * @return el rol encontrado
     */
    @Select(FIND_BY_ID)
    public CPlanta findById(Long recid);
    
    /**
     * Busca un plantas por su codigo
     * @param codigo el codigo del plantas
     * @return el plantas encontrado
     */
    @Select(FIND_BY_CODE)
    public CPlanta findByCodigo(String codigo);

    /**
     * Inserta un plantas
     * @param plantas el plantas a insertar
     */
    @Insert(INSERT_PLANT)
    @Options(useGeneratedKeys = true, keyProperty = "recid", flushCache = true, keyColumn = "id")
    public void insert(CPlanta rol);
    
    /**
     * Actualiza un plantas dado
     * @param plantas el plantas a actualizar
     */
    @Transactional
    @Update(UPDATE_PLANT)
    public void update(CPlanta rol);

    /**
     * elimina un plantas
     * @param recid el id del plantas a eliminar.
     */
    @Transactional
    @Delete(DELETE_PLANT)
    public void delete(Long recid);

    
}