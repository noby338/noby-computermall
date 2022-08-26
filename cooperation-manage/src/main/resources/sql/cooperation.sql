-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: noby_computermall
-- ------------------------------------------------------
-- Server version	5.7.19

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

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `components_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `supplier_components_id_fk` (`components_id`),
  CONSTRAINT `supplier_components_id_fk` FOREIGN KEY (`components_id`) REFERENCES `components` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='供应商';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'英特尔',1),(2,'AMD',1),(3,'华硕',2),(4,'微星',2),(5,'技嘉',2),(6,'七彩虹',3),(7,'影驰',3),(8,'蓝宝石',3),(9,'影驰',4),(10,'威刚',4),(11,'联想',4),(12,'七彩虹',4),(13,'三星',5),(14,'西部数据',5),(15,'希捷',5),(16,'酷冷至尊',6),(17,'先马',6),(18,'长城',7),(19,'安钛克',7),(20,'海盗船',8),(21,'猫头鹰',8),(22,'三星',9),(23,'LG',9);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `states` int(11) DEFAULT NULL COMMENT '1：正常；2：缺货；',
  PRIMARY KEY (`id`),
  KEY `model_supplier_id_fk` (`supplier_id`),
  CONSTRAINT `model_supplier_id_fk` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='各配件型号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'i7 8700k',1,2899.00,1),(2,'i5 8400',1,2100.00,1),(3,'Ryzen 5 5600X',2,1500.00,1),(4,'Ryzen 9 3900X',2,1340.00,1),(5,'PRIME H510M-F',3,790.00,1),(6,'PRIME H610M-K',3,870.00,1),(7,'MAG B660M MORTAR WIFI DDR4',4,980.00,0),(8,'MPG B550I GAMING EDGE MAX Wifi',4,1050.00,1),(9,'B660M GAMING DDR4',5,580.00,1),(10,'H610M H DDR4 ',5,460.00,1),(11,'GeForce RTX 3070 Ti 8G 1770',6,4050.00,1),(12,'1660s GeForce GTX 1660 SUPER',6,1300.00,1),(13,'GeForce RTX 3060 12GB ',7,3050.00,1),(14,'GeForce RTX 3070 Ti 8G',7,3899.00,1),(15,'RX 6950XT',8,3799.00,1),(16,'6900XT',8,3299.00,1),(17,'GAMER RGB DDR5 32GB(16GB×2)',9,560.00,1),(18,'HOF Pro RGB DDR4 3600 32GB(8GB×4)',9,850.00,1),(19,'XPG DDR4 3200 8G',10,699.00,1),(20,'万紫千红 DDR4 2400 8G',10,799.00,1),(21,'红靡战甲 Master大师 DDR4 3200 32GB(16GB×2)',11,999.00,1),(22,'炫光RGB DDR4 3200 16GB(8GB×2)',11,850.00,1),(23,'iGame DDR4 3000 8GB',12,759.00,1),(24,'CVN Guardian 捍卫者 RGB DDR5 6000 16GB',12,1050.00,1),(25,'970 EVO Plus',13,2020.00,1),(26,'970 PRO',13,1200.00,0),(27,'My Passport SSD',14,999.00,1),(28,'WD_BLACK P50',14,2222.11,1),(29,'4TB 64MB 5900R',15,399.00,1),(30,'4TB 256MB 5400',15,359.00,1),(31,'Q300L',16,569.00,1),(32,'MB520',16,499.00,1),(33,'平头哥M2',17,659.00,1),(34,'朱雀air',17,399.00,1),(35,'小钢炮X500',18,109.00,1),(36,'冰龙400mini',18,79.00,1),(37,'DF700 FLUX',19,80.00,1),(38,'GX300 - GX',19,101.00,1),(39,'H100i RGB PRO XT',20,304.00,1),(40,'CWCH60',20,78.00,0),(41,'NH-D15',21,108.00,1),(42,'NH-D15S',21,201.00,1),(43,'S27R356FHC',22,899.00,1),(44,'C49HG90DMC',22,7999.00,1),(45,'LG 27GP850',23,2799.00,1),(46,'LG 27UL650-W',23,2099.00,1);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `components`
--

DROP TABLE IF EXISTS `components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `components` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `components`
--

LOCK TABLES `components` WRITE;
/*!40000 ALTER TABLE `components` DISABLE KEYS */;
INSERT INTO `components` VALUES (1,'CPU'),(2,'主板'),(3,'显卡'),(4,'内存'),(5,'硬盘'),(6,'机箱'),(7,'电源'),(8,'散热器'),(9,'显示器');
/*!40000 ALTER TABLE `components` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-26 23:36:27
