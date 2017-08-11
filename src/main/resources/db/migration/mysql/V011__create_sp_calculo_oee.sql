/**
 * Query que crea el stored procedure dinámico del calculo de OEE
 * Author:  Ernesto Cantu Valle
 * Created: 10/08/2017
 */
DROP PROCEDURE IF EXISTS oee_db.SELECT_OEE ;

DELIMITER $$
$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `oee_db`.`SELECT_OEE`(
	IN fecha_inicio DATE,
	IN fecha_fin DATE
)
BEGIN
	
	DECLARE num_dias INT DEFAULT 1;
	SELECT datediff(fecha_fin,fecha_inicio) INTO num_dias;
	
	IF num_dias = 0 THEN SET num_dias = 1;
	END IF;
	
	SELECT 
		OEE.MAQUINA as recid, 
		OEE.CODIGO_MAQUINA as codigo, 
		TRUNCATE((OEE.TIEMPO_EFECTIVO_PROD / OEE.TIEMPO_DISPONIBLE),5) AS disponibilidad, 
		TRUNCATE((OEE.CANTIDAD_PRODUCIDA/OEE.CANTIDAD_ESPERADA),5) AS rendimiento, 
		TRUNCATE((OEE.ACEPTADAS/OEE.CANTIDAD_PRODUCIDA),5) AS calidad, 
		TRUNCATE(( 
			TRUNCATE((OEE.TIEMPO_EFECTIVO_PROD / OEE.TIEMPO_DISPONIBLE),5)  * 
			TRUNCATE((OEE.CANTIDAD_PRODUCIDA/OEE.CANTIDAD_ESPERADA),5) * 
			TRUNCATE((OEE.ACEPTADAS/OEE.CANTIDAD_PRODUCIDA),5) 
		),5) AS oee 
		FROM 
		( 
			SELECT 
		       m.ID AS MAQUINA, 
		       m.codigo AS CODIGO_MAQUINA, 
		       SUM(rep.tiempo_efectivo_produccion) AS TIEMPO_EFECTIVO_PROD, 
		       (
		       		SELECT 
			           (num_dias * (SELECT SUM(turnos.duracion) FROM turnos)) - 
			           SUM(asignaciones_programa_produccion.duracion) tiempo_disponible_maquina 
			       FROM asignaciones_programa_produccion 
			  	   WHERE asignaciones_programa_produccion.es_paro = 1 
			       AND asignaciones_programa_produccion.fecha >= fecha_inicio
			       AND asignaciones_programa_produccion.fecha <= fecha_fin
			       AND maquina = m.id 
		       ) AS TIEMPO_DISPONIBLE, 
		   	   SUM(rep.unidades_producidas) AS CANTIDAD_PRODUCIDA, 
		   	   SUM(rep.tiempo_efectivo_produccion*r.unidades_minuto) AS CANTIDAD_ESPERADA, 
			   SUM(rep.unidades_aceptadas) AS ACEPTADAS  
			FROM asignaciones_programa_produccion a 
			JOIN maquinas m ON a.maquina = m.id 
			JOIN productos p ON a.producto = p.id 
			JOIN reportes_operador rep ON a.id = rep.asignacion 
			JOIN rates_produccion r ON a.maquina = r.maquina AND a.producto = r.producto 
			WHERE a.es_paro = 0 AND a.fecha >= fecha_inicio AND a.fecha <= fecha_fin
			GROUP BY a.maquina 
		)OEE;
END $$
DELIMITER ;
