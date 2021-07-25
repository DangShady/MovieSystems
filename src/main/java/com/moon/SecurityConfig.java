package com.moon;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.moon.entity.Account;
import com.moon.respository.AccountDAO;
import com.moon.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AccountDAO accDao;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	//Cơ chế mã hóa mật khẩu
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
	
	//Cung cấp dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(username -> {
			try {
				Account user = accDao.findById(username).get();
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAccountRoles().stream()
						.map(er -> er.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found");
			}

		});
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/order/**","/account/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("GUEST","ADMIN")
			.antMatchers("/rest/authorities").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success",false)
			.failureUrl("/security/login/error");
		
		http.rememberMe()
			.tokenValiditySeconds(86400);
		
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthoried");
		
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
		
	}
	
	
	
	// Cho phép truy xuất Rest API từ bên ngoài
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
	
}
