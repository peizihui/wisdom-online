CONFIG SET protected-mode no

CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `status_id` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '状态(1:正常，0:禁用)',
  `sort` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '排序',
  `user_no` bigint(20) NOT NULL COMMENT '用户编号',
  `mobile` char(11) NOT NULL DEFAULT '' COMMENT '手机',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_phone` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='后台用户信息';

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'2018-03-31 11:22:37','2018-05-10 15:28:40',1,1,2018033111202589416,'18800000000','超级管理员','超级管理员'),(2,'2018-12-28 16:57:47','2018-12-28 16:57:47',1,1,2018112209531803,'13800000000','普通用户','测试demo用户');
