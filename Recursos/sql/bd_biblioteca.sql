-- MySQL Script generated by MySQL Workbench
-- Wed May 24 09:33:15 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_gestionLibros
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_gestionLibros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_gestionLibros` DEFAULT CHARACTER SET utf8 ;
USE `bd_gestionLibros` ;

-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `rol_nombre` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_rol`),
  UNIQUE INDEX `id_rol_UNIQUE` (`id_rol` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `numero_documento` VARCHAR(10) NOT NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `apellido_usuario` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `contrasena` VARCHAR(30) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `fecha_creacion` VARCHAR(20) NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE,
  UNIQUE INDEX `numero_documento_UNIQUE` (`numero_documento` ASC) VISIBLE,
  INDEX `fk_usuario_rol1_idx` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol1`
    FOREIGN KEY (`rol_id`)
    REFERENCES `bd_gestionLibros`.`rol` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`pais` (
  `id_pais` INT NOT NULL AUTO_INCREMENT,
  `nombre_pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pais`),
  UNIQUE INDEX `id_pais_UNIQUE` (`id_pais` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre_autor` VARCHAR(50) NOT NULL,
  `apellido_autor` VARCHAR(50) NOT NULL,
  `fecha_nacimiento` VARCHAR(20) NOT NULL,
  `pais_id` INT NOT NULL,
  PRIMARY KEY (`id_autor`),
  UNIQUE INDEX `id_autor_UNIQUE` (`id_autor` ASC) VISIBLE,
  INDEX `fk_autor_pais_idx` (`pais_id` ASC) VISIBLE,
  CONSTRAINT `fk_autor_pais`
    FOREIGN KEY (`pais_id`)
    REFERENCES `bd_gestionLibros`.`pais` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`editorial` (
  `id_editorial` INT NOT NULL AUTO_INCREMENT,
  `nombre_editorial` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_editorial`),
  UNIQUE INDEX `id_editorial_UNIQUE` (`id_editorial` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`genero_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`genero_libro` (
  `id_genero` INT NOT NULL AUTO_INCREMENT,
  `nombre_genero` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id_genero`),
  UNIQUE INDEX `id_genero_UNIQUE` (`id_genero` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `nombre_libro` VARCHAR(60) NOT NULL,
  `autor_id` INT NOT NULL,
  `editorial_id` INT NOT NULL,
  `genero_id` INT NOT NULL,
  `anio_publicacion` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_libro`),
  UNIQUE INDEX `id_libro_UNIQUE` (`id_libro` ASC) VISIBLE,
  INDEX `fk_libro_autor1_idx` (`autor_id` ASC) VISIBLE,
  INDEX `fk_libro_editorial1_idx` (`editorial_id` ASC) VISIBLE,
  INDEX `fk_libro_genero_libro1_idx` (`genero_id` ASC) VISIBLE,
  CONSTRAINT `fk_libro_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `bd_gestionLibros`.`autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_editorial1`
    FOREIGN KEY (`editorial_id`)
    REFERENCES `bd_gestionLibros`.`editorial` (`id_editorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_genero_libro1`
    FOREIGN KEY (`genero_id`)
    REFERENCES `bd_gestionLibros`.`genero_libro` (`id_genero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`estado` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE INDEX `id_estado_UNIQUE` (`id_estado` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_gestionLibros`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_gestionLibros`.`prestamo` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_prestamo` VARCHAR(30) NOT NULL,
  `fecha_entrega` VARCHAR(30) NOT NULL,
  `usuario_id` INT NOT NULL,
  `libro_id` INT NOT NULL,
  `estado_id` INT NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  UNIQUE INDEX `id_prestamo_UNIQUE` (`id_prestamo` ASC) VISIBLE,
  INDEX `fk_prestamo_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_prestamo_libro1_idx` (`libro_id` ASC) VISIBLE,
  INDEX `fk_prestamo_estado1_idx` (`estado_id` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `bd_gestionLibros`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_libro1`
    FOREIGN KEY (`libro_id`)
    REFERENCES `bd_gestionLibros`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_estado1`
    FOREIGN KEY (`estado_id`)
    REFERENCES `bd_gestionLibros`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
