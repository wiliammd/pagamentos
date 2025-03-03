package com.pagamento;

import com.pagamento.config.TestSqsConfig;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@SpringBootTest(classes = TestSqsConfig.class)
class ApiApplicationTests {


//	@Mock
//	private SqsAsyncClient sqsAsyncClient;
//
//	@Mock
//	private SqsTemplate sqsTemplate;
//
//	@InjectMocks
//	private ApiApplication apiApplication;
	@Test
	void contextLoads() {
	}

}
