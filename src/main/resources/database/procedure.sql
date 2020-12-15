DELIMITER $$
CREATE PROCEDURE `addOrderItem`(IN `_idOrder` INT, IN `_idFoodItem` INT, IN `_idTopping` INT, IN `_quantity` INT, IN `_unitPrice` INT)
    MODIFIES SQL DATA
INSERT INTO `order_item` (`idOrder`, `idFoodItem`, `idTopping`, `quantity`, `unitPrice`) VALUES (_idOrder, _idFoodItem, _idTopping, _quantity, _unitPrice)  ON DUPLICATE KEY UPDATE    
`quantity`= `quantity` + _quantity AND `unitPrice` = _unitPrice$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION `getEmployee`(`_id` INT) RETURNS varchar(1000) CHARSET utf8mb4
BEGIN
    DECLARE result VARCHAR(1000);
   SELECT 
        CONCAT(`id` , '|' , `username`, '|', `password`, '|', `name`, '|', `phoneNumber`, '|', UNIX_TIMESTAMP(`startDate`), '|', `permissionName`, '|', `permissionId`)
           INTO result FROM `employee` WHERE `id` = _id;
    RETURN result;
END$$
DELIMITER ;


DELIMITER $$
CREATE FUNCTION `getUnitPrice`(`_id` INT) RETURNS int(11)
BEGIN
    DECLARE result VARCHAR(1000);
    SELECT unitPrice INTO result FROM `food_item` WHERE id = _id;
    RETURN result;
END$$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION getTranslatorGroupsFromIdManga(id INT) RETURNS VARCHAR(1000)
BEGIN
    DECLARE result VARCHAR(1000);
    SELECT GROUP_CONCAT(
        DISTINCT CONCAT(id, '|' , name) 
        ORDER BY idManga SEPARATOR ','
        )
    INTO result
    FROM manga_translator_groups
	JOIN translator_groups
	ON manga_translator_groups.`idTranslatorGroup` = translator_groups.`id`
	WHERE idManga = id
	GROUP BY idManga;
    RETURN result;
END;

SELECT CONCAT(`id` , '|' , `username`, '|', `password`, '|', `name`, '|', `phoneNumber`, '|', UNIX_TIMESTAMP(`startDate`), '|', `permissionName`, '|', `permissionId`) AS dataEmployee FROM `employee`
SELECT `id` + '|' +  `username`+ '|' +`password`+ '|' + `name`+ '|'+ `phoneNumber`+'|'+TIMESTAMP(`startDate`)+'|'+ `permissionName`+ '|'+ `permissionId` FROM `employee`;