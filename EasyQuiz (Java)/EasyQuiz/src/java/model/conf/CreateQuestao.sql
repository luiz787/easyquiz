DROP TABLE IF EXISTS questao CASCADE;

CREATE TABLE `questao` (
  `Id` int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  `Enunciado` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Imagem` blob,
  `Dificuldade` int(1) NOT NULL,
  `Disciplina` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Tipo` char(1) NOT NULL
)