-- MySQL Script generated by MySQL Workbench
-- 02/23/16 11:18:03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tipo_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipo_cliente` (
  `cod_tip_cliente` INT NOT NULL,
  `pct_desc` DECIMAL NULL,
  PRIMARY KEY (`cod_tip_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(45) NULL,
  `cod_tip_cliente` INT NOT NULL,
  PRIMARY KEY (`id_cliente`, `cod_tip_cliente`),
  INDEX `fk_clientes_tipo_cliente1_idx` (`cod_tip_cliente` ASC),
  CONSTRAINT `fk_clientes_tipo_cliente1`
    FOREIGN KEY (`cod_tip_cliente`)
    REFERENCES `mydb`.`tipo_cliente` (`cod_tip_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`servicos` (
  `id_servico` INT NOT NULL AUTO_INCREMENT,
  `nome_servico` VARCHAR(45) NULL,
  `valor_servico` DECIMAL NULL,
  PRIMARY KEY (`id_servico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`clientes_servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientes_servicos` (
  `id_cliente_servico` INT NOT NULL AUTO_INCREMENT,
  `data_ini` DATETIME NULL,
  `data_fim` DATETIME NULL,
  `data_pagamento` DATETIME NULL,
  `id_cliente` INT NOT NULL,
  `id_servico` INT NOT NULL,
  PRIMARY KEY (`id_cliente_servico`),
  INDEX `fk_clientes_servicos_clientes1_idx` (`id_cliente` ASC),
  INDEX `fk_clientes_servicos_servicos1_idx` (`id_servico` ASC),
  CONSTRAINT `fk_clientes_servicos_clientes1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `mydb`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_servicos_servicos1`
    FOREIGN KEY (`id_servico`)
    REFERENCES `mydb`.`servicos` (`id_servico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
