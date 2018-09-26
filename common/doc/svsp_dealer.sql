/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.136
Source Server Version : 50635
Source Host           : 192.168.0.136:3306
Source Database       : svsp_customer

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-09-18 14:11:30
*/
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer_balance_log
-- ----------------------------
/*DROP TABLE IF EXISTS `customer_balance_log`;
CREATE TABLE `customer_balance_log` (
  `balance_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '余额日志id',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `source` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '记录来源:1订单,2退货单',
  `source_sn` int(10) unsigned NOT NULL COMMENT '相关单据ID',
  `create_time` datetime NOT NULL COMMENT '记录生成时间',
  `amount` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '变动金额',
  PRIMARY KEY (`balance_id`),
  KEY `fk_customer_balance_log_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户余额变动表';*/

-- ----------------------------
-- Table structure for customer_inf
-- ----------------------------
/*DROP TABLE IF EXISTS `customer_inf`;
CREATE TABLE `customer_inf` (
  `customer_inf_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `customer_name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `identity_card_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证,2军官证,3护照',
  `identity_card_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `mobile_phone` int(10) unsigned DEFAULT NULL COMMENT '手机号',
  `customer_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `gender` char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `user_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `register_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `customer_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别:1普通会员,2青铜会员,3白银会员,4黄金会员,5钻石会员',
  `user_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`customer_inf_id`),
  UNIQUE KEY `fk_customer_inf_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';*/

-- ----------------------------
-- Table structure for customer_level_inf
-- ----------------------------
/*DROP TABLE IF EXISTS `customer_level_inf`;
CREATE TABLE `customer_level_inf` (
  `customer_level` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '会员级别ID',
  `level_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '会员级别名称',
  `min_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '该级别最低积分',
  `max_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '该级别最高积分',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`customer_level`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户级别信息表';
*/
-- ----------------------------
-- Table structure for customer_login
-- ----------------------------
DROP TABLE IF EXISTS `dealer_login`;
CREATE TABLE `dealer_login` (
  `uuid` varchar(50)COLLATE utf8_bin NOT NULL COMMENT '唯一标识',
  `dealer_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '经销商ID',
  `login_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '经销商登陆名（手机号）',
  `password` char(32) COLLATE utf8_bin NOT NULL COMMENT 'md5加密的密码',
  `user_stats` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `mobile_phone` bigint(20) NOT NULL,
  PRIMARY KEY (`dealer_id`),
  UNIQUE KEY `fk_customer_login_name` (`login_name`) USING HASH,
  UNIQUE KEY `fk_customer_login_phone` (`mobile_phone`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='经销商登录表';

-- ----------------------------
-- Table structure for customer_login_log
-- ----------------------------
/*DROP TABLE IF EXISTS `customer_login_log`;
CREATE TABLE `customer_login_log` (
  `login_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '登录日志ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '登录用户ID',
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户登录时间',
  `login_ip` int(10) unsigned NOT NULL COMMENT '登录IP',
  `login_type` tinyint(4) NOT NULL COMMENT '登录类型:0未成功 1成功',
  PRIMARY KEY (`login_id`),
  KEY `fk_customer_login_log_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录日志表';*/

-- ----------------------------
-- Table structure for customer_point_log
-- ----------------------------
/*DROP TABLE IF EXISTS `customer_point_log`;
CREATE TABLE `customer_point_log` (
  `point_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '积分日志ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `source` tinyint(3) unsigned NOT NULL COMMENT '积分来源:0订单,1登录,2活动',
  `refer_number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '积分来源相关编号',
  `change_point` smallint(6) NOT NULL DEFAULT '0' COMMENT '变更积分数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '积分日志生成时间',
  PRIMARY KEY (`point_id`),
  KEY `fk_customer_point_log_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户积分日志表';*/
