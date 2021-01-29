DROP TABLE `orderlines`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;


CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`iid` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
	`price` DOUBLE NOT NULL,
	PRIMARY KEY (`iid`)
);


CREATE TABLE IF NOT EXISTS `orders` (
    `oid` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_id` INT NOT NULL,
    `price` DOUBLE,
    PRIMARY KEY (`oid`),
    FOREIGN KEY (`fk_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE
);    
    
CREATE TABLE IF NOT EXISTS `orderlines` (
    `rid`  INT(11) NOT NULL AUTO_INCREMENT,
    `fk_iid` INT NOT NULL,
    `fk_oid` INT NOT NULL,
    PRIMARY KEY (`rid`),
    FOREIGN KEY (`fk_iid`) REFERENCES `items` (`iid`) ON DELETE CASCADE , 
    FOREIGN KEY (`fk_oid`) REFERENCES `orders` (`oid`) ON DELETE CASCADE
);