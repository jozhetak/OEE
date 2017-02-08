/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de Rates de Produccion
 * 
 * Ernesto Cantú
 * Conciencia
 * 27/01/2017
 */


var ratesRestURL = 'rest/cRateProduccion';

$(document).ready(function(){
   $('#rates').DataTable({
        "ajax": ratesRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "maquina" },
            { "data": "codigoMaquina" },
            { "data": "producto" },
            { "data": "codigoProducto" },
            { "data": "unidadesMinuto" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 1 ],
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