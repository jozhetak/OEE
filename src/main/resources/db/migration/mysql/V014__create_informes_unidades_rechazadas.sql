/**
 * Query que crea la tabla de informe de piezas rechazadas.
 * 
 * Author:  Ernesto Cantu Valle
 * Created: 24/11/2016
 */
CREATE TABLE `informe_unidades_rechazadas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_informe_operador` bigint(20) DEFAULT NULL,
  `unidades_rechazadas` decimal(18,5) DEFAULT NULL,
  `justificacion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;