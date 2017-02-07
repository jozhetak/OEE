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
            'menubar=no, scrollbars=1,modal=yes,width=' + 500 + ',height=' + 200);
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE PAROS PROGRAMADOS */
$("#paros").on('click', function() {
   window.open('cparosProgramados', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 500 + ',height=' + 200);
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE PAROS PROGRAMADOS */
$("#productos").on('click', function() {
   window.open('cproductos', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 500 + ',height=' + 200);
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE UNIDADES PRODUCTIVAS */
$("#unidades").on('click', function() {
   window.open('cunidades', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 500 + ',height=' + 200);
});

/* FUNCION QUE DEFINE LA ACCION AL HACER CLICK EN EL BOTÓN DE RATES DE PRODUCCION */
$("#rates").on('click', function() {
   window.open('crates', '_blank', 'location=no, status=no, toolbar=no, titlebar=no,' +
            'menubar=no, scrollbars=1,modal=yes,width=' + 500 + ',height=' + 200);
});