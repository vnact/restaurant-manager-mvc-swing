-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3316
-- Thời gian đã tạo: Th12 12, 2020 lúc 02:06 PM
-- Phiên bản máy phục vụ: 10.4.16-MariaDB
-- Phiên bản PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `restaurant`
--
CREATE DATABASE IF NOT EXISTS `restaurant` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `restaurant`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `phoneNumber`, `name`, `address`, `birthday`) VALUES
(1, '0911175581', 'Cường', 'Nghệ An', '2000-04-09 17:00:00'),
(2, '0911175581', 'Linh', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `startDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `permissionName` varchar(50) NOT NULL,
  `permissionId` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `permissionName`, `permissionId`) VALUES
(1, 'admin', 'admin', 'Admin', NULL, '2020-11-23 17:00:00', 'Quản lý', '1'),
(2, 'nhanvien', '12345', 'Nhân Viên 1', '0911175581', '2020-11-24 05:15:08', 'Nhân viên', '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food_category`
--

DROP TABLE IF EXISTS `food_category`;
CREATE TABLE IF NOT EXISTS `food_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `slug` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `food_category`
--

INSERT INTO `food_category` (`id`, `name`, `slug`) VALUES
(1, 'Đồ Ăn', 'do-an'),
(2, 'Trà Sữa', 'tra-sua'),
(3, 'Cà Phê', 'ca-phe'),
(4, 'Topping', 'topping');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food_item`
--

DROP TABLE IF EXISTS `food_item`;
CREATE TABLE IF NOT EXISTS `food_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `urlImage` varchar(50) DEFAULT NULL,
  `unitName` varchar(20) NOT NULL,
  `unitPrice` bigint(20) NOT NULL,
  `idCategory` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_item_category` (`idCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `food_item`
--

INSERT INTO `food_item` (`id`, `name`, `description`, `urlImage`, `unitName`, `unitPrice`, `idCategory`) VALUES
(1, 'No Topping', '', '', 'Phần', 0, 4),
(2, 'Trân Châu Tuyết Sợi', NULL, NULL, 'Phần', 10000, 4),
(3, 'Trân Châu Đen', NULL, NULL, 'Phần', 10000, 4),
(4, 'Trân Châu Trắng', NULL, NULL, 'Phần', 10000, 4),
(5, 'Trà Sữa Trân Châu', NULL, NULL, 'Ly', 50000, 2),
(6, 'Trà Sữa Sương Sáo', NULL, NULL, 'Ly', 45000, 2),
(7, 'Trà Sữa Matcha(L)', '', '', 'Ly', 50000, 1),
(8, 'Sữa Tươi Trân Châu Đường Đen', NULL, NULL, 'Ly', 45000, 2),
(9, 'Bánh Flan', '', '', 'Cái', 10000, 1),
(10, 'Hướng dương', NULL, NULL, 'Túi', 10000, 1),
(11, 'Cafe truyền thống', NULL, NULL, 'Cốc', 35000, 3),
(12, 'Espresso', NULL, NULL, 'Cốc', 45000, 3),
(13, 'Trà Sữa Matcha(XL)', NULL, NULL, 'Ly', 25000, 2),
(14, 'Trà Sữa Ô Long', '', '', 'Ly', 20000, 2),
(15, 'Trà Đào', '', 'tra-ao-2020-12-10-12-15-10.png', 'Ly', 40000, 2),
(16, 'Trà Đào(L)', '', 'tra-ao-l-2020-12-10-12-16-17.png', 'Ly', 50000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idEmployee` int(11) NOT NULL,
  `idTable` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL DEFAULT 'local' COMMENT 'local - tại quán\nonline - đặt online',
  `status` varchar(45) NOT NULL DEFAULT 'unpaid' COMMENT 'unpaid - chưa thanh toán\npaid - đã thanh toán',
  `orderDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `payDate` timestamp NULL DEFAULT NULL,
  `paidAmount` bigint(20) DEFAULT 0,
  `totalAmount` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `fk_employee_order` (`idEmployee`),
  KEY `fk_order_table` (`idTable`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `idEmployee`, `idTable`, `type`, `status`, `orderDate`, `payDate`, `paidAmount`, `totalAmount`) VALUES
(1, 1, 1, 'local', 'unpaid', '2020-11-24 07:28:41', NULL, 0, 0),
(2, 1, 1, 'online', 'unpaid', '2020-11-24 08:05:08', '2020-11-23 17:00:00', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_item`
--

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE IF NOT EXISTS `order_item` (
  `idOrder` int(11) NOT NULL,
  `idFoodItem` int(11) NOT NULL,
  `idTopping` int(11) NOT NULL DEFAULT 0,
  `quantity` int(11) NOT NULL DEFAULT 1,
  `unitPrice` bigint(20) NOT NULL DEFAULT 0,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idOrder`,`idFoodItem`,`idTopping`),
  KEY `fk_order_main_item` (`idFoodItem`),
  KEY `fk_order_topping` (`idTopping`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `order_item`
--

INSERT INTO `order_item` (`idOrder`, `idFoodItem`, `idTopping`, `quantity`, `unitPrice`, `note`) VALUES
(1, 1, 1, 3, 0, NULL),
(1, 3, 2, 2, 0, NULL),
(1, 8, 1, 2, 0, NULL),
(2, 8, 1, 2, 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipment`
--

DROP TABLE IF EXISTS `shipment`;
CREATE TABLE IF NOT EXISTS `shipment` (
  `idOrder` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `shipperName` varchar(50) NOT NULL,
  `shipperPhoneNumber` varchar(20) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'topay' COMMENT 'topay - chờ xác nhận\ntoship - chờ lấy hàng\ntoreceive - đang giao\ncompleted - hoàn thành\ncancelled - đã hủy',
  `notice` varchar(45) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT current_timestamp(),
  `endDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `fk_ship_customer` (`idCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `shipment`
--

INSERT INTO `shipment` (`idOrder`, `idCustomer`, `shipperName`, `shipperPhoneNumber`, `status`, `notice`, `startDate`, `endDate`) VALUES
(2, 1, 'Nguyễn Văn B', '09421321323', 'toreceive', NULL, '2020-11-23 17:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `table`
--

DROP TABLE IF EXISTS `table`;
CREATE TABLE IF NOT EXISTS `table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'free' COMMENT 'free-Trống\nserving-Đang phục vụ\nreserving-Đặt trước',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `table`
--

INSERT INTO `table` (`id`, `name`, `status`) VALUES
(1, 'Bàn 1', 'free'),
(2, 'Bàn 2', 'free'),
(3, 'Bàn 3', 'free');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `food_item`
--
ALTER TABLE `food_item`
  ADD CONSTRAINT `fk_item_category` FOREIGN KEY (`idCategory`) REFERENCES `food_category` (`id`);

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_employee_order` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `fk_order_table` FOREIGN KEY (`idTable`) REFERENCES `table` (`id`);

--
-- Các ràng buộc cho bảng `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `fk_order_item` FOREIGN KEY (`idOrder`) REFERENCES `order` (`id`),
  ADD CONSTRAINT `fk_order_main_item` FOREIGN KEY (`idFoodItem`) REFERENCES `food_item` (`id`),
  ADD CONSTRAINT `fk_order_topping` FOREIGN KEY (`idTopping`) REFERENCES `food_item` (`id`);

--
-- Các ràng buộc cho bảng `shipment`
--
ALTER TABLE `shipment`
  ADD CONSTRAINT `fk_order_ship` FOREIGN KEY (`idOrder`) REFERENCES `order` (`id`),
  ADD CONSTRAINT `fk_ship_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
