package com.nt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ConditionalOnProperty(
		name = "app.runner.enabled",
		havingValue = "true",
		matchIfMissing = true
)
class BootDataJpaProj17InteractingWithTwoDBsApplicationTests {

	@Test
	void contextLoads() {
	}

}
