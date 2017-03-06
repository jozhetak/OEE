/**
 * asignaciones.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de asignaciones
 * 
 * Ernesto Cantú
 * Conciencia
 * 27/02/2017
 */


//URL que define la ruta de acceso al rest de asignaciones
var asignacionesRestURLBase = 'rest/oAsignacion';

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

$(function () {
    $('#asignacionesTable tbody').on( 'click', 'tr', function () {
        var table = $('#asignacionesTable').DataTable();
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            $("#reporteButton").addClass("disabled");
        }
        else {
            $('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            if(!table.row('.selected').data().esParo)
                $("#reporteButton").removeClass("disabled");
            else
                $("#reporteButton").addClass("disabled");
        }
    });
    
    $("#reporteButton").click(function(){
        //alert("generar reporte");
        var table = $('#asignacionesTable').DataTable();
        console.log(table.row('.selected').data());
        window.open('OAsignacion/reporte/'+table.row('.selected').data().recid, '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=300,height=600');
    });
});