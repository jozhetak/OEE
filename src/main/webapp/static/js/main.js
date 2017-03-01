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
   window.open('oasignaciones', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
          'menubar=no, scrollbars=1,modal=yes,width='+screen.availWidth+',height='+screen.availHeight);
  
});


var stompClient = null;

/**
 * Function that updates the gui if the connection status changes
 * connected: status connection
 */
function setConnected(connected) {  
    if(connected)
        console.log("connected");
    else
        console.log("disconnected");
}


/**
 * Method that stablishes a connection with the web socket
 * server. Executes the sowGreeting method when an event occurres 
 */
function connect() {
    var socket = new SockJS('OEE-websocket'); // search for the server
    stompClient = Stomp.over(socket); //creates a stomp client
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/notify/oAsignacionLoaded', function (greeting) {
            //asignacionesCSVLoaded();
        });
    });
}


/**
 * Method that disconects to the server
 */
function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/**
 */
function asignacionesCSVLoaded(message) {
    var table = $('#asignacionesTable').DataTable();
    table.ajax.reload();
}



//$(function () {
//    connect();
//
//    $('#asignacionesTable tbody').on( 'click', 'tr', function () {
//        if ( $(this).hasClass('selected') ) {
//            $(this).removeClass('selected');
//        }
//        else {
//            $('tr.selected').removeClass('selected');
//            $(this).addClass('selected');
//        }
//    } );
//    
//    $("#reporteButton").click(function(){
//        alert("generar reporte");
//        var table = $('#asignacionesTable').DataTable();
//        console.log(table.row('.selected').data());
//    });
//});