-- Employee --

--Hiển thị thông tin các nhân viên
SELECT e.id, e.name, e.username, password, phoneNumber, startDate, ep.name as permissionName, ep.slug as permissionSlug, ep.id as permissionId FROM `employee` e JOIN `employee_position` ep ON e.idPosition = ep.id
--Thêm nhân viên
INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `idPosition`) VALUES (NULL, 'nhanvien2', '12345', 'Nhân Viên 2', NULL, current_timestamp(), '2')
--Sửa nhân viên
UPDATE `employee` SET `username` = 'nhanvien2', `phoneNumber` = '' WHERE `employee`.`id` = 2;
--Xóa nhân viên
DELETE FROM `employee` WHERE `employee`.`id` = 3

-- Food Item --
SELECT o.id, idEmployee, idTable, type, o.status, orderDate, payDate, paidAmount, totalAmount, discount, username, e.name AS  nameEmployee, phoneNumber, startDate, permissionName, permissionId, t.name AS nameTable, t.status AS statusTable FROM `order` o JOIN `employee` e ON o.`idEmployee` = e.`id` JOIN `table` t ON t.`id` = o.`idTable`
--Thêm user
CREATE USER 'kma'@'%' IDENTIFIED VIA mysql_native_password USING 'kma';
GRANT ALL PRIVILEGES ON *.* TO 'kma'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT ALL PRIVILEGES ON `restaurant`.* TO 'kma'@'%';