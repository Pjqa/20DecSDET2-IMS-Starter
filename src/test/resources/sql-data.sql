INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Thing', 'One');
INSERT INTO `customers` (`first_name`, `surname`) VALUES ('Cat', 'Hat');

INSERT INTO `items` (`name`, `price`) VALUES ('Lolly', 0.55);
INSERT INTO `items` (`name`, `price`) VALUES ('Haribos', 1.55);

INSERT INTO `orders` (`fk_id` ) VALUES (1);
INSERT INTO `orders` (`fk_id`) VALUES (2);

INSERT INTO `orderlines` (`fk_iid`, `fk_oid`) VALUES (1, 1);
INSERT INTO `orderlines` (`fk_iid`, `fk_oid`) VALUES (2, 2);