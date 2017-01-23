/**
 * plantas.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de plantas
 * 
 * Ernesto Cantú
 * Conciencia
 * 29/11/2016
 */
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

var plantasRestURL = 'rest/cPlanta';
var popup;

$(function () {    
    $('#grid').w2grid({ 
        name: 'plantasGride', 
        method: 'GET',
        url: plantasRestURL,
        show: { 
            toolbar: true,
            plantasFormter: false,
            toolbarAdd: false,
            toolbarDelete: true,
            toolbarEdit: true
        },
        toolbar:{
            items: [
                { type: 'break' },
                { type: 'button', id: 'uploadButton', caption: 'My other button', img: 'glyphicon-upload' }
            ],
            onClick: function (target, data) {
                if(target==='uploadButton'){
                    this.onUpload;
                }
            }
        },
        searches: [                
            { field: 'codigo', caption: 'Código', type: 'text' },
            { field: 'descripcion', caption: 'Descripción', type: 'text' }
        ],
        columns: [                
            { field: 'recid', caption: 'Id', size: '50px', sortable: true, attr: 'align=center' },
            { field: 'codigo', caption: 'Código', size: '30%', sortable: true },
            { field: 'descripcion', caption: 'Descripción', size: '30%', sortable: true }
        ],
        onEdit: function (event) {
            editPopup(); //informa a la funcion que se seleccionó la opcion de editar.
        },
        onDelete: function (event) {
//            objectToDelete = this.get(this.getSelection())[0]; //regresa un array de objetos seleccionados
//            
//            w2confirm(delete_options)
//                    .yes(function(){
//                        $.ajax({
//                            type: 'POST',
//                            url: plantasRestURL + "/delete",
//                            data: JSON.stringify(objectToDelete),
//                            dataType: "json",
//                            contentType: "application/json",
//                            success: function (data) {
//                                w2ui['plantasGride'].reload();
//                            },
//                            error: function (data) {
//                                w2alert(data.responseJSON.error);
//                            }
//                        });
//                    })
//                    .no(function(){});
//            event.preventDefault(); //previene mostrar mensaje por default
        }
        
    });   
    
    w2ui['plantasGride'].hideColumn('recid');
});

function uploadPopup(){
    
     if (!w2ui.uploadFormForm) {
        $().w2form({
            name: 'uploadForm',
            style: 'border: 0px; background-color: transparent;',
            fields: [
                { field: 'Ruta', type: 'text', required: true },
                { field: 'descripcion', type: 'text', required: false }
            ],
            actions: {
                "save": function () { this.validate(); savePlanta();},
                "reset": function () { this.clear(); }
            }
        });
    }
    
    popup = $().w2popup('open', {
        title   : 'Plantas',
        body    : '<div id="form" style="width: 100%; height: 100%;"></div>',
        style   : 'padding: 15px 0px 0px 0px',
        width   : 400,
        height  : 200, 
        showMax : true,
        onToggle: function (event) {
            $(w2ui.plantasForm.box).hide();
            event.onComplete = function () {
                $(w2ui.plantasForm.box).show();
                w2ui.plantasForm.resize();
            };
        },
        onOpen: function (event) {
            event.onComplete = function () {
                // specifying an onOpen handler instead is equivalent to specifying an onBeforeOpen handler, which would make this code execute too early and hence not deliver.
                $('#w2ui-popup #form').w2render('plantasForm');
                
            };
        }
    });
    
    planta = w2ui['plantasGride'].get(w2ui['plantasGride'].getSelection())[0];
    w2ui.plantasForm.record=planta;
    w2ui.plantasForm.refresh();
}



function editPopup() {   
    
    if (!w2ui.plantasForm) {
        $().w2form({
            name: 'plantasForm',
            style: 'border: 0px; background-color: transparent;',
            fields: [
                { field: 'codigo', type: 'text', required: true },
                { field: 'descripcion', type: 'text', required: false }
            ],
            actions: {
                "save": function () { this.validate(); savePlanta();},
                "reset": function () { this.clear(); }
            }
        });
    }
    
    popup = $().w2popup('open', {
        title   : 'Plantas',
        body    : '<div id="form" style="width: 100%; height: 100%;"></div>',
        style   : 'padding: 15px 0px 0px 0px',
        width   : 400,
        height  : 200, 
        showMax : true,
        onToggle: function (event) {
            $(w2ui.plantasForm.box).hide();
            event.onComplete = function () {
                $(w2ui.plantasForm.box).show();
                w2ui.plantasForm.resize();
            };
        },
        onOpen: function (event) {
            event.onComplete = function () {
                // specifying an onOpen handler instead is equivalent to specifying an onBeforeOpen handler, which would make this code execute too early and hence not deliver.
                $('#w2ui-popup #form').w2render('plantasForm');
                
            };
        }
    });
    
    planta = w2ui['plantasGride'].get(w2ui['plantasGride'].getSelection())[0];
    w2ui.plantasForm.record=planta;
    w2ui.plantasForm.refresh();
}

/* Metodo que recibe la peticion del usuario de guardar una planta*/
function savePlanta(){
    var record = w2ui.plantasForm.record;
    updatePlanta(record);
    popup.close();
}

function updatePlanta(planta){
    $.ajax({
        type: 'POST',
        url: plantasRestURL + "/update",
        data: JSON.stringify(role),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            w2ui['plantasGride'].reload();
        },
        error: function (data) {
            w2alert(data.responseJSON.error);
        }
    });
}