/**
 * mquinas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de Rates de Produccion
 * 
 * Ernesto Cantú
 * Conciencia
 * 27/01/2017
 */


var ratesRestURL = 'rest/cRateProduccion';

$(function () {    
    $('#grid').w2grid({ 
        name: 'ratesGrid', 
        method: 'GET',
        url: ratesRestURL,
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
            { field: 'maquina', caption: 'Máquina', size: '50px' },
            { field: 'codigoMaquina', caption: 'Máquina', size: '33%', sortable: false },
            { field: 'producto', caption: 'Producto', size: '50px' },
            { field: 'codigoProducto', caption: 'Producto', size: '33%', sortable: false },
            { field: 'unidadesMinuto', caption: 'Unidades/Minuto', size: '33%' }
        ]
    });
    
    w2ui['ratesGrid'].hideColumn('recid', 'maquina','producto');
});
