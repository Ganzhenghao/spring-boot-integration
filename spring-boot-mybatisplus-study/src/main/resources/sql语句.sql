CREATE TABLE `mp_user` (
                           `id` BIGINT ( 255 ) NOT NULL,
                           `name` VARCHAR ( 255 ) DEFAULT NULL,
                           `age` INT ( 11 ) DEFAULT NULL,
                           `email` VARCHAR ( 255 ) DEFAULT NULL,
                           `version` VARCHAR ( 255 ) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           `deleted` INT ( 10 ) DEFAULT NULL,
                           PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;