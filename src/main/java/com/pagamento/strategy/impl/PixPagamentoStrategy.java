package com.pagamento.strategy.impl;

import com.pagamento.dto.PaymentDto;
import com.pagamento.service.PaymentService;
import com.pagamento.strategy.MethodPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PixPagamentoStrategy implements MethodPaymentStrategy {


    private final PaymentService paymentService;
    @Override
    public void processarPagamento(PaymentDto paymentDto) {
        //TODO regra pix
        paymentService.processarPagamento(paymentDto);
    }
}
