-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2024 at 09:25 PM
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
-- Table structure for table `attempted`
--

CREATE TABLE `attempted` (
  `problemID` int(11) DEFAULT NULL,
  `userMail` varchar(255) DEFAULT NULL,
  `code` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attempted`
--

INSERT INTO `attempted` (`problemID`, `userMail`, `code`) VALUES
(3, 'hridoy@gmail.com', '\"\"\"write a function named func that will reverse the array\"\"\"\ndef func(list):\n	list.reverse()\n	return list');

-- --------------------------------------------------------

--
-- Table structure for table `friends`
--

CREATE TABLE `friends` (
  `fmail` varchar(255) DEFAULT NULL,
  `umail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `friends`
--

INSERT INTO `friends` (`fmail`, `umail`) VALUES
('hridoy@gmail.com', 'mehrin@gmail.com'),
('mehrin@gmail.com', 'hridoy@gmail.com'),
('shagin@gmail.com', 'hridoy@gmail.com'),
('hridoy@gmail.com', 'emon@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `friend_requests`
--

CREATE TABLE `friend_requests` (
  `request_id` int(11) NOT NULL,
  `sender_email` varchar(255) NOT NULL,
  `receiver_email` varchar(255) NOT NULL,
  `status` enum('pending','accepted','rejected') NOT NULL DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `friend_requests`
--

INSERT INTO `friend_requests` (`request_id`, `sender_email`, `receiver_email`, `status`) VALUES
(2, 'shagin@gmail.com', 'hridoy@gmail.com', 'accepted'),
(3, 'hridoy@gmail.com', 'emon@gmail.com', 'accepted'),
(5, 'mehrin@gmail.com', 'emon@gmail.com', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `postid` int(11) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`postid`, `mail`, `content`, `time`) VALUES
(12, 'hridoy@gmail.com', 'Solved array 3 by python3\nTime Taken : 0.01\nSpace Taken : 7424', '2024-04-07 01:23:53');

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
(3, 'reverse array ', 'array 3', 'array', 'if __name__ == \"__main__\":\n    list = [1,2,3,4,5]\n    print(func(list))', '[5, 4, 3, 2, 1]', '\"\"\"write a function named func that will reverse the array\"\"\"'),
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
(18, 'count vowels in string', 'string 3', 'string', NULL, NULL, NULL),
(19, 'leetcode', 'gas station', 'greedy', 'gas = [5,8,2,8]\r\ncost = [6,5,6,6]\r\nobj = Solution()\r\nprint(obj.canCompleteCircuit(gas,cost))', '3', 'class Solution(object):\r\n    def canCompleteCircuit(self, gas, cost):\r\n        \"\"\"\r\n        :type gas: List[int]\r\n        :type cost: List[int]\r\n        :rtype: int\r\n        \"\"\"');

-- --------------------------------------------------------

--
-- Table structure for table `solved`
--

CREATE TABLE `solved` (
  `problemID` int(11) DEFAULT NULL,
  `userMail` varchar(255) DEFAULT NULL,
  `code` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `solved`
--

INSERT INTO `solved` (`problemID`, `userMail`, `code`) VALUES
(3, 'hridoy@gmail.com', '\"\"\"write a function named func that will reverse the array\"\"\"\ndef func(list):\n	list.reverse()\n	return list');

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
('1234', 'emon@gmail.com'),
('1234', 'hridoy@gmail.com'),
('1234', 'mehrin@gmail.com'),
('1234', 'shagin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE `user_profile` (
  `umail` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `about_me` text DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`umail`, `pic`, `institution`, `position`, `about_me`, `name`) VALUES
('hridoy@gmail.com', 'images/guts.jpeg', 'uiu', 'student', 'fakaa', 'hridoy ahmeddd'),
('emon@gmail.com', 'images/zoro.jpeg', 'ewu', '', '', 'emon'),
('mehrin@gmail.com', 'images/guts.jpeg', NULL, NULL, NULL, 'Mehrin Ahmed Chowdhury'),
('shagin@gmail.com', 'images/guts.jpeg', NULL, NULL, NULL, 'Shagin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attempted`
--
ALTER TABLE `attempted`
  ADD KEY `userMail` (`userMail`),
  ADD KEY `problemID` (`problemID`);

--
-- Indexes for table `friends`
--
ALTER TABLE `friends`
  ADD KEY `fmail` (`fmail`),
  ADD KEY `fmail2` (`umail`);

--
-- Indexes for table `friend_requests`
--
ALTER TABLE `friend_requests`
  ADD PRIMARY KEY (`request_id`),
  ADD UNIQUE KEY `unique_request` (`sender_email`,`receiver_email`),
  ADD KEY `fk_receiver_email` (`receiver_email`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`postid`),
  ADD KEY `mail` (`mail`);

--
-- Indexes for table `problems`
--
ALTER TABLE `problems`
  ADD PRIMARY KEY (`problemID`);

--
-- Indexes for table `solved`
--
ALTER TABLE `solved`
  ADD KEY `userMail` (`userMail`),
  ADD KEY `problemID` (`problemID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD KEY `umail` (`umail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `friend_requests`
--
ALTER TABLE `friend_requests`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `postid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `problems`
--
ALTER TABLE `problems`
  MODIFY `problemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attempted`
--
ALTER TABLE `attempted`
  ADD CONSTRAINT `attempted_ibfk_1` FOREIGN KEY (`userMail`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `attempted_ibfk_2` FOREIGN KEY (`problemID`) REFERENCES `problems` (`problemID`);

--
-- Constraints for table `friends`
--
ALTER TABLE `friends`
  ADD CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`fmail`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`umail`) REFERENCES `users` (`email`);

--
-- Constraints for table `friend_requests`
--
ALTER TABLE `friend_requests`
  ADD CONSTRAINT `fk_receiver_email` FOREIGN KEY (`receiver_email`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `fk_sender_email` FOREIGN KEY (`sender_email`) REFERENCES `users` (`email`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`mail`) REFERENCES `users` (`email`);

--
-- Constraints for table `solved`
--
ALTER TABLE `solved`
  ADD CONSTRAINT `solved_ibfk_1` FOREIGN KEY (`userMail`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `solved_ibfk_2` FOREIGN KEY (`problemID`) REFERENCES `problems` (`problemID`);

--
-- Constraints for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`umail`) REFERENCES `users` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
