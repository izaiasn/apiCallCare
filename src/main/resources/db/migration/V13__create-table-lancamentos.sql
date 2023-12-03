create table lancamentos(
    idchamados bigint not null unique,
    lancamento varchar(500) not null,
    datalacamento date not null,
    horaiolacamento time not null,
    ativo tinyint not null,
    primary key(idchamados)

);