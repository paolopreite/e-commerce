CREATE TABLE `e_commerce`.`t_company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `business_name` VARCHAR(45) NOT NULL,
  `vat_number` VARCHAR(45) NOT NULL,
  `address_street` VARCHAR(45) NOT NULL,
  `address_zip` VARCHAR(45) NOT NULL,
  `address_city` VARCHAR(45) NOT NULL,
  `address_provence` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
