CREATE TABLE TB_ORDEM_SERVICO
(
    ID             BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    ID_EQUIPAMENTO BIGINT(20)    NOT NULL,
    ID_CLIENTE     BIGINT(20)    NOT NULL,
    DATA_INICIO    DATE          NOT NULL,
    DATA_FIM       DATE,
    STATUS         VARCHAR2(100) NOT NULL,
    IS_ATIVO       BOOLEAN       NOT NULL,
    constraint TB_ORDEM_SERVICO_TB_EQUIPAMENTO_ID_FK
        foreign key (ID_EQUIPAMENTO) references TB_EQUIPAMENTO on delete cascade,
    constraint TB_ORDEM_SERVICO_TB_CLIENTE_ID_FK
        foreign key (ID_CLIENTE) references TB_CLIENTE on delete cascade
)
