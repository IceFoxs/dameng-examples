DROP TABLE `f_user`;
CREATE TABLE `f_user` (
  `id` char(36) NOT NULL,
  `username` varchar(10) NOT NULL DEFAULT '',
  `age` int(11) DEFAULT NULL,
  `sfrz` tinyint(4) DEFAULT '0',
  `xgsj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cjsj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;