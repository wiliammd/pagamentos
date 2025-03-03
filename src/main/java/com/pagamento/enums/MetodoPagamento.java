package com.pagamento.enums;

import com.pagamento.service.PaymentService;
import com.pagamento.strategy.MethodPaymentStrategy;
import com.pagamento.strategy.impl.BoletoPagamentoStrategy;
import com.pagamento.strategy.impl.CartaoPagamentoStrategy;
import com.pagamento.strategy.impl.PixPagamentoStrategy;

public enum MetodoPagamento {
    CARTAO("Cartão de Crédito/Débito"),
    BOLETO("Boleto Bancário"),
    PIX("Pagamento via Pix");

    private final String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public MethodPaymentStrategy getStrategy(final PaymentService paymentService) {
        switch (this) {
            case CARTAO:
                return new CartaoPagamentoStrategy(paymentService);
            case BOLETO:
                return new BoletoPagamentoStrategy(paymentService);
            case PIX:
                return new PixPagamentoStrategy(paymentService);
            default:
                throw new IllegalArgumentException("Método de pagamento desconhecido");
        }
    }
}