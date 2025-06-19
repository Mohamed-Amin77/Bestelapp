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
-- Table structure for table `winkelmand`
--

DROP TABLE IF EXISTS `winkelmand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `winkelmand` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aantal` int NOT NULL,
  `materiaal_id` bigint DEFAULT NULL,
  `technieker_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2h2n7gfwr44cookh3gnr9r8fa` (`materiaal_id`),
  KEY `FKd9ky4qmjonm3n0mv77wm2llx9` (`technieker_id`),
  CONSTRAINT `FK2h2n7gfwr44cookh3gnr9r8fa` FOREIGN KEY (`materiaal_id`) REFERENCES `materialen` (`id`),
  CONSTRAINT `FKd9ky4qmjonm3n0mv77wm2llx9` FOREIGN KEY (`technieker_id`) REFERENCES `gebruikers` (`id`),
  CONSTRAINT `winkelmand_chk_1` CHECK ((`aantal` >= 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `winkelmand`
--

LOCK TABLES `winkelmand` WRITE;
/*!40000 ALTER TABLE `winkelmand` DISABLE KEYS */;
/*!40000 ALTER TABLE `winkelmand` ENABLE KEYS */;
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
