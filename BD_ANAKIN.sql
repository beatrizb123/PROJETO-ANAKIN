create database anakinpj;

use anakinpj;

create table usuario(
    nome_usuario varchar(20) primary key not null,
    senha_usuario varchar(20) not null,
    filme_usuario varchar(100) not null
);

create table controle_sessao(
	id_sessao int auto_increment not null primary key,
	nome_sessao varchar(100) not null,
    anotacoes_sessao varchar(200),
    inventario_sessao varchar(200),
	id_usuario varchar(20),
    constraint fk_usuario foreign key(id_usuario) references usuario (nome_usuario)
);

create table dados(
	id_dados int primary key auto_increment,
    registro varchar(300),
    id_sessao int not null,
    foreign key (id_sessao) references controle_sessao (id_sessao)
);
create Table NumeroVereficador(
	id int Primary key auto_increment,
    usuario varchar(100),
	numero int not null
);

insert into numerovereficador (numero) values (0);

	create table CLASSE(
		ID_CLASSE int primary key auto_increment,
		Tipo_Classe varchar(15) not null,
		Talento_Padrão varchar(30) not null,
		Talento_Especial varchar(30) not null
	);

CREATE TABLE PROTAGONISTA (
		 id_Protagonista int primary key AUTO_INCREMENT,
		 nome_Protagonista varchar(100),
		 ocupacao_Protagonista varchar (50),
		 idade_Protagonista int,
		 altura_Protagonista float,
		 vida_Protagonista int,
		 defesa_Protagonista int,
		 magia_Protagonista int,
		 Poder int ,
		 Forca int,
		 Carisma int,
		 Agilidade int,
		 Intelecto int,	
		 id_SESSAO int,
		 id_CLASSE int,
         foreign key (id_SESSAO) references controle_sessao (id_sessao)
	);
    
	create table ALINHAMENTO(
		ID_ALINHAMENTO int primary key auto_increment,
		Tipo_Alinhamento varchar(10) not null,
		Talento_Padrão varchar(30) not null,
		Talento_Especial varchar(30)not null
	);
    
    	CREATE TABLE NPC(
		id_NPCS int primary key AUTO_INCREMENT,
		Nome_NPC varchar (100),
		Ocupacao_NPC varchar (50) ,
		Idade_NPC int,
		Altura_NPC float,
        Personalidade varchar(450),
		Vida_NPC int,
		Defesa_NPC int,
		Magia_NPC int,
		Poder int,
		Forca int,
		Carisma int ,
		Agilidade int,
		Intelecto int,
		Id_SESSAO int ,
		Id_ALINHAMENTO int,
		foreign key (Id_SESSAO) references controle_sessao(id_sessao)
	);
    
	create table COMBATE(
		ID_COMBATE int primary key auto_increment, 
		Ordem_Combate varchar(150),  
		Status_Combate char(1),
		ID_SESSAO  int,
		foreign key (ID_SESSAO) references Controle_Sessao (id_sessao)
	);

    
INSERT INTO Alinhamento (Tipo_Alinhamento, Talento_Padrão, Talento_Especial)
	values ('Bom', 'Esforço', 'Fascinar'),
		   ('Neutro', 'Estudo', 'Intuição'),
		   ('Mau', 'Algazarra', 'Sorte');


	insert into classe (Tipo_Classe, Talento_Especial, Talento_Padrão)
	values('Combatente', 'Lutar', 'Esforço'),
		  ('Feiticeiro', 'Magia', 'Estudo'),
		  ('Healer', 'Curar', 'Estudo'),
		  ('Suporte', 'Auxiliar', 'Esforço');
          
          
create table SessaoAcessada(
	idPorta int auto_increment primary key,
	id_sessao int,
	nome_sessao Varchar(150)
);
 
insert into SessaoAcessada(Id_sessao) value (1);
          
alter table npc
add column descriçao varchar(300);

create table protaOPEN(
ID_Porta int  primary key,
vereficador varchar(4)
);

create table NPC_OPEN(
ID_Porta int primary key,
vereficador varchar(4)
);

alter table protagonista 
add column DataEHoraDeCriacao datetime;


insert into protaOPEN(ID_Porta,vereficador) value (1,'open');
insert into NPC_OPEN(ID_Porta,vereficador) value (1,'open');
            
DELIMiTER $

create procedure apagarprotagonistaRecente()
begin
Declare idprotagonista int;

set idprotagonista = (select id_protagonista from protagonista order by DataEHoraDeCriacao desc limit 1 );
delete protagonista from protagonista where id_Protagonista = idprotagonista;
end$
DELIMITER ;
call apagarprotagonistaRecente();

Delimiter $ 
create Procedure apagarprotagonistaEspecifico (in nome varchar(200),in sessao int)
begin 
delete protagonista from protagonista where id_sessao = sessao and nome_protagonista  = nome;
end $
Delimiter ;
