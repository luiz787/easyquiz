-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Jul-2017 às 07:13
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easyquiz`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `dificuldade`
--

CREATE TABLE `dificuldade` (
  `cod_dificuldade` bigint(20) NOT NULL,
  `des_dificuldade` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `cod_disciplina` bigint(20) UNSIGNED NOT NULL,
  `nom_disciplina` char(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `modulo`
--

CREATE TABLE `modulo` (
  `cod_disciplina` bigint(20) UNSIGNED NOT NULL,
  `cod_modulo` bigint(20) UNSIGNED NOT NULL,
  `nom_modulo` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

CREATE TABLE `perfil` (
  `cod_perfil` bigint(20) NOT NULL,
  `nom_perfil` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `post`
--

CREATE TABLE `post` (
  `cod_post` bigint(20) UNSIGNED NOT NULL,
  `cod_questao` bigint(20) UNSIGNED NOT NULL,
  `txt_conteudo` text NOT NULL,
  `dat_criacao` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questao`
--

CREATE TABLE `questao` (
  `cod_questao` bigint(20) UNSIGNED NOT NULL,
  `cod_dificuldade` bigint(20) NOT NULL,
  `cod_disciplina` bigint(20) UNSIGNED NOT NULL,
  `cod_modulo` bigint(20) UNSIGNED NOT NULL,
  `cod_tipo` char(1) NOT NULL,
  `txt_enunciado` text NOT NULL,
  `img_enunciado` blob,
  `seq_questao_correta` bigint(20) DEFAULT NULL,
  `txt_resposta_aberta` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questaofechadaresposta`
--

CREATE TABLE `questaofechadaresposta` (
  `dat_inicio` datetime NOT NULL,
  `cod_usuario` bigint(20) UNSIGNED NOT NULL,
  `cod_questao` bigint(20) UNSIGNED NOT NULL,
  `seq_questao_resposta` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questao_fechada`
--

CREATE TABLE `questao_fechada` (
  `cod_questao` bigint(20) UNSIGNED NOT NULL,
  `seq_alternativa` bigint(20) UNSIGNED NOT NULL,
  `txt_alternativa` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `sessao`
--

CREATE TABLE `sessao` (
  `cod_usuario` bigint(20) UNSIGNED NOT NULL,
  `dat_inicio` datetime NOT NULL,
  `dat_fim` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `cod_usuario` bigint(20) UNSIGNED NOT NULL,
  `cod_perfil` bigint(20) NOT NULL,
  `nom_usuario` char(40) NOT NULL,
  `dat_nascimento` date NOT NULL,
  `txt_email` char(40) NOT NULL,
  `txt_senha` char(100) NOT NULL,
  `txt_escolaridade` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dificuldade`
--
ALTER TABLE `dificuldade`
  ADD PRIMARY KEY (`cod_dificuldade`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`cod_disciplina`);

--
-- Indexes for table `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`cod_modulo`,`cod_disciplina`),
  ADD KEY `Relationship4` (`cod_disciplina`);

--
-- Indexes for table `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`cod_perfil`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`cod_post`),
  ADD KEY `IX_Relationship8` (`cod_questao`);

--
-- Indexes for table `questao`
--
ALTER TABLE `questao`
  ADD PRIMARY KEY (`cod_questao`),
  ADD KEY `IX_Relationship6` (`cod_dificuldade`),
  ADD KEY `IX_Relationship7` (`cod_modulo`,`cod_disciplina`);

--
-- Indexes for table `questaofechadaresposta`
--
ALTER TABLE `questaofechadaresposta`
  ADD PRIMARY KEY (`dat_inicio`,`cod_usuario`,`cod_questao`),
  ADD KEY `Relationship16` (`cod_questao`);

--
-- Indexes for table `questao_fechada`
--
ALTER TABLE `questao_fechada`
  ADD PRIMARY KEY (`cod_questao`,`seq_alternativa`);

--
-- Indexes for table `sessao`
--
ALTER TABLE `sessao`
  ADD PRIMARY KEY (`dat_inicio`,`cod_usuario`),
  ADD KEY `Relationship14` (`cod_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cod_usuario`),
  ADD UNIQUE KEY `txt_email` (`txt_email`),
  ADD KEY `IX_Relationship1` (`cod_perfil`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `cod_disciplina` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `modulo`
--
ALTER TABLE `modulo`
  MODIFY `cod_modulo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `cod_post` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `questao`
--
ALTER TABLE `questao`
  MODIFY `cod_questao` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `cod_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `modulo`
--
ALTER TABLE `modulo`
  ADD CONSTRAINT `Relationship4` FOREIGN KEY (`cod_disciplina`) REFERENCES `disciplina` (`cod_disciplina`);

--
-- Limitadores para a tabela `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `Relationship8` FOREIGN KEY (`cod_questao`) REFERENCES `questao` (`cod_questao`);

--
-- Limitadores para a tabela `questao`
--
ALTER TABLE `questao`
  ADD CONSTRAINT `Relationship6` FOREIGN KEY (`cod_dificuldade`) REFERENCES `dificuldade` (`cod_dificuldade`),
  ADD CONSTRAINT `Relationship7` FOREIGN KEY (`cod_modulo`,`cod_disciplina`) REFERENCES `modulo` (`cod_modulo`, `cod_disciplina`);

--
-- Limitadores para a tabela `questaofechadaresposta`
--
ALTER TABLE `questaofechadaresposta`
  ADD CONSTRAINT `Relationship15` FOREIGN KEY (`dat_inicio`,`cod_usuario`) REFERENCES `sessao` (`dat_inicio`, `cod_usuario`),
  ADD CONSTRAINT `Relationship16` FOREIGN KEY (`cod_questao`) REFERENCES `questao` (`cod_questao`);

--
-- Limitadores para a tabela `questao_fechada`
--
ALTER TABLE `questao_fechada`
  ADD CONSTRAINT `Relationship2` FOREIGN KEY (`cod_questao`) REFERENCES `questao` (`cod_questao`);

--
-- Limitadores para a tabela `sessao`
--
ALTER TABLE `sessao`
  ADD CONSTRAINT `Relationship14` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `Relationship1` FOREIGN KEY (`cod_perfil`) REFERENCES `perfil` (`cod_perfil`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
