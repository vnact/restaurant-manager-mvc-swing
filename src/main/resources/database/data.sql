INSERT INTO `table` (`id`, `name`, `status`)
VALUES (NULL, 'Bàn 1', 'free'),
       (NULL, 'Bàn 2', 'free'),
       (NULL, 'Bàn 3', 'free');


INSERT INTO `customer` (`id`, `phoneNumber`, `name`, `address`, `birthday`)
VALUES (NULL, '0911175581', 'Cường', 'Nghệ An', '2000-04-10 00:00:00'),
       (NULL, '0911175581', 'Linh', NULL, NULL);


INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `permissionName`, `permissionId`)
VALUES (NULL, 'admin', 'admin', 'Admin', NULL, '2020-11-24 00:00:00','Quản lý', 1),
       (NULL, 'nhanvien', '12345', 'Nhân Viên 1', '0911175581', '2020-11-24 12:15:08','Nhân viên', 2);


INSERT INTO `food_category` (`id`, `name`, `slug`)
VALUES (NULL, 'Đồ Ăn', 'do-an'),
       (NULL, 'Trà Sữa', 'tra-sua'),
       (NULL, 'Cà Phê', 'ca-phe'),
       (NULL, 'Topping', 'topping');



ALTER TABLE `food_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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



INSERT INTO `order` (`idEmployee`, `idTable`, `type`, `orderDate`, `status`, `payDate`, `paidAmount`, `totalAmount`) VALUES
(1, 1, 'local', '2020-11-24 14:28:41', 'unpaid', NULL, 0, 0),
(1, 1, 'online', '2020-11-24 15:05:08', 'unpaid', '2020-11-24 00:00:00', 0, 0);


INSERT INTO `order_item` (`idOrder`, `idFoodItem`, `idTopping`, `quantity`, `foodPrice`, `toppingPrice`, `note`) VALUES
(1, 7, 1, 3, 0, 0, NULL),
(1, 8, 1, 2, 0, 0, NULL),
(1, 14, 2, 2, 0, 0, NULL),
(2, 9, 1, 2, 0, 0, NULL);


INSERT INTO `shipment` (`idOrder`, `idCustomer`, `shipperName`, `shipperPhoneNumber`, `status`, `notice`, `startDate`, `endDate`)
VALUES
(2, 1, 'Nguyễn Văn B', '09421321323', 'toreceive', NULL, '2020-11-24 00:00:00', NULL);
