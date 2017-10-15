CREATE DATABASE  IF NOT EXISTS `tjbbqdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tjbbqdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tjbbqdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `Category_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cateogry_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Sandwiches'),(2,'Appetizer'),(3,'Budget Meal'),(4,'Combo Meal'),(5,'Pasta'),(6,'Rice'),(7,'Dessert'),(8,'Drinks'),(9,'Favorites'),(10,'Extras');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumable`
--

DROP TABLE IF EXISTS `consumable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumable` (
  `Consumable_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Consumable_Name` varchar(100) NOT NULL,
  `Consumable_CodeName` varchar(45) DEFAULT NULL,
  `Consumable_Price` float NOT NULL,
  `Meal_ID` int(11) DEFAULT NULL,
  `Category_ID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Consumable_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumable`
--

LOCK TABLES `consumable` WRITE;
/*!40000 ALTER TABLE `consumable` DISABLE KEYS */;
INSERT INTO `consumable` VALUES (1,'Crispy Pork Chop','',99,NULL,NULL),(2,'Juicy Fried Chicken','',99,NULL,NULL),(3,'Crispy Liempo','',99,NULL,NULL),(4,'Beef Nachos','',145,NULL,NULL),(5,'Chicken Croquettes','',145,NULL,NULL),(6,'Buffalo Wings','',145,NULL,NULL),(7,'Hungarian Sausage','',145,NULL,NULL),(8,'Hamburger','',125,NULL,NULL),(9,'Hamburger w/ Cheese','',140,NULL,NULL),(10,'Hungarian','',140,NULL,NULL),(11,'Sriracha BBQ Chicken Skewers','',50,NULL,NULL),(12,'Sriracha Pork BBQ Skewers','',50,NULL,NULL),(13,'Fries Ala Carte','',80,NULL,NULL),(14,'Twisty Fries','',95,NULL,NULL),(15,'Cross Fries','',95,NULL,NULL),(16,'Crispy Wedges','',95,NULL,NULL),(17,'Jalapeno Balls','',155,NULL,NULL),(18,'Mozarella Cheese Sticks','',175,NULL,NULL),(19,'Sizzling Sisig','',220,NULL,NULL),(20,'Beef Nachos','',145,NULL,NULL),(49,'Chicken Quarter',NULL,125,NULL,NULL),(50,'Pork BBQ 2 pcs',NULL,105,NULL,NULL),(51,'Liempo BBQ',NULL,125,NULL,NULL),(52,'Porkchop BBQ 2 pcs',NULL,125,NULL,NULL),(53,'BBQ Spareribs',NULL,145,NULL,NULL),(54,'Baby Back Ribs',NULL,185,NULL,NULL),(55,'Grilled Beefy Burger',NULL,105,NULL,NULL),(56,'Grilled Hungarian 2pcs',NULL,145,NULL,NULL),(57,'Grilled Beefy Belly',NULL,195,NULL,NULL),(58,'Grilled Bulalo Steak',NULL,195,NULL,NULL),(59,'Beef Baby Back Ribs',NULL,195,NULL,NULL),(60,'Grilled Bangus',NULL,115,NULL,NULL),(61,'Grilled Tuna Belly',NULL,195,NULL,NULL),(62,'Grilled Tuna Panga',NULL,310,NULL,NULL),(78,'Spaghetti w/ Meatballs',NULL,125,NULL,NULL),(79,'Spaghetti Carbonara',NULL,125,NULL,NULL),(80,'Plain',NULL,20,NULL,'6'),(81,'Garlic',NULL,25,NULL,'6'),(82,'Java',NULL,25,NULL,'6'),(83,'Halo Halo',NULL,70,NULL,'7'),(84,'Saba Con Hielo',NULL,60,NULL,'7'),(85,'Mais Con Hielo',NULL,60,NULL,'7'),(86,'Lemon Iced Tea',NULL,40,NULL,NULL),(87,'Raspberry Juice',NULL,40,NULL,NULL),(88,'Iced Tea Litro',NULL,125,NULL,NULL),(89,'Bottled Water',NULL,20,NULL,NULL),(90,'Coke',NULL,40,NULL,NULL),(91,'Pineapple Juice in Can',NULL,45,NULL,NULL),(92,'San Mig Pale',NULL,55,NULL,NULL),(93,'San Mig Light',NULL,55,NULL,NULL),(94,'Sprite',NULL,40,NULL,NULL);
/*!40000 ALTER TABLE `consumable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incoming`
--

DROP TABLE IF EXISTS `incoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incoming` (
  `In_DateTime` datetime NOT NULL,
  `In_Quantity` int(11) NOT NULL,
  `In_Remarks` varchar(255) DEFAULT NULL,
  `RawItem_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incoming`
--

LOCK TABLES `incoming` WRITE;
/*!40000 ALTER TABLE `incoming` DISABLE KEYS */;
/*!40000 ALTER TABLE `incoming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `RawItem_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitem` (
  `Transaction_ID` int(11) NOT NULL,
  `Consumable_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
INSERT INTO `lineitem` VALUES (0,2,4),(1,1,3),(2,1,3),(3,2,4),(0,3,1),(0,3,1),(0,3,1);
/*!40000 ALTER TABLE `lineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal`
--

DROP TABLE IF EXISTS `meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meal` (
  `Meal_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AddOns` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Meal_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mealcontent`
--

DROP TABLE IF EXISTS `mealcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mealcontent` (
  `Meal_ID` int(11) NOT NULL,
  `Food_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mealcontent`
--

LOCK TABLES `mealcontent` WRITE;
/*!40000 ALTER TABLE `mealcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `mealcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outgoing`
--

DROP TABLE IF EXISTS `outgoing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outgoing` (
  `Out_DateTime` datetime NOT NULL,
  `Out_Quantity` int(11) NOT NULL,
  `Out_Remarks` varchar(255) DEFAULT NULL,
  `RawItem_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outgoing`
--

LOCK TABLES `outgoing` WRITE;
/*!40000 ALTER TABLE `outgoing` DISABLE KEYS */;
/*!40000 ALTER TABLE `outgoing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rawitem`
--

DROP TABLE IF EXISTS `rawitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rawitem` (
  `RawItem_ID` int(11) NOT NULL,
  `RawItem_Name` varchar(45) NOT NULL,
  `RawItem_Price` float NOT NULL,
  `RawItem_Quantity` varchar(45) NOT NULL,
  PRIMARY KEY (`RawItem_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rawitem`
--

LOCK TABLES `rawitem` WRITE;
/*!40000 ALTER TABLE `rawitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `rawitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `Trans_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Trans_DateTime` datetime NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Customer_Number` int(11) DEFAULT NULL,
  `Trans_Type` varchar(45) NOT NULL,
  `Cash` float NOT NULL,
  `Change` float DEFAULT NULL,
  `Tax` float NOT NULL,
  `Subtotal` float NOT NULL,
  `Senior_Discount` float DEFAULT NULL,
  `Total` float NOT NULL,
  PRIMARY KEY (`Trans_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2017-10-14 00:00:00',1,22,'dine-in',144,NULL,33,144,NULL,144),(2,'2017-10-14 00:00:00',1,23,'dine-in',3123,NULL,33,3123,NULL,3123),(3,'2017-12-14 00:00:00',1,24,'dine-in',1331,NULL,33,1331,NULL,1331),(4,'2017-12-14 00:00:00',6,1,'dine-in',2342,NULL,33,2342,NULL,2342),(5,'2018-01-02 00:00:00',6,2,'dine-in',2231,NULL,33,2231,NULL,2231),(6,'2018-01-02 00:00:00',6,3,'dine-in',3331,NULL,33,3331,NULL,3331),(7,'2018-01-02 00:00:00',6,4,'dine-in',604,NULL,33,604,NULL,604);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_Username` varchar(45) NOT NULL,
  `User_Name` varchar(45) NOT NULL,
  `User_Password` varchar(45) NOT NULL,
  `User_Role` varchar(45) NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jordan','jose','1234','Owner'),(2,'jolene','jolene','1234','Supervisor'),(3,'gavin','mark','1234','Cashier'),(4,'jason','clark','1234','Owner'),(5,'carlo','gian','1234','Supervisor'),(6,'nixon','nixon','1234','Cashier'),(7,'allen','patrick','1234','Owner'),(8,'stephen','stephen','1234','Supervisor'),(9,'sing','nyles','1234','Cashier'),(10,'glen','jasper','1234','Owner');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

<<<<<<< HEAD:ERD & DB/tjbbqdb.sql
-- Dump completed on 2017-10-15 22:20:21
=======
-- Dump completed on 2017-10-15 22:14:51
>>>>>>> 1593f62fab791c4a5fbf52e242b4b5d7d5be551a:tjbbqdb.sql
