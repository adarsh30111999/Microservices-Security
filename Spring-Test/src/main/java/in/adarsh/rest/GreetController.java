package in.adarsh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.adarsh.service.GreetService;

@RestController
public class GreetController {

	@Autowired
	private GreetService service;

	@GetMapping("/greet")
	public ResponseEntity<String> getGreet(@RequestParam("name") String name) {
		String response = service.greet(name);
		return ResponseEntity.ok(response);
	}

}
