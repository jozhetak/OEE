/**
 * Query que crea la tabla de usuarios.
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `rol_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



INSERT INTO `oee_db`.`usuarios` (`nombre`, `user_name`, `password`, `rol_id`) VALUES ('ernesto cantu', 'ecv', '4747819', '1');
INSERT INTO `oee_db`.`usuarios` (`nombre`, `user_name`, `password`, `rol_id`) VALUES ('ernesto cantu', 'admin', '1234', '2');
INSERT INTO `oee_db`.`usuarios` (`nombre`, `user_name`, `password`, `rol_id`) VALUES ('operador_m01', 'm01', '1234', '3');
INSERT INTO `oee_db`.`usuarios` (`nombre`, `user_name`, `password`, `rol_id`) VALUES ('operador_m02', 'm02', '1234', '3');