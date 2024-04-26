-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2024 at 05:04 PM
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
  `message` text DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`sender`, `receiver`, `message`, `id`) VALUES
('hridoy@gmail.com', 'mehrin@gmail.com', 'kere', 1),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sdfdsf', 2),
('hridoy@gmail.com', 'shagin@gmail.com', 'aiyoo', 3),
('hridoy@gmail.com', 'shagin@gmail.com', 'kireee', 4),
('shagin@gmail.com', 'hridoy@gmail.com', 'aaaa', 5),
('hridoy@gmail.com', 'shagin@gmail.com', 'asos?', 6),
('hridoy@gmail.com', 'shagin@gmail.com', 'asos?', 7),
('shagin@gmail.com', 'hridoy@gmail.com', 'asii', 8),
('hridoy@gmail.com', 'shagin@gmail.com', 'ki koros', 9),
('shagin@gmail.com', 'hridoy@gmail.com', 'boshe asi', 10),
('shagin@gmail.com', 'hridoy@gmail.com', 'tui', 11),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaa', 12),
('hridoy@gmail.com', 'shagin@gmail.com', 'amio', 13),
('shagin@gmail.com', 'hridoy@gmail.com', 'asdas', 14),
('shagin@gmail.com', 'hridoy@gmail.com', 'dfddd', 15),
('hridoy@gmail.com', 'shagin@gmail.com', 'dfgdf', 16),
('shagin@gmail.com', 'hridoy@gmail.com', 'dddddddddddddddd', 17),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aa', 18),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dasdas', 19),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sdfffffffffffffffffff', 20),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sdfsdfsd', 21),
('hridoy@gmail.com', 'shagin@gmail.com', 'sdfsdloisaldkkkkkkkkkk', 22),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaa', 23),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dsadsad', 24),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaaaaaaaaaaaa', 25),
('hridoy@gmail.com', 'mehrin@gmail.com', 'dsadas', 26),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sadsa', 27),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdasdas', 28),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdasd', 29),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdasd', 30),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdas', 31),
('hridoy@gmail.com', 'mehrin@gmail.com', 'adas', 32),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdas', 33),
('shagin@gmail.com', 'hridoy@gmail.com', 'asdas', 34),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaaaaaaaaaaaaaa', 35),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sadas', 36),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaaaaaaaaaaaa', 37),
('hridoy@gmail.com', 'mehrin@gmail.com', 'dsfdsfdsfds', 38),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dddddddddddd', 39),
('hridoy@gmail.com', 'mehrin@gmail.com', 'ssssssssssssssssssssssssssssss', 40),
('mehrin@gmail.com', 'hridoy@gmail.com', 'dsfsd', 41),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaa', 42),
('mehrin@gmail.com', 'hridoy@gmail.com', 'ki koros', 43),
('hridoy@gmail.com', 'mehrin@gmail.com', 'boshe asi', 44),
('hridoy@gmail.com', 'mehrin@gmail.com', 'tui', 45),
('mehrin@gmail.com', 'hridoy@gmail.com', 'amio', 46),
('hridoy@gmail.com', 'mehrin@gmail.com', 'dsf', 47),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asgsdfgsdg', 48),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaa', 49),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdsad', 50),
('mehrin@gmail.com', 'hridoy@gmail.com', 'ki koros', 51),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sadfa', 52),
('mehrin@gmail.com', 'hridoy@gmail.com', 'safd', 53),
('mehrin@gmail.com', 'hridoy@gmail.com', 'assa', 54),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdsa', 55),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdsa', 56),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdsa', 57),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asd', 58),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdas', 59),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdas', 60),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdas', 61),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdas', 62),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdas', 63),
('hridoy@gmail.com', 'shagin@gmail.com', 'aaaaaaaaaa', 64),
('shagin@gmail.com', 'hridoy@gmail.com', 'asdsad', 65),
('hridoy@gmail.com', 'shagin@gmail.com', 'ki koros', 66),
('shagin@gmail.com', 'hridoy@gmail.com', 'boshe asi bhai', 67),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdsa', 68),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdsa', 69),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaaaaaaaa', 70),
('mehrin@gmail.com', 'hridoy@gmail.com', 'ki koros', 71),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaadsa', 72),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdsa', 73),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sadsa', 74),
('mehrin@gmail.com', 'hridoy@gmail.com', 'asdsa', 75),
('hridoy@gmail.com', 'mehrin@gmail.com', 'asdsa', 76),
('mehrin@gmail.com', 'hridoy@gmail.com', 'fdsfdsfsdfsd', 77),
('hridoy@gmail.com', 'shagin@gmail.com', 'kireee', 78),
('shagin@gmail.com', 'hridoy@gmail.com', 'areh', 79),
('hridoy@gmail.com', 'shagin@gmail.com', 'ki koros', 80),
('shagin@gmail.com', 'hridoy@gmail.com', 'boshe asi', 81),
('shagin@gmail.com', 'hridoy@gmail.com', 'tui', 82),
('hridoy@gmail.com', 'shagin@gmail.com', 'gaan shuni', 83),
('shagin@gmail.com', 'hridoy@gmail.com', 'ki gaan', 84),
('hridoy@gmail.com', 'shagin@gmail.com', 'sadfhldisahg', 85),
('shagin@gmail.com', 'hridoy@gmail.com', 'eh', 86),
('hridoy@gmail.com', 'shagin@gmail.com', 'hehe', 87),
('shagin@gmail.com', 'hridoy@gmail.com', 'hayre', 88),
('hridoy@gmail.com', 'mehrin@gmail.com', 'kireee', 89),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaaaaaaa', 90),
('hridoy@gmail.com', 'mehrin@gmail.com', 'sadsa', 91),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sadsa', 92),
('hridoy@gmail.com', 'mehrin@gmail.com', 'fsdfds', 93),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sdfds', 94),
('hridoy@gmail.com', 'mehrin@gmail.com', 'aaaaaaaaa', 95),
('mehrin@gmail.com', 'hridoy@gmail.com', 'sdadasd', 96);

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
  ADD PRIMARY KEY (`id`),
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
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

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
