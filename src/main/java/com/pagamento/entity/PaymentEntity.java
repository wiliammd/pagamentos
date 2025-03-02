package com.pagamento.entity;

import com.pagamento.dto.PaymentDto;
import com.pagamento.enums.MetodoPagamento;
import com.pagamento.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "pagamentos")
public class PaymentEntity {

    @Id
    private UUID transacaoId;

    @Column(nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPagamento metodoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento statusPagamento;

    @Column(nullable = false)
    private UUID clienteId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataHoraInclusao;

    @Column
    private LocalDateTime dataHoraAtualizacao;

    public PaymentDto toDto() {
        return PaymentDto.builder()
                .transacaoId(transacaoId)
                .valor(valor)
                .metodoPagamento(metodoPagamento)
                .statusPagamento(statusPagamento)
                .clienteId(clienteId)
                .build();
    }
}
