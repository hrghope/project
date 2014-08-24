CREATE TABLE `warehouse` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dev_code` varchar(200) COLLATE utf8_bin NOT NULL,
  `dev_type` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `in_date` datetime NOT NULL,
  `out_date` datetime DEFAULT NULL,
  `state` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_warehouse_devcode` (`dev_code`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin