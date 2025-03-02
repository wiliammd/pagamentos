package com.pagamento.event.consumer;

import com.pagamento.dto.PaymentDto;
import com.pagamento.service.PaymentService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentConsumer {

    private final PaymentService paymentService;

    @SqsListener("payment-queue")
    public void listen(PaymentDto paymentDto) {
        log.info("Transação recebida:{}", paymentDto.getTransacaoId());
        paymentService.processarTransacao(paymentDto);
        log.info("Transação atualizada:{} para status:{}", paymentDto.getTransacaoId(), paymentDto.getStatusPagamento());

    }
}
