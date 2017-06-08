DROP TABLE IF EXISTS post CASCADE;

CREATE TABLE `post` (
    `Id` int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    `Conteudo` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `Id_Autor` int NOT NULL,
    `Data_Criacao` date NOT NULL,
    `Id_Questao` int NOT NULL
)
