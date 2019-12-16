package com.sistemas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder( passwordEncoder )
				.withUser("user").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("camilo").password( passwordEncoder.encode("123456") ).roles("USER", "ADMIN")
				.and()
				.withUser("arteaga").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("granados").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("angulo").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("camacho").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("garcia").password( passwordEncoder.encode("123456") ).roles("USER")
				.and()
				.withUser("castillo").password( passwordEncoder.encode("123456") ).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/docente/**").hasRole("ADMIN")
				.antMatchers("/**").hasAnyRole("ADMIN", "USER")
				.and().formLogin().permitAll()
				.and().exceptionHandling().accessDeniedPage("/403") //agregado
				.and().logout().logoutSuccessUrl("/login").permitAll()
				.and().csrf().disable();
	}
}
