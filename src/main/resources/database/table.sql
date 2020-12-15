CREATE TABLE IF NOT EXISTS `Customer` (
    `id` int NOT NULL AUTO_INCREMENT,
    `phoneNumber` varchar(20) NOT NULL,
    `name` varchar(50) NULL,
    `address` varchar(250) NULL,
    `birthday` TIMESTAMP NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `Table` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `status` varchar(45) NOT NULL DEFAULT 'free' COMMENT 'free-Trống\nserving-Đang phục vụ\nreserving-Đặt trước',
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `Employee` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(50) UNIQUE NOT NULL,
    `password` varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    `phoneNumber` varchar(20) NOT NULL DEFAULT '',
    `startDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `permissionName` varchar(50) NOT NULL,
    `permissionId` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `Food_Category` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(50) UNIQUE NOT NULL,
    `slug` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `Food_Item` (
    `id` int NOT NULL AUTO_INCREMENT AUTO_INCREMENT=1,
    `name` varchar(50) UNIQUE NOT NULL,
    `description` varchar(500) NULL,
    `urlImage` varchar(50) NULL,
    `unitName` varchar(20) NOT NULL,
    `unitPrice` bigint NOT NULL,
    `idCategory` int NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_item_category` FOREIGN KEY (`idCategory`) REFERENCES `Food_Category` (`id`)
);
CREATE TABLE IF NOT EXISTS `Order` (
    `id` int NOT NULL AUTO_INCREMENT,
    `idEmployee` int NOT NULL,
    `idTable` int NULL,
    `type` varchar(45) NOT NULL DEFAULT 'local' COMMENT 'local - tại quán\nonline - đặt online',
    `status` varchar(45) NOT NULL DEFAULT 'unpaid' COMMENT 'unpaid - chưa thanh toán\npaid - đã thanh toán',
    `orderDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `payDate` TIMESTAMP NULL,
    `paidAmount` bigint NULL DEFAULT 0,
    `totalAmount` bigint NOT NULL DEFAULT 0,
    `discount` int NOT NULL DEFAULT 0,
    CHECK(discount >= 0 AND discount <= 100)
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_employee_order` FOREIGN KEY (`idEmployee`) REFERENCES `Employee` (`id`),
    CONSTRAINT `fk_order_table` FOREIGN KEY (`idTable`) REFERENCES `Table` (`id`)
);
CREATE TABLE IF NOT EXISTS `Shipment` (
    `idOrder` int NOT NULL,
    `idCustomer` int NOT NULL,
    `shipperName` varchar(50) NOT NULL,
    `shipperPhoneNumber` varchar(20) NOT NULL,
    `status` varchar(45) NOT NULL DEFAULT 'topay' COMMENT 'topay - chờ xác nhận\ntoship - chờ lấy hàng\ntoreceive - đang giao\ncompleted - hoàn thành\ncancelled - đã hủy',
    `notice` varchar(45) NULL,
    `startDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `endDate` TIMESTAMP NULL,
    PRIMARY KEY (`idOrder`),
    CONSTRAINT `fk_ship_customer` FOREIGN KEY (`idCustomer`) REFERENCES `Customer` (`id`),
    CONSTRAINT `fk_order_ship` FOREIGN KEY (`idOrder`) REFERENCES `Order` (`id`)
);
CREATE TABLE IF NOT EXISTS `Order_Item` (
    `idOrder` int NOT NULL,
    `idFoodItem` int NOT NULL,
    `idTopping` int NOT NULL DEFAULT 1,
    `quantity` int NOT NULL DEFAULT 1,
    `foodPrice` bigint(20) NOT NULL DEFAULT 0,
    `toppingPrice` bigint(20) NOT NULL DEFAULT 0,
    `note` varchar(100) NULL,
    PRIMARY KEY ( `idOrder`, `idFoodItem`, `idTopping`),
    CONSTRAINT `fk_order_main_item` FOREIGN KEY (`idFoodItem`) REFERENCES `Food_Item` (`id`),
    CONSTRAINT `fk_order_topping` FOREIGN KEY (`idTopping`) REFERENCES `Food_Item` (`id`),
    CONSTRAINT `fk_order_item` FOREIGN KEY (`idOrder`) REFERENCES `Order` (`id`)
);