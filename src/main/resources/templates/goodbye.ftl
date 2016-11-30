<#assign inicioUrl = "/" />
<!DOCTYPE html>
<html lang="es-mx">
    <head>
        <base href="${rc.getContextPath()}/" />
        <title><@spring.message "app.titulo"/></title>
        <link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <script type="text/javascript">
            function login() {
                window.location.assign("<@spring.url '${inicioUrl}' />");
            };
        </script>
        <div style="top:20%" class="modal" id="my-modal" aria-hidden="true">
            <div class="modal-header">
                <h3><@spring.message "app.goodbye.title"/></h3>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <td width="70%">
                            <@spring.message "app.goodbye.mensaje"/></br></br>
                            <button type="submit" class="btn btn-danger" onclick="login()">
                                <@spring.message "app.goodbye.button"/>
                            </button>
                        </td>
                        <td width="30%">
                            <img src="static/images/Ernest.png" width="90%" style="vertical-align:200%;">
                        </td>
                    </tr>
                </table>
            </div>
        </div>	
    </body>
</html>