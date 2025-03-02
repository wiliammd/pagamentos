package com.pagamento.event.producer;

import com.pagamento.config.VarConfigs;
import com.pagamento.entity.PaymentEntity;
import com.pagamento.enums.StatusPagamento;
import com.pagamento.exception.PaymentNotFoundException;
import com.pagamento.repository.PaymentRepository;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentProducer {

    private final SqsTemplate sqsTemplate;

    private final VarConfigs varConfigs;

    private final PaymentRepository paymentRepository;


    public void produzirMensagem(UUID paymentId) {
        Random random = new Random();
        StatusPagamento statusPagamento = random.nextDouble() < 0.65? StatusPagamento.APROVADO: StatusPagamento.RECUSADO;
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElseThrow(()-> new PaymentNotFoundException("transacao id nao encontrada"));
        paymentEntity.setStatusPagamento(statusPagamento);
        sqsTemplate.send(varConfigs.getUrl(), paymentEntity.toDto());
    }
}
