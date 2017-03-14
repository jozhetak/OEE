<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="Conciencia" content="">
        <title>OEE</title> <!-- i18n -->
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
        <script src="static/vendor/jquery/jquery.js"></script>
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="static/vendor/datatables/js/dataTables.bootstrap.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="static/vendor/datatables/js/jquery.dataTables.js"></script>
        <link href="static/vendor/datatables/css/jquery.dataTables.css" rel="stylesheet">
        <script>
            $(function () {
                $("#fechaInicio").datepicker({ dateFormat: 'yy-mm-dd' });
                $("#fechaFin").datepicker({ dateFormat: 'yy-mm-dd' });

                $("#consultaButton").on("click", getOEERangoFechas);
            });
        </script>
        <style>
            body{
                margin: 2.5%;
            }

            #container{
                margin:10%;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <p>Fecha de Inicio: <input type="text" id="fechaInicio"></p>
            <p>Fecha de Fin: <input type="text" id="fechaFin"></p>
            <hr>
            <button id="consultaButton">Consultar</button>
            <hr>
            
            <table id="oee" class="display" hidden="true">
                <thead>
                    <tr>
                        <th>Record Id</th>
                        <th>Máquina</th>
                        <th>Disponibilidad</th>
                        <th>Rendimiento</th>
                        <th>Calidad</th>
                        <th>OEE</th>
                    </tr>
                </thead>
            </table>
            
        <div>
    </body>
    <script>
        
        var reportesURL = 'rest/rCalculoOEE/maquinas';

        function getOEERangoFechas() {
            var sysFechas = {
                fechaInicio : $("#fechaInicio").val(),
                fechaFin : $("#fechaFin").val()
            };
            
            
            $.ajax({
            type: 'POST',
            url: reportesURL,
            data: JSON.stringify(sysFechas),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                $("#oee").show();
                $("#oee").DataTable({
                    data: data.data,
                    "columns": [
                        { "data": "recid" },
                        { "data": "codigo" },
                        { "data": "disponibilidad" },
                        { "data": "rendimiento" },
                        { "data": "calidad" },
                        { "data": "oee" }
                    ],
                    "columnDefs": [
                        {
                            "targets": [ 0 ],
                            "visible": false,
                            "searchable": false
                        }
                    ],
                    "paging":false
                });
            },
            error: function (data) {
                alert(data.responseJSON.error);
            }
        });
        }

    </script>
</html>
