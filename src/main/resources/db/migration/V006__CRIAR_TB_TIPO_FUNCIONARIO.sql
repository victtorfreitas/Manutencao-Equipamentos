CREATE TABLE TB_TIPO_FUNCIONARIO
(
    ID        BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    NOME      VARCHAR2(250) NOT NULL UNIQUE,
    DESCRICAO VARCHAR2(300),
    IS_ATIVO  BOOLEAN       NOT NULL
)
