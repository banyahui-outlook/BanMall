CREATE TABLE IF NOT EXISTS `user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `age` INT NOT NULL,
   `money` INT NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` (`name`,`age`,`money`)values('zhangsan',18,10000);
INSERT INTO `user` (`name`,`age`,`money`)values('lisi',32,30000);
INSERT INTO `user` (`name`,`age`,`money`)values('wangwu',21,80000);
INSERT INTO `user` (`name`,`age`,`money`)values('zhaoliu',26,90000);