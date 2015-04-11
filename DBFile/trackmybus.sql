-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: trackmybus
-- ------------------------------------------------------
-- Server version	5.5.9

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
-- Table structure for table `businformation`
--

DROP TABLE IF EXISTS `businformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businformation` (
  `Bus_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Device_Num` varchar(15) NOT NULL,
  `Bus_Loc_Longitude` varchar(45) DEFAULT NULL,
  `Bus_Loc_Latitude` varchar(45) NOT NULL,
  `Bus_Last_Update` varchar(10) DEFAULT NULL,
  `BR_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Bus_Id`),
  UNIQUE KEY `Bus_Num_UNIQUE` (`Device_Num`),
  KEY `fk_businformation_BR_Id_idx` (`BR_Id`),
  CONSTRAINT `fk_businformation_BR_Id` FOREIGN KEY (`BR_Id`) REFERENCES `busroute` (`BR_Id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=613 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businformation`
--

LOCK TABLES `businformation` WRITE;
/*!40000 ALTER TABLE `businformation` DISABLE KEYS */;
INSERT INTO `businformation` VALUES (1,'1021362111','18.522449','73.866753','null',1),(2,'1021362112','18.522449','73.866753','null',2),(3,'1021362113','18.5167044','73.8310057','null',3);
/*!40000 ALTER TABLE `businformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busroute`
--

DROP TABLE IF EXISTS `busroute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busroute` (
  `BR_Id` int(10) NOT NULL AUTO_INCREMENT,
  `BR_Num` varchar(10) NOT NULL,
  `BR_City` varchar(250) NOT NULL,
  `BR_Source` varchar(250) NOT NULL,
  `BR_Destination` varchar(250) NOT NULL,
  `BR_Status` varchar(10) NOT NULL,
  PRIMARY KEY (`BR_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busroute`
--

LOCK TABLES `busroute` WRITE;
/*!40000 ALTER TABLE `busroute` DISABLE KEYS */;
INSERT INTO `busroute` VALUES (1,'101','Pune','Dhayri','Swargate','null'),(2,'102','Pune','Kothrud depo','Swargate','null'),(3,'104','Pune','Kothrud depo','Katraj depo','null');
/*!40000 ALTER TABLE `busroute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busroute_busstop`
--

DROP TABLE IF EXISTS `busroute_busstop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busroute_busstop` (
  `BRS_Id` int(10) NOT NULL,
  `BRS_BR_Id` int(10) DEFAULT NULL,
  `BRS_BS_ID` int(10) DEFAULT NULL,
  `BRS_Order` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`BRS_Id`),
  KEY `fk_BRS_BusRoute_Id_idx` (`BRS_BR_Id`),
  KEY `fk_BRS_BusStop_Id_idx` (`BRS_BS_ID`),
  CONSTRAINT `fk_BRS_BusRoute_Id` FOREIGN KEY (`BRS_BR_Id`) REFERENCES `busroute` (`BR_Id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_BRS_BusStop_Id` FOREIGN KEY (`BRS_BS_ID`) REFERENCES `busstop` (`BS_Id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busroute_busstop`
--

LOCK TABLES `busroute_busstop` WRITE;
/*!40000 ALTER TABLE `busroute_busstop` DISABLE KEYS */;
INSERT INTO `busroute_busstop` VALUES (1,1,1,'1'),(2,1,2,'2'),(3,1,3,'3'),(4,1,4,'4'),(5,1,5,'5'),(6,1,6,'6'),(7,1,7,'7'),(8,1,8,'8'),(9,1,9,'9'),(10,1,10,'10'),(11,1,11,'11'),(12,1,12,'12'),(13,1,13,'13'),(14,2,14,'1'),(15,2,15,'2'),(16,2,16,'3'),(17,2,17,'4'),(18,2,18,'5'),(19,2,19,'6'),(20,2,20,'7'),(21,2,21,'8'),(22,2,22,'9'),(23,2,23,'10'),(24,2,24,'11'),(25,2,25,'12'),(26,2,26,'13'),(27,2,13,'14'),(28,3,14,'1'),(29,3,15,'2'),(30,3,16,'3'),(31,3,17,'4'),(32,3,18,'5'),(33,3,19,'6'),(34,3,20,'7'),(35,3,21,'8'),(36,3,22,'9'),(37,3,23,'10'),(38,3,24,'11'),(39,3,25,'12'),(40,3,26,'13'),(41,3,27,'14'),(42,3,28,'15'),(43,3,29,'16'),(44,3,30,'17'),(45,3,31,'18'),(46,3,32,'19'),(47,3,33,'20'),(48,3,34,'21'),(49,3,35,'22'),(50,3,36,'23'),(51,3,37,'24'),(52,3,38,'25'),(53,3,39,'26'),(54,3,40,'27'),(55,3,41,'28'),(56,3,42,'29'),(57,3,43,'30'),(58,3,44,'31'),(59,3,45,'32'),(60,3,46,'33'),(61,3,47,'34'),(62,3,48,'35');
/*!40000 ALTER TABLE `busroute_busstop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busstop`
--

DROP TABLE IF EXISTS `busstop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busstop` (
  `BS_Id` int(10) NOT NULL AUTO_INCREMENT,
  `BS_Name` varchar(250) NOT NULL,
  `BS_Loc_Longitude` varchar(45) DEFAULT NULL,
  `BS_Loc_Latitude` varchar(45) DEFAULT NULL,
  `BS_Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BS_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2171 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busstop`
--

LOCK TABLES `busstop` WRITE;
/*!40000 ALTER TABLE `busstop` DISABLE KEYS */;
INSERT INTO `busstop` VALUES (1,'Dhayari, Maruti Mandir','','18.522449','73.866753'),(2,'Dhayari Gaon','','18.52245','73.866756'),(3,'Ganesh Nagar','','18.522451','73.866759'),(4,'Raykar Vasti','','18.522452','73.866762'),(5,'Dhayari Phata','','18.522453','73.866765'),(6,'Abhiruchi Mall','','18.522454','73.866768'),(7,'Vadgaon Bridge','','18.522455','73.866771'),(8,'Santosh Hall','','18.522456','73.866774'),(9,'Hingane','','18.522457','73.866777'),(10,'Pu.La Deshpande','','18.522458','73.86678'),(11,'Dandekar Bridge','','18.522459','73.866783'),(12,'Saras Baug','','18.52246','73.866786'),(13,'Swargate','','18.522461','73.866789'),(14,'Kothrud depo','','18.522462','73.866792'),(15,'Bharatinagar','','18.522463','73.866795'),(16,'Kachra Depot','','18.522464','73.866798'),(17,'Vanaz Company','','18.522465','73.866801'),(18,'Vanaz Corner','','18.522466','73.866804'),(19,'Jai Bhavani Nagar','','18.522467','73.866807'),(20,'Anandnagar','','18.522468','73.86681'),(21,'Mit College','','18.522469','73.866813'),(22,'More Vidyalaya','','18.52247','73.866816'),(23,'Paud Phata','','18.522471','73.866819'),(24,'Sndt College','','18.522472','73.866822'),(25,'Nalstop','','18.522473','73.866825'),(26,'Petrol Pump','','18.522474','73.866828'),(27,'Ras Shala','','18.522475','73.866831'),(28,'Deccan Gymkhana','','18.522476','73.866834'),(29,'Sahitya Parishad','','18.522477','73.866837'),(30,'Maharashtra Mandal','','18.522478','73.86684'),(31,'S.p. College','','18.522479','73.866843'),(32,'Madiwale Colony','','18.52248','73.866846'),(33,'Hirabaug','','18.522481','73.866849'),(34,'Laxminarayan Talkies','','18.522482','73.866852'),(35,'S.t. Colony','','18.522483','73.866855'),(36,'Bhapkar Petrol Pump','','18.522484','73.866858'),(37,'Araneshwar Corner','','18.522485','73.866861'),(38,'Natubaug','','18.522486','73.866864'),(39,'Sharada Arcade','','18.522487','73.866867'),(40,'Padmavati','','18.522488','73.86687'),(41,'Shankar Maharaj Math','','18.522489','73.866873'),(42,'Vishweshwar Bank','','18.52249','73.866876'),(43,'Balajinagar','','18.522491','73.866879'),(44,'Chaitanya Nagar','','18.522492','73.866882'),(45,'Bharati Vidyapeth Gate','','18.522493','73.866885'),(46,'Katraj Dudh Dairy','','18.522494','73.866888'),(47,'More Baug','','18.522495','73.866891'),(48,'Katraj','','18.522496','73.866894');
/*!40000 ALTER TABLE `busstop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-11 20:59:57
