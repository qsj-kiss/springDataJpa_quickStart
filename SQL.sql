/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26 : Database - springdatajpa_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springdatajpa_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `springdatajpa_db`;

/*Table structure for table `cst_customer` */

DROP TABLE IF EXISTS `cst_customer`;

CREATE TABLE `cst_customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) DEFAULT NULL,
  `cust_address` varchar(50) DEFAULT NULL,
  `cust_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cst_customer` */

insert  into `cst_customer`(`cust_id`,`cust_name`,`cust_address`,`cust_number`) values (1,'我真帅','湖南长沙','1516115645'),(2,'王月月','湖南长沙','1321354655'),(3,'秦交','湖南永州','4456456456'),(4,'小秦总','湖南衡阳','4444545454'),(5,'小秦子','湖南衡阳','4456456456'),(6,'小月子','湖南衡阳','4456456456');

/*Table structure for table `stu_student` */

DROP TABLE IF EXISTS `stu_student`;

CREATE TABLE `stu_student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) DEFAULT NULL,
  `stu_number` varchar(50) DEFAULT NULL,
  `stu_sex` char(5) DEFAULT NULL,
  `stu_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `stu_student` */

insert  into `stu_student`(`stu_id`,`stu_name`,`stu_number`,`stu_sex`,`stu_address`) values (1,'秦小交','1511161551','男','湖南长沙'),(2,'秦中交','1511511515','女','湖南永州'),(3,'王月月','5615165151','女','湖南长沙'),(4,'张老三','5644687321','女','湖南长沙'),(5,'秦大交','1511161551','男','湖南长沙');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
