package in.adarsh.service;

import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetService {

	public String greet(String name) {
		return "Hello, " + name;
	}

}
