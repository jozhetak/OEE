<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ProEfficient</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="Conciencia" content="">
        <title>Welcome</title>
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="static/vendor/jquery/jquery.min.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="static/vendor/metisMenu/metisMenu.min.js"></script>
        <script src="static/dist/js/sb-admin-2.js"></script>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form action="" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="User Name" id="username" name="username" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" type="password" id="password" name="password" value="">
                                    </div>
                                    <button type="submit" class="btn btn-lg btn-success btn-block">Log In</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>