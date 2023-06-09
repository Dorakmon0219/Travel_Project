/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50540 (5.5.40)
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 50540 (5.5.40)
 File Encoding         : 65001

 Date: 09/06/2023 11:58:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hotel_info
-- ----------------------------
DROP TABLE IF EXISTS `hotel_info`;
CREATE TABLE `hotel_info`  (
  `hotelId` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `hotelName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `contacter` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `price` int(11) NOT NULL,
  `hotelType` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`hotelId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hotel_info
-- ----------------------------
INSERT INTO `hotel_info` VALUES ('1001', '竹轩大酒店', '重庆理工大学花溪校区', '18332143789', '寇雨波', 999, '宿舍');
INSERT INTO `hotel_info` VALUES ('1002', '松轩大酒店', '巴南区红光大道69号', '18332143788', '曹博', 666, '别墅');
INSERT INTO `hotel_info` VALUES ('1003', '宏新客房', '重庆市巴南区', '13933112490', '徐启航', 555, '旅馆');

SET FOREIGN_KEY_CHECKS = 1;
