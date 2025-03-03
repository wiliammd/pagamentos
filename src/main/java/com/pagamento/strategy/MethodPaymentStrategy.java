package com.pagamento.strategy;

import com.pagamento.dto.PaymentDto;

/**
 * interface Strategy metodo de pagamento.
 */
public interface MethodPaymentStrategy {

    void processarPagamento(PaymentDto paymentDto);
}
