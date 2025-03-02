package com.pagamento.enums;

public enum StatusPagamento {
    PENDENTE("Pagamento pedente"),
    APROVADO("Pagamento aprovado"),
    RECUSADO("Pagamento recusado");

    private final String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }
}