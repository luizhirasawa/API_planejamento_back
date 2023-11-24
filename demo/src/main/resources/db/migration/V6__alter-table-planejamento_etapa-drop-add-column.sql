alter table planejamento_etapa drop column estado;

alter table planejamento_etapa add column estado varchar (15) not null;

alter table planejamento_etapa_insumo drop column unidade;

alter table planejamento_etapa_insumo add column unidade varchar (2) not null;

drop type status_etapa;
drop type unidade;