package com.riset.springsecurity.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.riset.springsecurity.service.CustomeUsersDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//1 hari
	int tokenTime = 24 * 60 * 60;
	
	@Autowired
	private CustomeUsersDetailService customeUserDetailService;
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.userDetailsService(customeUserDetailService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.headers()
			.frameOptions().sameOrigin()
				.and()
			.authorizeRequests()
			//webjars --> default library js/css, //assets --> default assets js/css
			.antMatchers("/resources/**", "/webjars/**", "/assets/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error").permitAll()
				.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.deleteCookies("my-remember-me-cookie").permitAll()
				.and()
			.rememberMe()
			.rememberMeCookieName("my-remember-me-cookie")
			.tokenRepository(tokenRepository())
			.tokenValiditySeconds(tokenTime)
				.and()
			.exceptionHandling();
	}
	
	PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenImpl = new JdbcTokenRepositoryImpl();
		tokenImpl.setDataSource(dataSource);
		return tokenImpl;
	}
}
