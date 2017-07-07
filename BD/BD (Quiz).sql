/*
Created: 22/06/2017
Modified: 06/07/2017
Project: Quiz
Model: EasyQuiz
Author: Luiz Augusto/Maria Carolina/Rafael Gontijo/Victor César/Victor Gabriel
Database: MySQL 5.6
*/


-- Create tables section -------------------------------------------------

-- Table Usuario

CREATE TABLE Usuario
(
  cod_usuario Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  cod_perfil Bigint NOT NULL,
  nom_usuario Char(40) NOT NULL,
  dat_nascimento Date NOT NULL,
  txt_email Char(40) NOT NULL,
  txt_senha Char(100) NOT NULL,
  PRIMARY KEY (cod_usuario)
)
;

CREATE INDEX IX_Relationship1 ON Usuario (cod_perfil)
;

ALTER TABLE Usuario ADD UNIQUE txt_email (txt_email)
;

-- Table Perfil

CREATE TABLE Perfil
(
  cod_perfil Bigint NOT NULL,
  nom_perfil Char(25) NOT NULL
)
;

ALTER TABLE Perfil ADD  PRIMARY KEY (cod_perfil)
;

-- Table Questao

CREATE TABLE Questao
(
  cod_questao Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  cod_dificuldade Bigint NOT NULL,
  cod_disciplina Bigint UNSIGNED NOT NULL,
  cod_modulo Bigint UNSIGNED NOT NULL,
  cod_tipo Char(1) NOT NULL,
  txt_enunciado Text NOT NULL,
  img_enunciado Blob,
  seq_questao_correta Bigint,
  txt_resposta_aberta Text,
  PRIMARY KEY (cod_questao)
)
;

CREATE INDEX IX_Relationship6 ON Questao (cod_dificuldade)
;

CREATE INDEX IX_Relationship7 ON Questao (cod_modulo,cod_disciplina)
;

-- Table Questao_Fechada

CREATE TABLE Questao_Fechada
(
  cod_questao Bigint UNSIGNED NOT NULL,
  seq_alternativa Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  txt_alternativa Text NOT NULL
)
;

ALTER TABLE Questao_Fechada ADD  PRIMARY KEY (cod_questao,seq_alternativa)
;

-- Table Disciplina

CREATE TABLE Disciplina
(
  cod_disciplina Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  nom_disciplina Char(40) NOT NULL,
  PRIMARY KEY (cod_disciplina)
)
;

-- Table Modulo

CREATE TABLE Modulo
(
  cod_disciplina Bigint UNSIGNED NOT NULL,
  cod_modulo Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  nom_modulo Char(50) NOT NULL,
  PRIMARY KEY (cod_modulo,cod_disciplina)
)
;

-- Table Dificuldade

CREATE TABLE Dificuldade
(
  cod_dificuldade Bigint NOT NULL,
  des_dificuldade Char(20) NOT NULL
)
;

ALTER TABLE Dificuldade ADD  PRIMARY KEY (cod_dificuldade)
;

-- Table Post

CREATE TABLE Post
(
  cod_post Bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  cod_questao Bigint UNSIGNED NOT NULL,
  txt_conteudo Text NOT NULL,
  dat_criacao Datetime NOT NULL,
  PRIMARY KEY (cod_post)
)
;

CREATE INDEX IX_Relationship8 ON Post (cod_questao)
;

-- Table Sessao

CREATE TABLE Sessao
(
  cod_usuario Bigint UNSIGNED NOT NULL,
  dat_inicio Datetime NOT NULL,
  dat_fim Datetime
)
;

ALTER TABLE Sessao ADD  PRIMARY KEY (dat_inicio,cod_usuario)
;

-- Table QuestaoFechadaResposta

CREATE TABLE QuestaoFechadaResposta
(
  dat_inicio Datetime NOT NULL,
  cod_usuario Bigint UNSIGNED NOT NULL,
  cod_questao Bigint UNSIGNED NOT NULL,
  seq_questao_resposta Bigint NOT NULL
)
;

ALTER TABLE QuestaoFechadaResposta ADD  PRIMARY KEY (dat_inicio,cod_usuario,cod_questao)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE Usuario ADD CONSTRAINT Relationship1 FOREIGN KEY (cod_perfil) REFERENCES Perfil (cod_perfil) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Questao_Fechada ADD CONSTRAINT Relationship2 FOREIGN KEY (cod_questao) REFERENCES Questao (cod_questao) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Modulo ADD CONSTRAINT Relationship4 FOREIGN KEY (cod_disciplina) REFERENCES Disciplina (cod_disciplina) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Questao ADD CONSTRAINT Relationship6 FOREIGN KEY (cod_dificuldade) REFERENCES Dificuldade (cod_dificuldade) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Questao ADD CONSTRAINT Relationship7 FOREIGN KEY (cod_modulo, cod_disciplina) REFERENCES Modulo (cod_modulo, cod_disciplina) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Post ADD CONSTRAINT Relationship8 FOREIGN KEY (cod_questao) REFERENCES Questao (cod_questao) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE Sessao ADD CONSTRAINT Relationship14 FOREIGN KEY (cod_usuario) REFERENCES Usuario (cod_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE QuestaoFechadaResposta ADD CONSTRAINT Relationship15 FOREIGN KEY (dat_inicio, cod_usuario) REFERENCES Sessao (dat_inicio, cod_usuario) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE QuestaoFechadaResposta ADD CONSTRAINT Relationship16 FOREIGN KEY (cod_questao) REFERENCES Questao (cod_questao) ON DELETE RESTRICT ON UPDATE RESTRICT
;

