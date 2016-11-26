<#assign inicioUrl = "/" />
<!DOCTYPE html>
<html lang="es-mx">
    <head>
        <base href="${rc.getContextPath()}/" />
        <title><@spring.message "app.titulo"/></title>
        <link rel="icon" href="favicon.ico">
        <link rel="stylesheet" type="text/css" href="static/libs/normalize/normalize.css" />
        <script type="text/javascript" src="static/libs/jquery/jquery-2.1.4.min.js"></script>
        <link rel="stylesheet" type="text/css" href="static/css/bootstrap2.css">
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