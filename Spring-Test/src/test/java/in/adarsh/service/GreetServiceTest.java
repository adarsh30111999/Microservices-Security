package in.adarsh.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetServiceTest {

	private final GreetService service = new GreetService();

	@Test
	void testGreet() {

		String result = service.greet("Avinash");
		Assertions.assertEquals("Hello, Avinash", result);
	}

}
