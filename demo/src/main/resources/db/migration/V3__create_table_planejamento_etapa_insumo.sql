CREATE TABLE insumo_cultura_qtdha (
    id bigserial not NULL,
    qtdha numeric(19, 4) not null,
    id_cultura bigint not NULL,
    id_insumo bigint not NULL,

    primary key(id),
    foreign key(id_cultura) references cultura(id), 
    foreign key(id_insumo) references insumos(id)
);

CREATE TYPE status_etapa AS ENUM ('Aguardando', 'Execução', 'Concluída', 'Desconforme');
CREATE TYPE unidade AS ENUM ('KG', 'L');

CREATE TABLE planejamento_etapa(
    id bigserial not NULL,
    nome_etapa varchar(30) not NULL,
    numero_dias int not null, 
    estado status_etapa,
    id_planejamento bigint not NULL,

    primary key(id),
    foreign key (id_planejamento) references planejamento(id)
);

CREATE TABLE planejamento_etapa_insumo(
    id bigserial not NULL,
    unidade unidade,
    quantidade_ha numeric(19, 4) not null,
    planejamento_etapa_id bigint not NULL,
    id_cultura bigint not NULL,
    id_insumo bigint not null,

    primary key(id),
    
    foreign key(id_cultura) references cultura(id), 
    foreign key(id_insumo) references insumos(id),
    foreign key (planejamento_etapa_id) references planejamento_etapa(id)
);