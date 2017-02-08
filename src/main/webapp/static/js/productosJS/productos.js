/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de productos
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var productosRestURL = 'rest/cProducto';

$(document).ready(function(){
   $('#productos').DataTable({
        "ajax": productosRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "codigo" },
            { "data": "descripcion" },
            { "data": "unidadProductiva" },
            { "data": "codigoUnidadProduccion" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 3 ],
                "visible": false,
                "searchable": false
            }
        ],
        "paging":false
    });    
});