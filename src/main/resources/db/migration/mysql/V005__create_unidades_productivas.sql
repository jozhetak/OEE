/**
 * Query que crea el catálogo de unidades
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `unidades_productivas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `oee_db`.`unidades_productivas` (`codigo`, `descripcion`) VALUES ('pza', 'Piezas');