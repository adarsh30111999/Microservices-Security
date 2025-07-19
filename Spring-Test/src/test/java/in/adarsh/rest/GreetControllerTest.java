package in.adarsh.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import in.adarsh.service.GreetService;

@WebMvcTest(GreetController.class)
public class GreetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GreetService greetService;

	@Test
	public void testGreet() throws Exception {
		when(greetService.greet("Avinash")).thenReturn("Hello, Avinash");
		mockMvc.perform(get("/greet").param("name", "Avinash")).andExpect(status().isOk())
				.andExpect(content().string("Hello, Avinash"));
	}

}
