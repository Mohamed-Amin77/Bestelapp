-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: materiaalbeheer
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `materialen`
--

DROP TABLE IF EXISTS `materialen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialen` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `naam` varchar(255) NOT NULL,
  `aantal` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `materialen_chk_1` CHECK ((`aantal` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialen`
--

LOCK TABLES `materialen` WRITE;
/*!40000 ALTER TABLE `materialen` DISABLE KEYS */;
INSERT INTO `materialen` VALUES (1,'Bevestigingsmateriaal','Bouten: M6, M8, M10, M12, M16, inox A2/A4, verzinkt',0),(2,'Bevestigingsmateriaal','Moeren: zeskantmoeren, borgmoeren, flensmoeren',0),(3,'Bevestigingsmateriaal','Ringen: sluitringen, veerringen, tandringen',0),(4,'Bevestigingsmateriaal','Ankerbouten',0),(5,'Bevestigingsmateriaal','Chemische ankers (bv. Hilti HIT)',0),(6,'Bevestigingsmateriaal','Keilbouten',0),(7,'Bevestigingsmateriaal','Draadstangen (M6 t.e.m. M16)',0),(8,'Bevestigingsmateriaal','Inslagmoeren',0),(9,'Bevestigingsmateriaal','Tapbouten',0),(10,'Bevestigingsmateriaal','Zeskantkop- en inbusbouten',0),(11,'Bevestigingsmateriaal','Torx- en kruiskopschroeven',0),(12,'Bevestigingsmateriaal','Zelftappende vijzen',0),(13,'Bevestigingsmateriaal','Parkervijzen',0),(14,'Bevestigingsmateriaal','Spaanplaatschroeven',0),(15,'Bevestigingsmateriaal','Slangenklemmen (div. diameters)',0),(16,'PBM','Veiligheidshelm (met kinband)',0),(17,'PBM','Oordoppen / gehoorkappen',0),(18,'PBM','Veiligheidsbril / gelaatsscherm',0),(19,'PBM','Stofmaskers (FFP2, FFP3)',0),(20,'PBM','Werkhandschoenen (snijvast, chemisch resistent, elektrisch geïsoleerd)',0),(21,'PBM','Veiligheidsschoenen (S3, antistatisch, stalen tip)',0),(22,'PBM','Werklaarzen (PVC, nitril, met stalen zool)',0),(23,'PBM','Regenkledij (jassen, broeken, capes)',0),(24,'PBM','Fluovesten / signalisatiekledij (EN ISO 20471)',0),(25,'PBM','Overall (brandvertragend, antistatisch, waterafstotend)',0),(26,'PBM','Valharnas en lijn',0),(27,'PBM','Gasdetectiemeter (O₂, CH₄, H₂S, CO)',0),(28,'PBM','Handontsmetting / EHBO-kit',0),(29,'PBM','Klim- en valbeveiligingsmateriaal (harnas, lifeline, karabijnhaken)',0);
/*!40000 ALTER TABLE `materialen` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-19 17:10:36
