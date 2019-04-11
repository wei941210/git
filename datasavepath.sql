/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.101:3306
Source Server Version : 50703
Source Host           : 192.168.1.101:3306
Source Database       : hnsecurity

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2018-08-06 14:57:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datasavepath
-- ----------------------------
DROP TABLE IF EXISTS `datasavepath`;
CREATE TABLE `datasavepath` (
  `path` varchar(255) DEFAULT NULL COMMENT '上报公安厅信息保存路径'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datasavepath
-- ----------------------------
INSERT INTO `datasavepath` VALUES ('D:/downloadfile/testfile');
