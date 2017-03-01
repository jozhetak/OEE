/**
 * roles.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de roles
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
 */


//variable que contiene la ruta a los servicios rest de roles
var rolesRestURL = 'rest/sysRole';



$(document).ready(function(){
   $('#roles').DataTable({
        "ajax": rolesRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "codigo" },
            { "data": "descripcion" }
        ],
        "paging":false
    });    
});


