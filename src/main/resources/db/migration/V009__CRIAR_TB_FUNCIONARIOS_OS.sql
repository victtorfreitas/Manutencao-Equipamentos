CREATE TABLE TB_FUNCIONARIOS_OS
(
    ID_FUNCIONARIO   BIGINT(20) NOT NULL,
    ID_ORDEM_SERVICO BIGINT(20) NOT NULL,
    IS_ATIVO         BOOLEAN    NOT NULL,
    constraint TB_FUNCIONARIOS_OS_TB_FUNCIONARIO_ID_FK
        foreign key (ID_FUNCIONARIO) references TB_FUNCIONARIO on delete cascade,
    constraint TB_FUNCIONARIOS_OS_TB_ORDEM_SERVICO_ID_FK
        foreign key (ID_ORDEM_SERVICO) references TB_ORDEM_SERVICO on delete cascade
)
