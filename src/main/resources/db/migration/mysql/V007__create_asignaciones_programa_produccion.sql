/**
 * Query que crea la tabla de asignaciones al programa de produccion 
 *
 * Author:  Ernesto Cantu Valle
 * Created: 24/11/2016
 */
CREATE TABLE `asignaciones_programa_produccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `maquina` bigint(20) DEFAULT NULL,
  `producto` bigint(20) DEFAULT NULL,
  `turno` bigint(20) DEFAULT NULL,
  `operador` bigint(20) DEFAULT NULL,
  `duracion` decimal(18,5) DEFAULT NULL,
  `es_paro` tinyint(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
