/**
 * Query que crea la tabla de roles de usuarios
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
