/*
 Navicat Premium Data Transfer

 Source Server         : wyx
 Source Server Type    : MySQL
 Source Server Version : 50538
 Source Host           : localhost:3306
 Source Schema         : ces

 Target Server Type    : MySQL
 Target Server Version : 50538
 File Encoding         : 65001

 Date: 30/04/2020 21:56:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cs_user
-- ----------------------------
DROP TABLE IF EXISTS `cs_user`;
CREATE TABLE `cs_user`  (
  `USER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GENDER` decimal(1, 0) NULL DEFAULT NULL,
  `BIRTHDAY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SAL` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PIC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cs_user
-- ----------------------------
INSERT INTO `cs_user` VALUES (1, 'xuan', '11', 1, '2020-04-11', 'xuan@gmail.com', '12121212', '/upload/3812bf5c-2e4c-4cca-841d-5cb4a30dc12e.jpg');
INSERT INTO `cs_user` VALUES (2, 'juan', '11', 0, '2020-04-10', 'xuan@gmail.com', '111111', '/upload/37084a1d-1e0b-4ac0-b6bf-8956231485a5.jpg');

SET FOREIGN_KEY_CHECKS = 1;
