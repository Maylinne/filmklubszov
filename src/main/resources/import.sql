INSERT INTO `filmklub`.`user` (`id`, `email`, `name`, `password`, `role`) VALUES ('2', 'fksz@fksz.com', 'Lab�th Viktor', '$2a$11$FNqfP9xgkMZqP9Qb/71.c.prnJ1e5Rz7Pyug46/gKlfPfKMn.ZNAq', 'ROLE_ADMIN');
INSERT INTO `filmklub`.`filmmeta` (`id`, `director`, `hungarianTitle`, `title`) VALUES ('1', 'Luc Besson', 'otodik elem', '5th element');
INSERT INTO `filmklub`.`cut` (`id`, `hungarianTitle`, `length`, `title`, `year`, `filmMeta_id`) VALUES ('2', 'Rendezői változat', '126', 'Director\'s cut', '1996', '1');
INSERT INTO `filmklub`.`location` (`id`, `address`, `city`, `name`) VALUES ('3', 'Rejtő Jenő u. 6', 'Budapest', 'Nagy Anasztázia');
INSERT INTO `filmklub`.`spot` (`id`, `name`, `places`, `location_id`) VALUES ('4', 'Nappali', '8', '3');
INSERT INTO `filmklub`.`offer` (`id`, `cut_id`, `partner_id`) VALUES ('5', '2', '2');
INSERT INTO `filmklub`.`offer` (`id`, `partner_id`, `spot_id`) VALUES ('6', '2', '4');
