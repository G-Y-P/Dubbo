/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySql
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:33066
 Source Schema         : dubbo_one

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 06/04/2020 20:26:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item_info
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(15, 2) NULL DEFAULT NULL COMMENT '销售价',
  `is_active` int(11) NULL DEFAULT 1 COMMENT '是否有效（1=是；0=否）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_code`(`code`) USING BTREE COMMENT '商品编码唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item_info
-- ----------------------------
INSERT INTO `item_info` VALUES (1, '10010', 'Java编程思想', 58.50, 1, '2019-01-13 14:07:58', NULL);
INSERT INTO `item_info` VALUES (2, '10011', '由浅入深实战分布式中间件', 45.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (3, '10012', 'Dubbo实战教程', 68.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (4, '10013', 'JVM深入实战指南', 38.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (5, '10014', 'SpringBoot实战', 56.50, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (6, '10015', 'SpringCloud实战', 64.00, 1, '2019-01-13 14:07:59', NULL);
INSERT INTO `item_info` VALUES (7, '10017', 'Mysql实战指南', 75.50, 1, '2019-01-13 14:07:59', NULL);

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `item_id` int(11) NOT NULL COMMENT '商品ID',
  `total` int(11) NOT NULL COMMENT '数量',
  `customer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `is_active` int(11) NULL DEFAULT NULL COMMENT '是否有效（1=是，0=否）',
  `order_time` datetime NULL DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES (2, 1, 2, 'jack', NULL, '2020-03-30 16:57:03', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ew', 3);
INSERT INTO `user` VALUES (2, 'fd', 4);
INSERT INTO `user` VALUES (3, 'fvbd', 3);
INSERT INTO `user` VALUES (4, 'fdgd', 4);
INSERT INTO `user` VALUES (5, 'fdv', 5);

SET FOREIGN_KEY_CHECKS = 1;
