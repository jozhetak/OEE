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
    <title>ProEfficient</title> <!-- i18n -->
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <hr>
    <h3>Asignaciones del día</h3>
    <hr>
    <table id="asignacionesTable" class="display">
    </table>
    <hr>
    <c:if test="${role=='OPER'}">
        <button id="reporteButton">Crear Reporte</button>
    </c:if>
    <c:if test="${role == 'ADMIN' || role == 'SA'}">
    <form id="contenidoUploadForm" name="contenidoUploadForm" method="post" action="uploadFile" enctype="multipart/form-data">
        <input type="file" id="FileData" name="FileData" accept=".csv">
        <input type="text" id="Ruta" name="Ruta" value="/oAsignacionDiaCSVLoad" hidden="true">
        <input type="submit">
    </form>
    <br>
    <hr>
    <c:if test="${fn:length(loadLog) gt 0}">
        Errores en la carga del archivo:<br>
    <c:forEach var="log" items="${loadLog}">
        <c:out value="${log}"/><br>
    </c:forEach>
    </c:if>
    </c:if>
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
<script>
    


    var stompClient = null;

    /**
     * Method that stablishes a connection with the web socket
     * server. Executes the sowGreeting method when an event occurres 
     */
    function connect() {
        var socket = new SockJS('OEE-websocket'); // search for the server
        stompClient = Stomp.over(socket); //creates a stomp client
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/notify/logError', function (message) {
                logMessage(message);
            });
        });
    }


    function logMessage(message){
        console.log(message.message);
    }
</script>
