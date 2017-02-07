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
    <title>Máquinas</title>
    <script src="static/vendor/jquery/jquery.js"></script>
    <script type="text/javascript" src="static/js/maquinasJS/maquinas.js"></script>
    
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
    <div id="container">
        <table id="maquinas" class="display">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Descripción</th>
                    <th>Código Unidad Productiva</th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>