-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `importance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `announcement`
--

LOCK TABLES `announcement` WRITE;
/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` VALUES (23,'2022-02-13','格雷福斯','春节放假','<p><strong>春节放假7天，如果主动加班，三倍工资，另：食堂吃饭免费</strong></p>',2),(25,'2022-02-02','bywind','元旦放假','<p class=\"contentFont\">根据国务院办公厅通知精神，现将2022年元旦放假安排通知如下：</p>\n<p class=\"contentFont\" style=\"text-align: center;\"><span style=\"text-decoration: underline;\"><strong>1月1日（星期六）至3日（星期一）放假，共3天。</strong></span></p>\n<p class=\"contentFont\" style=\"padding-left: 40px;\">节假日期间，各区、各部门要妥善安排好值班和安全、保卫等工作，遇有重大突发事件，要按规定及时报告并妥善处置。</p>\n<p class=\"contentFont\" style=\"padding-left: 40px;\">请广大市民提前安排好工作生活，节日期间注意安全，科学佩戴口罩，保持社交距离和个人良好卫生习惯，减少人员聚集，做好个人有效防护，度过一个欢乐、祥和、平安的节日假期。</p>\n<p class=\"contentFont\" style=\"text-align: right;\">天津市人民政府办公厅</p>\n<p class=\"contentFont\" style=\"text-align: right;\">2021年12月17日</p>',3);
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '123456',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'customer',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (17,'西奥','123456','1568526328','customer'),(22,'22岁的男人','123456','123456789','customer');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` varchar(255) NOT NULL,
  `time` date DEFAULT NULL,
  `userId` varchar(255) NOT NULL,
  `items` json DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('202203282033039041508421913269202946','2022-03-28','2','{\"list\": [{\"id\": 1, \"count\": 1, \"price\": 900, \"title\": \"全景天窗遮阳帘\", \"totalPrice\": 900}, {\"id\": 2, \"count\": 1, \"price\": 8000, \"title\": \"第三代家庭充电服务包\", \"totalPrice\": 8000}]}','salesperson'),('202203282033216141508421987537743874','2022-03-29','2','{\"list\": [{\"id\": 6, \"count\": 1, \"price\": 900, \"title\": \"固定式车顶遮阳帘\", \"totalPrice\": 900}, {\"id\": 4, \"count\": 1, \"price\": 2160, \"title\": \"Model S 全天候脚垫套装\", \"totalPrice\": 2160}]}','salesperson'),('202203282127183191508435563279265793','2022-03-28','1','{\"list\": [{\"id\": 6, \"count\": 1, \"price\": 900, \"title\": \"固定式车顶遮阳帘\", \"totalPrice\": 900}, {\"id\": 2, \"count\": 1, \"price\": 8000, \"title\": \"第三代家庭充电服务包\", \"totalPrice\": 8000}]}','customer'),('202204101524447931513055364635115521','2022-04-10','1','{\"list\": [{\"id\": 1, \"count\": 1, \"price\": 900, \"title\": \"全景天窗遮阳帘\", \"totalPrice\": 900}, {\"id\": 6, \"count\": 1, \"price\": 900, \"title\": \"固定式车顶遮阳帘\", \"totalPrice\": 900}]}','customer'),('202204101530125881513056739481829377','2022-04-10','1','{\"list\": [{\"id\": 2, \"count\": 1, \"price\": 8000, \"title\": \"第三代家庭充电服务包\", \"totalPrice\": 8000}, {\"id\": 4, \"count\": 1, \"price\": 2160, \"title\": \"Model S 全天候脚垫套装\", \"totalPrice\": 2160}]}','customer'),('202204101531007041513056941286572034','2022-04-10','17','{\"list\": [{\"id\": 1, \"count\": 1, \"price\": 900, \"title\": \"全景天窗遮阳帘\", \"totalPrice\": 900}]}','customer'),('202204152136057951514960757254774785','2022-04-15','1','{\"list\": [{\"id\": 2, \"count\": 1, \"price\": 8000, \"title\": \"第三代家庭充电服务包\", \"totalPrice\": 8000}, {\"id\": 4, \"count\": 1, \"price\": 2160, \"title\": \"Model S 全天候脚垫套装\", \"totalPrice\": 2160}]}','customer'),('202204152136297681514960857767075842','2022-04-15','1','{\"list\": [{\"id\": 1, \"count\": 1, \"price\": 900, \"title\": \"全景天窗遮阳帘\", \"totalPrice\": 900}]}','customer'),('202204201946570081516745228979154946','2022-04-20','1','{\"list\": [{\"id\": 16, \"count\": 1, \"price\": 4350, \"title\": \"Naoshima围巾\", \"totalPrice\": 4350}, {\"id\": 19, \"count\": 1, \"price\": 5900, \"title\": \"Pop H 15腰带\", \"totalPrice\": 5900}]}','customer'),('202205121340180631524625491763634178','2022-05-12','1','{\"list\": [{\"id\": 20, \"count\": 1, \"price\": 6050, \"title\": \"Fusion项链\", \"totalPrice\": 6050}, {\"id\": 16, \"count\": 1, \"price\": 4350, \"title\": \"Naoshima围巾\", \"totalPrice\": 4350}, {\"id\": 14, \"count\": 1, \"price\": 2000, \"title\": \"男士方巾\", \"totalPrice\": 2000}, {\"id\": 23, \"count\": 1, \"price\": 3910, \"title\": \"GV Prism太阳镜\", \"totalPrice\": 3910}]}','customer'),('202205201435244231527538462567370754','2022-05-20','17','{\"list\": [{\"id\": 15, \"count\": 1, \"price\": 2150, \"title\": \"“卡利普索花园” 65厘米方巾\", \"totalPrice\": 2150}, {\"id\": 14, \"count\": 2, \"price\": 2000, \"title\": \"男士方巾\", \"totalPrice\": 4000}]}','customer'),('202205211136142041527855760753360898','2022-05-21','17','{\"list\": [{\"id\": 15, \"count\": 1, \"price\": 2150, \"title\": \"“卡利普索花园” 65厘米方巾\", \"totalPrice\": 2150}, {\"id\": 14, \"count\": 2, \"price\": 2000, \"title\": \"男士方巾\", \"totalPrice\": 4000}]}','customer');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `surplus` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT '100',
  `warehouse` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `imgurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'https://s2.loli.net/2022/02/19/4YRxdEmjt725NZz.png',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (14,'男士方巾',231,2000,'上海','https://s2.loli.net/2022/04/19/AlRCi2IbN7cPFWm.jpg'),(15,'“卡利普索花园” 65厘米方巾',123,2150,'上海','https://s2.loli.net/2022/04/19/uJA3XQVBFxRH7pS.jpg'),(16,'Naoshima围巾',300,4350,'北京','https://s2.loli.net/2022/04/19/fKgc41dxEpVR9zT.jpg'),(17,'Uni迷你菱形巾',125,3300,'北京','https://s2.loli.net/2022/04/19/hx6O7FusBHRfaNC.jpg'),(18,'Lucky 15双面腰带',0,5700,'北京','https://s2.loli.net/2022/04/19/zVgfMHPbLlAZx7o.jpg'),(19,'Pop H 15腰带',51,5900,'广州','https://s2.loli.net/2022/04/19/rm7WiR8ncOdTyE4.jpg'),(20,'Fusion项链',222,6050,'广州','https://s2.loli.net/2022/04/19/qcPQvbSGBsxO8Fj.jpg'),(21,'As de Coeur项链',301,3300,'广州','https://s2.loli.net/2022/04/19/HCymf2lX9zrdjGN.jpg'),(23,'GV Prism太阳镜',232,3910,'广州','https://s2.loli.net/2022/04/19/M8TSL9bAnPoyfz5.jpg'),(24,'GV Day太阳镜',320,2490,'重庆','https://s2.loli.net/2022/04/19/uDHGZNOWEmcaC6S.jpg'),(25,'希腊回纹缎带腰带',125,2400,'重庆','https://s2.loli.net/2022/04/19/9U4SJAxavXqNdg1.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesperson`
--

DROP TABLE IF EXISTS `salesperson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salesperson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sales` int(11) DEFAULT '0',
  `tel` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '123456',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'salesperson',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesperson`
--

LOCK TABLES `salesperson` WRITE;
/*!40000 ALTER TABLE `salesperson` DISABLE KEYS */;
INSERT INTO `salesperson` VALUES (1,'韩春明',120,'1562325123','123456','salesperson'),(2,'苏萌',87,'1318465174','123456','salesperson'),(3,'关小关',15,'132145645','123456','salesperson');
/*!40000 ALTER TABLE `salesperson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '123456',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'admin',
  `tel` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `position` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '销售经理',
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'bywind','$2a$10$oyIQz3vL4pcVvnX1/LPyUO5au5E/nKo2IpxqxrNukMGH8362VfGga','admin','15954236982','销售经理'),(2,'格雷福斯','$2a$10$oyIQz3vL4pcVvnX1/LPyUO5au5E/nKo2IpxqxrNukMGH8362VfGga','admin','15954268235','销售经理'),(3,'auguste','$2a$10$OOyY1hIqpIyBvR3A/JL2kuPkeL0vO/YzX1BdXT7qvFpRCe1R/XhaC','admin','13185616235','销售经理');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-25 12:32:28
