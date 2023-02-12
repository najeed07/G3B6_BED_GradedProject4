package org.greatlearning.empmgmt_rest_api.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	//Authorization setup
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}
	
	//Authentication Setup
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addNewEmployee").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/addRole").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/addUser").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/listAllEmployees").authenticated()
				.antMatchers(HttpMethod.GET, "/api/getEmployeeById/**", "/api/getEmployeeById**").authenticated()
				.antMatchers(HttpMethod.GET, "/api/getEmployeesSortedByName**", "/api/getEmployeesSortedByName/**")
				.authenticated()
				.antMatchers(HttpMethod.GET, "/api/searchByFirstName**", "/api/searchByFirstName/**")
				.authenticated()
				.antMatchers(HttpMethod.DELETE, "/api/deleteEmployeeById/{id}", "/api/deleteEmployeeById/**")
				.hasRole("ADMIN")
				.antMatchers("/api/updateEmployee").hasAnyRole("ADMIN", "USER")
				.anyRequest()
				.fullyAuthenticated()
				.and()
				.httpBasic();

	}
}
