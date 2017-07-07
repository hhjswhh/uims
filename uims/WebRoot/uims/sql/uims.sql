/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.0.21-community : Database - uims
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`uims` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `uims`;

/*Table structure for table `t_sys_message` */

DROP TABLE IF EXISTS `t_sys_message`;

CREATE TABLE `t_sys_message` (
  `m_ph` char(11) NOT NULL,
  `m_messageContext` varchar(16) default NULL,
  `m_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `m_info_lid` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_message` */

/*Table structure for table `t_sys_urgent` */

DROP TABLE IF EXISTS `t_sys_urgent`;

CREATE TABLE `t_sys_urgent` (
  `m_id` int(9) NOT NULL auto_increment,
  `m_title` varchar(80) NOT NULL,
  `m_context` text NOT NULL,
  `m_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `m_reviewState` char(1) NOT NULL,
  `m_ph` char(11) NOT NULL,
  `m_name` varchar(30) NOT NULL,
  `m_mail` varchar(30) NOT NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_urgent` */

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `m_ph` char(11) NOT NULL,
  `m_img` varchar(100) NOT NULL,
  `m_name` varchar(30) NOT NULL,
  `m_sex` char(1) NOT NULL,
  `m_mail` varchar(30) default NULL,
  `m_addr` varchar(100) default NULL,
  `m_pwd` varchar(30) NOT NULL,
  `m_type` char(1) NOT NULL,
  `m_delete` char(1) NOT NULL,
  PRIMARY KEY  (`m_ph`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`m_ph`,`m_img`,`m_name`,`m_sex`,`m_mail`,`m_addr`,`m_pwd`,`m_type`,`m_delete`) values ('15853136112','122','admin','1','222@163.com',NULL,'123','3','1');

/*Table structure for table `t_uims_info` */

DROP TABLE IF EXISTS `t_uims_info`;

CREATE TABLE `t_uims_info` (
  `m_id` int(9) NOT NULL auto_increment,
  `m_title` varchar(80) NOT NULL,
  `m_context` text NOT NULL,
  `m_date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `m_type` varchar(8) NOT NULL,
  `m_payState` char(1) NOT NULL,
  `m_payType` char(1) NOT NULL,
  `m_reviewState` char(1) NOT NULL,
  `m_ph` char(11) NOT NULL,
  `m_name` varchar(30) NOT NULL,
  `m_mail` varchar(30) NOT NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_uims_info` */

/*Table structure for table `t_uims_relation` */

DROP TABLE IF EXISTS `t_uims_relation`;

CREATE TABLE `t_uims_relation` (
  `m_user_ph` char(11) NOT NULL,
  `m_info_id` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_uims_relation` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
