<#include "Configs.java">
<#include "Macros.java">
package ${package};

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Clase para la extracción de datos de BD y su mapeo a POJOs
 *
 * @author ${user}
 * created on ${.now?datetime}
 */
public interface ${object}Mapper {

    @Insert("INSERT INTO ${db_name}("
            <#list fields as field><#if field != "id" >
              + "${toUnderScore(field)}<#if field_has_next>, </#if>"
            </#if></#list>
            + ") VALUES ("
            <#list fields as field><#if field != "id" >
              + "${sc}{${field}}<#if field_has_next>, </#if>"
            </#if></#list>
            + ")")
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
    public int insert(${object} ${object?uncap_first});

    @Delete("DELETE FROM ${db_name} WHERE id =${sc}{id}")
    public int delete(Long id);

    // Implementacion en maper xml
    public int deleteAllById(List<Long> idsList);

<#if main_key??>
    <#if dto_ids??>
    @Select("SELECT" +
                " ${db_name}.* " +
            <#list dto_ids as id>
                <#if map_tables[id]??>
                ",${toUnderScore(map_tables[id])}.codigo as ${id2code(id)} " +
                    <#if extra_dto_fields[id]??>
                ",${toUnderScore(map_tables[id])}.${extra_dto_fields[id].to} as ${extra_dto_fields[id].from} " +
                    </#if>
                </#if>
            </#list>
            "FROM" +
                " ${db_name} " +
            <#list dto_ids as id>
                <#if map_tables[id]??>
                ",${toUnderScore(map_tables[id])} " +
                </#if>
            </#list>
            "WHERE" +
                   " ${toUnderScore(map_tables[main_key])}.id = ${sc}{${main_key}} " +
            <#list dto_ids as id>
                <#if map_tables[id]??>
                "AND ${db_name}.${toUnderScore(id)} = ${toUnderScore(map_tables[id])}.id "<#if id_has_next> +</#if>
                </#if>
            </#list>
    )
    public List<${object}DTO> findAllBy${main_key?cap_first}DTO(Long ${main_key});

    </#if>
    @Select("SELECT * FROM ${db_name} WHERE ${toUnderScore(main_key)} = ${sc}{${main_key}} ORDER BY id")
    public List<${object}> findAllBy${main_key?cap_first}(Long ${main_key});

    @Select("SELECT id FROM ${db_name} WHERE ${toUnderScore(main_key)} = ${sc}{${main_key}} ORDER BY id")
    public List<Long> findAllIdsBy${main_key?cap_first}(Long ${main_key});

    @Select("SELECT * FROM ${db_name} WHERE ${toUnderScore(main_key)} = ${sc}{${main_key}} AND codigo =${sc}{codigo}")
    public ${object} findBy${main_key?cap_first}AndCodigo(@Param("${main_key}") Long ${main_key}, @Param("codigo") String codigo);

</#if>
<#if object?starts_with("P")>
   @Select("SELECT * FROM ${db_name} WHERE id_periodo = #{idPeriodo} ORDER BY id")
    public List<P${object}> findAllByIdPeriodo(Long idPeriodo);

</#if>
    @Select("SELECT * FROM ${db_name} WHERE id = ${sc}{id}")
    public ${object} findById(Long id);

<#if find_by_keys??>
    @Select("SELECT * FROM ${db_name} WHERE "
            <#list find_by_keys as key>
              + "${toUnderScore(key)} = ${sc}{${key}}<#if key_has_next>, AND </#if>"
            </#list>
              + " ORDER BY id"
    )
    public ${object} findAllByKeys(<#list find_by_keys as key>@Param("${key}") Long ${key}<#if key_has_next>, </#if></#list>);

</#if>
    @Select("UPDATE ${db_name} SET "
            <#list fields as field><#if field != "id" >
            + "${toUnderScore(field)} = ${sc}{${field}}<#if field_has_next>,</#if> "
            </#if></#list>
            + "WHERE id = ${sc}{id}")
    public void update(${object} ${object?uncap_first});
}