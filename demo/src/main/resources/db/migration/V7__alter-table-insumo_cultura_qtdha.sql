alter table insumo_cultura_qtdha drop column qtdha;

alter table insumo_cultura_qtdha add column quantidade_ha numeric(19, 4) not null;