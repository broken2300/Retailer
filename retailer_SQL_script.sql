/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : retailer

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-10 20:25:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `name` varchar(255) NOT NULL,
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for `credit`
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(16) NOT NULL,
  `CVS` varchar(5) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `birth` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `brand` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `price` double NOT NULL,
  `store` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `UPC` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `maxStock` int(11) NOT NULL,
  `stock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for `storelog`
-- ----------------------------
DROP TABLE IF EXISTS `storelog`;
CREATE TABLE `storelog` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `customer` int(11) NOT NULL COMMENT 'foreign key vender id',
  `store` int(11) NOT NULL COMMENT 'foreign key store id',
  `product` int(11) NOT NULL COMMENT 'foreign key product id',
  `amount` int(11) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storelog
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for `vendor`
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vendor
-- ----------------------------

-- ----------------------------
-- Table structure for `vendorlog`
-- ----------------------------
DROP TABLE IF EXISTS `vendorlog`;
CREATE TABLE `vendorlog` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `vender` int(11) NOT NULL COMMENT 'foreign key vender id',
  `store` int(11) NOT NULL COMMENT 'foreign key store id',
  `product` int(11) NOT NULL COMMENT 'foreign key product id',
  `amount` int(11) NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vendorlog
-- ----------------------------

-- ----------------------------
-- Table structure for `vendorproduct`
-- ----------------------------
DROP TABLE IF EXISTS `vendorproduct`;
CREATE TABLE `vendorproduct` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `vendor` int(11) NOT NULL,
  `product` varchar(255) NOT NULL,
  `prize` double NOT NULL,
  `size` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vendorproduct
-- ----------------------------
