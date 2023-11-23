drop table tipo;

alter table planejamento_etapa add column ativo boolean;
update planejamento_etapa set ativo = true;
alter table planejamento_etapa_insumo add column ativo boolean;
update planejamento_etapa_insumo set ativo = true;