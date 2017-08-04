/**
 * Query que crea la tabla de turnos.
 * 
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `turnos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(15) DEFAULT NULL,
  `duracion` decimal(10,0) DEFAULT NULL,
  `descripcion`  VARCHAR(45),
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `oee_db`.`turnos` (`codigo`, `duracion`, `descripcion`) VALUES ('t01', '6', 'Matutino');
INSERT INTO `oee_db`.`turnos` (`codigo`, `duracion`, `descripcion`) VALUES ('t01', '6', 'Vespertino');
INSERT INTO `oee_db`.`turnos` (`codigo`, `duracion`, `descripcion`) VALUES ('t03', '5', 'Nocturno');