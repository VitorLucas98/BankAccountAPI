CREATE TABLE tipo_conta (
    id INT GENERATED BY DEFAULT AS IDENTITY,
    descricao VARCHAR(50) NOT NULL,
    CONSTRAINT id_tipo_conta_pk PRIMARY KEY (id)
 );


