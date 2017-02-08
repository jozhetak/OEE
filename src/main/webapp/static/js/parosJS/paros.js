/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de paros programados
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var paroRestURL = 'rest/cParoProgramado';


$(document).ready(function(){
   $('#paros').DataTable({
        "ajax": paroRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "codigo" },
            { "data": "descripcion" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "paging":false
    });    
});