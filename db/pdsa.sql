-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 08, 2019 at 09:00 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.1.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pdsa`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `branchname` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id`, `branchname`) VALUES
(1, '545tjgjgk.gff'),
(2, 'ANURADHAPURA'),
(3, 'POLGAHAWELA'),
(4, 'GAMPAHA'),
(5, 'RAGAMA'),
(6, 'GALGAMUWA'),
(7, 'COLOMBO'),
(8, 'KELANIYA'),
(9, 'GALLE'),
(12, 'MATARA'),
(14, 'DAMBULLA'),
(15, 'JAFFNA'),
(16, '333333');

-- --------------------------------------------------------

--
-- Table structure for table `distance_detail`
--

CREATE TABLE `distance_detail` (
  `id` int(11) NOT NULL,
  `from_b` varchar(100) NOT NULL,
  `to_b` varchar(100) NOT NULL,
  `distance` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distance_detail`
--

INSERT INTO `distance_detail` (`id`, `from_b`, `to_b`, `distance`) VALUES
(1, 'KURUNEGALA', 'KURUNEGALA', '0'),
(2, 'KURUNEGALA', 'ANURADHAPURA', '90'),
(3, 'KURUNEGALA', 'GALGAMUWA', '65'),
(4, 'KURUNEGALA', 'GAMPAHA', '0'),
(5, 'KURUNEGALA', 'RAGAMA', '0'),
(6, 'KURUNEGALA', 'KELANIYA', '0'),
(7, 'KURUNEGALA', 'COLOMBO', '0'),
(8, 'KURUNEGALA', 'GALLE', '0'),
(9, 'KURUNEGALA', 'MATARA', '0'),
(10, 'ANURADHAPURA', 'KURUNEGALA', '90'),
(11, 'ANURADHAPURA', 'ANURADHAPURA', '0'),
(12, 'ANURADHAPURA', 'GALGAMUWA', '60'),
(13, 'ANURADHAPURA', 'POLGAHAWELA', '0'),
(14, 'ANURADHAPURA', 'GAMPAHA', '0'),
(15, 'ANURADHAPURA', 'RAGAMA', '0'),
(16, 'ANURADHAPURA', 'KELANIYA', '0'),
(17, 'ANURADHAPURA', 'COLOMBO', '0'),
(18, 'ANURADHAPURA', 'GALLE', '0'),
(19, 'ANURADHAPURA', 'MATARA', '0'),
(20, 'KURUNEGALA', 'POLGAHAWELA', '33'),
(21, 'GALGAMUWA', 'KURUNEGALA', '65'),
(22, 'GALGAMUWA', 'ANURADHAPURA', '60'),
(23, 'GALGAMUWA', 'GALGAMUWA', '0'),
(24, 'GALGAMUWA', 'POLGAHAWELA', '0'),
(25, 'GALGAMUWA', 'GAMPAHA', '0'),
(26, 'GALGAMUWA', 'RAGAMA', '0'),
(27, 'GALGAMUWA', 'KELANIYA', '0'),
(28, 'GALGAMUWA', 'COLOMBO', '0'),
(29, 'GALGAMUWA', 'GALLE', '0'),
(30, 'GALGAMUWA', 'MATARA', '0'),
(31, 'POLGAHAWELA', 'MATARA', '0'),
(32, 'POLGAHAWELA', 'GALLE', '0'),
(33, 'POLGAHAWELA', 'KELANIYA', '0'),
(34, 'POLGAHAWELA', 'RAGAMA', '0'),
(35, 'POLGAHAWELA', 'GAMPAHA', '75'),
(36, 'POLGAHAWELA', 'POLGAHAWELA', '0'),
(37, 'POLGAHAWELA', 'GALGAMUWA', '0'),
(38, 'POLGAHAWELA', 'ANURADHAPURA', '0'),
(39, 'POLGAHAWELA', 'KURUNEGALA', '33'),
(40, 'RAGAMA', 'KURUNEGALA', '0'),
(41, 'RAGAMA', 'ANURADHAPURA', '0'),
(42, 'RAGAMA', 'GALGAMUWA', '0'),
(43, 'RAGAMA', 'POLGAHAWELA', '0'),
(44, 'RAGAMA', 'GAMPAHA', '0'),
(45, 'RAGAMA', 'RAGAMA', '0'),
(46, 'RAGAMA', 'KELANIYA', '12'),
(47, 'RAGAMA', 'COLOMBO', '0'),
(48, 'RAGAMA', 'GALLE', '0'),
(49, 'RAGAMA', 'MATARA', '0'),
(50, 'KELANIYA', 'KURUNEGALA', '0'),
(51, 'KELANIYA', 'ANURADHAPURA', '0'),
(52, 'KELANIYA', 'GALGAMUWA', '0'),
(53, 'KELANIYA', 'POLGAHAWELA', '0'),
(54, 'KELANIYA', 'GAMPAHA', '30'),
(55, 'KELANIYA', 'RAGAMA', '12'),
(56, 'KELANIYA', 'KELANIYA', '0'),
(57, 'KELANIYA', 'COLOMBO', '35'),
(58, 'KELANIYA', 'GALLE', '0'),
(59, 'KELANIYA', 'MATARA', '0'),
(60, 'COLOMBO', 'KURUNEGALA', '0'),
(61, 'COLOMBO', 'ANURADHAPURA', '0'),
(62, 'COLOMBO', 'GALGAMUWA', '0'),
(63, 'COLOMBO', 'POLGAHAWELA', '0'),
(64, 'COLOMBO', 'GAMPAHA', '45'),
(65, 'COLOMBO', 'RAGAMA', '0'),
(66, 'COLOMBO', 'KELANIYA', '35'),
(67, 'COLOMBO', 'COLOMBO', '0'),
(68, 'COLOMBO', 'GALLE', '150'),
(69, 'COLOMBO', 'MATARA', '0'),
(70, 'GALLE', 'KURUNEGALA', '0'),
(71, 'GALLE', 'ANURADHAPURA', '0'),
(72, 'GALLE', 'GALGAMUWA', '0'),
(73, 'GALLE', 'POLGAHAWELA', '0'),
(74, 'GALLE', 'GAMPAHA', '0'),
(75, 'GALLE', 'RAGAMA', '0'),
(76, 'GALLE', 'KELANIYA', '0'),
(77, 'GALLE', 'COLOMBO', '150'),
(78, 'GALLE', 'MATARA', '30'),
(79, 'MATARA', 'KURUNEGALA', '0'),
(80, 'MATARA', 'ANURADHAPURA', '0'),
(81, 'MATARA', 'GALGAMUWA', '0'),
(82, 'MATARA', 'POLGAHAWELA', '0'),
(83, 'MATARA', 'GAMPAHA', '0'),
(84, 'MATARA', 'RAGAMA', '0'),
(85, 'MATARA', 'KELANIYA', '0'),
(86, 'MATARA', 'COLOMBO', '0'),
(87, 'MATARA', 'GALLE', '30'),
(88, 'MATARA', 'MATARA', '0'),
(89, 'GALLE', 'GALLE', '0'),
(90, 'POLGAHAWELA', 'COLOMBO', '0'),
(91, 'GAMPAHA', 'KURUNEGALA', '0'),
(92, 'GAMPAHA', 'ANURADHAPURA', '0'),
(93, 'GAMPAHA', 'GALGAMUWA', '0'),
(94, 'GAMPAHA', 'POLGAHAWELA', '0'),
(95, 'GAMPAHA', 'GAMPAHA', '0'),
(96, 'GAMPAHA', 'RAGAMA', '12'),
(97, 'GAMPAHA', 'COLOMBO', '45'),
(98, 'GAMPAHA', 'GALLE', '0'),
(99, 'GAMPAHA', 'MATARA', '0'),
(100, 'GALLE', 'GALLE', '0'),
(101, 'JAFFNA', 'ANURADHAPURA', '78'),
(102, 'JAFFNA', 'DAMBULLA', '89'),
(103, '545tjgjgk.gff', 'ANURADHAPURA', '56');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'shashila', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `distance_detail`
--
ALTER TABLE `distance_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `distance_detail`
--
ALTER TABLE `distance_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
