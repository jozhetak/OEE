package com.conciencia.service.impl;

import com.conciencia.mapper.OAsignacionDiaMapper;
import com.conciencia.pojo.CMaquina;
import com.conciencia.pojo.CTurno;
import com.conciencia.pojo.OAsignacionDia;
import com.conciencia.service.CMaquinaService;
import com.conciencia.service.CParoProgramadoService;
import com.conciencia.service.CProductoService;
import com.conciencia.service.CRateProduccionService;
import com.conciencia.service.CTurnoService;
import com.conciencia.service.OAsignacionDiaService;
import com.conciencia.service.SysUserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Clase que define las operaciones a realizar con los objetos asignacion
 * 
 * @author Ernesto Cantu Valle
 * Conciencia
 * 28/01/2017
 */
@Service("OAsignacionDiaService")
public class OAsignacionDiaServiceImpl implements OAsignacionDiaService {
    
    @Resource
    OAsignacionDiaMapper asignacionDiaMapper;
    
    @Resource
    CMaquinaService maquinaService;
    
    @Resource
    CProductoService productoService;
    
    @Resource
    CParoProgramadoService paroService;
    
    @Resource
    SysUserService userService;
    
    @Resource
    CTurnoService turnoService;
    
    @Resource
    CRateProduccionService rateService;
    
    @Override
    public OAsignacionDia findOne(Long id) {
        return asignacionDiaMapper.findOne(id);
    }
        
    /**
     * Método que regresa una lista de asignaciones por máquina.
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @return una lista de asignaciones por máquina
     */
    @Override
    public List<OAsignacionDia> findAll(){
        return asignacionDiaMapper.findAll();
    }

    /**
     * Método que regresa una lista de asignaciones para un operador
     * 
     * Utilizado por:
     * 
     * 1.- Grid (Rest Service - getAll)
     * 
     * @param id id del operador
     * @return una lista de Asignaciones
     */
    @Override
    public List<OAsignacionDia> findAllByOperador(Long id) {
        return asignacionDiaMapper.findAllByOperador(id);
    }
    
    /**
     * Método que se encargará de validar e insertar las asignaciones del día así
     * como generar un reporte correspondiente.
     *
     * Pseudocódigo:
     * 
     * 1.- Obtiene el tiempo disponible de cada máquina-turno en la base de datos
     * 2.- Por cada asignacion leida del archivo de asignaciones, 
     * 
     * Validaciones:
     * 
     * 1.- Existe la máquina
     * 2.- Existe el turno
     * 3.- Existe el producto
     * 4.- Existe el usuario asignado como operador
     * 5.- Existe un estandar de produccion para la maquina-producto.
     * 6.- Aun hay tiempo disponible para producción en el turno
     * 
     * @param asignacionesDia Lista de asignaciones
     */
    @Override
    public List<String> insertAsignacionesIntoDataBase(List<OAsignacionDia> asignacionesDia){
        
        asignacionDiaMapper.deleteAsignaciones();
        Map<String,BigDecimal> tiempoDisponibleMaquinaTurno = getDuracionMaquinaTurno();
        Long idMaquina,idTurno,idProducto,idUsuario;
        String key;
        Boolean existeMaquina,existeTurno,existeProducto,existeUsuario,existeRate,hayTiempoDisponible;
        Date hoy = new Date();
        BigDecimal tiempoDisponible;   
        List<String> loadLog = new ArrayList<>();
        int contador = 1;
        
        for(OAsignacionDia asignacion: asignacionesDia){
            key = asignacion.getCodigoMaquina().
                            concat("-").
                            concat(asignacion.getCodigoTurno());
            
           idMaquina = maquinaService.findByCode(asignacion.getCodigoMaquina());
           existeMaquina = idMaquina != null;
           
           idTurno = turnoService.findByCode(asignacion.getCodigoTurno());
           existeTurno = idTurno != null;
           
           if(!asignacion.getEsParo()){
               idProducto = productoService.findByCode(asignacion.getCodigoProducto());
           }else{
               idProducto = paroService.findByCode(asignacion.getCodigoProducto());
           }
           existeProducto = idProducto != null;
           
           idUsuario = userService.findByCode(asignacion.getNombreOperador());
           existeUsuario = idUsuario != null;
           
           if(!asignacion.getEsParo()){
               existeRate = rateService.findByMaquinaProducto(idMaquina, idProducto);
           }else
               existeRate = true;
           
           
           tiempoDisponible = tiempoDisponibleMaquinaTurno.get(key);
           hayTiempoDisponible = !tiempoDisponible.equals(BigDecimal.ZERO);
           
           if(!existeMaquina){
               loadLog.add("No se encontró la máquina " + asignacion.getCodigoMaquina() + " del registro " + contador);
           }
           
           if(!existeTurno){
               loadLog.add("No se encontró el turno " + asignacion.getCodigoTurno()+ " del registro " + contador);
           }
           
           if(!existeProducto){
               loadLog.add("No se encontró al producto " + asignacion.getCodigoProducto() + " del registro " + contador);
           }
           
           if(!existeUsuario){
               loadLog.add("No se encontró al operador " + asignacion.getNombreOperador()+ " del registro " + contador);
           }
           
           if(!existeRate){               
               loadLog.add("No se encontró un rate de produccion para el producto " 
                       + asignacion.getCodigoProducto() + " y la máquina " + 
                       asignacion.getCodigoMaquina() + " del registro " + contador);
           }
           
           if(!hayTiempoDisponible){
               loadLog.add("Se excedió el tiempo asignado a la máquina " + asignacion.getCodigoMaquina()+ " del registro " + contador);
           }
           
           if(existeMaquina && 
                   existeTurno && 
                   existeProducto && 
                   existeUsuario && 
                   existeRate && 
                   hayTiempoDisponible){
           
               asignacion.setMaquina(idMaquina); 
               asignacion.setTurno(idTurno);
               asignacion.setProducto(idProducto);
               asignacion.setOperador(idUsuario);
               asignacion.setFecha(hoy);
               tiempoDisponibleMaquinaTurno.put(key,tiempoDisponible.subtract(asignacion.getDuracion()));
               
               asignacionDiaMapper.insertAsignacion(asignacion);
           }
           
           contador++;
        }
        return loadLog;
    }
    
    /**
     * Método privado que me proporcionará una estructura de datos para tener la 
     * relación de tiempo usado para la máquina durante un turno.
     * 
     * Durante un día productivo, todas las máquinas tienen por turno la duracion
     * del tiempo del turno disponible para producir. De este modo, creo una estructura
     * de datos del tipo Map la cual me informará el tiempo disponible para producir
     * usando como llave del mapa "maquina-producto".
     * 
     * @return un objeto map que me dirá el tiempo disponible del turno por máquina.
     */
    private Map<String,BigDecimal> getDuracionMaquinaTurno(){
        Map<String,BigDecimal> tiempoDisponibleTurnoMaquina = new HashMap<>();
        List<CMaquina> maquinas = maquinaService.findAll();
        List<CTurno> turnos = turnoService.findAll();
        
        for(CMaquina maquina:maquinas){
            for(CTurno turno:turnos){
                tiempoDisponibleTurnoMaquina.put(
                        maquina.getCodigo().
                                concat("-").
                                concat(turno.getCodigo()), 
                        turno.getDuracion());
            }
        }
        return tiempoDisponibleTurnoMaquina;
    }

    @Override
    public Date getUltimaFechaAsignacionGeneral() {
        return asignacionDiaMapper.getUltimaFechaAsignacionGeneral();
    }

    @Override
    public Date getUltimaFechaAsignacionOperador(Long operador) {
        return asignacionDiaMapper.getUltimaFechaAsignacionOperador(operador);
    }

    @Override
    public Integer getNumerAsignacionesGeneral(Date fecha) {
        return asignacionDiaMapper.getNumeroAsignacionesGeneral(fecha);
    }

    @Override
    public Integer getNumerAsignacionesOperador(Date fecha, Long operador) {
        return asignacionDiaMapper.getNumeroAsignacionesOperador(fecha, operador);
    }

    @Override
    public Integer getNumerReportadasGeneral(Date fecha) {
        return asignacionDiaMapper.getNumeroReportadasGeneral(fecha);
    }

    @Override
    public Integer getNumerReportadasOperador(Date fecha, Long operador) {
        return asignacionDiaMapper.getNumeroReportadasOperador(fecha, operador);
    }

    
}
