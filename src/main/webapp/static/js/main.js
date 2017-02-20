/**
 * main.js Contiene todas las funcionalidades específicas para el funcionamiento
 * del sistema de Cálculo de Rendimiento de Equipos OEE ProEfficient.
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
 */

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE USUARIOS */
$("#usuarios").on('click', function() {
   window.open('users', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 800 + ',height=' + 400);
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE ROLES */
$("#roles").on('click', function() {
   window.open('roles', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 800 + ',height=' + 400);
});


//------------------------------------------------------------------------------


// CATALOGOS DEL SISTEMA

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE MAQUINAS */
$("#maquinas").on('click', function() {
   window.open('cmaquinas', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE TURNOS */
$("#turnos").on('click', function() {
   window.open('cturnos', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE PAROS PROGRAMADOS */
$("#paros").on('click', function() {
   window.open('cparosProgramados', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE PAROS PROGRAMADOS */
$("#productos").on('click', function() {
   window.open('cproductos', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE UNIDADES PRODUCTIVAS */
$("#unidades").on('click', function() {
   window.open('cunidades', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE RATES DE PRODUCCION */
$("#rates").on('click', function() {
   window.open('crates', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,fullscreen=yes');
});


/****************************************************************************/

//asignaciones

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE CARGAR ASIGNACIONES */
$("#asignaciones").on('click', function() {
   window.open('oasignacionesLoad', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
          'menubar=no, scrollbars=1,modal=yes,width=' + 800 + ',height=' + 400);
  
});


/****************************************************************************/
//URL que define la ruta de acceso al rest de asignaciones
var asignacionesRestURLBase = 'rest/oAsignacion';

$(document).ready(function(){
    
    var asignacionesRestURL = asignacionesRestURLBase;
    
    if($("#userRole").val() === 'OPER'){
        asignacionesRestURL += "/" + $("#userId").val();
    }
    
   $('#asignacionesTable').DataTable({
        "ajax": asignacionesRestURL,
        "columns": [
            { 
                "data": "recid" ,
                "title":"Record Id"
            },
            { 
                "data": "maquina" ,
                "title":"Id de Máquina"
            },
            { 
                "data": "codigoMaquina" ,
                "title":"Máquina"
            },
            { 
                "data": "producto",
                "title":"Id de Producto"
            },
            { 
                "data": "codigoProducto",
                "title":"Producto"
            },
            { 
                "data": "turno",
                "title":"Id de Turno" 
            },
            { 
                "data": "codigoTurno",
                "title":"Turno"
            },
            { 
                "data": "operador",
                "title":"Id de Operador"
            },
            { 
                "data": "nombreOperador",
                "title":"Operador"
            },
            { 
                "data": "duracion",
                "title":"Duración(Mins)"
            },
            { 
                "data": "esParo",
                "title":"EsParo"
            },
            { 
                "data": "fecha",
                "title":"Fecha",
                "render": function ( data, type, row ) {
                    // If display or filter data is requested, format the date
                    if ( type === 'display' || type === 'filter' ) {
                        var d = new Date( data);
                        return d.getDate() +'-'+ (d.getMonth()+1) +'-'+ d.getFullYear();
                    }

                    // Otherwise the data type requested (`type`) is type detection or
                    // sorting data, for which we want to use the integer, so just return
                    // that, unaltered
                    return data;
                }
            }
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
            },
            {
                "targets": [ 5 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 7 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 10 ],
                "visible": false,
                "searchable": false
            }
        ],
        "lengthMenu": [[5, 15, 25, -1], [5, 15, 25, "All"]]
    });    
});