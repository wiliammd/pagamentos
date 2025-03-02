package com.pagamento.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.payment.vars")
@Getter
@Setter
public class VarConfigs {

    private String url;
}
