CREATE TABLE IF NOT EXISTS `order`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` INT NOT NULL,
   `goods_id` INT NOT NULL,
   `count` INT NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `order` (`user_id`,`goods_id`,`count`)values(1,1,1);
