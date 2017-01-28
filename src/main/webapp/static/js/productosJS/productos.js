/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de productos
 * 
 * Ernesto Cantú
 * Conciencia
 * 25/01/2017
 */


var productosRestURL = 'rest/cProducto';

$(function () {    
    $('#grid').w2grid({ 
        name: 'productosGrid', 
        method: 'GET',
        url: productosRestURL,
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
            { field: 'codigo', caption: 'Código', size: '33%', sortable: false },
            { field: 'descripcion', caption: 'Descripción', size: '33%', sortable: false },
            { field: 'unidadProduccion', caption: 'Unidad Productiva', size: '50px' },
            { field: 'codigoUnidadProduccion', caption: 'Unidad Productiva', size: '33%' }
        ]
    });
    
    w2ui['productosGrid'].hideColumn('recid', 'unidadProduccion');
});
