-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Dec 06, 2016 at 05:10 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `contacts`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `mycontacts`
-- 

CREATE TABLE `mycontacts` (
  `contactname` varchar(50) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `mycontacts`
-- 

INSERT INTO `mycontacts` VALUES ('user', '0899999999', 'user@gmail.com');
INSERT INTO `mycontacts` VALUES ('admin', '0811111111', 'admin@hotmail.com');
INSERT INTO `mycontacts` VALUES ('Josh', '0999999999', 'josh@gmail.com');
INSERT INTO `mycontacts` VALUES ('Yodchai', '0123456789', 'yodchai@siam.edu');
