package com.pagamento.event.consumer;

import com.pagamento.dto.PaymentDto;
import com.pagamento.service.PaymentService;
import com.pagamento.strategy.MethodPaymentStrategy;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentConsumer {

    private MethodPaymentStrategy methodPaymentStrategy;

    private final PaymentService paymentService;

    @SqsListener("payment-queue")
    public void listen(PaymentDto paymentDto) {
        log.info("Transação recebida:{}", paymentDto.getTransacaoId());
        methodPaymentStrategy = paymentDto.getMetodoPagamento().getStrategy(paymentService);
        methodPaymentStrategy.processarPagamento(paymentDto);
        log.info("Transação atualizada:{} para status:{}", paymentDto.getTransacaoId(), paymentDto.getStatusPagamento());

    }
}
