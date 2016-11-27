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
