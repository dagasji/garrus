
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `plate` varchar(10) NOT NULL ,
  `gas` varchar(45) NULL,
  `vehicle_type` varchar(65) DEFAULT NULL,
  `details` varchar(45) NULL,
  `year` varchar(45) NULL,
  `brand` varchar(45) NULL,
  `model` varchar(10) NULL,
  `chofer` varchar(45) NULL,
  `soap_date` date NULL,
  `tyres` varchar(45) NULL,
  `last_maintenance` date NULL,
  `next_inspection` date NULL,
  `on_repair` int(1) NULL default 0,
  PRIMARY KEY (`plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

 ALTER TABLE `vehicle` 
ADD CONSTRAINT `vehicle_rutFK`
  FOREIGN KEY (`chofer`)
  REFERENCES `driver` (`rut`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;




--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `rut` varchar(10) NOT NULL ,
  `name` varchar(45) NULL,
  `license_expire_date` date NULL,
	PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(1000) NOT NULL ,
  `plate` varchar(10) NOT NULL,
  `date` DATE NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `entry` 
ADD INDEX `plateFK_idx` (`plate` ASC);

ALTER TABLE `entry` 
ADD CONSTRAINT `entry_plateFK`
  FOREIGN KEY (`plate`)
  REFERENCES `vehicle` (`plate`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  

DROP TABLE IF EXISTS `division`;
CREATE TABLE `division` (
  `name` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL ,
	PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sector`;
CREATE TABLE `sector` (
  `name` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL ,
  `division_name` varchar(50) NOT NULL ,
  `permissions` varchar(1000) NOT NULL ,
	PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `sector` 
ADD CONSTRAINT `sector_divisionFK`
  FOREIGN KEY (`division_name`)
  REFERENCES `division` (`name`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL ,
  `name` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ride`;
CREATE TABLE `ride` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `plate` varchar(50) NOT NULL ,
  `rut_chofer` varchar(10) NOT NULL,
  `start` datetime  NOT NULL,
  `end` datetime NULL,
  `details` varchar(500) NULL,
  `distance` INT(4) NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `ride` 
ADD CONSTRAINT `ride_plateFK`
  FOREIGN KEY (`plate`)
  REFERENCES `vehicle` (`plate`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `ride` 
ADD CONSTRAINT `ride_rutFK`
  FOREIGN KEY (`rut_chofer`)
  REFERENCES `driver` (`rut`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `rut` varchar(10) NOT NULL ,
  `start` date NOT NULL ,
  `end` date NOT NULL ,  
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 ALTER TABLE `leaves` 
ADD CONSTRAINT `leaves_rutFK`
  FOREIGN KEY (`rut`)
  REFERENCES `driver` (`rut`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

