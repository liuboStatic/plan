CREATE TABLE `tb_plan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT ''主键'',
  `plan_info` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT ''计划内容'',
  `plan_end_time` datetime DEFAULT NULL COMMENT ''计划时间'',
  `is_end` tinyint(1) DEFAULT NULL COMMENT ''是否完成'',
  `create_time` datetime DEFAULT NULL COMMENT ''创建时间'',
  `create_user` int DEFAULT NULL COMMENT ''创建用户'',
  `update_time` datetime DEFAULT NULL COMMENT ''修改时间'',
  `update_user` int DEFAULT NULL COMMENT ''修改用户'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;