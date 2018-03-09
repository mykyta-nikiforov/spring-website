#------------- Create roles
INSERT INTO `role` (`role`) VALUES ('ADMIN');
INSERT INTO `role` (`role`) VALUES ('TEACHER');
INSERT INTO `role` (`role`) VALUES ('STUDENT');

#------------- Create degrees
INSERT INTO `degree` (`name`) VALUES ('Професор');
INSERT INTO `degree` (`name`) VALUES ('Доцент');
INSERT INTO `degree` (`name`) VALUES ('Кандидат наук');

#------------- Create teachers
INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('romaka@ukr.net', '$2a$10$BiLVI1THGI4MUU5VzEB.5.GiOi3d58ctE23rWJAnhrok16sTTDtCe', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('1', 'Ромака', 'Володимир', 'Афанасійович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('otenko@gmail.com', '$2a$10$WXxNQqi0MENHTuxk509T2OceMiiIZpGKqw/a/mIIviwqXAHp8k0WO', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('2', 'Отенко', 'Віктор', 'Романович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('marchuk@i.ua', '$2a$10$VO7jPPbYvX3/NiWsL8K/3.Fifw0QJ5M.BKnkvkpedcNcgVQV6ZeZW', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('3', 'Марчук', 'Михайло', 'Володимирович', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('3', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('bereziuk@ukr.net', '$2a$10$aJRGJSFj29gZp9TMPj8uYuMch2JTaISso2.VYnZUiTUgHUZ7fXq4q', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('4', 'Березюк', 'Богдан', 'Михайлович', '3');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('4', '2');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('shandra@ukr.net', '$2a$10$WGGFq/bIi9ITYInPreDINeIP7IaqU2qustzD58MbEMmQJW7GTHUC.', b'1', b'1', b'1', b'1');
INSERT INTO `teacher` (`id`, `surname`, `name`, `patronymic`, `degree_id`) VALUES ('5', 'Шандра', 'Зеновій', 'Антонович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('5', '2');

#------------- Create groups
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('УІ-41', '4', '5');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('КБ-11', '1', '3');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('ЗІ-42', '4', '2');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('ЗІ-31', '3', '4');
INSERT INTO `groupp` (`number`, `year_of_study`, `curator_id`) VALUES ('КБУІ-21', '2', '1');

#------------- Create students
INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('nikiforovpizza@gmail.com', '$2a$10$47C9wWuj4WRM2ZBWo1PwceK4n8FdUSMHjiS/qfA./MXgotNy5aw/q', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('6', 'Нікіфоров', 'Микита', 'Андрійович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('6', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('artsyvak@gmail.com', '$2a$10$7tZNm1XSgnuPYRX3mKlKA.UxZvTTMJ9t6IewfCR3klr9mGc8J7MSy', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('7', 'Сивак', 'Артем', 'Володимирович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('7', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('datsiv@gmail.com', '$2a$10$loay1A5mGSwCJLd9j/NqMevbRkuN0mvEFZFArS4DX72hQtSQ7Ur0y', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('8', 'Даців', 'Святослав', 'Романович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('8', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('bap07@gmail.com', '$2a$10$FlzNwjTdHDM4ALBFCFGtg.hlHd4cI6HiZYwd00VvrRiqN9pF6axC6', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('9', 'Бап', 'Антоніна', 'Андріївна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('9', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('klivarsvit@gmail.com', '$2a$10$2FopCgtvHWphOh3vBFmdWeucs5rJRhAqg9MSL/DVmoi1qJps.eYvy', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('10', 'Климарчук', 'Світлана', 'Петрівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('10', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('opolskyi97@gmail.com', '$2a$10$lsWqMDkOIckw/obAmw64ruZYW78rvqBRGNvcmmif3RLL8GNqel4.G', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('11', 'Опольський', 'Сергій', 'Ігорович', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('11', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('naboka@gmail.com', '$2a$10$0FrJKtoAvvfUgRL17NoZXOdxMKwFx46QzwNt1dgyGflTt0v6ZAL/W', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('12', 'Набока', 'Вікторія', 'Володимирівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('12', '3');

INSERT INTO `user` (`email`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES ('novruzova@gmail.com', '$2a$10$bbyd7WNrV27cW0vvgi3aGuiia8pPagHIpkL5SBpVb3gxwy2Vu59w.', b'1', b'1', b'1', b'1');
INSERT INTO `student` (`id`, `surname`, `name`, `patronymic`, `group_id`) VALUES ('13', 'Новрузова', 'Катерина', 'Дмитрівна', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('13', '3');

#------------- Create courses
#------------------ Основи інформаційної безпеки
INSERT INTO `course` (`name`, `description`) VALUES ('Основи інформаційної безпеки', "Курс має на меті навчити студента: знати роль і місце захисту інформації в загальній структурі національної безпеки; терміни і визначення в галузі інформаційної безпеки; методологію формування множини загроз інформації; канали несанкціонованого доступу до інформації; уміти формувати перелік заходів для запобігання витоку інформації; формувати множину загроз інформації; визначати показники стійкості систем захисту інформації.");
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Історія комп'ютерних вірусів", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Основні види шкідливого програмного забезпечення", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Сучасні загрози інформаційної безпеки", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Загрози для мобільних пристроїв", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Антивіруси: технології, індустрія, практичне застосування", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Безпека електронних фінансів", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Принципи поводження з персональною інформацією", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Принципи безпечної роботи з мобільними пристроями", 1);
INSERT INTO `lecture` (`name`, `course_id`) VALUES ("Безпека в умовах інформаційної війни та кібервійни", 1);