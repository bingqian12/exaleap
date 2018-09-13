/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : svsp_product

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 09/13/2018 10:05:34 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `product_brand_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_brand_info`;
CREATE TABLE `product_brand_info` (
  `brand_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '品牌ID',
  `brand_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '品牌名称',
  `telephone` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `brand_web` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌网站',
  `brand_logo` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌logo URL',
  `brand_desc` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌描述',
  `brand_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '品牌状态,0禁用,1启用',
  `brand_order` tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='品牌信息表';

-- ----------------------------
--  Records of `product_brand_info`
-- ----------------------------
BEGIN;
INSERT INTO `product_brand_info` VALUES ('1', '探路者', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('2', 'Columbia', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('3', '骆驼', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('4', '凯乐石', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('5', '北极狐', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('6', 'TheNorthFace', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('7', 'SALOMON', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('8', 'LOWA', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('9', '伯希和', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('10', '诺诗兰', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('11', 'Jack Wolfskin', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('12', '金狐狸', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('13', 'JACK&JONES', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('14', 'Lee', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('15', '太平鸟', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('16', '李宁', '', null, null, null, '1', '0', '2018-09-12 22:43:05'), ('17', 'NB', '', null, null, null, '1', '0', '2018-09-12 22:43:05');
COMMIT;

-- ----------------------------
--  Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '分类名称',
  `category_code` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '分类编码',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父分类ID',
  `category_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类层级',
  `category_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类状态',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品分类表';

-- ----------------------------
--  Records of `product_category`
-- ----------------------------
BEGIN;
INSERT INTO `product_category` VALUES ('1', '女装', '01', '0', '1', '1', '2018-09-12 22:43:05'), ('2', '男装', '02', '0', '1', '1', '2018-09-12 22:43:05'), ('3', '内衣', '03', '0', '1', '1', '2018-09-12 22:43:05'), ('4', '女鞋', '04', '0', '1', '1', '2018-09-12 22:43:05'), ('5', '男鞋', '05', '0', '1', '1', '2018-09-12 22:43:05'), ('6', '户外', '06', '0', '1', '1', '2018-09-12 22:43:05'), ('7', '运动', '07', '0', '1', '1', '2018-09-12 22:43:05'), ('8', '童装', '08', '0', '1', '1', '2018-09-12 22:43:05'), ('9', '女士裙装', '0101', '1', '2', '1', '2018-09-12 22:43:05'), ('10', '女士上装', '0102', '1', '2', '1', '2018-09-12 22:43:05'), ('11', '女士下装', '0103', '1', '2', '1', '2018-09-12 22:43:05'), ('12', '男士上装', '0201', '2', '2', '1', '2018-09-12 22:43:05'), ('13', '男士下装', '0202', '2', '2', '1', '2018-09-12 22:43:05'), ('14', '户外鞋服', '0601', '6', '2', '1', '2018-09-12 22:43:05'), ('15', '户外装备', '0602', '6', '2', '1', '2018-09-12 22:43:05'), ('16', '垂钓用品', '0603', '6', '2', '1', '2018-09-12 22:43:05'), ('17', '连衣裙', '010101', '9', '3', '1', '2018-09-12 22:43:05'), ('18', '蕾丝裙', '010102', '9', '3', '1', '2018-09-12 22:43:05'), ('19', '套装裙', '010103', '9', '3', '1', '2018-09-12 22:43:05'), ('20', '棉麻连衣裙', '010104', '9', '3', '1', '2018-09-12 22:43:05'), ('21', '针织裙', '010105', '9', '3', '1', '2018-09-12 22:43:05'), ('22', 'a字裙', '010106', '9', '3', '1', '2018-09-12 22:43:05'), ('23', '长裙', '010107', '9', '3', '1', '2018-09-12 22:43:05'), ('24', '针织衫', '010201', '10', '3', '1', '2018-09-12 22:43:05'), ('25', '衬衫', '010202', '10', '3', '1', '2018-09-12 22:43:05'), ('26', 'T恤', '010203', '10', '3', '1', '2018-09-12 22:43:05'), ('27', '雪纺衫', '010204', '10', '3', '1', '2018-09-12 22:43:05'), ('28', '外套', '010205', '10', '3', '1', '2018-09-12 22:43:05'), ('29', '小西装', '010206', '10', '3', '1', '2018-09-12 22:43:05'), ('30', '风衣', '010207', '10', '3', '1', '2018-09-12 22:43:05'), ('31', '休闲裤', '010301', '11', '3', '1', '2018-09-12 22:43:05'), ('32', '牛仔裤', '010302', '11', '3', '1', '2018-09-12 22:43:05'), ('33', '连体裤', '010303', '11', '3', '1', '2018-09-12 22:43:05'), ('34', '哈伦裤', '010304', '11', '3', '1', '2018-09-12 22:43:05'), ('35', '九分裤', '010305', '11', '3', '1', '2018-09-12 22:43:05'), ('36', '小脚裤', '010306', '11', '3', '1', '2018-09-12 22:43:05'), ('37', '打底裤', '010307', '11', '3', '1', '2018-09-12 22:43:05'), ('38', '夹克', '020101', '19', '3', '1', '2018-09-12 22:43:05'), ('39', '衬衫', '020102', '19', '3', '1', '2018-09-12 22:43:05'), ('40', '卫衣', '020103', '19', '3', '1', '2018-09-12 22:43:05'), ('41', '风衣', '020104', '19', '3', '1', '2018-09-12 22:43:05'), ('42', '皮衣', '020105', '19', '3', '1', '2018-09-12 22:43:05'), ('43', '西服套装', '020106', '19', '3', '1', '2018-09-12 22:43:05'), ('44', '毛衣', '020107', '19', '3', '1', '2018-09-12 22:43:05'), ('45', '冲锋衣裤', '060101', '49', '3', '1', '2018-09-12 22:43:05'), ('46', '速干衣裤', '060102', '49', '3', '1', '2018-09-12 22:43:05'), ('47', '滑雪服', '060103', '49', '3', '1', '2018-09-12 22:43:05'), ('48', '户外风衣', '060104', '49', '3', '1', '2018-09-12 22:43:05'), ('49', '雪地靴', '060105', '49', '3', '1', '2018-09-12 22:43:05'), ('50', '溯溪鞋', '060106', '49', '3', '1', '2018-09-12 22:43:05'), ('51', '徒步鞋', '060107', '49', '3', '1', '2018-09-12 22:43:05'), ('52', '帐篷', '060201', '50', '3', '1', '2018-09-12 22:43:05'), ('53', '睡袋', '060202', '50', '3', '1', '2018-09-12 22:43:05'), ('54', '野餐烧烤', '060203', '50', '3', '1', '2018-09-12 22:43:05'), ('55', '登山攀岩', '060204', '50', '3', '1', '2018-09-12 22:43:05'), ('56', '背包', '060205', '50', '3', '1', '2018-09-12 22:43:05'), ('57', '户外照明', '060206', '50', '3', '1', '2018-09-12 22:43:05'), ('58', '极限户外', '060207', '50', '3', '1', '2018-09-12 22:43:05'), ('59', '钓竿', '060301', '51', '3', '1', '2018-09-12 22:43:05'), ('60', '鱼线', '060302', '51', '3', '1', '2018-09-12 22:43:05'), ('61', '浮漂', '060303', '51', '3', '1', '2018-09-12 22:43:05'), ('62', '鱼饵', '060304', '51', '3', '1', '2018-09-12 22:43:05'), ('63', '鱼包', '060305', '51', '3', '1', '2018-09-12 22:43:05'), ('64', '钓箱', '060306', '51', '3', '1', '2018-09-12 22:43:05'), ('65', '鱼线轮', '060307', '51', '3', '1', '2018-09-12 22:43:05');
COMMIT;

-- ----------------------------
--  Table structure for `product_comment`
-- ----------------------------
DROP TABLE IF EXISTS `product_comment`;
CREATE TABLE `product_comment` (
  `comment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单ID',
  `customer_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '评论标题',
  `content` varchar(300) COLLATE utf8_bin NOT NULL COMMENT '评论内容',
  `audit_status` tinyint(4) NOT NULL COMMENT '审核状态:0未审核1已审核',
  `audit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`comment_id`),
  KEY `fk_product_comment_product_id` (`product_id`) USING BTREE,
  KEY `fk_product_comment_order_id` (`order_id`) USING BTREE,
  KEY `fk_product_comment_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品评论表';

-- ----------------------------
--  Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `product_code` char(16) COLLATE utf8_bin NOT NULL COMMENT '商品编码',
  `product_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `bar_code` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '国条码',
  `brand_id` int(10) unsigned NOT NULL COMMENT '品牌表的ID',
  `one_category_id` int(10) unsigned NOT NULL COMMENT '一级分类ID',
  `two_category_id` int(10) unsigned NOT NULL COMMENT '二级分类ID',
  `three_category_id` int(10) unsigned NOT NULL COMMENT '三级分类ID',
  `supplier_id` int(10) unsigned NOT NULL COMMENT '商品的供应商id',
  `price` decimal(8,2) NOT NULL COMMENT '商品销售价格',
  `average_cost` decimal(18,2) NOT NULL COMMENT '商品加权平均成本',
  `publish_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '上下架状态:0下架1上架',
  `audit_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '审核状态:0未审核,1已审核',
  `weight` float DEFAULT NULL COMMENT '商品重量',
  `length` float DEFAULT NULL COMMENT '商品长度',
  `heigh` float DEFAULT NULL COMMENT '商品高度',
  `width` float DEFAULT NULL COMMENT '商品宽度',
  `color_type` enum('红','黄','蓝','黒') COLLATE utf8_bin DEFAULT NULL,
  `production_date` datetime NOT NULL COMMENT '生产日期',
  `shelf_life` int(11) NOT NULL COMMENT '商品有效期',
  `descript` text COLLATE utf8_bin NOT NULL COMMENT '商品描述',
  `indate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品信息表';

-- ----------------------------
--  Table structure for `product_pic_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_pic_info`;
CREATE TABLE `product_pic_info` (
  `product_pic_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `pic_desc` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '图片描述',
  `pic_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '图片URL',
  `is_master` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否主图:0.非主图1.主图',
  `pic_order` tinyint(4) NOT NULL DEFAULT '0' COMMENT '图片排序',
  `pic_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '图片是否有效:0无效 1有效',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`product_pic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品图片信息表';

-- ----------------------------
--  Table structure for `product_supplier_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_supplier_info`;
CREATE TABLE `product_supplier_info` (
  `supplier_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `supplier_code` char(8) COLLATE utf8_bin NOT NULL COMMENT '供应商编码',
  `supplier_name` char(50) COLLATE utf8_bin NOT NULL COMMENT '供应商名称',
  `supplier_type` tinyint(4) NOT NULL COMMENT '供应商类型:1.自营,2.平台',
  `link_man` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '供应商联系人',
  `phone_number` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `bank_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '供应商开户银行名称',
  `bank_account` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '银行账号',
  `address` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '供应商地址',
  `supplier_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:0禁用,1启用',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='供应商信息表';

-- ----------------------------
--  Records of `product_supplier_info`
-- ----------------------------
BEGIN;
INSERT INTO `product_supplier_info` VALUES ('1', '10001', '供应商-1', '1', '张三', '13800138001', '工商银行', '62988776444333', '上海', '1', '2018-09-12 22:43:05'), ('2', '10002', '供应商-2', '1', '李四', '13800138002', '招行银行', '629809988765533', '天津', '1', '2018-09-12 22:43:05'), ('3', '20001', '供应商-3', '1', '王五', '13800138003', '中国银行', '12345656785443', '北京', '1', '2018-09-12 22:43:05');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
