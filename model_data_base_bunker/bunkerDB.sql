-- MySQL Script generated by MySQL Workbench
-- Thu Oct 15 18:14:47 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema theBunkerDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema theBunkerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `theBunkerDB` DEFAULT CHARACTER SET utf8 ;
USE `theBunkerDB` ;

-- -----------------------------------------------------
-- Table `theBunkerDB`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Person` (
  `perIdPerson` INT NOT NULL AUTO_INCREMENT,
  `perName` VARCHAR(20) NULL,
  `perLastName` VARCHAR(25) NULL,
  `perGender` VARCHAR(10) NULL,
  `perDocumentType` VARCHAR(23) NULL,
  `perDocumentNumber` VARCHAR(10) NULL,
  `perEmail` VARCHAR(45) NULL,
  `perLogin` VARCHAR(10) NULL,
  `perPassword` VARCHAR(100) NULL,
  PRIMARY KEY (`perIdPerson`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Employee` (
  `empIdEmployee` INT NOT NULL,
  `empEmployeeType` VARCHAR(15) NULL,
  `empState` VARCHAR(15) NULL,
  PRIMARY KEY (`empIdEmployee`),
  CONSTRAINT `fkPersonEmployee`
    FOREIGN KEY (`empIdEmployee`)
    REFERENCES `theBunkerDB`.`Person` (`perIdPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Client` (
  `cliIdClient` INT NOT NULL,
  `cliNote` VARCHAR(45) NULL,
  PRIMARY KEY (`cliIdClient`),
  CONSTRAINT `fkPersonClient`
    FOREIGN KEY (`cliIdClient`)
    REFERENCES `theBunkerDB`.`Person` (`perIdPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Category` (
  `catIdCategory` INT NOT NULL AUTO_INCREMENT,
  `catCategoryName` VARCHAR(45) NULL,
  `catCategoryDescription` VARCHAR(100) NULL,
  PRIMARY KEY (`catIdCategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Dish` (
  `disIdDish` INT NOT NULL AUTO_INCREMENT,
  `disIdCategory` INT NOT NULL,
  `disDishName` VARCHAR(45) NULL,
  `disDishPrice` DOUBLE(10,2) NULL,
  `disPhoto` VARCHAR(90) NULL,
  PRIMARY KEY (`disIdDish`),
  INDEX `fkCategoryDish_idx` (`disIdCategory` ASC),
  CONSTRAINT `fkCategoryDish`
    FOREIGN KEY (`disIdCategory`)
    REFERENCES `theBunkerDB`.`Category` (`catIdCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Order` (
  `ordIdOrder` INT NOT NULL AUTO_INCREMENT,
  `ordIdPerson` INT NOT NULL,
  `ordIdEmployee` INT NULL,
  `ordDateOrder` DATE NULL,
  `ordIvaOrder` DOUBLE(2,1) NULL,
  `ordTotalOrder` DOUBLE(10,2) NULL,
  `ordStateOrder` VARCHAR(15) NULL,
  PRIMARY KEY (`ordIdOrder`),
  INDEX `fkPersonOrder_idx` (`ordIdPerson` ASC),
  INDEX `fkEmployeeOrder_idx` (`ordIdEmployee` ASC),
  CONSTRAINT `fkPersonOrder`
    FOREIGN KEY (`ordIdPerson`)
    REFERENCES `theBunkerDB`.`Person` (`perIdPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkEmployeeOrder`
    FOREIGN KEY (`ordIdEmployee`)
    REFERENCES `theBunkerDB`.`Employee` (`empIdEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Charge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Charge` (
  `chaIdCharge` INT NOT NULL AUTO_INCREMENT,
  `chaIdOrder` INT NOT NULL,
  `chaIdDish` INT NOT NULL,
  `chaQuantityDish` INT NULL,
  `chaSalePriceDIsh` DOUBLE(10,2) NULL,
  PRIMARY KEY (`chaIdCharge`),
  INDEX `fkDishCharge_idx` (`chaIdDish` ASC),
  INDEX `fkOderCharge_idx` (`chaIdOrder` ASC),
  CONSTRAINT `fkDishCharge`
    FOREIGN KEY (`chaIdDish`)
    REFERENCES `theBunkerDB`.`Dish` (`disIdDish`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkOderCharge`
    FOREIGN KEY (`chaIdOrder`)
    REFERENCES `theBunkerDB`.`Order` (`ordIdOrder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `theBunkerDB`.`Session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `theBunkerDB`.`Session` (
  `sesIdSession` INT NOT NULL AUTO_INCREMENT,
  `sesIdPersona` INT NULL,
  `sesDateLogin` DATE NULL,
  PRIMARY KEY (`sesIdSession`),
  INDEX `fkPersonSession_idx` (`sesIdPersona` ASC),
  CONSTRAINT `fkPersonSession`
    FOREIGN KEY (`sesIdPersona`)
    REFERENCES `theBunkerDB`.`Person` (`perIdPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;