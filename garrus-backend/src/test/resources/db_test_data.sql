TRUNCATE  `entry`;
TRUNCATE `users`;
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



INSERT INTO `users` values ('konum','1234','Guillermo Gefaell','ROLE_ADMIN,ROLE_USER');
INSERT INTO `users` values ('user','1234','Normal User','ROLE_USER');
