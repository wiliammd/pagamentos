CREATE TABLE transacao (
    transacao_id BINARY(16) PRIMARY KEY,
    valor DECIMAL(10,2) NOT NULL,
    metodo_pagamento VARCHAR(25) NOT NULL,
    status_pagamento VARCHAR(25) NOT NULL,
    cliente_id BINARY(16) NOT NULL,
    data_hora_inclusao DATETIME NOT NULL,
    data_hora_atualizacao DATETIME
);