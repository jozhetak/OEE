<!DOCTYPE html>
<html>
<head>
    <base href="${rc.getContextPath()}/" />
    <title>Plantas</title>
    <script src="static/vendor/jquery/jquery.js"></script>
    <script type="text/javascript" src="static/vendor/w2ui/js/w2ui-1.5.rc1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/vendor/w2ui/css/w2ui-1.5.rc1.min.css" />
    <link rel="stylesheet" type="text/css" href="static/vendor/webix/codebase/webix.css" />
    <script type="text/javascript" src="static/js/plantasJS/plantas.js"></script>
    <script type="text/javascript" src="static/vendor/webix/codebase/webix.js"></script>
</head>
<body>
    <div id="grid" style="width: 100%; height: 300px;"></div>
    <form id="contenidoUploadForm" name="contenidoUploadForm" method="post" action="uploadFile" enctype="multipart/form-data">
        <input type="file" id="FileData" name="FileData" accept=".csv">
        <input type="text" id="Ruta" name="Ruta" value="/plantas">
        <input type="submit">
    </form>
</body>
</html>