-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: testhibernate
-- ------------------------------------------------------
-- Server version	5.6.16-log

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
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (202,'1111','sec_name2'),(203,'1111','sec_name3'),(204,'1111','sec_name4'),(205,'1111','sec_name5'),(208,'1111','sec_name8'),(209,'1111','sec_name9'),(220,'1','sec_name20'),(222,'1','sec_name22'),(223,'1','sec_name23'),(224,'1','sec_name24'),(225,'1','sec_name25'),(226,'1','sec_name26'),(227,'1','sec_name27'),(228,'1','sec_name28'),(229,'1','sec_name29'),(230,'1','sec_name30'),(232,'1','sec_name32'),(233,'1','sec_name33'),(234,'1','sec_name34'),(235,'1','sec_name35'),(236,'1','sec_name36'),(237,'1','sec_name37'),(238,'1','sec_name38'),(239,'1','sec_name39'),(240,'1','sec_name40'),(242,'1','sec_name42'),(243,'1','sec_name43'),(244,'1','sec_name44'),(245,'1','sec_name45'),(246,'1','sec_name46'),(247,'1','sec_name47'),(248,'1','sec_name48'),(249,'1','sec_name49'),(250,'1','sec_name50'),(252,'1','sec_name52'),(253,'1','sec_name53'),(254,'1','sec_name54'),(255,'1','sec_name55'),(256,'1','sec_name56'),(257,'1','sec_name57'),(258,'1','sec_name58'),(259,'1','sec_name59'),(260,'1','sec_name60'),(262,'1','sec_name62'),(263,'1','sec_name63'),(264,'1','sec_name64'),(265,'1','sec_name65'),(266,'1','sec_name66'),(267,'1','sec_name67'),(268,'1','sec_name68'),(269,'1','sec_name69'),(270,'1','sec_name70'),(272,'1','sec_name72'),(273,'1','sec_name73'),(274,'1','sec_name74'),(275,'1','sec_name75'),(276,'1','sec_name76'),(277,'1','sec_name77'),(278,'1','sec_name78'),(279,'1','sec_name79'),(280,'1','sec_name80'),(282,'1','sec_name82'),(283,'1','sec_name83'),(284,'1','sec_name84'),(285,'1','sec_name85'),(286,'1','sec_name86'),(287,'1','sec_name87'),(288,'1','sec_name88'),(289,'1','sec_name89'),(290,'1','sec_name90'),(292,'1','sec_name92'),(293,'1','sec_name93'),(294,'1','sec_name94'),(295,'1','sec_name95'),(296,'1','sec_name96'),(297,'1','sec_name97'),(298,'1','sec_name98'),(299,'1','sec_name99'),(400,'1','sec_name200');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,202,'book1'),(2,202,'book2');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;