create table equipamento(
    id bigint not null auto_increment,
    modelo varchar(100) not null,
    tipoEquipamento varchar(100) not null,
    fabricante varchar(100) not null,
    modalidade varchar(100) not null,
    numeroSerie varchar(100) not null unique,
    codigoEquipamento varchar(11) not null unique,
    datainstalacao date not null ,
    hora time not null,
    ativo varchar(20),


    primary key(id)

);