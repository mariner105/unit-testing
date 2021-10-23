package com.mariner105.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
// Specify which property file(s) to use for this test class
// They can be used to override other properties of the same names
// that are in the file
@TestPropertySource(locations={"classpath:test-configuration.yml"})
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
