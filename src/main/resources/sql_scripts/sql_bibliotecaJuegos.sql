DROP DATABASE IF EXISTS bibliotecaJuegos;
CREATE DATABASE bibliotecaJuegos;
USE bibliotecaJuegos;

CREATE TABLE Desarrollador (
id_desarrollador int not null auto_increment,
nombre varchar (25) not null,
num_juegos int,
primary key (id_desarrollador)
);

CREATE TABLE Genero (
id_genero int not null auto_increment,
nombre varchar (25) not null,
descripcion varchar (150), 
primary key (id_genero)
);

CREATE TABLE Juego (
 id_juego int not null auto_increment,
 nombre varchar (25) not null,
 id_desarrollador int,
 id_genero int,
 precio decimal (10),
 fecha_lanzamiento date,
 caratula blob,
 primary key (id_juego), 
 foreign key (id_desarrollador) references Desarrollador (id_desarrollador)
	on delete set null on update cascade,
foreign key (id_genero) references Genero (id_genero)
	on delete set null on update cascade
 );
 
insert into desarrollador (id_desarrollador, nombre) VALUES (1, 'aa');
insert into desarrollador (nombre, num_juegos) VALUES ('aa', 100);
insert into juego (id_juego, nombre) VALUES (1, 'aaa');
 
alter table Juego add creation_date date;
alter table Desarrollador add creation_date DATETIME DEFAULT CURRENT_TIMESTAMP;
alter table Genero add creation_date date;

select * from desarrollador;





