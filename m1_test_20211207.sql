-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 07, 2021 at 07:21 PM
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
-- Database: `m1_test`
--
CREATE DATABASE IF NOT EXISTS `m1_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `m1_test`;

-- --------------------------------------------------------

--
-- Table structure for table `osobe`
--

DROP TABLE IF EXISTS `osobe`;
CREATE TABLE IF NOT EXISTS `osobe` (
  `osobe_id` int(11) NOT NULL AUTO_INCREMENT,
  `jmbg` char(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ime` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `godiste` int(4) NOT NULL,
  `email` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`osobe_id`),
  UNIQUE KEY `jmbg` (`jmbg`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `osobe`
--

INSERT INTO `osobe` (`osobe_id`, `jmbg`, `ime`, `prezime`, `godiste`, `email`) VALUES
(1, '1234567890123', 'Peter', 'Smith', 1985, 'peter@example.com'),
(2, '1234567890124', 'Test', 'Test', 1991, 'test@example.com'),
(3, '2345678901234', 'Jane', 'Smith', 1982, 'jane@example.com'),
(4, '3456789012345', 'Joshua', 'Marks', 1992, 'joshua@example.com'),
(5, '4567890123456', 'Cathyl', 'Marks', 1971, 'cathlyn@example.com'),
(6, '5678901234567', 'Jacob', 'Ronan', 1987, 'jacob@example.com'),
(7, '0987654321123', 'John', 'Doe', 1970, 'johnd@example.com'),
(8, '8765432109123', 'Jane', 'Doe', 1970, 'janed@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `proizvodi`
--

DROP TABLE IF EXISTS `proizvodi`;
CREATE TABLE IF NOT EXISTS `proizvodi` (
  `naziv` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` decimal(10,2) NOT NULL,
  `proizvodjac` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kolicina` int(11) NOT NULL,
  `jedinica_mere` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `barkod` char(13) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`barkod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `proizvodi`
--

INSERT INTO `proizvodi` (`naziv`, `cena`, `proizvodjac`, `kolicina`, `jedinica_mere`, `barkod`) VALUES
('BONITO čaj kamilica 24g', '101.99', 'Bonito', 24, 'g', '1234567890123'),
('Sladoled ALOMA forest fruits 900ml', '149.99', 'Aloma', 900, 'ml', '3858888675868'),
('Brašno KIKINDSKI MLIN T-400 1kg', '67.99', 'Kikindski mlin', 1, 'kg', '8600969901138'),
('Džem NECTAR Life crveni mix 370g', '269.99', 'Nectar', 370, 'g', '8606108094785');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
