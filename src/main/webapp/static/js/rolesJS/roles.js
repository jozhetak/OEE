/**
 * roles.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de roles
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
 */


//Objeto que contiene las propiedades para el manejo de la eliminación de registros
delete_options = {
    msg          : 'Desea eliminar el registro?',
    title        : w2utils.lang('Eliminar?'),
    width        : 450,       // width of the dialog
    height       : 220,       // height of the dialog
    yes_text     : 'Si',     // text for yes button
    yes_class    : '',        // class for yes button
    yes_style    : '',        // style for yes button
    yes_callBack : null,      // callBack for yes button
    no_text      : 'No',      // text for no button
    no_class     : '',        // class for no button
    no_style     : '',        // style for no button
    no_callBack  : null,      // callBack for no button
    callBack     : null       // common callBack
};

//variable que contiene la ruta a los servicios rest de roles
var rolesRestURL = 'rest/sysRole';
var popup;


//Grid w2ui
$(function () {    
    $('#grid').w2grid({ 
        name: 'rolesGrid', 
        method: 'GET',
        url: rolesRestURL,
        show: { 
            toolbar: true,
            rolesFormter: false,
            toolbarAdd: true,
            toolbarDelete: true,
            toolbarEdit: true
        },
        searches: [                
            { field: 'codigo', caption: 'Codigo', type: 'text' }
        ],
        columns: [                
            { field: 'recid', caption: 'Id', size: '50px', sortable: true, attr: 'align=center' },
            { field: 'codigo', caption: 'Código', size: '30%', sortable: true },
            { field: 'descripcion', caption: 'Descripción', size: '30%', sortable: true }
        ],
        onAdd: function (event) {
            //w2alert('add
            openPopup(true);//informa a la funcion que se selecionó la opcion de agregar
        },
        onEdit: function (event) {
            //w2alert('edit');
            openPopup(false); //informa a la funcion que se seleccionó la opcion de editar.
        },
        onDelete: function (event) {
            objectToDelete = this.get(this.getSelection())[0]; //regresa un array de objetos seleccionados
            
            w2confirm(delete_options)
                    .yes(function(){
                        $.ajax({
                            type: 'POST',
                            url: rolesRestURL + "/delete",
                            data: JSON.stringify(objectToDelete),
                            dataType: "json",
                            contentType: "application/json",
                            success: function (data) {
                                w2ui['rolesGrid'].reload();
                            },
                            error: function (data) {
                                w2alert(data.responseJSON.error);
                            }
                        });
                    })
                    .no(function(){});
            event.preventDefault(); //previene mostrar mensaje por default
        }
        
    });   
    
    w2ui['rolesGrid'].hideColumn('recid');
});


//Funcion que abre el popup del formulario de alta de roles
function openPopup(isNew) {   
    
    if (!w2ui.rolesForm) {
        $().w2form({
            name: 'rolesForm',
            style: 'border: 0px; background-color: transparent;',
            fields: [
                { field: 'codigo', type: 'text', required: true },
                { field: 'descripcion', type: 'text', required: false }
            ],
            actions: {
                "save": function () { this.validate(); saveRole();},
                "reset": function () { this.clear(); }
            }
        });
    }
    
    
    popup = $().w2popup('open', {
        title   : 'Roles',
        body    : '<div id="form" style="width: 100%; height: 100%;"></div>',
        style   : 'padding: 15px 0px 0px 0px',
        width   : 500,
        height  : 300, 
        showMax : true,
        onToggle: function (event) {
            $(w2ui.rolesForm.box).hide();
            event.onComplete = function () {
                $(w2ui.rolesForm.box).show();
                w2ui.rolesForm.resize();
            };
        },
        onOpen: function (event) {
            event.onComplete = function () {
                // specifying an onOpen handler instead is equivalent to specifying an onBeforeOpen handler, which would make this code execute too early and hence not deliver.
                $('#w2ui-popup #form').w2render('rolesForm');
                
            };
        }
    });
    
    if(!isNew){
        //editar
        rol = w2ui['rolesGrid'].get(w2ui['rolesGrid'].getSelection())[0];
    }else{
        rol = {recid:null,codigo:"",descripcion:""}; 
    }
    w2ui.rolesForm.record=rol;
    w2ui.rolesForm.refresh();
}

/* Metodo que recibe la peticion del usuario de guardar un rol*/
function saveRole(){
    var record = w2ui.rolesForm.record;
    if(!record.recid){
        createRole(record);
    }else{
        updateRole(record);
    }
    popup.close();
}

function createRole(role){
    $.ajax({
        type: 'POST',
        url: rolesRestURL + "/create",
        data: JSON.stringify(role),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            w2ui['rolesGrid'].reload();
        },
        error: function (data) {
            w2alert(data.responseJSON.error);
        }
    });
}

function updateRole(role){
    $.ajax({
        type: 'POST',
        url: rolesRestURL + "/update",
        data: JSON.stringify(role),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            w2ui['rolesGrid'].reload();
        },
        error: function (data) {
            w2alert(data.responseJSON.error);
        }
    });
}