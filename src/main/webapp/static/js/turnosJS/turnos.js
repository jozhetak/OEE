/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de turnos
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var turnosRestURL = 'rest/cTurno';

$(document).ready(function(){
   $('#turnos').DataTable({
        "ajax": turnosRestURL,
        "columns": [
            { "data":"recid" },
            { "data": "codigo" },
            { "data": "descripcion" },
            { "data": "duracion" }
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
