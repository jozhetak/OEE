/**
 * Query que crea la tabla de roles de usuarios
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `oee_db`.`roles` (`codigo`, `descripcion`) VALUES ('SA', 'admin');
INSERT INTO `oee_db`.`roles` (`codigo`, `descripcion`) VALUES ('ADMIN', 'admin');
INSERT INTO `oee_db`.`roles` (`codigo`, `descripcion`) VALUES ('OPER', 'oper');