DROP TABLE IF EXISTS questao_fechada CASCADE;

CREATE TABLE `questao_fechada` (
  `Id` int(11) NOT NULL PRIMARY KEY ,
  `Alternativas` text NOT NULL,
  `Alternativa_Correta` int(1) NOT NULL
)

