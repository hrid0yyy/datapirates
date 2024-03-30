-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2024 at 06:08 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datapirates`
--

-- --------------------------------------------------------

--
-- Table structure for table `problems`
--

CREATE TABLE `problems` (
  `problemID` int(11) NOT NULL,
  `description` text NOT NULL,
  `problemName` varchar(255) DEFAULT NULL,
  `problemType` varchar(255) DEFAULT NULL,
  `driverCode` text DEFAULT NULL,
  `output` varchar(255) DEFAULT NULL,
  `codeFormat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `problems`
--

INSERT INTO `problems` (`problemID`, `description`, `problemName`, `problemType`, `driverCode`, `output`, `codeFormat`) VALUES
(3, 'reverse array ', 'array 3', 'array', NULL, '5', '// write a function named ReverseArray that will return an array'),
(4, 'find maximum element in array', 'array 2', 'array', NULL, NULL, NULL),
(5, 'check if array is sorted', 'array 5', 'array', NULL, NULL, NULL),
(6, 'find minimum element in array', 'array 7', 'array', NULL, NULL, NULL),
(7, 'remove duplicates from array', 'array 9', 'array', NULL, NULL, NULL),
(8, 'check if two arrays are equal', 'array 11', 'array', NULL, NULL, NULL),
(9, 'rotate array elements', 'array 13', 'array', NULL, NULL, NULL),
(10, 'split array into two parts with equal sum', 'array 15', 'array', NULL, NULL, NULL),
(11, 'check if array contains only positive numbers', 'array 14', 'array', NULL, NULL, NULL),
(12, 'find second largest element in array', 'array 16', 'array', NULL, NULL, NULL),
(13, 'remove specific element from array', 'array 17', 'array', NULL, NULL, NULL),
(14, 'find leaders in array', 'array 18', 'array', NULL, NULL, NULL),
(15, 'reverse string', 'string 1', 'string', NULL, NULL, NULL),
(16, 'reverse string', 'string 1', 'string', NULL, NULL, NULL),
(17, 'check if string is palindrome', 'string 2', 'string', NULL, NULL, NULL),
(18, 'count vowels in string', 'string 3', 'string', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `pass` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`pass`, `email`) VALUES
('1234', 'hridoy@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `problems`
--
ALTER TABLE `problems`
  ADD PRIMARY KEY (`problemID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `problems`
--
ALTER TABLE `problems`
  MODIFY `problemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
