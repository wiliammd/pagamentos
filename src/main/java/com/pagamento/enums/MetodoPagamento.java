package com.pagamento.enums;

public enum MetodoPagamento {
    CARTAO("Cartão de Crédito/Débito"),
    BOLETO("Boleto Bancário"),
    PIX("Pagamento via Pix");

    private final String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }
}