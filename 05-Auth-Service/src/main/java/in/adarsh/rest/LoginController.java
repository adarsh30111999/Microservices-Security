package in.adarsh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.adarsh.Entity.CustomerEntity;
import in.adarsh.repo.CustomerRepo;
import in.adarsh.service.JwtService;

@RestController
@RequestMapping("/auth")
public class LoginController {
	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private PasswordEncoder pwdEncoder;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody CustomerEntity entity) {
		CustomerEntity entity2 = custRepo.findByEmail(entity.getEmail());
		if (entity2 == null) {
			String encodedPwd = pwdEncoder.encode(entity.getPassword());
			entity.setPassword(encodedPwd);
			custRepo.save(entity);
			return new ResponseEntity<>("User Registered", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Already Available", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody CustomerEntity entity) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(entity.getEmail(),
				entity.getPassword());
		Authentication authenticate = authManager.authenticate(token);
		if (authenticate.isAuthenticated()) {
			String jwtToken = jwtService.generateToken(entity.getEmail());
			return new ResponseEntity<>(jwtToken, HttpStatus.OK);
		}
		return new ResponseEntity<>("Bad Credentials", HttpStatus.BAD_REQUEST);
	}

}
