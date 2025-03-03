package com.pagamento.api;

import com.pagamento.dto.PaymentDto;
import com.pagamento.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Tag(name = "Pagamentos", description = "API para gerenciamento de pagamentos")
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Cria um novo pagamento", description = "Endpoint para criar um pagamento")
    @PostMapping
    public ResponseEntity<PaymentDto> registrarPagamento(@RequestBody @Valid PaymentDto paymentDto) {
        return ResponseEntity.ok().body(paymentService.registrarPagamento(paymentDto));
    }

    @Operation(summary = "Consulta um pagamento", description = "Endpoint para buscar um pagamento pelo ID")
    @GetMapping("/{transacaoId}")
    public ResponseEntity<PaymentDto> getPayment(@Parameter(name = "transacaoId", example = "d76dd1c6-d977-412d-b1a0-418d937222ef") @PathVariable UUID transacaoId) {
        return ResponseEntity.ok().body(paymentService.retornaPagamento(transacaoId));
    }
}
