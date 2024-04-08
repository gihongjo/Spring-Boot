CREATE TABLE `board` (
                         `id` bigint(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `board_name` varchar(100) NOT NULL,
                         `status` varchar(50) NOT NULL
);

CREATE TABLE `post` (
                        `id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        `board_id` bigint(32),
                        `user_name` varchar(50) NOT NULL,
                        `password` varchar(4) NOT NULL,
                        `email` varchar(50) NOT NULL,
                        `status` varchar(50) NOT NULL,
                        `title` varchar(100) NOT NULL,
                        `content` text,
                        `posted_at` datetime NOT NULL
);

CREATE TABLE `reply` (
                         `id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         `post_id` bigint(32) NOT NULL,
                         `board` bigint(32),
                         `user_name` varchar(50) NOT NULL,
                         `password` varchar(4) NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `status` varchar(50) NOT NULL,
                         `title` varchar(100) NOT NULL,
                         `content` text NOT NULL,
                         `posted_at` datetime NOT NULL
);

ALTER TABLE `post` ADD FOREIGN KEY (`board_id`) REFERENCES `board` (`id`);

ALTER TABLE `reply` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);
