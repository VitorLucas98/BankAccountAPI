CREATE TABLE correntista (
    id INT GENERATED BY DEFAULT AS IDENTITY,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    CONSTRAINT id_correntista_pk PRIMARY KEY (id)
 );

