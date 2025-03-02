package com.pagamento.exception;

public class PaymentNotFoundException extends  RuntimeException{

    public PaymentNotFoundException(final String message) {
        super(message);
    }
}
