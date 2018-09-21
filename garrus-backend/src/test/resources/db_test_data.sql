TRUNCATE  `entry`;
TRUNCATE `leaves`;
TRUNCATE `ride`;
TRUNCATE `users`;
TRUNCATE `sector`;
TRUNCATE `division`;
TRUNCATE `vehicle`;

LOCK TABLES `vehicle` WRITE;
INSERT INTO `vehicle` VALUES ('FYJA-44','gasolina','Camioneta','coche alcalde','2017','Honda','Hilux','22222222-2','2019-02-26','214-55 R18','2018-06-26','2018-10-26',0);
INSERT INTO `vehicle` VALUES ('JYSH-22','diesel','Bus','Bus escolar','2017','Honda','Hilux','22222222-2','2019-02-26','214-55 R18','2018-06-26','2018-10-26',0);
INSERT INTO `vehicle` VALUES ('UKWH-33','gasolina','Tractor','JAC','2017','Honda','Hilux','11111111-1','2019-02-26','214-55 R18','2018-06-26','2018-10-26',0);
INSERT INTO `vehicle` VALUES ('LAKN-55','gasolina','Ambulancia','Ram payne','2017','Honda','Hilux','11111111-1','2019-02-26','214-55 R18','2018-06-26','2018-10-26',1);
UNLOCK TABLES;


LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;



INSERT INTO `driver` values ('22222222-2', 'Walter','2019-02-26');
INSERT INTO `driver` values ('11111111-1', 'Danilo','2019-02-26');

  
INSERT INTO `entry` values (1,'Cambio de aceite 10W40','FYJA-44','2018-07-20');
INSERT INTO `entry` values (2,'Recarga de combustible 20.000$','FYJA-44','2018-07-21');
INSERT INTO `entry` values (3,'Revisión de frenos.','FYJA-44','2018-07-22');


INSERT INTO `division` values ('Administracion','Administración municipal');

INSERT INTO `sector` values ('Servicios generales','Servicios generales (vehiculos)','Administracion', 'MODULE_VEHICLE_ACCESS,MODULE_VEHICLE_MODIFY');

INSERT INTO `users` values ('konum','hola','Guillermo Gefaell','ROLE_USER');
INSERT INTO `users` values ('cbueno','8819','Cecilia Bueno','ROLE_USER');


/* Hours are in UTC */
INSERT INTO `ride` values ('1','FYJA-44','11111111-1','2018-07-27 16:00:00','2018-07-27 17:00:00','VIaje a natales','120');
INSERT INTO `ride` values ('2','UKWH-33','11111111-1','2018-07-26 11:00:00','2018-07-26 16:00:00','VIaje a PUQ','800');
INSERT INTO `ride` values ('3','JYSH-22','22222222-2','2018-07-26 10:00:00','2018-07-26 14:00:00','VIaje a guido','100');
INSERT INTO `ride` values ('4','JYSH-22','22222222-2','2018-07-27 10:00:00','2018-07-27 11:00:00','VIaje a guido','100');

INSERT into `leaves` values (1,'22222222-2','2018-07-28','2018-07-29'); 