create table unidade(
    id bigint not null auto_increment,
    unidade varchar(100) not null,
    cnpj varchar(14) not null unique,
    centrodecusto varchar(100) not null unique,
    modelo varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);