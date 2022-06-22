
CREATE DATABASE bd_trabalho;

USE bd_trabalho;


CREATE TABLE piloto (
    idPiloto INT(3)NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomePiloto VARCHAR(30)NOT NULL

);


CREATE TABLE pista (

    idPista INT(3)NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomePista VARCHAR(30)NOT NULL

);

CREATE TABLE corrida(

    idCorrida INT(3)NOT NULL AUTO_INCREMENT PRIMARY KEY,
    qtdVotas INT(3)NOT NULL,
    melhorTempo FLOAT(20),
    posicao INT(3)NOT NULL,
    idPista int(3)NOT NULL ,
    idPiloto int(3)NOT NULL,
    FOREIGN KEY (idPista) REFERENCES pista(idPista),
    FOREIGN KEY (idPiloto) REFERENCES piloto(idPiloto)

);
