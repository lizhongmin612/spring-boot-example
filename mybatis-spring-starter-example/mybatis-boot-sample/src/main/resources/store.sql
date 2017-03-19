/*
SQLyog Ultimate v11.22 (64 bit)
MySQL - 5.7.17 : Database - store
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;


/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brand_id` int(10) unsigned NOT NULL COMMENT '品牌id',
  `inventory` int(10) unsigned NOT NULL COMMENT '库存数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uiq_bid` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `car` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
