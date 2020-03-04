/*
Navicat MySQL Data Transfer

Source Server         : MySQLForServer
Source Server Version : 50712
Source Host           : zhanghe.ac.cn:3306
Source Database       : s.k.blog

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-14 11:34:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `sid` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '武当山', '2017-03-13 22:50:56', '男', '张5分');
INSERT INTO `car` VALUES ('2', '武当山', '2017-03-13 22:51:30', '男', '张66分');
