/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de unidades productivas
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var paroRestURL = 'rest/cUnidadProductiva';

$(function () {    
    $('#grid').w2grid({ 
        name: 'unidadesGrid', 
        method: 'GET',
        url: paroRestURL,
        fixedBody: false, // calcula la altura del grid en base al número de columnas.
        show: { 
            toolbar: false,
            usersFormter: false,
            toolbarAdd: false,
            toolbarDelete: false,
            toolbarEdit: false
        },
        searches: [                
            { field: 'codigo', caption: 'Código', type: 'text' },
            { field: 'codigoUnidadProductiva', caption: 'Unidad Productiva', type: 'text' }
        ],
        columns: [                
            { field: 'recid', caption: 'Id', size: '50px', sortable: false},
            { field: 'codigo', caption: 'Código', size: '33%', sortable: true },
            { field: 'descripcion', caption: 'Descripción', size: '33%', sortable: true }
        ]
    });
    
    w2ui['unidadesGrid'].hideColumn('recid');
});
