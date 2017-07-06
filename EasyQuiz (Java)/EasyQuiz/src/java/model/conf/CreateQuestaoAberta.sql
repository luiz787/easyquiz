DROP TABLE IF EXISTS questao_aberta CASCADE;

CREATE TABLE `questao_aberta` (
  `Id` int(11) NOT NULL PRIMARY KEY ,
  `Resposta` text NOT NULL
)