package com.pagamento.service;

import com.pagamento.dto.PaymentDto;

import java.util.UUID;

/**
 * interface de service referente aos metodos de pagamento.
 */
public interface PaymentService {

    /**
     * metodo que registra o pagamento.
     * @param paymentDto dto com dados de pagamento.
     */
    PaymentDto registrarPagamento(PaymentDto paymentDto);


    /**
     * metodo que busca pagamento pelo id da transacao.
     * @param idTransacao registro da transacao
     * @return retorna PaymentDto.
     */
    PaymentDto retornaPagamento(UUID idTransacao);

    /**
     * metodo que processa transação.
     * @param  paymentDto dto com dados de pagamento.
     */
    void processarPagamento(PaymentDto paymentDto);
}
