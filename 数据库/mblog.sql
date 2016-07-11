/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : mblog

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-07-03 22:23:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `password` varchar(20) default NULL,
  `username` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `articlescrap`
-- ----------------------------
DROP TABLE IF EXISTS `articlescrap`;
CREATE TABLE `articlescrap` (
  `aid` int(11) NOT NULL auto_increment,
  `atype` int(11) default NULL,
  `img` varchar(255) default NULL,
  `text` longtext,
  `time` varchar(255) default NULL,
  `title` varchar(30) default NULL,
  `type` varchar(20) default NULL,
  `user_id` int(11) default NULL,
  `userinfo_id` int(11) default NULL,
  PRIMARY KEY  (`aid`),
  UNIQUE KEY `aid` (`aid`),
  KEY `FKF35D78BBA59BC15D` (`user_id`),
  KEY `FKF35D78BB1EEB453D` (`userinfo_id`),
  CONSTRAINT `FKF35D78BB1EEB453D` FOREIGN KEY (`userinfo_id`) REFERENCES `userinfo` (`user_id`),
  CONSTRAINT `FKF35D78BBA59BC15D` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articlescrap
-- ----------------------------
INSERT INTO `articlescrap` VALUES ('1', '0', '', '123', '2016-07-01 12:26', null, '个人日志', '2', '2');
INSERT INTO `articlescrap` VALUES ('2', '0', '', '123', '2016-07-01 12:27', null, '个人日志', '2', '2');
INSERT INTO `articlescrap` VALUES ('3', '0', '', '123', '2016-07-01 12:27', null, '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('4', '1', '71601.jpg', '打打撒', '2016-07-01 12:28', '我好方', '个人日志', '2', '2');
INSERT INTO `articlescrap` VALUES ('5', '0', '', '3123das', '2016-07-01 12:32', null, '签到说说', '3', '3');
INSERT INTO `articlescrap` VALUES ('6', '0', '', '123', '2016-07-01 12:33', null, '个人日志', '2', '2');
INSERT INTO `articlescrap` VALUES ('7', '0', '', '今儿个心情真是好!', '2016-07-01 18:56', null, '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('8', '0', '', '123123', '2016-07-01 19:10', null, '个人日志', '1', '1');
INSERT INTO `articlescrap` VALUES ('9', '0', '', '哇哈哈', '2016-07-01 20:03', null, '签到说说', '3', '3');
INSERT INTO `articlescrap` VALUES ('10', '0', '', '123', '2016-07-01 20:29', null, '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('11', '0', '', '哇哈哈', '2016-07-01 20:41', null, '签到说说', '3', '3');
INSERT INTO `articlescrap` VALUES ('12', '1', '223getAvatar.do.jpg', '散失散失', '2016-07-01 20:42', '哇哈哈哈', '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('13', '1', '541getAvatar.do.jpg', '散失散失', '2016-07-01 20:43', '哇哈哈哈', '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('14', '1', '31getAvatar.do.jpg', '散失散失', '2016-07-01 20:44', '哇哈哈哈', '个人日志', '3', '3');
INSERT INTO `articlescrap` VALUES ('15', '0', '', '哇哈哈', '2016-07-01 20:44', null, '个人日志', '3', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `password` varchar(20) default NULL,
  `username` varchar(20) default NULL,
  PRIMARY KEY  (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1234', 'shichao');
INSERT INTO `user` VALUES ('2', '1234', 'shengyong');
INSERT INTO `user` VALUES ('3', '1234', 'student');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL auto_increment,
  `uiBrithdate` varchar(20) default NULL,
  `uiBrithplace` varchar(20) default NULL,
  `uiEmail` varchar(20) default NULL,
  `uiNickname` varchar(20) default NULL,
  `uiTel` varchar(11) default NULL,
  `userImg` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '1994-10-24', '济南', '750229099@qq.com', '若水犹离', '17853593651', '33101.jpg');
INSERT INTO `userinfo` VALUES ('2', '1994-10-24', '乐陵', '12312314@qq.com', '宋红勇', '18865588578', '6getAvatar.do.jpg');
INSERT INTO `userinfo` VALUES ('3', '1994-06-20', '济南', '12312314@qq.com', '三好学生', '17853593651', '438type_04.jpg');
