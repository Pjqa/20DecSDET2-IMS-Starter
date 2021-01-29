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


CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `oid` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_id` INT NOT NULL,
    PRIMARY KEY (`oid`),
    FOREIGN KEY (`fk_id`) REFERENCES customers (`id`)
);    
    
CREATE TABLE IF NOT EXISTS `ims`.`orderlines` (
    `rid`  INT(11) NOT NULL AUTO_INCREMENT,
    `fk_iid` INT NOT NULL,
    `fk_oid` INT NOT NULL,
    PRIMARY KEY (`rid`),
    FOREIGN KEY (`fk_iid`) REFERENCES items (`iid`),
    FOREIGN KEY (`fk_oid`) REFERENCES orders (`oid`)
);
