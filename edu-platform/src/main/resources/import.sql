INSERT INTO `degree` (`name`) VALUES ('Професор');
INSERT INTO `degree` (`name`) VALUES ('Доцент');
INSERT INTO `degree` (`name`) VALUES ('Кандидат наук');

INSERT INTO `role` (`role`) VALUES ('ADMIN');
INSERT INTO `role` (`role`) VALUES ('TEACHER');
INSERT INTO `role` (`role`) VALUES ('STUDENT');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('romaka@ukr.net', '$2y$10$fH.l1DDY9VuZsBGYBm1g2.xBIjPpfOCmKhIBr6fEgj1YVRwXZAeKm', b'0', b'0', b'0', b'0');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('1', 'Ромака', 'Володимир', 'Афанасійович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('otenko@gmail.com', '$2y$10$koWxtsCMpz7ENQyn.9SfXeqa5RdhExxgd5tj2dttM16n3rMKyQrUa', b'0', b'0', b'0', b'0');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('2', 'Отенко', 'Віктор', 'Романович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('marchuk@i.ua', '$2y$10$SFilLsRrD4OLWNzfm3NEY.KpKunoajVa3mKrJrNxWf1WsBjMB6uKe', b'0', b'0', b'0', b'0');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('3', 'Марчук', 'Михайло', 'Володимирович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('3', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('bereziuk@ukr.net', '$2y$10$.5csDZChN/0XLf59uRr/5ODmYCgQDA2/kVoG5YuilfuGxV6rnfMG2', b'0', b'0', b'0', b'0');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('4', 'Березюк', 'Богдан', 'Михайлович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('4', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('shandra@ukr.net', '$2y$10$6IxJCXqrj3juFfiWOe.U8OsRUAK.0M1AXuA9pWG0iJhlkIS0U6v5i', b'0', b'0', b'0', b'0');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('5', 'Шандра', 'Зеновій', 'Антонович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('5', '2');