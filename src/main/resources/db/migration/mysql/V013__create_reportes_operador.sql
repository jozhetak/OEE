/**
 * Query que crea la tabla de reportes de operador 
 *
 * Author:  Ernesto Cantu Valle
 * Created: 24/11/2016
 */
CREATE TABLE `reportes_operador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_asignacion` bigint(20) DEFAULT NULL,
  `tiempo_efectivo_produccion` decimal(18,5) DEFAULT NULL,
  `unidades_producidas` decimal(18,5) DEFAULT NULL,
  `informacion_adicional` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;