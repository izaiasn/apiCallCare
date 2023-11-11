create table chamados(
    idunidade bigint not null auto_increment,
    unidade varchar(100) not null,
    idpessoa bigint not null unique,
    nome varchar(100) not null,
    telefone varchar(100) not null,
    especialidade varchar(100) not null,
    idequipamento bigint not null unique,
    modelo varchar(100) not null,
    tipoequipamento varchar(100) not null,
    fabricante varchar(100) not null,
    modalidade varchar(100) not null,
    numeroserie varchar(100) not null unique,
    codigoequipamento varchar(100) not null unique,
    dataabertura date not null,
    horaioabertura time not null,
    datafechamento date not null,
    horaiofechamento time not null,
    ativo tinyint not null,

    primary key(idunidade)

);




