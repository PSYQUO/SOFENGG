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
  `Category` varchar(45) NOT NULL,
  PRIMARY KEY (`Consumable_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumable`
--

LOCK TABLES `consumable` WRITE;
/*!40000 ALTER TABLE `consumable` DISABLE KEYS */;
INSERT INTO `consumable` VALUES (1,'Crispy Pork Chop','',99,NULL,'Budget Meal'),(2,'Juicy Fried Chicken','',99,NULL,'Budget Meal'),(3,'Crispy Liempo','',99,NULL,'Budget Meal'),(4,'Beef Nachos','',145,NULL,'Favorites'),(5,'Chicken Croquettes','',145,NULL,'Favorites'),(6,'Buffalo Wings','',145,NULL,'Favorites'),(7,'Hungarian Sausage','',145,NULL,'Favorites'),(8,'Hamburger','',125,NULL,'Sandwiches'),(9,'Hamburger w/ Cheese','',140,NULL,'Sandwiches'),(10,'Hungarian','',140,NULL,'Sandwiches'),(11,'Sriracha BBQ Chicken Skewers','',50,NULL,'Appetizers'),(12,'Sriracha Pork BBQ Skewers','',50,NULL,'Appetizers'),(13,'Fries Ala Carte','',80,NULL,'Appetizers'),(14,'Twisty Fries','',95,NULL,'Appetizers'),(15,'Cross Fries','',95,NULL,'Appetizers'),(16,'Crispy Wedges','',95,NULL,'Appetizers'),(17,'Jalapeno Balls','',155,NULL,'Appetizers'),(18,'Mozarella Cheese Sticks','',175,NULL,'Appetizers'),(19,'Sizzling Sisig','',220,NULL,'Appetizers'),(20,'Beef Nachos','',145,NULL,'Appetizers'),(49,'Chicken Quarter',NULL,125,NULL,'Combo Meals'),(50,'Pork BBQ 2 pcs',NULL,105,NULL,'Combo Meals'),(51,'Liempo BBQ',NULL,125,NULL,'Combo Meals'),(52,'Porkchop BBQ 2 pcs',NULL,125,NULL,'Combo Meals'),(53,'BBQ Spareribs',NULL,145,NULL,'Combo Meals'),(54,'Baby Back Ribs',NULL,185,NULL,'Combo Meals'),(55,'Grilled Beefy Burger',NULL,105,NULL,'Combo Meals'),(56,'Grilled Hungarian 2pcs',NULL,145,NULL,'Combo Meals'),(57,'Grilled Beefy Belly',NULL,195,NULL,'Combo Meals'),(58,'Grilled Bulalo Steak',NULL,195,NULL,'Combo Meals'),(59,'Beef Baby Back Ribs',NULL,195,NULL,'Combo Meals'),(60,'Grilled Bangus',NULL,115,NULL,'Combo Meals'),(61,'Grilled Tuna Belly',NULL,195,NULL,'Combo Meals'),(62,'Grilled Tuna Panga',NULL,310,NULL,'Combo Meals'),(78,'Spaghetti w/ Meatballs',NULL,125,NULL,'Pasta'),(79,'Spaghetti Carbonara',NULL,125,NULL,'Pasta'),(80,'Plain',NULL,20,NULL,'Rice'),(81,'Garlic',NULL,25,NULL,'Rice'),(82,'Java',NULL,25,NULL,'Rice'),(83,'Halo Halo',NULL,70,NULL,'Dessert'),(84,'Saba Con Hielo',NULL,60,NULL,'Dessert'),(85,'Mais Con Hielo',NULL,60,NULL,'Dessert'),(86,'Lemon Iced Tea',NULL,40,NULL,'Drinks'),(87,'Raspberry Juice',NULL,40,NULL,'Drinks'),(88,'Iced Tea Litro',NULL,125,NULL,'Drinks'),(89,'Bottled Water',NULL,20,NULL,'Drinks'),(90,'Coke',NULL,40,NULL,'Drinks'),(91,'Pineapple Juice in Can',NULL,45,NULL,'Drinks'),(92,'San Mig Pale',NULL,55,NULL,'Drinks'),(93,'San Mig Light',NULL,55,NULL,'Drinks'),(94,'Sprite',NULL,40,NULL,'Drinks');
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
  `Consumable_ID` int(11) NOT NULL,
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
  `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Consumable_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`Transaction_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
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
  `Change` float NOT NULL,
  `Tax` float NOT NULL,
  `Subtotal` float NOT NULL,
  `Senior_Discount` float DEFAULT NULL,
  `Total` float NOT NULL,
  PRIMARY KEY (`Trans_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL,
  `User_Username` varchar(45) NOT NULL,
  `User_Name` varchar(45) NOT NULL,
  `User_Password` varchar(45) NOT NULL,
  `User_Role` varchar(45) NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2017-10-12  0:28:49
