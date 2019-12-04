# --- !Ups

CREATE TABLE `TaskList` (
  `id` INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  `taskInfo` VARCHAR(30) NOT NULL
) Engine=Innodb;

INSERT INTO  `TaskList`(taskInfo) VALUES ('Comment 1');
INSERT INTO  `TaskList`(taskInfo) VALUES ('Comment 2');

# --- !Downs

drop table `TaskList` if exists;