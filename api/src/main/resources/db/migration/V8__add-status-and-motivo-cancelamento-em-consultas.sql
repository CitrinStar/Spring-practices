alter table consultas
    add column status varchar(255) default 'AGENDADA',
    add column motivo_cancelamento varchar(255);
update consultas set status = 'AGENDADA' where status is null;