<#assign loginUrl="/login" />
<!DOCTYPE html>
<html lang="en">

    <head>
        <base href="${rc.getContextPath()}/" />
        <title><@spring.message "app.titulo"/></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SB Admin 2 - Bootstrap Admin Theme</title>
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                            <form action="<@spring.url "/login" />" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="User Name" id="username" name="username" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" type="password" id="password" name="password" value="">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-lg btn-success btn-block"><@spring.message "app.login.button"/></button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="static/vendor/jquery/jquery.min.js"></script>
        <script src="static/vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="static/vendor/metisMenu/metisMenu.min.js"></script>
        <script src="static/dist/js/sb-admin-2.js"></script>
    </body>
</html>