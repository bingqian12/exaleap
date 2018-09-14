/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : svsp_order

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 09/13/2018 10:05:25 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `order_cart`
-- ----------------------------
DROP TABLE IF EXISTS `order_cart`;
CREATE TABLE `order_cart` (
  `cart_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `product_amount` int(11) NOT NULL COMMENT '加入购物车商品数量',
  `price` decimal(8,2) NOT NULL COMMENT '商品价格',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入购物车时间',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`cart_id`),
  KEY `fk_order_cart_customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='购物车表';

-- ----------------------------
--  Table structure for `order_customer_addr`
-- ----------------------------
DROP TABLE IF EXISTS `order_customer_addr`;
CREATE TABLE `order_customer_addr` (
  `customer_addr_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT 'customer_login表的自增ID',
  `zip` int(11) NOT NULL COMMENT '邮编',
  `province` int(11) NOT NULL COMMENT '地区表中省份的id',
  `city` int(11) NOT NULL COMMENT '地区表中城市的id',
  `district` int(11) NOT NULL COMMENT '地区表中的区id',
  `address` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '具体的地址门牌号',
  `is_default` tinyint(4) NOT NULL COMMENT '是否默认',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`customer_addr_id`),
  KEY `fk_order_addr_customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户地址表';

-- ----------------------------
--  Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID,订单详情表ID',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单表ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '订单商品ID',
  `product_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `product_cnt` int(11) NOT NULL DEFAULT '1' COMMENT '购买商品数量',
  `product_price` decimal(8,2) NOT NULL COMMENT '购买商品单价',
  `average_cost` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '平均成本价格',
  `weight` float DEFAULT NULL COMMENT '商品重量',
  `fee_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠分摊金额',
  `w_id` int(10) unsigned NOT NULL COMMENT '仓库ID',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`order_detail_id`),
  UNIQUE KEY `fk_order_detail_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单详情表';

-- ----------------------------
--  Table structure for `order_master`
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_sn` bigint(20) unsigned NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '下单人ID',
  `shipping_user` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '收货人姓名',
  `province` smallint(6) NOT NULL COMMENT '收货人所在省',
  `city` smallint(6) NOT NULL COMMENT '收货人所在市',
  `district` smallint(6) NOT NULL COMMENT '收货人所在区',
  `address` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '收货人详细地址',
  `payment_method` tinyint(4) NOT NULL COMMENT '支付方式:1现金,2余额,3网银,4支付宝,5微信',
  `order_money` decimal(8,2) NOT NULL COMMENT '订单金额',
  `district_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `shipping_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '运费金额',
  `payment_money` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '支付金额',
  `shipping_comp_name` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '快递公司名称',
  `shipping_sn` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '快递单号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `shipping_time` datetime DEFAULT NULL COMMENT '发货时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `order_point` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单积分',
  `invoice_title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '发票抬头',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `fk_order_master_order_sn` (`order_sn`),
  KEY `fk_order_master_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单主表';

-- ----------------------------
--  Table structure for `region_info`
-- ----------------------------
DROP TABLE IF EXISTS `region_info`;
CREATE TABLE `region_info` (
  `region_id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` smallint(6) NOT NULL DEFAULT '0' COMMENT '上级地区id',
  `region_name` varchar(150) COLLATE utf8_bin NOT NULL COMMENT '城市名称',
  `region_level` tinyint(1) NOT NULL COMMENT '级别',
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区信息表';

-- ----------------------------
--  Table structure for `shipping_info`
-- ----------------------------
DROP TABLE IF EXISTS `shipping_info`;
CREATE TABLE `shipping_info` (
  `ship_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ship_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '物流公司名称',
  `ship_contact` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '物流公司联系人',
  `telphone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '物流公司联系电话',
  `price` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '配送价格',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='物流公司信息表';

-- ----------------------------
--  Table structure for `warehouse_info`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_info`;
CREATE TABLE `warehouse_info` (
  `w_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  `warehouse_sn` char(5) COLLATE utf8_bin NOT NULL COMMENT '仓库编码',
  `warehouse_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '仓库名称',
  `warehouse_phone` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '仓库电话',
  `contact` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '仓库联系人',
  `province` smallint(6) NOT NULL COMMENT '省',
  `city` smallint(6) NOT NULL COMMENT '市',
  `district` smallint(6) NOT NULL COMMENT '区',
  `address` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '仓库地址',
  `warehouse_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '仓库状态:0禁用,1启用',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`w_id`),
  UNIQUE KEY `fk_warehouse_info_sn` (`warehouse_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='仓库信息表';

-- ----------------------------
--  Table structure for `warehouse_proudct`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_proudct`;
CREATE TABLE `warehouse_proudct` (
  `wp_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `w_id` smallint(5) unsigned NOT NULL COMMENT '仓库ID',
  `currnet_cnt` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '当前商品数量',
  `lock_cnt` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '当前占用数据',
  `in_transit_cnt` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '在途数据',
  `average_cost` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '移动加权成本',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`wp_id`),
  KEY `fk_warehouse_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品库存表';

SET FOREIGN_KEY_CHECKS = 1;
