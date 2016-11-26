/**
 * Query que crea la tabla de rates de produccion
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `rates_produccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_planta` bigint(20) DEFAULT NULL,
  `id_maquina` bigint(20) DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL,
  `unidades_hora` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_rate_maquina` (`id_maquina`) USING BTREE,
  KEY `idx_rate_producto` (`id_producto`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

