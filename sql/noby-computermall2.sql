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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='商户';
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='各电脑配件';
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
  `purchase_price` decimal(8,2) DEFAULT NULL COMMENT '进货价格',
  `sale_price` decimal(8,2) DEFAULT NULL COMMENT '出售价格',
  `num` int(11) DEFAULT NULL COMMENT '剩余数量',
  `supplier_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `model_supplier_id_fk` (`supplier_id`),
  KEY `model_store_id_fk` (`store_id`),
  CONSTRAINT `model_store_id_fk` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`),
  CONSTRAINT `model_supplier_id_fk` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='各配件型号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'i7 8700k',2899.00,4058.60,120,1,1),(2,'i5 8400',2100.00,2940.00,132,1,1),(3,'Ryzen 5 5600X',1500.00,2100.00,342,2,2),(4,'Ryzen 9 3900X',1340.00,1876.00,221,2,2),(5,'PRIME H510M-F',790.00,1106.00,68,3,3),(6,'PRIME H610M-K',870.00,1218.00,125,3,3),(7,'MAG B660M MORTAR WIFI DDR4',980.00,1372.00,40,4,4),(8,'MPG B550I GAMING EDGE MAX Wifi',1050.00,1470.00,35,4,4),(9,'B660M GAMING DDR4',580.00,812.00,302,5,8),(10,'H610M H DDR4 ',460.00,644.00,521,5,9),(11,'GeForce RTX 3070 Ti 8G 1770',4050.00,5670.00,409,6,5),(12,'1660s GeForce GTX 1660 SUPER',1300.00,1820.00,413,6,5),(13,'GeForce RTX 3060 12GB ',3050.00,4270.00,290,7,5),(14,'GeForce RTX 3070 Ti 8G',3899.00,5458.60,896,7,5),(15,'RX 6950XT',3799.00,5318.60,267,8,5),(16,'6900XT',3299.00,4618.60,468,8,5),(17,'GAMER RGB DDR5 32GB(16GB×2)',560.00,784.00,329,9,6),(18,'HOF Pro RGB DDR4 3600 32GB(8GB×4)',850.00,1190.00,134,9,6),(19,'XPG DDR4 3200 8G',699.00,978.60,560,10,7),(20,'万紫千红 DDR4 2400 8G',799.00,1118.60,356,10,7),(21,'红靡战甲 Master大师 DDR4 3200 32GB(16GB×2)',999.00,1398.60,820,11,7),(22,'炫光RGB DDR4 3200 16GB(8GB×2)',850.00,1190.00,432,11,7),(23,'iGame DDR4 3000 8GB',759.00,1062.60,346,12,6),(24,'CVN Guardian 捍卫者 RGB DDR5 6000 16GB',1050.00,1470.00,121,12,6),(25,'970 EVO Plus',2020.00,2828.00,568,13,8),(26,'970 PRO',1200.00,1680.00,347,13,8),(27,'My Passport SSD',999.00,1398.60,900,14,9),(28,'WD_BLACK P50',2222.11,3110.95,60,14,9),(29,'4TB 64MB 5900R',399.00,558.60,302,15,8),(30,'4TB 256MB 5400',359.00,502.60,521,15,8),(31,'Q300L',569.00,796.60,409,16,10),(32,'MB520',499.00,698.60,413,16,10),(33,'平头哥M2',659.00,922.60,290,17,11),(34,'朱雀air',399.00,558.60,896,17,12),(35,'小钢炮X500',109.00,152.60,367,18,13),(36,'冰龙400mini',79.00,110.60,468,18,13),(37,'DF700 FLUX',80.00,112.00,329,19,14),(38,'GX300 - GX',101.00,141.40,134,19,14),(39,'H100i RGB PRO XT',304.00,425.60,560,20,15),(40,'CWCH60',78.00,109.20,356,20,15),(41,'NH-D15',108.00,151.20,290,21,16),(42,'NH-D15S',201.00,281.40,896,21,16),(43,'S27R356FHC',899.00,1258.60,367,22,17),(44,'C49HG90DMC',7999.00,11198.60,468,22,18),(45,'LG 27GP850',2799.00,3918.60,329,23,19),(46,'LG 27UL650-W',2099.00,2938.60,329,23,20);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS sale_order;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_num` int(11) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  `total_money` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1：未付款；2：已付款；3：已发货；4：已收货',
  `client_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_order_client_id_fk` (`client_id`),
  CONSTRAINT `purchase_order_client_id_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES sale_order WRITE;
/*!40000 ALTER TABLE sale_order DISABLE KEYS */;
/*!40000 ALTER TABLE sale_order ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order_item`
--

DROP TABLE IF EXISTS sale_cart_item;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `purchase_order_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_order_item_model_id_fk` (`model_id`),
  KEY `purchase_order_item_purchase_order_id_fk` (`purchase_order_id`),
  CONSTRAINT `purchase_order_item_model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`),
  CONSTRAINT `purchase_order_item_purchase_order_id_fk` FOREIGN KEY (`purchase_order_id`) REFERENCES sale_order (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单条目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_item`
--

LOCK TABLES sale_cart_item WRITE;
/*!40000 ALTER TABLE sale_cart_item DISABLE KEYS */;
/*!40000 ALTER TABLE sale_cart_item ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_record`
--

DROP TABLE IF EXISTS sale_record;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `purchase_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `purchase_record_model_id_fk` (`purchase_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='采购记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_record`
--

LOCK TABLES sale_record WRITE;
/*!40000 ALTER TABLE sale_record DISABLE KEYS */;
INSERT INTO sale_record VALUES (1,'2021-12-24 00:50:31',1),(2,'2022-03-11 08:12:46',2),(3,'2021-07-22 04:51:30',3),(4,'2022-01-04 20:23:26',4),(5,'2020-11-15 19:43:16',5),(6,'2021-02-03 19:13:18',6),(7,'2021-10-12 03:44:50',7),(8,'2022-02-04 14:01:08',8),(9,'2021-03-14 02:44:33',9),(10,'2022-06-13 15:55:39',10),(11,'2022-02-18 20:29:17',11),(12,'2022-05-29 17:38:32',12),(13,'2022-08-01 02:57:55',13),(14,'2021-02-27 17:43:57',14),(15,'2021-05-04 07:04:44',15),(16,'2021-08-28 04:38:49',16),(17,'2021-03-11 21:10:09',17),(18,'2021-07-29 05:00:48',18),(19,'2020-11-04 00:54:01',19),(20,'2021-10-02 17:45:38',20);
/*!40000 ALTER TABLE sale_record ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(40) DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT '已用容量',
  `total_capacity` int(11) DEFAULT NULL COMMENT '仓库总容量',
  `components_id` int(11) DEFAULT NULL,
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
INSERT INTO `store` VALUES (1,'浙江省杭州市清河武街S座 986711',252,2000,1),(2,'河南省北京县梁平冯路k座 741686',563,2000,1),(3,'吉林省建华市清河昆明路m座 690686',193,3000,2),(4,'海南省秀梅县沙湾兰州街M座 412163',75,3000,2),(5,'山西省静县大兴李路e座 535535',2743,3000,3),(6,'河南省莹市滨城大冶路Z座 475428',930,2000,4),(7,'陕西省彬县朝阳陈街r座 170899',2168,1500,4),(8,'福建省齐齐哈尔县怀柔关岭街q座 353070',2040,3000,5),(9,'北京市勇县花溪杨街t座 204543',1481,1500,5),(10,'黑龙江省斌市清河赵街B座 783233',822,900,6),(11,'重庆市倩县清浦海口街N座 565278',290,800,6),(12,'宁夏回族自治区辛集市清浦通辽街f座 840284',896,1000,6),(13,'浙江省凤英县花溪上海街q座 477565',835,1500,7),(14,'河北省汕尾市孝南杜街H座 105965',463,1500,7),(15,'台湾省惠州市黄浦六盘水街r座 852369',916,3000,8),(16,'香港特别行政区长沙县海港陈街m座 694599',1186,3000,8),(17,'西藏自治区琴县门头沟熊路q座 534276',367,500,9),(18,'天津市鑫县东丽张街x座 897738',468,500,9),(19,'山西省秀兰县徐汇王街c座 853016',329,600,9),(20,'青海省淑兰市大东李街M座 242581',329,700,9);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_record`
--

DROP TABLE IF EXISTS `store_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `store_record_model_id_fk` (`model_id`),
  KEY `store_record_store_id_fk` (`store_id`),
  CONSTRAINT `store_record_model_id_fk` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`),
  CONSTRAINT `store_record_store_id_fk` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='出库入库记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_record`
--

LOCK TABLES `store_record` WRITE;
/*!40000 ALTER TABLE `store_record` DISABLE KEYS */;
INSERT INTO `store_record` VALUES (1,-15,'2022-05-31 10:02:19',14,10),(2,39,'2021-11-28 01:03:44',14,5),(3,200,'2022-03-31 02:31:08',20,16),(4,-97,'2021-09-10 02:14:43',14,11),(5,205,'2022-05-16 08:52:02',8,16),(6,209,'2021-09-13 09:06:47',3,17),(7,-65,'2022-06-18 13:23:13',2,9),(8,-76,'2022-03-04 21:48:55',2,18),(9,-10,'2021-09-28 00:03:07',11,45),(10,-224,'2022-04-27 12:37:13',17,42),(11,236,'2022-06-11 09:04:04',15,45),(12,-143,'2021-12-16 06:58:28',18,18),(13,-251,'2022-06-24 19:51:05',10,6),(14,270,'2021-10-31 08:22:14',1,6),(15,-144,'2022-05-30 10:56:47',14,25),(16,-145,'2022-03-26 01:04:14',7,27),(17,7,'2022-02-09 01:52:12',9,4),(18,36,'2022-06-05 10:11:19',5,5),(19,-239,'2022-03-02 22:37:36',2,34),(20,-2,'2021-09-24 05:39:20',4,38),(21,-250,'2022-01-18 20:28:03',19,44),(22,-191,'2021-09-26 04:35:17',5,8),(23,298,'2021-08-27 23:06:54',19,25),(24,-237,'2022-08-12 09:37:32',10,31),(25,279,'2021-09-10 20:25:15',9,33),(26,42,'2022-07-20 01:42:24',19,45),(27,-72,'2021-12-08 10:28:44',18,40),(28,-64,'2021-09-08 05:24:58',18,8),(29,-289,'2021-11-30 04:40:04',12,46),(30,146,'2022-05-25 04:31:12',12,18),(31,-255,'2021-09-15 07:20:17',8,44),(32,-177,'2022-07-26 11:05:32',20,3),(33,119,'2021-10-14 00:46:11',14,6),(34,160,'2022-05-12 02:35:36',17,4),(35,215,'2022-02-03 14:18:19',9,17),(36,265,'2022-04-02 09:43:29',18,4),(37,-76,'2022-04-16 02:59:56',3,30),(38,103,'2021-09-20 02:41:17',17,20),(39,-54,'2022-07-12 10:04:29',7,16),(40,-206,'2022-05-25 08:12:47',8,21);
/*!40000 ALTER TABLE `store_record` ENABLE KEYS */;
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

-- Dump completed on 2022-08-28  1:45:24
