/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : testssh

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-05-18 18:41:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `t_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7gpwa36tirgaj6g0uhiws2ld` (`t_id`),
  CONSTRAINT `FK7gpwa36tirgaj6g0uhiws2ld` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'xue', 'male', '23', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tCourse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'wang', 'female', 'English');
