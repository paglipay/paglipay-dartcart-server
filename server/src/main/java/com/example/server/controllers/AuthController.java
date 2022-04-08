package com.example.server.controllers;

import com.example.server.models.User;
import com.example.server.models.UserLogin;

import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {


	// @Autowired
	// public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
	// 					  UserService userService, AuthService authService, EmailServiceImpl emailServiceImp,
	// 					  BCryptPasswordEncoder bCryptEncoder, ResetPasswordService resetPasswordService) {
	// 	super();
	// 	this.authenticationManager = authenticationManager;
	// 	this.jwtTokenUtil = jwtTokenUtil;
	// 	this.userService = userService;
	// 	this.authService = authService;
	// 	this.emailServiceImp = emailServiceImp;
	// 	this.bCryptEncoder = bCryptEncoder;
	// 	this.resetPasswordService = resetPasswordService;
	// }

	@GetMapping("/login")
	public ResponseEntity<String> login() {
	  return new ResponseEntity<String>("HI ", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLogin request) {

		User retUser = new User();
		retUser.setUsername(request.getUsername());
		retUser.setPassword(request.getPassword());

		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "jwtTokenUtil.generateAccessToken(user)")
					.body(retUser);
	}

	// @PostMapping("/login")
	// public ResponseEntity<User> login(@RequestBody UserLogin request) {
	// 	try {
	// 		Authentication authenticate = authenticationManager.authenticate(
	// 				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

	// 		User user = (User) authenticate.getPrincipal();
	// 		com.revature.models.User retUser = userService
	// 				.getUserByUsername(user.getUsername().toLowerCase(Locale.ROOT));
	// 		retUser.setPassword(null);

	// 		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
	// 				.body(retUser);
	// 	} catch (BadCredentialsException ex) {
	// 		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	// 	}
	// }
}
