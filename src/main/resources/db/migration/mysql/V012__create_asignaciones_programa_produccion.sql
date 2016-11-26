/**
 * Query que crea la tabla de asignaciones al programa de produccion 
 *
 * Author:  Ernesto Cantu Valle
 * Created: 24/11/2016
 */
CREATE TABLE `asignaciones_programa_produccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_programa` bigint(20) DEFAULT NULL,
  `id_planta` bigint(20) DEFAULT NULL,
  `maquina` bigint(20) DEFAULT NULL,
  `producto` bigint(20) DEFAULT NULL,
  `turno` bigint(20) DEFAULT NULL,
  `operador` bigint(20) DEFAULT NULL,
  `duracion` decimal(18,5) DEFAULT NULL,
  `es_paro` tinyint(1) DEFAULT NULL,
  `informacion_adicional` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
