/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de maquinas
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var maquinasRestURL = 'rest/cMaquina';

$(document).ready(function(){
   $('#maquinas').DataTable({
        "ajax": maquinasRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "codigo" },
            { "data": "descripcion" },
            { "data": "unidadProduccion" },
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
    
