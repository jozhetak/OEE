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
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `oee_db`.`productos` (`codigo`, `descripcion`, `unidad_produccion`) VALUES ('p01', 'Producto 01', '1');
INSERT INTO `oee_db`.`productos` (`codigo`, `descripcion`, `unidad_produccion`) VALUES ('p02', 'Producto 02', '1');