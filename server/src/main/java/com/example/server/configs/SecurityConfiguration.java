package com.example.server.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Enable CORS and disable CSRF
    http = http.cors().and().csrf().disable();
    http.headers().frameOptions().disable();

    http
      .authorizeRequests()
      // Our public endpoints
      .antMatchers(
        // "/h2/**",
        "/login",
        "/products"
        // "/resetpass/*",
        // "/resetpassword",
        // "/register",
        // "/signup",
        // "/signup/shop",
        // "/shop_products",
        // "/featured_products",
        // "/shop_products/search/**"
      )
      .permitAll()
      .antMatchers(HttpMethod.GET, "/sellers/**")
      .permitAll()
      .antMatchers(HttpMethod.GET, "/invoices/**")
      .permitAll()
      // Our private endpoints
      .antMatchers("/actuator/**")
      .hasRole(Role.ADMIN.toString())
      .anyRequest()
      .authenticated();
  }
  // @Override
  // @Bean
  // public AuthenticationManager authenticationManagerBean() throws Exception {
  //   return super.authenticationManagerBean();
  // }
}
