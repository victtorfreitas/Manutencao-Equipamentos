CREATE TABLE TB_ENDERECO
(
    ID          BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    LOGRADOURO  VARCHAR2(100),
    NUMERO      VARCHAR2(30),
    COMPLEMENTO VARCHAR2(250),
    BAIRRO      VARCHAR2(150),
    CEP         VARCHAR2(8),
    CIDADE      VARCHAR2(150),
    ESTADO      VARCHAR2(30),
    ID_CLIENTE  BIGINT(20) NOT NULL,
    IS_ATIVO    BOOLEAN    NOT NULL,
    constraint TB_ENDERECO_TB_CLIENTE_ID_FK
        foreign key (ID_CLIENTE) references TB_CLIENTE on delete cascade
);

