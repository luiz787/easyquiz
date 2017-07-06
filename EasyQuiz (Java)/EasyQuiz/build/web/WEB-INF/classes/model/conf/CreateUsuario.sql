DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE `usuario` (
    `Id` int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    `Nome` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `Data_Nascimento` date NOT NULL,
    `Email` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `Senha` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `Questoes_Respondidas` int,
    `Questoes_Acertadas` int
)