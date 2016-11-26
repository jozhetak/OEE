/**
 * users.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de usuarios
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
 */
var usersRestURL = 'rest/sysUser';
$(function () {    
    $('#grid').w2grid({ 
        name: 'usersGrid', 
        method: 'GET',
        url: usersRestURL,
        show: { 
            toolbar: true,
            footer: true,
            toolbarAdd: true,
            toolbarDelete: true,
            toolbarSave: true,
            toolbarEdit: true
        },
        searches: [                
            { field: 'userName', caption: 'User Name', type: 'text' },
            { field: 'name', caption: 'Full Name', type: 'text' }
        ],
        columns: [                
            { field: 'recid', caption: 'Id', size: '50px', sortable: true, attr: 'align=center' },
            { field: 'userName', caption: 'User Name', size: '30%', sortable: true },
            { field: 'name', caption: 'Full Name', size: '30%', sortable: true },
            { field: 'rolName', caption: 'Rol', size: '40%' }
        ],
        onAdd: function (event) {
            w2alert('add');
        },
        onEdit: function (event) {
            w2alert('edit');
        },
        onDelete: function (event) {
            console.log('delete has default behavior');
        },
        onSave: function (event) {
            w2alert('save');
        }
    });   
});
