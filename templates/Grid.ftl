<#include "Configs.java"><#include "Macros.java">
<${sc}assign recordsUrl="rest/${main_id}/${dc}{${main_id}.id}/${id_name}<#if !object?starts_with("V")>/dto</#if>"/>
<${sc}assign downloadURL="rest/${main_id}/${dc}{${main_id}.id}/${id_name}/${object?replace("DTO$", "", 'r')}.csv"/>
<#if !object?starts_with("S") && !object?starts_with("V")>
<${sc}assign processorUrl="uploadFile" />
<${sc}assign processorRoute="/${id_name}"/>
</#if>
<${sc}assign msg_title><${spring}.message "grid_${id_name}.title"/></${sc}assign>
<${sc}assign msg_caption><${spring}.message "grid_${id_name}.caption"/>&nbsp;<${spring}.message "referencia.${main_id}"/></${sc}assign>
<!DOCTYPE html>
<html lang="es-mx">
    <head>
        <base href="${dc}{rc.getContextPath()}/" />
        <title>${dc}{msg_title}</title>
        <link rel="stylesheet" type="text/css" href="static/libs/normalize/normalize.css" />
        <link rel="stylesheet" type="text/css" href="static/libs/jquery-ui-1.11.4.smoothness/jquery-ui.min.css"/>
        <link rel="stylesheet" type="text/css" href="static/libs/free-jqgrid/4.11.1/css/ui.jqgrid.css" />
        <link rel="stylesheet" type="text/css" href="static/css/gridLib.css" />
    </head>
    <body>
        <div id='contenido'></div>

        <script type="text/javascript" src="static/libs/jquery/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="static/libs/jquery-ui-1.11.4.smoothness/jquery-ui.min.js"></script>
        <script type="text/javascript" src="static/libs/free-jqgrid/4.11.1/js/i18n/grid.locale-es-mx.js"></script>
        <script type="text/javascript" src="static/libs/free-jqgrid/4.11.1/js/jquery.jqgrid.min.js"></script>
        <script type="text/javascript" src="static/libs/gridLib.js"></script>    
        <script type='text/javascript'>
        new Grid('contenido')
            .setReference('${dc}{${main_id}.codigo}','${dc}{${main_id}.id}')
            .setCaption('${dc}{msg_caption}')
            .setUrl('${dc}{recordsUrl}')
            .setGroup(new ColumnGroup()
<#list fieldsAndSimpleModifiers as field>
  <#assign tipo>${field?split(' ')[1]}</#assign>
  <#assign nombre>${field?split(' ')[2]}</#assign>
  <#assign caption = toCaption(nombre)>
  <#assign ancho><#if nombre = "codigo">85<#elseif nombre = "descripcion">150<#else>100</#if></#assign>
  <#if nombre != "id" && nombre != "LOG_ID" && nombre != "serialVersionUID" && !dto_ids?seq_contains(nombre) >
    <#if tipo = "BigDecimal" || tipo = "Long" || tipo = "BigInteger"  || tipo = "Short">
                        .add(new NumberColumn()
    <#else>
                        .add(new LabelColumn()
    </#if>
    <#if tipo = "Long" || tipo = "BigInteger"  || tipo = "Short">
                                .setInteger()
    </#if>
                                .setLabel("${caption}")
                                .setName("${nombre}")
                                .setWidth(${ancho}))
  </#if>
</#list>
                        .add(new IdColumn())

            )
            .add(new CSVExportButton()
                     .setUrl('${dc}{downloadURL}'))
<#if !object?starts_with("S") && !object?starts_with("V")>
            .add(new CSVLoadButton()
                    .setUrl('${dc}{processorUrl}')
                    .setReference('${dc}{${main_id}.id}')
                    .setPath('${dc}{processorRoute}'))
</#if>
            .showFilterToolbar()
            .display();
        </script>
    </body>
</html>