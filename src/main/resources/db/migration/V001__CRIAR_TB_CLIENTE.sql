create table TB_CLIENTE
(
    ID       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME     VARCHAR2(250) not null,
    CPF      VARCHAR2(11)  not null,
    EMAIL    VARCHAR2(250),
    IS_ATIVO BOOLEAN       NOT NULL

);
