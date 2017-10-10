CREATE DATABASE  IF NOT EXISTS `tjbbqdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tjbbqdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tjbbqdb
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `Food_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Food_Name` varchar(100) NOT NULL,
  `Food_CodeName` varchar(45) DEFAULT NULL,
  `Food_Price` float NOT NULL,
  `Category` varchar(45) NOT NULL,
  PRIMARY KEY (`Food_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Crispy Pork Chop','',99,'Budget Meal'),(2,'Juicy Fried Chicken','',99,'Budget Meal'),(3,'Crispy Liempo','',99,'Budget Meal'),(4,'Beef Nachos','',145,'Favorites'),(5,'Chicken Croquettes','',145,'Favorites'),(6,'Buffalo Wings','',145,'Favorites'),(7,'Hungarian Sausage','',145,'Favorites'),(8,'Hamburger','',125,'Sandwiches'),(9,'Hamburger w/ Cheese','',140,'Sandwiches'),(10,'Hungarian','',140,'Sandwiches'),(11,'Sriracha BBQ Chicken Skewers','',50,'Appetizers'),(12,'Sriracha Pork BBQ Skewers','',50,'Appetizers'),(13,'Fries Ala Carte','',80,'Appetizers'),(14,'Twisty Fries','',95,'Appetizers'),(15,'Cross Fries','',95,'Appetizers'),(16,'Crispy Wedges','',95,'Appetizers'),(17,'Jalapeno Balls','',155,'Appetizers'),(18,'Mozarella Cheese Sticks','',175,'Appetizers'),(19,'Sizzling Sisig','',220,'Appetizers'),(20,'Beef Nachos','',145,'Appetizers'),(49,'Chicken Quarter',NULL,125,'Combo Meals'),(50,'Pork BBQ 2 pcs',NULL,105,'Combo Meals'),(51,'Liempo BBQ',NULL,125,'Combo Meals'),(52,'Porkchop BBQ 2 pcs',NULL,125,'Combo Meals'),(53,'BBQ Spareribs',NULL,145,'Combo Meals'),(54,'Baby Back Ribs',NULL,185,'Combo Meals'),(55,'Grilled Beefy Burger',NULL,105,'Combo Meals'),(56,'Grilled Hungarian 2pcs',NULL,145,'Combo Meals'),(57,'Grilled Beefy Belly',NULL,195,'Combo Meals'),(58,'Grilled Bulalo Steak',NULL,195,'Combo Meals'),(59,'Beef Baby Back Ribs',NULL,195,'Combo Meals'),(60,'Grilled Bangus',NULL,115,'Combo Meals'),(61,'Grilled Tuna Belly',NULL,195,'Combo Meals'),(62,'Grilled Tuna Panga',NULL,310,'Combo Meals'),(78,'Spaghetti w/ Meatballs',NULL,125,'Pasta'),(79,'Spaghetti Carbonara',NULL,125,'Pasta'),(80,'Plain',NULL,20,'Rice'),(81,'Garlic',NULL,25,'Rice'),(82,'Java',NULL,25,'Rice'),(83,'Halo Halo',NULL,70,'Dessert'),(84,'Saba Con Hielo',NULL,60,'Dessert'),(85,'Mais Con Hielo',NULL,60,'Dessert'),(86,'Lemon Iced Tea',NULL,40,'Drinks'),(87,'Raspberry Juice',NULL,40,'Drinks'),(88,'Iced Tea Litro',NULL,125,'Drinks'),(89,'Bottled Water',NULL,20,'Drinks'),(90,'Coke',NULL,40,'Drinks'),(91,'Pineapple Juice in Can',NULL,45,'Drinks'),(92,'San Mig Pale',NULL,55,'Drinks'),(93,'San Mig Light',NULL,55,'Drinks'),(94,'Sprite',NULL,40,'Drinks');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingridient`
--

DROP TABLE IF EXISTS `ingridient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingridient` (
  `Food_ID` int(11) NOT NULL,
  `Raw_ID` int(11) NOT NULL,
  `Quantity` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingridient`
--

LOCK TABLES `ingridient` WRITE;
/*!40000 ALTER TABLE `ingridient` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingridient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitem` (
  `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Food_ID` int(11) DEFAULT NULL,
  `Meal_ID` int(11) DEFAULT NULL,
  `Quantity` varchar(45) NOT NULL,
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
  `Meal_Name` varchar(100) NOT NULL,
  `Meal_CodeName` varchar(45) DEFAULT NULL,
  `Meal_Price` float NOT NULL,
  PRIMARY KEY (`Meal_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal`
--

LOCK TABLES `meal` WRITE;
/*!40000 ALTER TABLE `meal` DISABLE KEYS */;
INSERT INTO `meal` VALUES (1,'Chicken Quarter',NULL,165),(2,'Pork BBQ 2 pcs',NULL,145),(3,'Liempo BBQ',NULL,165),(4,'Porkchop BBQ 2 pcs',NULL,165),(5,'BBQ Spareribs',NULL,185),(6,'Baby Back Ribs',NULL,225),(7,'Grilled Beefy Burger',NULL,145),(8,'Grilled Hungarian 2pcs',NULL,185),(9,'Grilled Beefy Belly',NULL,235),(10,'Grilled Bulalo Steak',NULL,235),(11,'Beef Baby Back Ribs',NULL,235),(12,'Grilled Bangus',NULL,155),(13,'Grilled Tuna Belly',NULL,235),(14,'Grilled Tuna Panga',NULL,350);
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
-- Table structure for table `rawitem`
--

DROP TABLE IF EXISTS `rawitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rawitem` (
  `Raw_ID` int(11) NOT NULL,
  `Raw_Name` varchar(45) NOT NULL,
  `Raw_Price` float NOT NULL,
  `Raw_Quantity` varchar(45) NOT NULL,
  PRIMARY KEY (`Raw_ID`)
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
  `DTD` varchar(45) NOT NULL,
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

-- Dump completed on 2017-10-09 22:02:19
