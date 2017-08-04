/**
 * Query que crea la tabla de rates de produccion
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `rates_produccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_maquina` bigint(20) DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL,
  `unidades_minuto` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

