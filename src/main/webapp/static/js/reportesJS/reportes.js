/**
 * reportes.js Contiene todas las funcionalidades específicas para el funcionamiento
 * de la pantalla de reportes
 * 
 * Ernesto Cantú
 * Conciencia
 * 06/03/2017
 */


//URL que define la ruta de acceso al rest de asignaciones
var reportesRestURLBase = 'rest/oReporte/reporte';

$("#submitButton").click(function(){
    var duracionAsignacion = parseInt($("#duracionAsignacion").val());
    var duracionValida = false;
    var tiempoEfectivoProduccion = parseInt($("#tiempoEfectivoProduccion").val());
    var tiempoValido=false;
    var unidadesProducidas = parseInt($("#unidadesProducidas").val());
    var unidadesProducidasValidas=false;
    var unidadesAceptadas = parseInt($("#unidadesAceptadas").val());
    var unidadesAceptadasValidas=false;
    
    if(!tiempoEfectivoProduccion){
        alert("Valor inválido en el campo:Tiempo Efectivo de Produccion");
    }else{
        tiempoValido = true;
    }
    
    if(!unidadesProducidas){
        alert("Valor inválido en el campo:Unidades Producidas");
    }else{
        unidadesProducidasValidas = true;
    }
    
    if(!unidadesAceptadas){
        alert("Valor inválido en el campo:Unidades Aceptadas");
    }else{
        unidadesAceptadasValidas = true;
    }
    
    if(tiempoEfectivoProduccion > duracionAsignacion){
        alert("El tiempo efectivo de produccion es mayor a la duracion de la asignacion");
    }else{
        duracionValida = true;
    }
    
    if(duracionValida && tiempoValido && unidadesProducidasValidas && unidadesAceptadasValidas){
        var reporte = {
            recid:$("#recid").val(),
            asignacion:$("#idAsignacion").val(),
            tiempoEfectivoProduccion: tiempoEfectivoProduccion,
            unidadesProducidas: unidadesProducidas,
            unidadesAceptadas:unidadesAceptadas,
            tiempoParo: duracionAsignacion-tiempoEfectivoProduccion,
            informacionAdicional:$("#informacionAdicional").val()
        };
        
        $.ajax({
            type: 'POST',
            url: reportesRestURLBase,
            data: JSON.stringify(reporte),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                window.close();
            },
            error: function (data) {
                alert(data.responseJSON.error);
            }
        });
    }
    
    
});

$("#resetButton").click(function(){
    $("#tiempoEfectivoProduccion").val("");
    $("#unidadesProducidas").val("");
    $("#unidadesAceptadas").val("");
    $("#informacionAdicional").val("");
});

if($("#roleId").val() === "ADMIN"){
    $("#duracionAsignacion").attr("disabled","disabled");
    $("#tiempoEfectivoProduccion").attr("disabled","disabled");
    $("#unidadesProducidas").attr("disabled","disabled");
    $("#unidadesAceptadas").attr("disabled","disabled");
    $("#informacionAdicional").attr("disabled","disabled");
}