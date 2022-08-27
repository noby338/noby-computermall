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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone_num` varchar(15) DEFAULT NULL,
  `default_address` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='商户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'迪摩信息有限公司','13389143849',NULL),(2,'中建创业科技有限公司','13553245850',NULL),(3,'南康传媒有限公司','18672452499',NULL),(4,'超艺网络有限公司','18045628972',NULL),(5,'恩悌传媒有限公司','13327785665',NULL),(6,'富罳科技有限公司','13504075306',NULL),(7,'开发区世创科技有限公司','15846196576',NULL),(8,'网新恒天科技有限公司','18120551350',NULL),(9,'毕博诚科技有限公司','14552484635',NULL),(10,'黄石金承信息有限公司','13026436219',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_address`
--

DROP TABLE IF EXISTS `client_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(40) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_address_client_id_fk` (`client_id`),
  CONSTRAINT `client_address_client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='商户的收货地址';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_address`
--

LOCK TABLES `client_address` WRITE;
/*!40000 ALTER TABLE `client_address` DISABLE KEYS */;
INSERT INTO `client_address` VALUES (1,'青海省秀云县锡山南昌路S座 387926',1),(2,'福建省桂香市丰都邯郸路i座 934189',2),(3,'贵州省岩市高明齐齐哈尔路P座 835776',3),(4,'江苏省文县翔安永安路X座 399934',4),(5,'宁夏回族自治区沈阳县黄浦张路x座 108702',5),(6,'湖南省佛山市江北马路j座 274943',6),(7,'北京市秀兰县沈河海门街a座 905127',7),(8,'山东省巢湖市西峰兴安盟街x座 984194',8),(9,'陕西省海门县友好张家港路B座 844465',9),(10,'辽宁省淑珍市崇文汕尾街D座 908607',10),(11,'内蒙古自治区雪县沈北新王街U座 895590',1),(12,'河南省潜江县上街南宁街N座 562049',2),(13,'宁夏回族自治区福州县南长易路b座 573836',3),(14,'甘肃省志强县花溪高路q座 292724',4),(15,'天津市秀梅市丰都季路Y座 823190',5),(16,'甘肃省长春市华龙台北街c座 801763',6),(17,'江苏省西安县和平张路z座 921187',7),(18,'贵州省倩县龙潭李街h座 348847',8),(19,'澳门特别行政区辛集县双滦张街m座 652077',9),(20,'湖南省潜江县新城哈尔滨街L座 428019',10);
/*!40000 ALTER TABLE `client_address` ENABLE KEYS */;
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
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) DEFAULT NULL,
  `phone_num` int(11) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  `total_money` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1：未付款；2：已付款；3：已发货；4：已收货',
  PRIMARY KEY (`id`),
  KEY `purchase_order_client_id_fk` (`client_id`),
  CONSTRAINT `purchase_order_client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_item`
--

DROP TABLE IF EXISTS `purchase_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_order_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_order_item_model_id_fk` (`model_id`),
  KEY `purchase_order_item_purchase_order_id_fk` (`purchase_order_id`),
  CONSTRAINT `purchase_order_item_model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`),
  CONSTRAINT `purchase_order_item_purchase_order_id_fk` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单条目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_item`
--

LOCK TABLES `purchase_order_item` WRITE;
/*!40000 ALTER TABLE `purchase_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_record`
--

DROP TABLE IF EXISTS `purchase_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_order_id` int(11) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_record_model_id_fk` (`purchase_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='采购记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_record`
--

LOCK TABLES `purchase_record` WRITE;
/*!40000 ALTER TABLE `purchase_record` DISABLE KEYS */;
INSERT INTO `purchase_record` VALUES (1,1,'2021-12-24 00:50:31'),(2,2,'2022-03-11 08:12:46'),(3,3,'2021-07-22 04:51:30'),(4,4,'2022-01-04 20:23:26'),(5,5,'2020-11-15 19:43:16'),(6,6,'2021-02-03 19:13:18'),(7,7,'2021-10-12 03:44:50'),(8,8,'2022-02-04 14:01:08'),(9,9,'2021-03-14 02:44:33'),(10,10,'2022-06-13 15:55:39'),(11,11,'2022-02-18 20:29:17'),(12,12,'2022-05-29 17:38:32'),(13,13,'2022-08-01 02:57:55'),(14,14,'2021-02-27 17:43:57'),(15,15,'2021-05-04 07:04:44'),(16,16,'2021-08-28 04:38:49'),(17,17,'2021-03-11 21:10:09'),(18,18,'2021-07-29 05:00:48'),(19,19,'2020-11-04 00:54:01'),(20,20,'2021-10-02 17:45:38');
/*!40000 ALTER TABLE `purchase_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `components_id` int(11) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `total_capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_components_id_fk` (`components_id`),
  CONSTRAINT `store_components_id_fk` FOREIGN KEY (`components_id`) REFERENCES `components` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='库存';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,1,'浙江省杭州市清河武街S座 986711',1820,2000),(2,1,'河南省北京县梁平冯路k座 741686',1432,2000),(3,2,'吉林省建华市清河昆明路m座 690686',2346,3000),(4,2,'海南省秀梅县沙湾兰州街M座 412163',2121,3000),(5,3,'山西省静县大兴李路e座 535535',568,1000),(6,4,'河南省莹市滨城大冶路Z座 475428',1347,2000),(7,4,'陕西省彬县朝阳陈街r座 170899',900,1500),(8,5,'福建省齐齐哈尔县怀柔关岭街q座 353070',2060,3000),(9,5,'北京市勇县花溪杨街t座 204543',1302,1500),(10,6,'黑龙江省斌市清河赵街B座 783233',521,900),(11,6,'重庆市倩县清浦海口街N座 565278',409,800),(12,6,'宁夏回族自治区辛集市清浦通辽街f座 840284',413,1000),(13,7,'浙江省凤英县花溪上海街q座 477565',290,1500),(14,7,'河北省汕尾市孝南杜街H座 105965',896,1500),(15,8,'台湾省惠州市黄浦六盘水街r座 852369',2367,3000),(16,8,'香港特别行政区长沙县海港陈街m座 694599',468,3000),(17,9,'西藏自治区琴县门头沟熊路q座 534276',329,500),(18,9,'天津市鑫县东丽张街x座 897738',134,500),(19,9,'山西省秀兰县徐汇王街c座 853016',560,600),(20,9,'青海省淑兰市大东李街M座 242581',356,700);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'杨莹',38,0),(2,'吴玉',28,1),(3,'宋龙',26,0),(4,'黄红',25,0),(5,'王亮',23,1),(6,'任欢',29,1),(7,'李建平',18,0),(8,'孙淑兰',21,1),(9,'张秀英',30,1),(10,'王海燕',29,0),(11,'陈杰',40,0),(12,'张云',33,1),(13,'李丽娟',26,0),(14,'朱晨',39,1),(15,'李玉英',33,1),(16,'黄兵',19,1),(17,'胡丹丹',24,1),(18,'张刚',37,0),(19,'李冬梅',19,1),(20,'孟慧',28,0),(21,'金桂兰',31,1),(22,'江琴',28,1),(23,'赵琴',23,1),(24,'陈凯',36,0),(25,'廖莹',35,1),(26,'戴飞',29,1),(27,'李利',26,1),(28,'邓红',25,1),(29,'李斌',19,0),(30,'吴晶',35,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-27  1:44:04
