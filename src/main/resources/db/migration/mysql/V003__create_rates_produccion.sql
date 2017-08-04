/**
 * Query que crea la tabla de rates de produccion
 *
 * Author:  Ernesto Cantu Valle
 * Created: 23/11/2016
 */
CREATE TABLE `rates_produccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `maquina` bigint(20) DEFAULT NULL,
  `producto` bigint(20) DEFAULT NULL,
  `unidades_minuto` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `oee_db`.`rates_produccion` (`maquina`, `producto`, `unidades_minuto`) VALUES ('1', '1', '15');
INSERT INTO `oee_db`.`rates_produccion` (`maquina`, `producto`, `unidades_minuto`) VALUES ('1', '2', '12');
INSERT INTO `oee_db`.`rates_produccion` (`maquina`, `producto`, `unidades_minuto`) VALUES ('2', '1', '17');
INSERT INTO `oee_db`.`rates_produccion` (`maquina`, `producto`, `unidades_minuto`) VALUES ('2', '2', '10');