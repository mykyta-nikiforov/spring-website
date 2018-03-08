#------------- Create roles
INSERT INTO `role` (`role`) VALUES ('ADMIN');
INSERT INTO `role` (`role`) VALUES ('TEACHER');
INSERT INTO `role` (`role`) VALUES ('STUDENT');

#------------- Create degrees
INSERT INTO `degree` (`name`) VALUES ('Професор');
INSERT INTO `degree` (`name`) VALUES ('Доцент');
INSERT INTO `degree` (`name`) VALUES ('Кандидат наук');

#------------- Create teachers
INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('romaka@ukr.net', '$2y$10$fH.l1DDY9VuZsBGYBm1g2.xBIjPpfOCmKhIBr6fEgj1YVRwXZAeKm', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('1', 'Ромака', 'Володимир', 'Афанасійович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('otenko@gmail.com', '$2y$10$koWxtsCMpz7ENQyn.9SfXeqa5RdhExxgd5tj2dttM16n3rMKyQrUa', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('2', 'Отенко', 'Віктор', 'Романович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('marchuk@i.ua', '$2y$10$SFilLsRrD4OLWNzfm3NEY.KpKunoajVa3mKrJrNxWf1WsBjMB6uKe', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('3', 'Марчук', 'Михайло', 'Володимирович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('3', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('bereziuk@ukr.net', '$2y$10$.5csDZChN/0XLf59uRr/5ODmYCgQDA2/kVoG5YuilfuGxV6rnfMG2', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('4', 'Березюк', 'Богдан', 'Михайлович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('4', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('shandra@ukr.net', '$2y$10$6IxJCXqrj3juFfiWOe.U8OsRUAK.0M1AXuA9pWG0iJhlkIS0U6v5i', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('5', 'Шандра', 'Зеновій', 'Антонович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('5', '2');

#------------- Create groups
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('УІ-41', '4', '5');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('КБ-11', '1', '3');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('ЗІ-42', '4', '2');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('ЗІ-31', '3', '4');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('КБУІ-21', '2', '1');

#------------- Create students
INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('nikiforovpizza@gmail.com', '$2y$10$2lKKDNZhegw2nrYNqtC.zeQXJzqYrL428qViG10DhZHbK1L61wMee', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('6', 'Нікіфоров', 'Микита', 'Андрійович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('6', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('artsyvak@gmail.com', '$2y$10$Hfn/2cU92UU42OLXK4Yry.FGM9uVBduKDpjl5q7Vw6Z960zwsVHYi', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('7', 'Сивак', 'Артем', 'Володимирович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('7', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('datsiv@gmail.com', '$2y$10$efPMpUxMh9WuMmeFtWQxuOj6B8x3zdmL5RE1dhkhsDB46ZQR/0cwS', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('8', 'Даців', 'Святослав', 'Романович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('8', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('bap07@gmail.com', '$2y$10$WSzkiMiH2G0N2otB4BAeeOTdckbr.yu47cb6Q0i2bchiUoatxQ1mK', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('9', 'Бап', 'Антоніна', 'Андріївна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('9', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('klivarsvit@gmail.com', '$2y$10$8d0UEcOwLc8mqn.NQcLqR.RjiUOevqI0MyZVXVeTVhBYgsf1dglQO', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('10', 'Климарчук', 'Світлана', 'Петрівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('10', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('opolskyi97@gmail.com', '$2y$10$In1fqHHz6kUibZPUBtY6keuNYdUQnCjurZQNZ5W7b8hGei8WVj0iK', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('11', 'Опольський', 'Сергій', 'Ігорович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('11', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('naboka@gmail.com', '$2y$10$NT4xeN4H2zYg9gNjaGWrU.os3wmuk55AyIZaG5VVLQvczeJQDweWS', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('12', 'Набока', 'Вікторія', 'Володимирівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('12', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('novruzova@gmail.com', '$2y$10$JNVO32kPzBIM.tIzomMfPuQwo5q8uCz284eey/2kLTmzlh98eahI6', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('13', 'Новрузова', 'Катерина', 'Дмитрівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('13', '3');