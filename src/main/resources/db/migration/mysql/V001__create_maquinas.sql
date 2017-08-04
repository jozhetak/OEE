/**
 * Query que crea la tabla de maquinas.
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `maquinas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(15) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `unidad_produccion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

