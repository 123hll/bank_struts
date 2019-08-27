/*
MySQL Data Transfer
Source Host: localhost
Source Database: llc
Target Host: localhost
Target Database: llc
Date: 2011-12-2 9:06:16
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `sex` varchar(2) default NULL,
  `email` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` int(4) NOT NULL auto_increment,
  `head` varchar(50) NOT NULL,
  `text` varchar(500) default NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `usename` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `id` int(4) NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `stu_id` int(4) NOT NULL,
  `class_id` int(4) NOT NULL,
  `grade` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `n1` (`stu_id`),
  KEY `n2` (`class_id`),
  CONSTRAINT `n1` FOREIGN KEY (`stu_id`) REFERENCES `register` (`id`) ON DELETE CASCADE,
  CONSTRAINT `n2` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(4) NOT NULL,
  `class` varchar(8) NOT NULL,
  `teacher` varchar(8) NOT NULL,
  `score` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `register` VALUES ('3', 'admin', 'admin', '男', '290969298@163.com');
INSERT INTO `register` VALUES ('4', 'llc', '123456', '男', '22222222222@qq.com');
INSERT INTO `register` VALUES ('6', '22222', '22222', '男', '223');
INSERT INTO `register` VALUES ('7', 'la', 'la', '男', 'lksdjf');
INSERT INTO `title` VALUES ('2', '啊啊', '啊 啊的上发生的', '2011年11月1日 6:19:32');
INSERT INTO `title` VALUES ('3', '爱的22份11', '爱上对方爱上对方爱的身份撒旦法是111', '2011年11月1日 6:19:44');
INSERT INTO `title` VALUES ('4', '撒旦法', '爱上对方爱上对方爱asdfasdf', '2011年11月1日 7:13:11');
INSERT INTO `user` VALUES ('admin', '123', '1');
INSERT INTO `user` VALUES ('llc', '123456', '2');
INSERT INTO `grade` VALUES ('1', '3', '2', '100');
INSERT INTO `grade` VALUES ('2', '4', '1', '72.5');
INSERT INTO `grade` VALUES ('6', '5', '2', '70');
INSERT INTO `grade` VALUES ('7', '3', '7', '100');
INSERT INTO `grade` VALUES ('8', '3', '6', '99');
INSERT INTO `grade` VALUES ('9', '4', '4', '100');
INSERT INTO `grade` VALUES ('11', '3', '4', '100');
INSERT INTO `class` VALUES ('1', 'JAVA', '陈雪军', '5');
INSERT INTO `class` VALUES ('2', 'C++', '张三皮', '1');
INSERT INTO `class` VALUES ('3', '路由技术', '李克伟', '2');
INSERT INTO `class` VALUES ('4', '交换技术', '张丹丹', '4.5');
INSERT INTO `class` VALUES ('5', 'orcal', '洗', '5');
INSERT INTO `class` VALUES ('6', '软件工程', '在行动', '2.5');
INSERT INTO `class` VALUES ('7', '数据库', '了侧身', '1.5');

