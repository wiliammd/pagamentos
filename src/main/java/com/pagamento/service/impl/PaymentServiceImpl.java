package com.pagamento.service.impl;

import com.pagamento.dto.PaymentDto;
import com.pagamento.entity.PaymentEntity;
import com.pagamento.exception.PaymentNotFoundException;
import com.pagamento.repository.PaymentRepository;
import com.pagamento.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentDto registrarPagamento(PaymentDto paymentDto) {
        final PaymentEntity paymentEntity = paymentRepository.save(paymentDto.toEntitySave());
        log.info("Intenção de pagamento registrada: {}", paymentEntity.getTransacaoId());
        return paymentEntity.toDto();
    }

    @Override
    public PaymentDto retornaPagamento(final UUID idTransacao) {
        PaymentEntity paymentEntity = paymentRepository.findById(idTransacao).orElseThrow(
                () -> new PaymentNotFoundException("Pagamento não encontrado "));
        return paymentEntity.toDto();
    }

    @Override
    public void processarPagamento(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentDto.getTransacaoId()).orElseThrow(
                () -> new PaymentNotFoundException("Pagamento não encontrado "));
        //TODO qualquer outra regra que queria implementar
        paymentEntity.setStatusPagamento(paymentDto.getStatusPagamento());
        paymentEntity.setDataHoraAtualizacao(LocalDateTime.now());
        paymentRepository.save(paymentEntity);
        log.info("Pagamento de transacaoId:{} atualizado para status:{}", paymentEntity.getTransacaoId(), paymentEntity.getStatusPagamento().toString());
    }
}
