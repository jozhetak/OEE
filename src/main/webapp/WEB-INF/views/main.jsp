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
    <title>ProEfficient</title> <!-- i18n -->
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
    <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ProEfficient v1.0 - ${user.userName}</a> <!-- i18n -->
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href=""><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Catálogos del Sistema<span class="fa arrow"></span></a> <!-- i18n -->
                            <ul class="nav nav-second-level">
                                <li>
                                    <a id="maquinas">Máquinas</a>
                                </li>
                                <li>
                                    <a id="turnos">Turnos</a>
                                </li>
                                <li>
                                    <a id="paros">Paros Programados</a>
                                </li>
                                <li>
                                    <a id="productos">Productos</a>
                                </li>
                                <li>
                                    <a id="unidades">Unidades de Producción</a>
                                </li>
                                <li>
                                    <a id="rates">Rates de Producción</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Programas de Producción<span class="fa arrow"></span></a> <!-- i18n -->
                            <ul class="nav nav-second-level">
                                <li>
                                    <a id="asignaciones">Consultar asignaciones</a>
                                </li>
                                <security:authorize access="hasAuthority('SA') or hasAuthority('ADMIN')">
                                <li>
                                    <a id="oeeMaquinas">Reportes</a>
                                </li>
                                </security:authorize>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <security:authorize access="hasAuthority('SA')">
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>Administración de Sistema<span class="fa arrow"></span></a> <!-- i18n -->
                            <ul class="nav nav-second-level">
                                <li>
                                    <a id="usuarios"> Usuarios</a>
                                </li>
                                <li>
                                    <a id="roles">Roles</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        </security:authorize>
                    </ul>
                </div>
            </div>
            <!-- /.navbar-static-side -->
        </nav>


        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">ProEfficient 1.0</h1>
                        <h3>Resumenes!</h3>
                        <hr>
                    </div>
                </div>
            </div>
        </div>

    </div>
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
    <input type="text" hidden="true" id="userId" value="${user.recid}"></input>
    <input type="text" hidden="true" id="userRole" value="${user.rolName}"></input>
</body>
</html>
