-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2024 at 10:16 AM
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
(3, 'hridoy@gmail.com', 'def func(list):\n	list.reverse()\n	return list'),
(4, 'hridoy@gmail.com', 'def func(list):\n	return sum(list)'),
(3, 'hridoy@gmail.com', '\"\"\"write a function named func that will reverse the array\"\"\"\nfghfg'),
(3, 'emon@gmail.com', 'def function(list):\n	return 2'),
(3, 'emon@gmail.com', '\"\"\"write a function named func that will reverse the array\"\"\"\ndef function(list)\n	list.reverse()\n	return list'),
(4, 'emon@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)');

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `sender` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `message` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`sender`, `receiver`, `message`) VALUES
('hridoy@gmail.com', 'mehrin@gmail.com', 'helu mehrin'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'helu hridoy'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ki obosthaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'areh'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'oyyy'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'hgfhgf'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'jgbj'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'hgjkghj'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'hhh'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'gg'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaaaaaaaaaaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'ki koros'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'boshe asi'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'amio'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ohho'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'one piece dekhsos?'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'naaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'uysss'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asd'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaa'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dsadas'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaa'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'dssds'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sdsd'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sds'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaa'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'dsdsdsds'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dsdsd'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'arasdfsdfrewr'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'areh bhai ki kos'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaaaa'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'bhai'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kiree'),
('shagin@gmail.com', 'hridoy@gmail.com', 'ki lekhli'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kiree'),
('shagin@gmail.com', 'hridoy@gmail.com', 'oh accha'),
('hridoy@gmail.com', 'shagin@gmail.com', 'ehh?'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kise'),
('hridoy@gmail.com', 'shagin@gmail.com', 'bujos na kotha?'),
('shagin@gmail.com', 'hridoy@gmail.com', 'naaaa'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kire?'),
('shagin@gmail.com', 'hridoy@gmail.com', 'naaa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'dsf'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kireee'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kiree'),
('shagin@gmail.com', 'hridoy@gmail.com', 'areh'),
('shagin@gmail.com', 'hridoy@gmail.com', 'ki obostha tor'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kir'),
('hridoy@gmail.com', 'shagin@gmail.com', 'sdfsd'),
('hridoy@gmail.com', 'shagin@gmail.com', 'sdfsd'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaaaaaaaa'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kireeeeeeeeee'),
('shagin@gmail.com', 'hridoy@gmail.com', 'arehhh'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kiree'),
('shagin@gmail.com', 'hridoy@gmail.com', 'fdsfsd'),
('shagin@gmail.com', 'hridoy@gmail.com', 'sss'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kire'),
('shagin@gmail.com', 'hridoy@gmail.com', 'aaa'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kire'),
('hridoy@gmail.com', 'shagin@gmail.com', 'bol'),
('hridoy@gmail.com', 'shagin@gmail.com', 'asos?'),
('shagin@gmail.com', 'hridoy@gmail.com', 'ho asi'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asos?'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'bol'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ki koros'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'boisha asi'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'tui'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'amio'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ok'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sdfdsjhfjksadhfjaskhfuiwerhbwtbxuyhvuoiretkjlwethykrt'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'kire paglay geli'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ohayoooo'),
('mehrin@gmail.com', 'hridoy@gmail.com', 'kire'),
('hridoy@gmail.com', 'shagin@gmail.com', 'asos'),
('hridoy@gmail.com', 'mehrin@gmail.com', 'kooo'),
('shagin@gmail.com', 'hridoy@gmail.com', 'oye'),
('hridoy@gmail.com', 'shagin@gmail.com', 'kire'),
('shagin@gmail.com', 'hridoy@gmail.com', 'asos?'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'aaa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kire'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kireee'),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa'),
('shagin@gmail.com', 'hridoy@gmail.com', 'kireee'),
('hridoy@gmail.com', 'shagin@gmail.com', 'oyeee'),
('shagin@gmail.com', 'hridoy@gmail.com', 'asos');

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
('hridoy@gmail.com', 'shagin@gmail.com'),
('shagin@gmail.com', 'hridoy@gmail.com'),
('hridoy@gmail.com', 'mehrin@gmail.com'),
('mehrin@gmail.com', 'hridoy@gmail.com');

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
(9, 'hridoy@gmail.com', 'shagin@gmail.com', 'accepted'),
(10, 'hridoy@gmail.com', 'mehrin@gmail.com', 'accepted');

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
(18, 'hridoy@gmail.com', 'Solved array 3 by python3\nTime Taken : 0.01\nSpace Taken : 7552', '2024-04-18 11:16:17'),
(19, 'hridoy@gmail.com', 'Solved array sum by python3\nTime Taken : 0.01\nSpace Taken : 7552', '2024-04-18 11:18:16'),
(20, 'emon@gmail.com', 'Solved array sum by python3\nTime Taken : 0.01\nSpace Taken : 7680', '2024-04-18 12:32:46');

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
(4, 'calculate sum of array elements', 'array sum', 'array', 'if __name__ == \"__main__\":\n    list = [1, 2, 3, 4, 5]\n    print(func(list))', '15', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"'),
(5, 'find maximum element in array', 'max array', 'array', 'if __name__ == \"__main__\":\n    list = [1, 5, 3, 7, 2]\n    print(func(list))', '7', '\"\"\"write a function named func that will find the maximum element in the array\"\"\"'),
(6, 'find minimum element in array', 'min array', 'array', 'if __name__ == \"__main__\":\n    list = [10, 5, 8, 3, 12]\n    print(func(list))', '3', '\"\"\"write a function named func that will find the minimum element in the array\"\"\"'),
(7, 'calculate average of array elements', 'array average', 'array', 'if __name__ == \"__main__\":\n    list = [2, 4, 6, 8, 10]\n    print(func(list))', '6.0', '\"\"\"write a function named func that will calculate the average of array elements\"\"\"'),
(8, 'check if array contains a specific element', 'array element check', 'array', 'if __name__ == \"__main__\":\n    list = [1, 2, 3, 4, 5]\n    element = 3\n    print(func(list, element))', 'True', '\"\"\"write a function named func that will check if a specific element is present in the array\"\"\"'),
(9, 'remove duplicates from array', 'array duplicates', 'array', 'if __name__ == \"__main__\":\n    list = [1, 2, 3, 2, 4, 5, 4]\n    print(func(list))', '[1, 2, 3, 4, 5]', '\"\"\"write a function named func that will remove duplicates from the array\"\"\"'),
(10, 'sort array in ascending order', 'array sort', 'array', 'if __name__ == \"__main__\":\n    list = [5, 3, 8, 2, 7]\n    print(func(list))', '[2, 3, 5, 7, 8]', '\"\"\"write a function named func that will sort the array in ascending order\"\"\"'),
(11, 'sort array in descending order', 'array reverse sort', 'array', 'if __name__ == \"__main__\":\n    list = [5, 3, 8, 2, 7]\n    print(func(list))', '[8, 7, 5, 3, 2]', '\"\"\"write a function named func that will sort the array in descending order\"\"\"'),
(12, 'insert element at specific index in array', 'array insert', 'array', 'if __name__ == \"__main__\":\n    list = [1, 2, 4, 5]\n    element = 3\n    index = 2\n    print(func(list, element, index))', '[1, 2, 3, 4, 5]', '\"\"\"write a function named func that will insert an element at a specific index in the array\"\"\"'),
(13, 'delete element at specific index in array', 'array delete', 'array', 'if __name__ == \"__main__\":\n    list = [1, 2, 3, 4, 5]\n    index = 2\n    print(func(list, index))', '[1, 2, 4, 5]', '\"\"\"write a function named func that will delete an element at a specific index in the array\"\"\"'),
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
(3, 'hridoy@gmail.com', 'def func(list):\n	list.reverse()\n	return list'),
(4, 'hridoy@gmail.com', 'def func(list):\n	return sum(list)'),
(4, 'emon@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)');

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
('1234', 'chaity@gmail.com'),
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
('hridoy@gmail.com', 'images/guts.jpeg', 'uiu uni', 'student', 'faka\n', 'hridoy ahmeddd'),
('emon@gmail.com', 'images/zoro.jpeg', 'ewu', 'student', 'haiya\n', 'emon'),
('mehrin@gmail.com', 'images/guts.jpeg', NULL, NULL, NULL, 'Mehrin Ahmed Chowdhury'),
('shagin@gmail.com', 'images/guts.jpeg', NULL, NULL, NULL, 'Shagin'),
('chaity@gmail.com', 'images/user.png', NULL, NULL, NULL, 'chaity');

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
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD KEY `sender` (`sender`),
  ADD KEY `receiver` (`receiver`);

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
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `postid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
-- Constraints for table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `users` (`email`),
  ADD CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`receiver`) REFERENCES `users` (`email`);

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
