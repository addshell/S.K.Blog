/*
Navicat MySQL Data Transfer

Source Server         : MySQLForServer
Source Server Version : 50712
Source Host           : zhanghe.ac.cn:3306
Source Database       : sk_blog

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-03-16 12:46:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(10) NOT NULL AUTO_INCREMENT,
  `articleTitle` varchar(255) DEFAULT NULL,
  `articleContent` longtext,
  `publishTime` datetime DEFAULT NULL,
  `userId` int(5) DEFAULT NULL,
  `categoryId` int(10) DEFAULT NULL,
  PRIMARY KEY (`articleId`),
  KEY `userid` (`userId`) USING BTREE,
  KEY `categoryid` (`categoryId`) USING BTREE,
  CONSTRAINT `categoryid` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`),
  CONSTRAINT `userid_a` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '武当山', '2017-03-13 22:50:56', '男', '张5分');
INSERT INTO `car` VALUES ('2', '武当山', '2017-03-13 22:51:30', '男', '张66分');
INSERT INTO `car` VALUES ('10', 'wejfi', '2017-10-23 00:00:00', 'man', 'zhangwuji');
INSERT INTO `car` VALUES ('11', '武当山', '2017-03-14 11:39:05', '男', '张77分');
INSERT INTO `car` VALUES ('12', '武当山', '2017-03-14 11:47:30', '男', '张77分');
INSERT INTO `car` VALUES ('13', '武当山', '2017-03-14 11:50:20', '男', '张77分');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(18) NOT NULL,
  `categoryName` varchar(255) DEFAULT NULL,
  `userId` int(5) DEFAULT NULL,
  PRIMARY KEY (`categoryId`),
  KEY `userid` (`userId`) USING BTREE,
  CONSTRAINT `userid` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(10) NOT NULL AUTO_INCREMENT,
  `commentUser` varchar(255) DEFAULT NULL,
  `commentContent` text,
  `commentTime` datetime DEFAULT NULL,
  `articleId` int(10) DEFAULT NULL,
  PRIMARY KEY (`commentId`),
  KEY `articleid` (`articleId`) USING BTREE,
  CONSTRAINT `articleid` FOREIGN KEY (`articleId`) REFERENCES `article` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(5) NOT NULL AUTO_INCREMENT,
  `messageName` varchar(255) DEFAULT NULL,
  `messageTime` datetime DEFAULT NULL,
  `messageContent` text,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPass` varchar(255) DEFAULT NULL,
  `userPhone` int(11) DEFAULT NULL,
  `root` tinyint(1) DEFAULT NULL,
  `commentPower` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hjji', '156156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('2', 'hjji', '156156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('5', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('6', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('7', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('8', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('9', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('10', 'hjji', '1567156', '1356627998', '1', '0');
INSERT INTO `user` VALUES ('11', 'hjji', '1567156', '1356627998', '1', '0');
