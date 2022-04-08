package com.example.server.controllers;

import com.example.server.models.UserLogin;
import com.example.server.services.AuthService;
import com.example.server.services.UserService;
import com.example.server.utilities.JwtTokenUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserService userService;
  private final AuthService authService;

  // private final ResetPasswordService resetPasswordService;
  // private final EmailServiceImpl emailServiceImp;
  private final BCryptPasswordEncoder bCryptEncoder;

  @Autowired
  public AuthController(
    AuthenticationManager authenticationManager,
    JwtTokenUtil jwtTokenUtil,
    UserService userService,
    AuthService authService,
    //   EmailServiceImpl emailServiceImp
    BCryptPasswordEncoder bCryptEncoder
    // ResetPasswordService resetPasswordService
  ) {
    super();
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userService = userService;
    this.authService = authService;
    // this.emailServiceImp = emailServiceImp;
    this.bCryptEncoder = bCryptEncoder;
    // this.resetPasswordService = resetPasswordService;
  }

  @GetMapping("/login")
  public ResponseEntity<String> login() {
    return new ResponseEntity<String>("HI ", HttpStatus.OK);
  }

  // @PostMapping("/login")
  // public ResponseEntity<User> login(@RequestBody UserLogin request) {

  // 	User retUser = new User();
  // 	retUser.setUsername(request.getUsername());
  // 	retUser.setPassword(request.getPassword());

  // 	return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "jwtTokenUtil.generateAccessToken(user)")
  // 				.body(retUser);
  // }

  @PostMapping("/login")
  public ResponseEntity<com.example.server.models.User> login(
    @RequestBody UserLogin request
  ) {
    // try {
    Authentication authenticate = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getUsername(),
        request.getPassword()
      )
    );

    User user = (User) authenticate.getPrincipal();
    com.example.server.models.User retUser = userService.getUserByUsername(
      user.getUsername().toLowerCase(Locale.ROOT)
    );
    retUser.setPassword(null);

    return ResponseEntity
      .ok()
      .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
      .body(retUser);
    // } catch (BadCredentialsException ex) {
    //   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    // }
  }
}
