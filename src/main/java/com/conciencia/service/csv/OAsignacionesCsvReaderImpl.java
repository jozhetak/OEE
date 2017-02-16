package com.conciencia.service.csv;

import com.conciencia.eCSV.Reader.CSVReader;
import com.conciencia.eCSV.Reader.Exception.UnscapedSeparator;
import com.conciencia.pojo.OAsignacionDia;
import java.math.BigDecimal;

/**
 *
 * @author 0ecanval
 */
public class OAsignacionesCsvReaderImpl extends CSVReader<OAsignacionDia>{

    public OAsignacionesCsvReaderImpl(String csvFile) {
        super(csvFile);
    }

    @Override
    public OAsignacionDia map(String[] readedLine) throws UnscapedSeparator {
        OAsignacionDia asignacion = new OAsignacionDia();
        int j = 0;
        
        if(readedLine.length == 6){
            asignacion.setCodigoMaquina(readedLine[j++]);
            asignacion.setCodigoProducto(readedLine[j++]);
            asignacion.setCodigoTurno(readedLine[j++]);
            asignacion.setNombreOperador(readedLine[j++]);
            asignacion.setDuracion(new BigDecimal(readedLine[j++]));
            //como valido si es paro?
        }else{
            throw new UnscapedSeparator("");
        }
        return asignacion;
    }
    
}
