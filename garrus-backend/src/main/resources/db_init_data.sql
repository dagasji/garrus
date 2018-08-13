TRUNCATE `users`;



LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


INSERT INTO `users` values ('konum','1234','God User','ROLE_ADMIN,ROLE_USER');
INSERT INTO `users` values ('user','1234','Normal User','ROLE_USER');
