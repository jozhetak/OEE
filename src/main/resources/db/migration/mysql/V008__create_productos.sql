/**
 * Query que crea la tabla de productos.
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `unidad_produccion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_unidad_producto` (`unidad_produccion`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

