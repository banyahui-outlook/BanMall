CREATE TABLE IF NOT EXISTS `goods`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `price` INT NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `goods` (`name`,`price`)values('apple',5000);
INSERT INTO `goods` (`name`,`price`)values('oppo',2000);
INSERT INTO `goods` (`name`,`price`)values('xiaomi',3000);
INSERT INTO `goods` (`name`,`price`)values('huawei',4000);