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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `idpatient` char(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'null',
  `napatient` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'null',
  `sexpatient` char(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'no',
  `agepatient` int(11) NOT NULL DEFAULT '0',
  `ropatient` char(3) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `nadopa` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `blopatient` char(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diapatient` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idopatient` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idpatient`),
  KEY `idopatient` (`idopatient`),
  CONSTRAINT `idopatient_f` FOREIGN KEY (`idopatient`) REFERENCES `office` (`idoffice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('21101','王胜安','男',31,'001','齐风','A','肺炎','101'),('21102','蔡壮保','男',54,'002','高飞','B','慢性气管炎','101'),('21103','易江伟','男',28,'003','陆风','O','自发性气胸','102'),('21104','张顺谷','男',32,'004','朱珠','AB','胆道结石','102'),('21105','李鑫灏','男',8,'005','邓杨','A','细菌性痢疾','103'),('21106','梁澄静','女',8,'006','程悦','A','诺如腹泻','103'),('21107','严席华','男',58,'009','刘宇','B','宫颈炎','104'),('21108','时党舒','女',26,'007','白浩','O','脑梗塞','105'),('21109','何刚名','男',66,'008','苏楠','B','脑出血','105'),('21110','刘鲜发','男',32,'010','宋思琪','A','脑积水','201'),('21111','何毅','男',35,'011','路大名','O','脑出血','201'),('21112','唐宸禹','男',38,'012','宋思琪','B','颅脑外伤','201'),('21113','张顺联','男',50,'013','刘楠','A','泌尿结石','202'),('21114','汤青','女',29,'014','孙怡','B','急性肾炎','202'),('21115','柯纤栩','女',34,'015','焦丹','AB','腰间盘突出','203'),('21116','夏莱','女',30,'016','章子怡','B','电解质紊乱','204'),('21117','杜鹃','女',28,'017','李娟','B','内分泌紊乱','204'),('21118','张洪赫','男',25,'018','郭一曼','AB','慢性牙周炎','205'),('21119','池慕颖','女',26,'019','刘晓','O','口腔白斑','205'),('21120','齐芬霞','女',69,'020','王路明','A','口腔白斑','301'),('21121','卢全旭','男',66,'021','张珍','AB','青光眼','301'),('21122','卓互知','男',45,'022','韩子奇','O','中耳炎','302'),('21123','元感奇','男',16,'023','徐若鸿','B','扁平疣','303'),('21124','秦长乐','男',32,'024','陆磊李丽','O','皮肤癣','303'),('21125','丘寸心','男',48,'025','高涛','B','血胸','304'),('21126','路从风','男',18,'026','陈若玉','A','漏斗胸','305'),('21127','王浩','男',29,'027','李丽','AB','胸部异物','304'),('21128','潘奕','女',30,'028','刘思宇','B','胸腔积液','305');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-03 16:53:45
