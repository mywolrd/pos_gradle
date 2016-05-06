create table pos.item (
    id    serial    primary key,
    name  varchar(50)    null,
    type  varchar(50)    not null,
    dollar    smallint,
    cent    smallint,
    active    boolean
);

grant select, insert, delete, update on pos.item to pos;
