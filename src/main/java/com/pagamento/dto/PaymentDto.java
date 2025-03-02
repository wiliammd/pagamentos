package com.pagamento.dto;

import com.pagamento.entity.PaymentEntity;
import com.pagamento.enums.MetodoPagamento;
import com.pagamento.enums.StatusPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Schema(name = "Classe dto referente objeto pagamento")
public class PaymentDto {

    @NotNull(message = "O valor do pagamento é obrigatório.")
    @Positive(message = "O valor do pagamento deve ser maior que zero.")
    @Schema(name = "valor", example = "10")
    private BigDecimal valor;
    @NotNull(message = "metodo de pagamento é obrigatório!")
    private MetodoPagamento metodoPagamento;
    @NotNull(message = "O ID do cliente é obrigatório.")
    @Schema(name = "clienteId", example = "f635af01-407f-4390-af26-9fbf62163229")
    private UUID clienteId;
    @NotNull(message = "O ID da transação é obrigatório.")
    @Schema(name = "transacaoId", example = "d76dd1c6-d977-412d-b1a0-418d937222ef")
    private UUID transacaoId;

    private StatusPagamento statusPagamento;

    public PaymentEntity toEntitySave() {
        return PaymentEntity.builder()
                .transacaoId(transacaoId)
                .clienteId(clienteId)
                .valor(valor)
                .dataHoraInclusao(LocalDateTime.now())
                .metodoPagamento(metodoPagamento)
                .statusPagamento(StatusPagamento.PENDENTE)
                .build();
    }
}
