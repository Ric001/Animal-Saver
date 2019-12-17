CREATE DATABASE Animal_Saver_DB;
USE Animal_Saver_DB;

CREATE TABLE Rescued_Animals(
    AnimalID INTEGER PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(100),
    Saver VARCHAR(100),
    Species VARCHAR(100),
    SEX CHAR(1),
    SaveDate DATE, 
    DEATH DATE
);


SHOW TABLES;


