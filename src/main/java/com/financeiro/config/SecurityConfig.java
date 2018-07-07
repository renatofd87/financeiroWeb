package com.financeiro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.financeiro.util.Constantes;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier(Constantes.PARAM_USER_DETAIL_SERVICE)
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(Constantes.URL_DESPESA_RESTRITA)
			.access(Constantes.ROLES_PERMITIDAS)
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage(Constantes.URL_LOGIN)
			.permitAll()
			.failureUrl(Constantes.URL_LOGIN_ERRO)
			.usernameParameter(Constantes.PARAM_USERNAME)
			.passwordParameter(Constantes.PARAM_PASSWORD)
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher(Constantes.URL_LOGOUT))
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage(Constantes.URL_403);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers(Constantes.URL_IGNORE_LAYOUT);
	}
	
}