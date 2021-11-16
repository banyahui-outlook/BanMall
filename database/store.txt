CREATE TABLE IF NOT EXISTS `store`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `goods_id` INT NOT NULL,
   `count` INT NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `store` (`goods_id`,`count`)values(1,100);
INSERT INTO `store` (`goods_id`,`count`)values(2,200);
INSERT INTO `store` (`goods_id`,`count`)values(3,300);
INSERT INTO `store` (`goods_id`,`count`)values(4,400);