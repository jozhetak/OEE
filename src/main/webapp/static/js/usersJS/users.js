/**
 * users.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de usuarios
 * 
 * Ernesto Cantú
 * Conciencia
 * 26/11/2016
 */



var usersRestURL = 'rest/sysUser';



$(document).ready(function(){
   $('#usuarios').DataTable({
        "ajax": usersRestURL,
        "columns": [
            { "data": "recid" },
            { "data": "userName" },
            { "data": "name" },
            { "data": "rolName" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "paging":false
    });    
});

    
$(function () {
    $('#usuarios tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            $("#updateButton").addClass("disabled");
            $("#deleteButton").addClass("disabled");
        }
        else {
            $('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            $("#updateButton").removeClass("disabled");
            $("#deleteButton").removeClass("disabled");
        }
    } );
    
    $("#addButton").click(function(){
        alert("nuevo usuario");
    });
    
    $("#updateButton").click(function(){
        if(!$("#updateButton").hasClass("disabled")){
            alert("update usuario");
        }
        
        var table = $('#asignacionesTable').DataTable();
        var user = table.row('.selected').data();
    });
    
    $("#deleteButton").click(function(){
        if(!$("#deleteButton").hasClass("disabled")){
            var del = confirm("Desea eliminar este usuario?");
            if(del){
                var table = $('#usuarios').DataTable();
                var user = table.row('.selected').data();
                $.ajax({
                    type: 'POST',
                    url: usersRestURL + '/delete',
                    data: JSON.stringify(user),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data) {
                        table.ajax.reload();
                    },
                    error: function (data) {
                        alert(data.responseJSON.error);
                    }
                });
                $("#updateButton").addClass("disabled");
                $("#deleteButton").addClass("disabled");
            }
        }
    });
});    