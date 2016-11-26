<#function toUnderScore camelCase>
    <#return camelCase?uncap_first?replace("[A-Z]", "_$0", 'r')?lower_case?replace("^([a-z])_([a-z])", "$1$2", 'r')>
</#function>
<#function toCaption fieldName>
    <#return fieldName?replace("[A-Z]", " $0", 'r')?cap_first>
</#function >
<#function id2code id>
    <#return id?replace("^id", "codigo", 'r')>
</#function >
<#function filterIds4DTO campos>
    <#local result = []>
    <#list campos as texto>
        <#if texto != "id" && texto?starts_with("id")>
            <#local result = result + [texto]>
        </#if>
    </#list>
    <#return result>
</#function>
<#assign db_name = toUnderScore(object)>
<#assign id_name>${db_name?split('_')[0]}</#assign>
<#assign sc>#</#assign>
<#assign dc>$</#assign>
<#assign spring>@spring</#assign>
<#assign main_key><#if object?starts_with("S") || object?starts_with("V")>idSolucion<#else>idEscenario</#if></#assign>
<#if (map_tables[main_key])??><#assign main_class = map_tables[main_key]></#if>
<#assign main_class_db_name = toUnderScore(main_class)>
<#assign main_id>${main_class_db_name?split('_')[0]}</#assign>
<#if (map_find_by_keys[object])??><#assign find_by_keys = map_find_by_keys[object]></#if>
<#assign dto_ids = filterIds4DTO(fields)>