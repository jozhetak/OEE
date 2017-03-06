<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <title>Reporte</title> <!-- i18n -->
            <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h5>Reporte de la asignacion : ${asignacion.codigoMaquina} - ${asignacion.codigoProducto}</h5>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        <div role="form">
                            <div class="form-group">
                                <input id="recid" hidden="true"></input>
                            </div>
                            <div class="form-group">
                                <label>Tiempo Efectivo de Produccion</label>
                                <input id="tiempoEfectivoProduccion" class="form-control" placeholder="Minutos"></input>
                            </div>
                            <div class="form-group">
                                <label>Unidades Producidas</label>
                                <input id="unidadesProducidas" class="form-control" placeholder="Unidades Producidas"></input>
                            </div>
                            <div class="form-group">
                                <label>Unidades Aceptadas</label>
                                <input id="unidadesAceptadas" class="form-control" placeholder="Unidades Aceptadas"></input>
                            </div>
                            <div class="form-group">
                                <label>Informacion Adicional</label>
                                <textarea id="informacionAdicional" class="form-control" rows="5"></textarea>
                            </div>
                            <button type="submit" class="btn btn-default">Submit Button</button>
                            <button type="reset" class="btn btn-default">Reset Button</button>
                        </div>
                    </div>
                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>

        <input type="text" hidden="true" id="userId" value="${user.recid}"></input>
        <input type="text" hidden="true" id="userRole" value="${user.rolName}"></input>
        <script src="static/vendor/jquery/jquery.min.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="static/vendor/metisMenu/metisMenu.min.js"></script>
        <script src="static/dist/js/sb-admin-2.js"></script>
        <script src="static/js/main.js"></script>
        <script src="static/vendor/datatables/js/jquery.dataTables.js"></script>
        <link href="static/vendor/datatables/css/jquery.dataTables.css" rel="stylesheet">
        <script src="static/vendor/datatables/js/dataTables.bootstrap.js"></script>
        <script src="static/vendor/sock/sock.js"></script>
        <script src="static/vendor/stomp/stomp.js"></script>
        <script type="text/javascript" src="static/js/asignacionesJS/asignaciones.js"></script>

    </body>
</html>
