-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.26-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para hconfortsystem
CREATE DATABASE IF NOT EXISTS `hconfortsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hconfortsystem`;


-- Copiando estrutura para tabela hconfortsystem.administrador
CREATE TABLE IF NOT EXISTS `administrador` (
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.controladministrador
CREATE TABLE IF NOT EXISTS `controladministrador` (
  `efetuarLogin` varchar(50) NOT NULL,
  `cadastrarGerente` varchar(50) NOT NULL,
  `gerarRelatorios` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.controlgerente
CREATE TABLE IF NOT EXISTS `controlgerente` (
  `efetuarLogin` varchar(50) NOT NULL,
  `cadastrarRecepcionista` varchar(50) NOT NULL,
  `cadastrarServico` varchar(50) NOT NULL,
  `cadastrarQuarto` varchar(50) NOT NULL,
  `consultarRecepcionista` varchar(50) NOT NULL,
  `excluirAlterarReserva` varchar(50) NOT NULL,
  `cadastrarQuartoPromocao` varchar(50) NOT NULL,
  `gerarRelatorios` varchar(50) NOT NULL,
  `listarQuartosUsados` varchar(50) NOT NULL,
  `excluirHospede` varchar(50) NOT NULL,
  `alterarHospede` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.controlhospede
CREATE TABLE IF NOT EXISTS `controlhospede` (
  `efetuarLogin` varchar(50) NOT NULL,
  `solicitarServico` varchar(50) NOT NULL,
  `consultarPromocoesReservas` varchar(50) NOT NULL,
  `listarPromocoes` varchar(50) NOT NULL,
  `alugarPromocoes` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.controlrecepcionista
CREATE TABLE IF NOT EXISTS `controlrecepcionista` (
  `efetuarLogin` varchar(50) NOT NULL,
  `cadastrarHospede` varchar(50) NOT NULL,
  `consultarHospede` varchar(50) NOT NULL,
  `consultarQuarto` varchar(50) NOT NULL,
  `realizarReserva` varchar(50) NOT NULL,
  `consultarReserva` varchar(50) NOT NULL,
  `fecharEstadia` varchar(50) NOT NULL,
  `calcularGastoEstagia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.gerente
CREATE TABLE IF NOT EXISTS `gerente` (
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.hospede
CREATE TABLE IF NOT EXISTS `hospede` (
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `RG` varchar(14) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` int(11) NOT NULL,
  `horario` time NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela hconfortsystem.recepcionista
CREATE TABLE IF NOT EXISTS `recepcionista` (
  `nome` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `RG` varchar(14) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` int(11) NOT NULL,
  `horario` time NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` int(11) NOT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
