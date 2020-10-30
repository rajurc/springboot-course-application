#DDL 

CREATE SCHEMA `course_catalog` ;


CREATE TABLE `course_catalog`.`course` (
  `Id` INT(10) NOT NULL,
  `course_title` VARCHAR(45) NOT NULL,
  `course_desc` VARCHAR(300) NOT NULL,
  `price_strtgy` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE);
  
  ALTER TABLE `course_catalog`.`course` 
CHANGE COLUMN `Id` `Id` INT(10) NOT NULL AUTO_INCREMENT ;
  
  

CREATE TABLE `course_catalog`.`price` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT,
  `course_id` INT(10) NOT NULL,
  `country_code` VARCHAR(10) NOT NULL,
  `base_price` FLOAT NOT NULL,
  `tax` FLOAT NOT NULL,
  `addnl_chg` FLOAT NOT NULL,
  `conversion_fee` FLOAT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,
  INDEX `course_id_fk_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `CourseID_FK`
    FOREIGN KEY (`course_id`)
    REFERENCES `course_catalog`.`course` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

 #DML 
 
 INSERT INTO `course_catalog`.`course`(`course_title`,`course_desc`,`price_strtgy`)
VALUES('Science','Science Description','yearly');
 
 INSERT INTO `course_catalog`.`course`(`course_title`,`course_desc`,`price_strtgy`)
VALUES('Mathematics','Mathematics Description','Monthly subscription');
 
 
 INSERT INTO `course_catalog`.`course`(`course_title`,`course_desc`,`price_strtgy`)
VALUES('Biology','Biology Description','Paid subscription');

 
 


INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (1,'US', 100, 0.3, 0.01,1.0);

INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (1,'IND', 250 , 0.1, 0.0, 0.0);

 INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (2,'US', 150 , 0.3, 0.02, 1.0);
 
 INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (2,'IND', 180 , 0.1, 0.12, 0.0);
 
 
 INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (3,'IND', 80 , 0.1, 0.22, 0.0);
 
 INSERT INTO `course_catalog`.`price`
(`course_id`,`country_code`,`base_price`,`tax`,`addnl_chg`,`conversion_fee`)
VALUES (3,'US', 10 , 0.3, 0.12, 1.0);
 