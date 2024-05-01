-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2024 at 07:10 PM
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
(4, 'emon@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)'),
(6, 'hridoy@gmail.com', '\"\"\"write a function named func that will find the minimum element in the array\"\"\"\ndef func(list):\n	returm min(list)'),
(4, 'hridoy@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)'),
(4, 'hridoy@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)'),
(3, 'hridoy@gmail.com', '\"\"\"write a function named func that will reverse the array\"\"\"\ndef func(list):\n	list.reverse()\n	return list');

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
('mehrin@gmail.com', 'hridoy@gmail.com', 'sdadasd', 96),
('mehrin@gmail.com', 'hridoy@gmail.com', 'aaa', 97),
('hridoy@gmail.com', 'mehrin@gmail.com', 'kire', 98);

-- --------------------------------------------------------

--
-- Table structure for table `contest`
--

CREATE TABLE `contest` (
  `contestID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `day` date DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `contestants` int(11) DEFAULT NULL,
  `maxRat` int(11) DEFAULT NULL,
  `minRat` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contest`
--

INSERT INTO `contest` (`contestID`, `name`, `day`, `start_time`, `contestants`, `maxRat`, `minRat`, `length`) VALUES
(7, 'contest 1.0', '2024-05-03', 20, 100, 100, 500, 3),
(8, 'contest 2.0', '2024-06-05', 20, 100, 500, 1000, 3),
(9, 'contest 0.0', '2024-04-01', 12, 123, 1200, 1400, 2),
(10, 'contest -1.0', '2024-04-01', 12, 123, 1213, 1400, 2),
(11, 'contest 4.0', '2024-04-30', 12, 100, 100, 200, 4),
(12, 'contest 5.0', '2024-04-30', 1, 100, 1200, 1400, 4),
(13, 'contest 6.0', '2024-05-01', 21, 100, 100, 200, 6);

-- --------------------------------------------------------

--
-- Table structure for table `contestants`
--

CREATE TABLE `contestants` (
  `contestID` int(11) DEFAULT NULL,
  `contestantMail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contestants`
--

INSERT INTO `contestants` (`contestID`, `contestantMail`) VALUES
(7, 'hridoy@gmail.com'),
(13, 'hridoy@gmail.com'),
(13, 'emon@gmail.com'),
(13, 'mehrin@gmail.com'),
(13, 'chaity@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `contestproblems`
--

CREATE TABLE `contestproblems` (
  `ratting` int(11) NOT NULL,
  `problemID` int(11) NOT NULL,
  `description` text NOT NULL,
  `problemName` varchar(255) DEFAULT NULL,
  `problemType` varchar(255) DEFAULT NULL,
  `driverCode` text DEFAULT NULL,
  `output` varchar(255) DEFAULT NULL,
  `codeFormat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contestproblems`
--

INSERT INTO `contestproblems` (`ratting`, `problemID`, `description`, `problemName`, `problemType`, `driverCode`, `output`, `codeFormat`) VALUES
(100, 1, 'find the missing number in a sequence', 'missing_number', 'array', 'if __name__ == \"__main__\":\n    sequence = [1, 2, 3, 4, 6, 7, 8]\n    print(func(sequence))', '5', '\"\"\"Write a function named func that will find the missing number in a sequence of consecutive integers.\"\"\"'),
(120, 2, 'count the number of words in a sentence', 'word_count', 'string', 'if __name__ == \"__main__\":\n    sentence = \"Hello world, how are you?\"\n    print(func(sentence))', '5', '\"\"\"Write a function named func that will count the number of words in a given sentence. Assume words are separated by spaces.\"\"\"'),
(150, 3, 'reverse array ', 'array_reverse', 'array', 'if __name__ == \"__main__\":\n    arr = [1,2,3,4,5]\n    print(func(arr))', '[5, 4, 3, 2, 1]', '\"\"\"Write a function named func that will reverse the elements of a given array.\"\"\"'),
(130, 4, 'check if a string is a palindrome', 'palindrome_check', 'string', 'if __name__ == \"__main__\":\n    string = \"level\"\n    print(func(string))', 'True', '\"\"\"Write a function named func that will check if a given string is a palindrome. A palindrome is a word that reads the same forwards and backwards.\"\"\"'),
(110, 5, 'find the maximum element in an array', 'max_element', 'array', 'if __name__ == \"__main__\":\n    arr = [1, 5, 2, 9, 4]\n    print(func(arr))', '9', '\"\"\"Write a function named func that will find the maximum element in a given array.\"\"\"'),
(160, 6, 'check if a string contains all unique characters', 'unique_characters', 'string', 'if __name__ == \"__main__\":\n    string = \"abcdefg\"\n    print(func(string))', 'True', '\"\"\"Write a function named func that will check if a given string contains all unique characters. Return True if it does, otherwise False.\"\"\"'),
(140, 7, 'compute the factorial of a number', 'factorial', 'number', 'if __name__ == \"__main__\":\n    n = 5\n    print(func(n))', '120', '\"\"\"Write a function named func that will compute the factorial of a given number.\"\"\"'),
(170, 8, 'remove duplicates from an array', 'remove_duplicates', 'array', 'if __name__ == \"__main__\":\n    arr = [1, 2, 3, 3, 4, 5, 5]\n    print(func(arr))', '[1, 2, 3, 4, 5]', '\"\"\"Write a function named func that will remove duplicates from a given array while preserving the original order of elements.\"\"\"'),
(180, 9, 'find the second largest element in an array', 'second_largest', 'array', 'if __name__ == \"__main__\":\n    arr = [10, 20, 30, 40, 50]\n    print(func(arr))', '40', '\"\"\"Write a function named func that will find the second largest element in a given array.\"\"\"'),
(190, 10, 'find the longest common prefix among strings', 'longest_prefix', 'string', 'if __name__ == \"__main__\":\n    strings = [\"apple\", \"app\", \"application\"]\n    print(func(strings))', 'app', '\"\"\"Write a function named func that will find the longest common prefix among a list of strings.\"\"\"'),
(200, 11, 'compute the power of a number', 'power_of_number', 'number', 'if __name__ == \"__main__\":\n    x = 2\n    n = 5\n    print(func(x, n))', '32', '\"\"\"Write a function named func that will compute the power of a given number. The function should take two arguments: the base (x) and the exponent (n).\"\"\"'),
(210, 12, 'check if a number is prime', 'prime_check', 'number', 'if __name__ == \"__main__\":\n    num = 17\n    print(func(num))', 'True', '\"\"\"Write a function named func that will check if a given number is prime. Return True if it is, otherwise False.\"\"\"'),
(220, 13, 'sort array of strings by their length', 'sort_strings_by_length', 'array', 'if __name__ == \"__main__\":\n    strings = [\"apple\", \"banana\", \"pear\", \"orange\"]\n    print(func(strings))', '[\"pear\", \"apple\", \"banana\", \"orange\"]', '\"\"\"Write a function named func that will sort a given array of strings based on their lengths in ascending order.\"\"\"'),
(230, 14, 'find the sum of all digits in a number', 'sum_of_digits', 'number', 'if __name__ == \"__main__\":\n    num = 12345\n    print(func(num))', '15', '\"\"\"Write a function named func that will find the sum of all digits in a given number.\"\"\"'),
(240, 15, 'find the intersection of two arrays', 'array_intersection', 'array', 'if __name__ == \"__main__\":\n    arr1 = [1, 2, 3, 4, 5]\n    arr2 = [4, 5, 6, 7, 8]\n    print(func(arr1, arr2))', '[4, 5]', '\"\"\"Write a function named func that will find the intersection of two given arrays.\"\"\"'),
(250, 16, 'find the number of vowels in a string', 'vowel_count', 'string', 'if __name__ == \"__main__\":\n    string = \"Hello world\"\n    print(func(string))', '3', '\"\"\"Write a function named func that will count the number of vowels in a given string.\"\"\"'),
(260, 17, 'reverse words in a sentence', 'reverse_words', 'string', 'if __name__ == \"__main__\":\n    sentence = \"Hello world\"\n    print(func(sentence))', 'world Hello', '\"\"\"Write a function named func that will reverse the words in a given sentence.\"\"\"'),
(270, 18, 'check if two strings are anagrams', 'anagram_check', 'string', 'if __name__ == \"__main__\":\n    str1 = \"listen\"\n    str2 = \"silent\"\n    print(func(str1, str2))', 'True', '\"\"\"Write a function named func that will check if two given strings are anagrams of each other. Return True if they are, otherwise False.\"\"\"'),
(280, 19, 'find the kth largest element in an array', 'kth_largest', 'array', 'if __name__ == \"__main__\":\n    arr = [3, 2, 1, 5, 6, 4]\n    k = 2\n    print(func(arr, k))', '5', '\"\"\"Write a function named func that will find the kth largest element in a given array.\"\"\"'),
(290, 20, 'compute the Fibonacci sequence', 'fibonacci_sequence', 'number', 'if __name__ == \"__main__\":\n    n = 5\n    print(func(n))', '[0, 1, 1, 2, 3]', '\"\"\"Write a function named func that will compute the Fibonacci sequence up to the nth term.\"\"\"'),
(300, 21, 'find the mode of an array', 'array_mode', 'array', 'if __name__ == \"__main__\":\n    arr = [1, 2, 2, 3, 3, 3, 4]\n    print(func(arr))', '3', '\"\"\"Write a function named func that will find the mode (the most frequently occurring element) in a given array.\"\"\"'),
(310, 22, 'reverse a linked list', 'reverse_linked_list', 'linked list', 'if __name__ == \"__main__\":\n    # Define linked list\n    class ListNode:\n        def __init__(self, val=0, next=None):\n            self.val = val\n            self.next = next\n    # Create linked list [1, 2, 3, 4, 5]\n    head = ListNode(1)\n    head.next = ListNode(2)\n    head.next.next = ListNode(3)\n    head.next.next.next = ListNode(4)\n    head.next.next.next.next = ListNode(5)\n    # Reverse the linked list\n    reversed_head = func(head)\n    # Print reversed linked list\n    while reversed_head:\n        print(reversed_head.val)\n        reversed_head = reversed_head.next', '5\n4\n3\n2\n1', '\"\"\"Write a function named func that will reverse a given linked list and return the new head of the reversed list.\"\"\"'),
(320, 23, 'check if a binary tree is balanced', 'balanced_binary_tree', 'binary tree', 'if __name__ == \"__main__\":\n    # Define binary tree node\n    class TreeNode:\n        def __init__(self, val=0, left=None, right=None):\n            self.val = val\n            self.left = left\n            self.right = right\n    # Create binary tree\n    root = TreeNode(1)\n    root.left = TreeNode(2)\n    root.right = TreeNode(3)\n    root.left.left = TreeNode(4)\n    root.left.right = TreeNode(5)\n    # Check if binary tree is balanced\n    print(func(root))', 'True', '\"\"\"Write a function named func that will check if a given binary tree is balanced. A binary tree is balanced if the heights of the two subtrees of any node never differ by more than 1.\"\"\"'),
(330, 24, 'find the longest increasing subsequence', 'longest_increasing_subsequence', 'array', 'if __name__ == \"__main__\":\n    arr = [10, 9, 2, 5, 3, 7, 101, 18]\n    print(func(arr))', '[2, 3, 7, 101]', '\"\"\"Write a function named func that will find the length of the longest increasing subsequence in a given array.\"\"\"'),
(340, 25, 'find the majority element in an array', 'majority_element', 'array', 'if __name__ == \"__main__\":\n    arr = [3, 3, 4, 2, 4, 4, 2, 4, 4]\n    print(func(arr))', '4', '\"\"\"Write a function named func that will find the majority element in a given array. The majority element is the element that appears more than n/2 times, where n is the length of the array.\"\"\"'),
(350, 26, 'find the shortest distance between two words in a sentence', 'shortest_word_distance', 'string', 'if __name__ == \"__main__\":\n    words = [\"the\", \"quick\", \"brown\", \"fox\", \"quick\"]\n    word1 = \"the\"\n    word2 = \"fox\"\n    print(func(words, word1, word2))', '3', '\"\"\"Write a function named func that will find the shortest distance between two given words in a sentence. Assume the words are guaranteed to exist in the sentence.\"\"\"'),
(360, 27, 'check if a string follows a pattern', 'pattern_check', 'string', 'if __name__ == \"__main__\":\n    pattern = \"abba\"\n    string = \"dog cat cat dog\"\n    print(func(pattern, string))', 'True', '\"\"\"Write a function named func that will check if a given string follows a specific pattern. The pattern consists of lowercase letters separated by spaces, and the string consists of words separated by spaces. Return True if the string follows the pattern, otherwise False.\"\"\"'),
(370, 28, 'compute the square root of a number', 'square_root', 'number', 'if __name__ == \"__main__\":\n    x = 16\n    print(func(x))', '4.0', '\"\"\"Write a function named func that will compute the square root of a given number.\"\"\"'),
(380, 29, 'find the longest substring without repeating characters', 'longest_substring', 'string', 'if __name__ == \"__main__\":\n    string = \"abcabcbb\"\n    print(func(string))', 'abc', '\"\"\"Write a function named func that will find the longest substring without repeating characters in a given string.\"\"\"'),
(390, 30, 'rotate an array by k steps to the right', 'rotate_array', 'array', 'if __name__ == \"__main__\":\n    arr = [1, 2, 3, 4, 5, 6, 7]\n    k = 3\n    func(arr, k)\n    print(arr)', '[5, 6, 7, 1, 2, 3, 4]', '\"\"\"Write a function named func that will rotate a given array to the right by k steps, where k is a non-negative integer.\"\"\"'),
(400, 31, 'find the longest palindromic substring in a string', 'longest_palindrome_substring', 'string', 'if __name__ == \"__main__\":\n    string = \"babad\"\n    print(func(string))', 'bab', '\"\"\"Write a function named func that will find the longest palindromic substring in a given string.\"\"\"'),
(410, 32, 'find the maximum product of two integers in an array', 'max_product_of_two', 'array', 'if __name__ == \"__main__\":\n    arr = [1, 2, 3, 4, 5]\n    print(func(arr))', '20', '\"\"\"Write a function named func that will find the maximum product of two integers in a given array.\"\"\"'),
(420, 33, 'find the number of islands in a binary matrix', 'number_of_islands', 'array', 'if __name__ == \"__main__\":\n    grid = [\n        [1, 1, 0, 0, 0],\n        [1, 1, 0, 0, 0],\n        [0, 0, 1, 0, 0],\n        [0, 0, 0, 1, 1]\n    ]\n    print(func(grid))', '3', '\"\"\"Write a function named func that will find the number of islands in a given binary matrix. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.\"\"\"'),
(430, 34, 'implement the atoi function', 'atoi', 'string', 'if __name__ == \"__main__\":\n    string = \"42\"\n    print(func(string))', '42', '\"\"\"Write a function named func that will implement the atoi function, which converts a string to an integer.\"\"\"'),
(440, 35, 'merge two sorted arrays into one', 'merge_sorted_arrays', 'array', 'if __name__ == \"__main__\":\n    arr1 = [1, 3, 5]\n    arr2 = [2, 4, 6]\n    print(func(arr1, arr2))', '[1, 2, 3, 4, 5, 6]', '\"\"\"Write a function named func that will merge two given sorted arrays into one sorted array.\"\"\"'),
(450, 36, 'find the median of two sorted arrays', 'median_of_sorted_arrays', 'array', 'if __name__ == \"__main__\":\n    nums1 = [1, 3]\n    nums2 = [2]\n    print(func(nums1, nums2))', '2.0', '\"\"\"Write a function named func that will find the median of two sorted arrays.\"\"\"'),
(460, 37, 'find the minimum window in a string which contains all characters from another string', 'minimum_window_substring', 'string', 'if __name__ == \"__main__\":\n    s = \"ADOBECODEBANC\"\n    t = \"ABC\"\n    print(func(s, t))', 'BANC', '\"\"\"Write a function named func that will find the minimum window in a given string which contains all characters from another given string.\"\"\"'),
(470, 38, 'find the k closest points to the origin', 'k_closest_points', 'array', 'if __name__ == \"__main__\":\n    points = [[1, 3], [-2, 2]]\n    k = 1\n    print(func(points, k))', '[[1, 3]]', '\"\"\"Write a function named func that will find the k closest points to the origin (0, 0) from a list of points in the 2D plane.\"\"\"'),
(480, 39, 'count the number of distinct subsequences', 'distinct_subsequences', 'string', 'if __name__ == \"__main__\":\n    s = \"rabbbit\"\n    t = \"rabbit\"\n    print(func(s, t))', '3', '\"\"\"Write a function named func that will count the number of distinct subsequences of string S which equals string T.\"\"\"'),
(490, 40, 'find the longest consecutive sequence of elements in an unsorted array', 'longest_consecutive_sequence', 'array', 'if __name__ == \"__main__\":\n    nums = [100, 4, 200, 1, 3, 2]\n    print(func(nums))', '4', '\"\"\"Write a function named func that will find the length of the longest consecutive sequence of elements in an unsorted array of integers.\"\"\"'),
(500, 41, 'implement the next permutation function', 'next_permutation', 'array', 'if __name__ == \"__main__\":\n    nums = [1, 2, 3]\n    func(nums)\n    print(nums)', '[1, 3, 2]', '\"\"\"Write a function named func that will generate the next lexicographically greater permutation of a given list of numbers.\"\"\"'),
(510, 42, 'find the longest valid parentheses substring in a given string', 'longest_valid_parentheses', 'string', 'if __name__ == \"__main__\":\n    s = \"(()\"\n    print(func(s))', '2', '\"\"\"Write a function named func that will find the length of the longest valid (well-formed) parentheses substring in a given string.\"\"\"'),
(520, 43, 'implement the merge sort algorithm', 'merge_sort', 'array', 'if __name__ == \"__main__\":\n    arr = [12, 11, 13, 5, 6, 7]\n    print(\"Given array is:\", arr)\n    func(arr)\n    print(\"Sorted array is:\", arr)', 'Sorted array is: [5, 6, 7, 11, 12, 13]', '\"\"\"Write a function named func that will implement the merge sort algorithm to sort a given array.\"\"\"'),
(530, 44, 'check if a string is a valid palindrome considering only alphanumeric characters and ignoring cases', 'valid_palindrome', 'string', 'if __name__ == \"__main__\":\n    s = \"A man, a plan, a canal: Panama\"\n    print(func(s))', 'True', '\"\"\"Write a function named func that will check if a given string is a valid palindrome, considering only alphanumeric characters and ignoring cases.\"\"\"'),
(540, 45, 'calculate the maximum profit that can be obtained by buying and selling stocks', 'max_profit_stocks', 'array', 'if __name__ == \"__main__\":\n    prices = [7, 1, 5, 3, 6, 4]\n    print(func(prices))', '5', '\"\"\"Write a function named func that will calculate the maximum profit that can be obtained by buying and selling stocks given their prices for a number of days.\"\"\"'),
(550, 46, 'find the maximum sum of a subarray of size k', 'max_subarray_sum', 'array', 'if __name__ == \"__main__\":\n    nums = [1, 4, 2, 10, 2, 3, 1, 0, 20]\n    k = 4\n    print(func(nums, k))', '24', '\"\"\"Write a function named func that will find the maximum sum of a subarray of size k in a given array of integers.\"\"\"'),
(560, 47, 'find the longest common subsequence of two strings', 'longest_common_subsequence', 'string', 'if __name__ == \"__main__\":\n    text1 = \"abcde\"\n    text2 = \"ace\"\n    print(func(text1, text2))', '3', '\"\"\"Write a function named func that will find the length of the longest common subsequence of two given strings.\"\"\"'),
(570, 48, 'implement the quick sort algorithm', 'quick_sort', 'array', 'if __name__ == \"__main__\":\n    arr = [10, 7, 8, 9, 1, 5]\n    print(\"Given array is:\", arr)\n    func(arr, 0, len(arr) - 1)\n    print(\"Sorted array is:\", arr)', 'Sorted array is: [1, 5, 7, 8, 9, 10]', '\"\"\"Write a function named func that will implement the quick sort algorithm to sort a given array.\"\"\"'),
(580, 49, 'implement a data structure for LRUCache (Least Recently Used Cache)', 'LRU_cache', 'data structure', 'if __name__ == \"__main__\":\n    cache = LRUCache(2)\n    cache.put(1, 1)\n    cache.put(2, 2)\n    print(cache.get(1))\n    cache.put(3, 3)\n    print(cache.get(2))', 'None\n2', '\"\"\"Implement a data structure named LRUCache which supports the following operations: get(key) - Get the value of the key if the key exists in the cache, otherwise return None. put(key, value) - Set or insert the value if the key is not already present.\"\"\"'),
(590, 50, 'find the longest substring with at most k distinct characters', 'longest_substring_k_distinct', 'string', 'if __name__ == \"__main__\":\n    s = \"eceba\"\n    k = 2\n    print(func(s, k))', '3', '\"\"\"Write a function named func that will find the length of the longest substring with at most k distinct characters in a given string.\"\"\"');

-- --------------------------------------------------------

--
-- Table structure for table `conteststate`
--

CREATE TABLE `conteststate` (
  `contestID` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conteststate`
--

INSERT INTO `conteststate` (`contestID`, `state`) VALUES
(7, 'Upcoming'),
(8, 'Upcoming'),
(9, 'Closed'),
(10, 'Closed'),
(11, 'Closed'),
(12, 'Closed'),
(13, 'Ongoing');

-- --------------------------------------------------------

--
-- Table structure for table `contestsubmission`
--

CREATE TABLE `contestsubmission` (
  `contestID` int(11) NOT NULL,
  `problemID` int(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `accept` int(11) NOT NULL,
  `code` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contestsubmission`
--

INSERT INTO `contestsubmission` (`contestID`, `problemID`, `mail`, `accept`, `code`) VALUES
(13, 3, 'emon@gmail.com', 0, '\"\"\"Write a function named func that will reverse the elements of a given array.\"\"\"\ndef func(list):\n	return list'),
(13, 3, 'emon@gmail.com', 1, '\"\"\"Write a function named func that will reverse the elements of a given array.\"\"\"\ndef func(list):\n	list.reverse()\n	return list'),
(13, 5, 'emon@gmail.com', 1, '\"\"\"Write a function named func that will find the maximum element in a given array.\"\"\"\ndef func(list):\n	return 9'),
(13, 5, 'hridoy@gmail.com', 1, '\"\"\"Write a function named func that will find the maximum element in a given array.\"\"\"\ndef func(list):\n	return 9');

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
(20, 'emon@gmail.com', 'Solved array sum by python3\nTime Taken : 0.01\nSpace Taken : 7680', '2024-04-18 12:32:46'),
(21, 'hridoy@gmail.com', 'Solved array sum by python3\nTime Taken : 0.01\nSpace Taken : 7680', '2024-04-30 23:42:07'),
(22, 'hridoy@gmail.com', 'Solved array sum by python3\nTime Taken : 0.01\nSpace Taken : 7296', '2024-05-01 14:02:41'),
(23, 'hridoy@gmail.com', 'Solved array 3 by python3\nTime Taken : 0.00\nSpace Taken : 7680', '2024-05-01 14:05:50');

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
-- Table structure for table `problemset`
--

CREATE TABLE `problemset` (
  `contestID` int(11) DEFAULT NULL,
  `problemID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `problemset`
--

INSERT INTO `problemset` (`contestID`, `problemID`) VALUES
(13, 11),
(13, 6),
(13, 1),
(13, 5),
(13, 10),
(13, 9),
(13, 7),
(13, 4),
(13, 8),
(13, 3);

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
(4, 'emon@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)'),
(4, 'hridoy@gmail.com', '\"\"\"write a function named func that will calculate the sum of array elements\"\"\"\ndef func(list):\n	return sum(list)'),
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
('hridoy@gmail.com', 'images/hridoy.jpg', 'uiu uni', 'student', 'faka\n', 'hridoy ahmeddd'),
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
-- Indexes for table `contest`
--
ALTER TABLE `contest`
  ADD PRIMARY KEY (`contestID`);

--
-- Indexes for table `contestants`
--
ALTER TABLE `contestants`
  ADD KEY `contestID` (`contestID`),
  ADD KEY `contestantMail` (`contestantMail`);

--
-- Indexes for table `conteststate`
--
ALTER TABLE `conteststate`
  ADD KEY `contestID` (`contestID`);

--
-- Indexes for table `contestsubmission`
--
ALTER TABLE `contestsubmission`
  ADD PRIMARY KEY (`contestID`,`problemID`,`accept`,`mail`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `contest`
--
ALTER TABLE `contest`
  MODIFY `contestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `friend_requests`
--
ALTER TABLE `friend_requests`
  MODIFY `request_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `postid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

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
-- Constraints for table `contestants`
--
ALTER TABLE `contestants`
  ADD CONSTRAINT `contestants_ibfk_1` FOREIGN KEY (`contestID`) REFERENCES `contest` (`contestID`),
  ADD CONSTRAINT `contestants_ibfk_2` FOREIGN KEY (`contestantMail`) REFERENCES `users` (`email`);

--
-- Constraints for table `conteststate`
--
ALTER TABLE `conteststate`
  ADD CONSTRAINT `conteststate_ibfk_1` FOREIGN KEY (`contestID`) REFERENCES `contest` (`contestID`);

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
