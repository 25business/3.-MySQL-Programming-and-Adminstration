-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 28, 2021 at 07:48 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `m4_employee_system`
--
CREATE DATABASE IF NOT EXISTS `m4_employee_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `m4_employee_system`;

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
CREATE TABLE IF NOT EXISTS `departments` (
  `departments_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) NOT NULL,
  `department_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`departments_id`),
  KEY `FK_managers` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`departments_id`, `manager_id`, `department_name`) VALUES
(1, 7, 'Research and Development'),
(2, 11, 'Marketing'),
(3, 11, 'Product Management'),
(4, 15, 'Human Resources'),
(5, 20, 'Accounting');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `employees_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`employees_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employees_id`, `first_name`, `last_name`, `email`) VALUES
(1, 'Gabrila', 'Ney', 'gney0@purevolume.com'),
(2, 'Lavinie', 'Ewbanke', 'lewbanke1@earthlink.net'),
(3, 'Ansley', 'Croster', 'acroster2@istockphoto.com'),
(4, 'Manda', 'Bredbury', 'mbredbury3@issuu.com'),
(5, 'Siouxie', 'Rickman', 'srickman4@washington.edu'),
(6, 'Idalina', 'Bernadzki', 'ibernadzki5@ycombinator.com'),
(7, 'Leontyne', 'McGrudder', 'lmcgrudder6@amazon.de'),
(8, 'Cointon', 'Leroy', 'cleroy7@ft.com'),
(9, 'Victoria', 'Christmas', 'vchristmas8@artisteer.com'),
(10, 'Carin', 'Methley', 'cmethley9@gmpg.org'),
(11, 'Gustav', 'Gilhouley', 'ggilhouleya@wikipedia.org'),
(12, 'Meryl', 'Soutar', 'msoutarb@topsy.com'),
(13, 'Thane', 'Blunkett', 'tblunkettc@netscape.com'),
(14, 'Sigfried', 'Vaadeland', 'svaadelandd@mozilla.org'),
(15, 'Vivianna', 'Feander', 'vfeandere@virginia.edu'),
(16, 'Melli', 'Doherty', 'mdohertyf@liveinternet.ru'),
(17, 'Lexis', 'Joan', 'ljoang@shareasale.com'),
(18, 'Alikee', 'Mc-Kerley', 'amckerleyh@newsvine.com'),
(19, 'Chicky', 'How to preserve', 'chowtopreservei@ustream.tv'),
(20, 'Zaneta', 'Sumpter', 'zsumpterj@army.mil');

-- --------------------------------------------------------

--
-- Table structure for table `employees_departments`
--

DROP TABLE IF EXISTS `employees_departments`;
CREATE TABLE IF NOT EXISTS `employees_departments` (
  `employees_id` int(11) NOT NULL,
  `departments_id` int(11) NOT NULL,
  PRIMARY KEY (`employees_id`,`departments_id`),
  KEY `FK_departments` (`departments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employees_departments`
--

INSERT INTO `employees_departments` (`employees_id`, `departments_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 1),
(8, 4),
(9, 3),
(10, 1),
(11, 2),
(11, 3),
(12, 3),
(13, 1),
(14, 5),
(15, 4),
(16, 1),
(17, 5),
(18, 2),
(19, 5),
(20, 5);

-- --------------------------------------------------------

--
-- Table structure for table `employments`
--

DROP TABLE IF EXISTS `employments`;
CREATE TABLE IF NOT EXISTS `employments` (
  `employments_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `contract_type` enum('Full-Time','Part-Time','Fixed-Term','Temporary Employment','Internship','Self-Employment') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`employments_id`),
  KEY `FK_employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employments`
--

INSERT INTO `employments` (`employments_id`, `employee_id`, `start_date`, `end_date`, `contract_type`) VALUES
(1, 1, '2018-04-20', NULL, 'Internship'),
(2, 2, '2020-07-12', NULL, 'Temporary Employment'),
(3, 3, '2019-02-03', '2008-12-09', 'Internship'),
(4, 4, '2013-12-29', NULL, 'Internship'),
(5, 5, '2002-10-11', NULL, 'Internship'),
(6, 6, '2005-07-14', NULL, 'Part-Time'),
(7, 7, '2001-12-13', NULL, 'Self-Employment'),
(8, 8, '2005-11-01', '2000-03-14', 'Temporary Employment'),
(9, 9, '2003-09-10', NULL, 'Internship'),
(10, 10, '2009-07-18', '2002-10-12', 'Internship'),
(11, 11, '2017-12-03', NULL, 'Fixed-Term'),
(12, 12, '2016-03-27', '2001-03-27', 'Self-Employment'),
(13, 13, '2006-12-29', '2007-10-30', 'Internship'),
(14, 14, '2007-05-06', '2005-05-12', 'Full-Time'),
(15, 15, '2002-06-24', NULL, 'Part-Time'),
(16, 16, '2006-08-30', NULL, 'Temporary Employment'),
(17, 17, '1999-12-24', NULL, 'Temporary Employment'),
(18, 18, '2019-08-07', NULL, 'Internship'),
(19, 19, '2010-06-20', '2004-02-18', 'Part-Time'),
(20, 20, '2001-12-08', NULL, 'Internship');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `departments`
--
ALTER TABLE `departments`
  ADD CONSTRAINT `FK_managers` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`employees_id`);

--
-- Constraints for table `employees_departments`
--
ALTER TABLE `employees_departments`
  ADD CONSTRAINT `FK_departments` FOREIGN KEY (`departments_id`) REFERENCES `departments` (`departments_id`),
  ADD CONSTRAINT `employees_departments_ibfk_1` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`employees_id`);

--
-- Constraints for table `employments`
--
ALTER TABLE `employments`
  ADD CONSTRAINT `FK_employees` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employees_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
