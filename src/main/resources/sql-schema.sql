drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);









CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`iid` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
	`value` DEC(5,2) NOT NULL,
	PRIMARY KEY (`iid`)
);