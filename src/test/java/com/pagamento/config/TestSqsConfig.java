package com.pagamento.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@TestConfiguration
public class TestSqsConfig {

    @Bean
    public SqsAsyncClient mockSqsAsyncClient() {
        return Mockito.mock(SqsAsyncClient.class);
    }

    @Bean
    public SqsTemplate mockSqsTemplate() {
        return Mockito.mock(SqsTemplate.class);
    }
}
