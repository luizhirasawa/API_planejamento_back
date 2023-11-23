CREATE TABLE insumos (
id bigserial not NULL,
codigo varchar(10) not null,
nome varchar(50) not null,
descricao varchar(100) not null,
principio_ativo varchar(50) not null,
grupo varchar(20) not null, 
subclasse varchar (20) not null,
fabricante varchar(30) not null,
preco numeric(19, 4) not null,
unidade varchar(4) not null,

primary key (id)
);

CREATE TABLE cultura (
id bigserial not NULL,
nome varchar(50) not null,
preco_venda numeric(19, 4) not null,
embalagem_venda varchar(20) not null,

primary key(id)
);

CREATE TABLE tipo (
id bigserial not NULL,
codigo varchar(10) not null,
nome_etapa varchar(50) not null,
numero_dias int not null, 
unidade varchar(4) not null,
quantidade_ha numeric(19, 4) not null,
id_insumo bigint not null,

primary key(id, codigo),
foreign key (id_insumo) references insumos(id)
);

CREATE TABLE planejamento (
id bigserial not NULL,
area_plantio int not null,
nome_etapa varchar(50) not null,
data_comeco varchar (15) not null,
data_colheita varchar (15) not null,
id_cultura_anterior bigint not null,
id_cultura bigint not null,
tipo jsonb,

primary key(id),
foreign key (id_cultura_anterior) references cultura(id),
foreign key (id_cultura) references cultura(id)
);

CREATE TABLE plantio (
id bigserial not NULL,
nome varchar(50) not null,
id_cultura_anterior bigint not null,
id_planejamento bigint not null,

primary key (id),
foreign key (id_cultura_anterior) references cultura(id),
foreign key (id_planejamento) references planejamento(id)
);

