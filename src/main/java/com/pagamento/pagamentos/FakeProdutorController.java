package com.pagamento.pagamentos;

import com.pagamento.event.producer.PaymentProducer;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtor")
@Tag(name = "FakeProducer", description = "Endpoint criado apenas para produzir mensagem fake pois console nao esta funcionando")
public class FakeProdutorController {

    private final PaymentProducer paymentProducer;

    @PutMapping("/produzir")
    public String produzirMensagem(@Parameter(name = "transacaoId", example = "d76dd1c6-d977-412d-b1a0-418d937222ef") @RequestParam UUID transacaoId) {
        paymentProducer.produzirMensagem(transacaoId);
        return "mensagem enviada";
    }
}
