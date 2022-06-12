-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hostipal
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `iddoctor` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'null',
  `namedoctor` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'null',
  `sexdoctor` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'no',
  `agedoctor` int(11) NOT NULL DEFAULT '0',
  `titledoctor` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `onudoctor` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'no',
  PRIMARY KEY (`iddoctor`),
  KEY `onudoctor_idx` (`onudoctor`),
  CONSTRAINT `onudovtor` FOREIGN KEY (`onudoctor`) REFERENCES `office` (`idoffice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('101001','高飞','男',30,'101','101'),('101002','杨蕾','女',24,'住院医师','101'),('101003','齐峰','男',27,'主治医师','101'),('101004','李想','女',45,'主任医师','102'),('101005','朱珠','女',30,'主治医师','102'),('101006','陆','男',35,'102','102'),('101007','邓阳','男',30,'主治医师','103'),('101008','程悦','女',28,'副主治医师','103'),('101009','刘宇','女',40,'副主任医师','104'),('101010','刘子怡','女',34,'主治医师','104'),('101011','白浩','男',58,'主任医师','105'),('101012','苏楠','女',32,'主治医师','105'),('101013','宋思琪','女',50,'主任医师','201'),('101014','路大名','男',24,'住院医师','201'),('101015','孙怡','女',33,'主治医师','202'),('101016','刘楠','男',33,'主治医师','202'),('101017','杨子龙','男',35,'主治医师','203'),('101018','焦丹','女',23,'住院医师','203'),('101019','章子怡','女',38,'副主任医师','204'),('101020','李娟','女',32,'主治医师','204'),('101021','郭一曼','女',35,'主治医师','205'),('101022','刘晓','男',22,'住院医师','205'),('101023','王路明','男',36,'主治医师','301'),('101024','张珍','女',29,'副主治医师','301'),('101025','韩子奇','男',31,'主治医师','302'),('101026','乔芳','女',31,'主治医师','302'),('101027','徐若鸿','男',49,'主任医师','303'),('101028','陆磊','男',31,'主治医师','303'),('101029','李丽','女',51,'主任医师','304'),('101030','高涛','男',31,'主治医师','304'),('101031','陈若玉','女',39,'副主任医师','305'),('101032','刘思宇','女',30,'主治医师','305');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-03 16:53:46
