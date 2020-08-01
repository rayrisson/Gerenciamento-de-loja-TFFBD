
CREATE SCHEMA IF NOT EXISTS `bdLoja` DEFAULT CHARACTER SET utf8 ;
USE `bdLoja` ;

-- -----------------------------------------------------
-- Table `bdLoja`.`tbCategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbCategoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nomeCategoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdLoja`.`tbProduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbProduto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(45) NOT NULL,
  `precoProduto` DOUBLE NOT NULL,
  `qtdProduto` INT NOT NULL,
  `codigoBarrasProduto` VARCHAR(20) UNIQUE,
  `fkCategoria` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
  CONSTRAINT `fk_tbProduto_tbCategoria`
    FOREIGN KEY (`fkCategoria`)
    REFERENCES `bdLoja`.`tbCategoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdLoja`.`tbFormaPagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbFormaPagamento` (
  `idFormaPagamento` INT NOT NULL AUTO_INCREMENT,
  `nomeFP` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFormaPagamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdLoja`.`tbCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbCliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(15) NULL DEFAULT 0,
  `CPF` VARCHAR(14) UNIQUE,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdLoja`.`tbVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbVenda` (
  `idVenda` INT NOT NULL AUTO_INCREMENT,
  `dataVenda` DATETIME NOT NULL,
  `fkFP` INT NOT NULL,
  `fkCliente` INT NOT NULL,
  PRIMARY KEY (`idVenda`),
  CONSTRAINT `fk_tbVenda_tbFormaPagamento1`
    FOREIGN KEY (`fkFP`)
    REFERENCES `bdLoja`.`tbFormaPagamento` (`idFormaPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbVenda_tbCliente1`
    FOREIGN KEY (`fkCliente`)
    REFERENCES `bdLoja`.`tbCliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdLoja`.`tbItensDaVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdLoja`.`tbItensDaVenda` (
  `fkProduto` INT NOT NULL,
  `fkVenda` INT NOT NULL,
  `IVqtd` INT NOT NULL,
  PRIMARY KEY (`fkProduto`, `fkVenda`),
  CONSTRAINT `fk_tbItensDaVenda_tbProduto1`
    FOREIGN KEY (`fkProduto`)
    REFERENCES `bdLoja`.`tbProduto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbItensDaVenda_tbVenda1`
    FOREIGN KEY (`fkVenda`)
    REFERENCES `bdLoja`.`tbVenda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE VIEW A AS SELECT * FROM tbVenda INNER JOIN tbCliente WHERE fkCliente = idCliente;

CREATE VIEW B AS SELECT * FROM tbFormaPagamento INNER JOIN A WHERE fKFP = idFormapagamento;

CREATE VIEW C AS SELECT * FROM tbItensDaVenda INNER JOIN B WHERE fKVenda = idVenda;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
