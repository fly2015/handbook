-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Generation Time: Aug 19, 2022 at 06:26 AM
-- Server version: 8.0.30
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `handbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `article_id` int NOT NULL,
  `article_title` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `article_title_slug` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `article_content` text CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `sequence` int DEFAULT NULL,
  `status_id` int NOT NULL,
  `created_by_user` int NOT NULL,
  `last_modified_by_user` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`article_id`, `article_title`, `article_title_slug`, `article_content`, `sequence`, `status_id`, `created_by_user`, `last_modified_by_user`, `created_date`, `last_modified_date`) VALUES
(2, 'article_ae0ea', 'article_4eef7', 'article_content_836692ee3d66c2eea5a0f75e4e090f4c', NULL, 1, 1, 1, '2018-09-11 21:41:58', '2018-09-11 21:41:58'),
(3, 'article_8940b', 'article_810bc', 'article_content_f69e52ad0d1c8a85d40cd3f35a1586ea', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(4, 'article_c1801', 'article_1fa15', 'article_content_3175fd0e467db18d3fdc3fbfc3c6eb50', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(5, 'article_d1496', 'article_3d514', 'article_content_5bc8a824f78ba204b51eae7f623aebd4', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(6, 'article_f6995', 'article_385e0', 'article_content_b156bbbb42a8a2476a74822f9be0881c', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(7, 'article_94b02', 'article_07572', 'article_content_9afb58dcc02a904edc5f05a9fa86c99a', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(8, 'article_06225', 'article_3b129', 'article_content_5aa4e213ff2d9cce345d519f4377f969', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(9, 'article_b90a8', 'article_82bef', 'article_content_9c924cbdc3b834974ff30bbf01c2d290', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(10, 'article_55218', 'article_df395', 'article_content_f3ac20651f3c7e3fad2778d5ef06b94c', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(11, 'article_698fc', 'article_ae243', 'article_content_07c1cf8e86230745b0b6076cfed83043', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(12, 'article_038ed', 'article_e1fa4', 'article_content_db88a5d909b35a837fc055c0b2ca903f', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(13, 'article_53704', 'article_40920', 'article_content_14b94ba0eed672bbde0312eac3d6e603', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(14, 'article_586e3', 'article_4247f', 'article_content_9ab95b3c039a2bc816c6835f926e7398', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(15, 'article_88b69', 'article_7782e', 'article_content_de1a24cdaeb1c3c336b3452b054fe93a', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(16, 'article_35480', 'article_79024', 'article_content_68ab36088b6617a0060bfbbcdbd962c4', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(17, 'article_8596f', 'article_4eed0', 'article_content_fcde1a6bf78efa197999ce8f38bc78e2', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(18, 'article_479ee', 'article_77dff', 'article_content_ebf16f8d97ed1a5a87e544999554de74', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(19, 'article_285ac', 'article_2a5fa', 'article_content_100e41ec24245f0eeee234ff98f222e6', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(20, 'article_28a96', 'article_d77ce', 'article_content_f4a6ac0003d068b431449f60393236f1', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(21, 'article_5617d', 'article_b1e67', 'article_content_861deba46b209cc49207211a4a60215b', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(22, 'article_9a73c', 'article_d5946', 'article_content_83db149f3e5835bd3c2b2b03975267ef', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(23, 'article_f3a8b', 'article_147d2', 'article_content_1c42a5aa9f06a4479fb0dbbd4d051a04', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(24, 'article_7f141', 'article_53963', 'article_content_119c978cc0d1480e3289d44a56a5de73', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(25, 'article_0b032', 'article_27ac6', 'article_content_1fd5cc182b08e244e6dfbd9f8ed9e16d', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(26, 'article_d98a2', 'article_f11a8', 'article_content_bfae668642774ed7fbdb30a5f7c6816e', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(27, 'article_20271', 'article_364df', 'article_content_d2a22d5baf89bc1aae74b6039099a72f', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(28, 'article_1f8c4', 'article_5d19d', 'article_content_1cefc88f433cfdbb069330670b1c2aef', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(29, 'article_70596', 'article_600cc', 'article_content_0e131c12563259b31a2e3cfcdbc38b96', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(30, 'article_0ed6e', 'article_95d84', 'article_content_767c49e382441bf564364f08878dbec9', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(31, 'article_47d00', 'article_c0f17', 'article_content_89b9b8b5c399bea6cc872f35389dbec2', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(32, 'article_6f9d2', 'article_2546a', 'article_content_aa56edc0cc2a936de80c5f0c843f61a8', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(33, 'article_94147', 'article_dd6c8', 'article_content_c4d60975c948d6106fb64ddc4558cc70', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(34, 'article_3bce7', 'article_82295', 'article_content_978b17fef8e2bef6251209a1830803b8', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(35, 'article_fe1ad', 'article_a88b3', 'article_content_1da656950ca9dfdbf74ecee8e213c672', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(36, 'article_4aa1f', 'article_af3d2', 'article_content_428a45061472c9dca374234bc1f08d4e', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(37, 'article_b1858', 'article_0b120', 'article_content_d55fbb4344625bde64b1132cf68a1cec', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(38, 'article_3bb6e', 'article_55dc6', 'article_content_6a302bcf20203a796e5c85770b5f5ebf', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(39, 'article_07957', 'article_1047b', 'article_content_0037371137c6c658df9728632006d73b', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(40, 'article_bf0be', 'article_538dc', 'article_content_cb89ddb4dbc98f90e23cffef1318783f', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(41, 'article_c57b2', 'article_7d023', 'article_content_df824bfb064c5c451e095b594c351ddf', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(42, 'article_bbf4e', 'article_f935f', 'article_content_7e9d72c8ed51a2732dce7fe952b69410', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(43, 'article_e99e0', 'article_38f5b', 'article_content_f00c4bf87227473e92bbb91fc2f95b63', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(44, 'article_cd4d8', 'article_b814d', 'article_content_ac8e76fe62a01cb13573b433dd44ba2d', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(45, 'article_d9187', 'article_6788b', 'article_content_7ba4c7709a0f9502746ee0d756cf9539', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(46, 'article_6dbe6', 'article_5e5e5', 'article_content_e4152e6d1483922c96e734da548ce0cf', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(47, 'article_323e0', 'article_72104', 'article_content_0bb84cc7643ca2fb12babc3914b08083', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(48, 'article_ebd03', 'article_b144d', 'article_content_18029f60a0ca878197fec3421767bd90', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(49, 'article_45e0d', 'article_72ef0', 'article_content_70241946ad10b4259f16c7c363d9c954', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(50, 'article_70903', 'article_6d08b', 'article_content_cae16ef43bf6795710c11dc47ffd8f08', NULL, 1, 1, 1, '2018-09-11 21:43:02', '2018-09-11 21:43:02'),
(51, 'article_c18d5', 'article_ff1cb', 'article_content_1cfda720b04f2cfc98246625bc2cf6e3', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(52, 'article_2271b', 'article_64742', 'article_content_3c686c25136db56b60330b56cb83f31b', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(53, 'article_764fe', 'article_b6780', 'article_content_f27323d6e0daf5c5e961972d1186f26a', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(54, 'article_246f7', 'article_cd846', 'article_content_4031f51ebbf6b528fb9efe8ef2b74fd3', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(55, 'article_ad13f', 'article_18d1c', 'article_content_c24b39e5f283f8005084b201ee7b8307', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(56, 'article_07997', 'article_7f34f', 'article_content_8474fc659c86245c4ba2b6684c8d30da', NULL, 1, 1, 1, '2018-09-11 21:43:03', '2018-09-11 21:43:03'),
(66, 'Deep understanding of Docker concepts', 'Deep-understanding-of-Docker-concepts', '<p>Deep understanding of Docker concepts.</p>', NULL, 1, 1, 1, '2022-08-19 06:22:30', '2022-08-19 06:22:30');

-- --------------------------------------------------------

--
-- Table structure for table `bookmark`
--

CREATE TABLE `bookmark` (
  `bookmark_id` int NOT NULL,
  `article_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `comment_id` int NOT NULL,
  `article_id` int NOT NULL,
  `comment_content` text CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `status_id` int NOT NULL,
  `created_by_user` int NOT NULL,
  `last_modified_by_user` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `role_name` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `role_name_slug` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `status_id` int NOT NULL,
  `created_by_user` int NOT NULL,
  `last_modified_by_user` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `role_name_slug`, `status_id`, `created_by_user`, `last_modified_by_user`, `created_date`, `last_modified_date`) VALUES
(1, 'ADMIN', 'admin', 1, 1, 1, '2018-09-04 22:12:54', '2018-09-04 22:12:54'),
(2, 'USER', 'user', 1, 1, 1, '2018-09-04 22:12:54', '2018-09-04 22:12:54'),
(3, 'TEST', 'test', 1, 1, 1, '2018-09-04 22:13:56', '2018-09-04 22:13:56'),
(4, 'INACTIVE_ROLE', 'inactive-role', 0, 1, 1, '2018-09-04 22:13:56', '2018-09-04 22:13:56');

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `tag_id` int NOT NULL,
  `tag_name` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `tag_name_slug` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `status_id` int NOT NULL,
  `created_by_user` int NOT NULL,
  `last_modified_by_user` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`tag_id`, `tag_name`, `tag_name_slug`, `status_id`, `created_by_user`, `last_modified_by_user`, `created_date`, `last_modified_date`) VALUES
(1, 'tag_a21e9', 'tag_0a1bc', 1, 1, 1, '2018-09-11 21:02:03', '2018-09-11 21:02:03'),
(2, 'tag_68a35', 'tag_95523', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(3, 'tag_a5f09', 'tag_0eaaf', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(4, 'tag_b2438', 'tag_dc360', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(5, 'tag_448de', 'tag_0358e', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(6, 'tag_e56ab', 'tag_1f2de', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(7, 'tag_b5660', 'tag_cfb4d', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(8, 'tag_d675b', 'tag_e3f82', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(9, 'tag_7c558', 'tag_2c683', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(10, 'tag_a8c6d', 'tag_b5b0c', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(11, 'tag_c28e7', 'tag_56513', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(12, 'tag_1b07d', 'tag_e0d83', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(13, 'tag_27c68', 'tag_f9e4f', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(14, 'tag_a8627', 'tag_6695c', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(15, 'tag_66668', 'tag_8f051', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(16, 'tag_aae50', 'tag_32f3b', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(17, 'tag_e9431', 'tag_7fd90', 1, 1, 1, '2018-09-11 21:02:16', '2018-09-11 21:02:16'),
(57, 'test2018123', 'test2018123', 1, 1, 1, '2018-10-25 22:07:16', '2018-10-25 22:07:16'),
(58, 'test112018', 'test112018', 1, 1, 1, '2018-11-07 21:35:06', '2018-11-07 21:35:06'),
(59, 'test20181231243', 'test20181231243', 0, 1, 1, '2018-11-07 21:56:09', '2018-11-07 21:56:09'),
(60, 'test20181231zzzz', 'test20181231zzzz', 1, 1, 1, '2018-11-07 23:00:32', '2018-11-07 23:00:32'),
(61, 'test20181231243xsar', 'test20181231243xsar', 1, 1, 1, '2018-11-07 23:00:57', '2018-11-07 23:00:57'),
(62, 'test20181231243uuuu', 'test20181231243uuuu', 0, 1, 1, '2018-11-07 23:01:04', '2018-11-07 23:01:04'),
(63, 'Docker Workshop', 'Docker-Workshop', 1, 1, 1, '2022-08-19 06:21:47', '2022-08-19 06:21:47');

-- --------------------------------------------------------

--
-- Table structure for table `tag_article`
--

CREATE TABLE `tag_article` (
  `index_id` int NOT NULL,
  `tag_id` int NOT NULL,
  `article_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `tag_article`
--

INSERT INTO `tag_article` (`index_id`, `tag_id`, `article_id`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 1, 4),
(4, 1, 5),
(11, 2, 2),
(12, 3, 3),
(13, 4, 4),
(14, 5, 5),
(15, 6, 6),
(17, 8, 8),
(18, 56, 57),
(19, 55, 57),
(20, 55, 58),
(21, 56, 58),
(22, 55, 59),
(23, 56, 59),
(24, 56, 60),
(25, 55, 60),
(26, 56, 61),
(27, 55, 61),
(28, 55, 62),
(29, 56, 62),
(30, 56, 63),
(31, 55, 63),
(32, 2, 64),
(33, 1, 64),
(34, 1, 65),
(35, 63, 66);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL,
  `user_id` int NOT NULL,
  `article_id` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `email` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `password` varchar(250) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `status_id` int NOT NULL DEFAULT '0',
  `created_by_user` int NOT NULL,
  `last_modified_by_user` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `password`, `status_id`, `created_by_user`, `last_modified_by_user`, `created_date`, `last_modified_date`) VALUES
(1, 'admin', 'admin@gmail.com', 'password', 1, 1, 1, '2018-09-04 22:09:46', '2018-09-04 22:09:46'),
(2, 'user', 'user@gmail.com', 'password', 1, 1, 1, '2018-09-04 22:10:28', '2018-09-04 22:10:28'),
(3, 'testuser', 'testuser@gmail.com', 'testuser', 1, 1, 1, '2018-09-04 22:10:28', '2018-09-04 22:10:28'),
(4, 'intactiveuser', 'intactiveuser@gmail.com', 'intactiveuser', 0, 1, 1, '2018-09-04 22:11:15', '2018-09-04 22:11:15'),
(5, 'user2018', '123@gmail.com', 'password', 1, 0, 0, '2018-11-09 00:02:47', '2018-11-09 00:02:47'),
(6, 'user20181', '123@gmail.com', 'pa$$word', 0, 0, 0, '2018-11-09 00:05:37', '2018-11-09 00:05:37');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `index_id` int NOT NULL,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`index_id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(6, 14, 2),
(7, 15, 2),
(8, 16, 2),
(9, 5, 2),
(10, 6, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`tag_id`),
  ADD UNIQUE KEY `tag_name_slug` (`tag_name_slug`);

--
-- Indexes for table `tag_article`
--
ALTER TABLE `tag_article`
  ADD PRIMARY KEY (`index_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`index_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `article_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `tag_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `tag_article`
--
ALTER TABLE `tag_article`
  MODIFY `index_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `index_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
