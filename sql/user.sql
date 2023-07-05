CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `account` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `ip` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;