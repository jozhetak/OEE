/**
 * Query que crea la tabla de maquinas.
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `maquinas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_planta` bigint(20) DEFAULT NULL,
  `codigo` varchar(15) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `unidad_produccion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_planta` (`id_planta`),
  KEY `idx_unidad_maquina` (`unidad_produccion`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

