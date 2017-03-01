<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html>
<head>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
    <title>Usuarios</title>
    <script src="static/vendor/jquery/jquery.js"></script>
    <script type="text/javascript" src="static/js/usersJS/users.js"></script>
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/vendor/datatables/js/jquery.dataTables.js"></script>
    <link href="static/vendor/datatables/css/jquery.dataTables.css" rel="stylesheet">
    <script src="static/vendor/datatables/js/dataTables.bootstrap.js"></script>
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
    <div style="margin:2%;padding-bottom: 0px;" class="col-md-6 text-right">
        <button id="addButton" class="btn btn-success">Agregar</button>
        <button id="updateButton" class="btn btn-info disabled">Actualizar</button>
        <button id="deleteButton" class="btn btn-danger disabled">Eliminar</button>
    </div>
    <div id="container">
        <table id="usuarios" class="display">
            <thead>
                <tr>
                    <th>Record Id</th>
                    <th style="width:33%">Usuario</th>
                    <th style="width:33%">Nombre</th>
                    <th style="width:33%">Role Name</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>