/*
 Navicat Premium Data Transfer

 Source Server         : MySQLDB
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : onlineshop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 24/11/2020 23:40:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '13-inch MacBook Air with Apple M1 Chip', 7999.00);
INSERT INTO `goods` VALUES (2, '13-inch MacBook Pro with Apple M1 Chip', 9999.00);
INSERT INTO `goods` VALUES (3, '16-inch MacBook Pro with Intel Core i9 Processor', 18999.00);
INSERT INTO `goods` VALUES (4, '27-inch iMac with Intel Core i7 Processor', 14399.00);
INSERT INTO `goods` VALUES (5, 'Mac mini with Apple M1 Chip', 5299.00);
INSERT INTO `goods` VALUES (6, 'Mac Pro with Intel Xeon W processor', 389472.00);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('abc', '123', 1);
INSERT INTO `users` VALUES ('Alex', '123', 2);
INSERT INTO `users` VALUES ('null', 'null', 3);
INSERT INTO `users` VALUES ('root', '123456', 4);
INSERT INTO `users` VALUES ('xh', '111', 5);
INSERT INTO `users` VALUES ('yql', '0046', 6);
INSERT INTO `users` VALUES ('sw', '111', 7);
INSERT INTO `users` VALUES ('test1', '123', 8);

SET FOREIGN_KEY_CHECKS = 1;
