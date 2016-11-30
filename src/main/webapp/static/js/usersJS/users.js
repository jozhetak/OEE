/**
 * users.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de usuarios
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
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

var usersRestURL = 'rest/sysUser';
$(function () {    
    $('#grid').w2grid({ 
        name: 'usersGrid', 
        method: 'GET',
        url: usersRestURL,
        show: { 
            toolbar: true,
            usersFormter: true,
            toolbarAdd: true,
            toolbarDelete: true,
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
        actions:{
            
        },
        onAdd: function (event) {
            //w2alert('add');
            newObject = {};
            openPopup(newObject);
        },
        onEdit: function (event) {
            //w2alert('edit');
            objectToEdit = this.get(this.getSelection());
            openPopup(objectToEdit);
        },
        onDelete: function (event) {
            objectToDelete = this.get(this.getSelection())[0]; //regresa un array de objetos seleccionados
            
            w2confirm(delete_options)
                    .yes(function(){
                        $.ajax({
                            type: 'POST',
                            url: "rest/sysUser/delete",
                            data: JSON.stringify(objectToDelete),
                            dataType: "json",
                            contentType: "application/json",
                            success: function (data) {
                                w2ui['usersGrid'].reload();
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
});


function openPopup(user) {
    if (!w2ui.usersForm) {
        $().w2form({
            name: 'usersForm',
            style: 'border: 0px; background-color: transparent;',
            formHTML: 
                '<div class="w2ui-page page-0">'+
                '    <div class="w2ui-field">'+
                '        <label>Name:</label>'+
                '        <div>'+
                '           <input name="first_name" type="text" maxlength="100" style="width: 250px"/>'+
                '        </div>'+
                '    </div>'+
                '    <div class="w2ui-field">'+
                '        <label>Last Name:</label>'+
                '        <div>'+
                '            <input name="last_name" type="text" maxlength="100" style="width: 250px"/>'+
                '        </div>'+
                '    </div>'+
                '    <div class="w2ui-field">'+
                '        <label>Email:</label>'+
                '        <div>'+
                '            <input name="email" type="text" style="width: 250px"/>'+
                '        </div>'+
                '    </div>'+
                '</div>'+
                '<div class="w2ui-buttons">'+
                '    <button class="w2ui-btn" name="reset">Reset</button>'+
                '    <button class="w2ui-btn" name="save">Save</button>'+
                '</div>',
            fields: [
                { field: 'first_name', type: 'text', required: true },
                { field: 'last_name', type: 'text', required: true },
                { field: 'email', type: 'email' }
            ],
            record: { 
                first_name    : 'John',
                last_name     : 'Doe',
                email         : 'jdoe@email.com'
            },
            actions: {
                "save": function () { this.validate(); },
                "reset": function () { this.clear(); }
            }
        });
    }
    $().w2popup('open', {
        title   : 'Form in a Popup',
        body    : '<div id="form" style="width: 100%; height: 100%;"></div>',
        style   : 'padding: 15px 0px 0px 0px',
        width   : 500,
        height  : 300, 
        showMax : true,
        onToggle: function (event) {
            $(w2ui.usersForm.box).hide();
            event.onComplete = function () {
                $(w2ui.usersForm.box).show();
                w2ui.usersForm.resize();
            };
        },
        onOpen: function (event) {
            event.onComplete = function () {
                // specifying an onOpen handler instead is equivalent to specifying an onBeforeOpen handler, which would make this code execute too early and hence not deliver.
                $('#w2ui-popup #form').w2render('usersForm');
            };
        }
    });
}