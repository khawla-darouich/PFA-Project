package ormva.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder= passwordEncoder();
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	/*	auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("123")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123")).roles("ADMIN");
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select tel as principal, password from user where tel=?")
			.authoritiesByUsernameQuery("select tel as principal,role as role from users_roles where tel=?");*/
			//.passwordEncoder(passwordEncoder);
			
		
	} 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		//http.formLogin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.authorizeRequests().antMatchers("/appelOffres**/**").hasAuthority("PARTICULIER");
		http.authorizeRequests().antMatchers("/register**/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf().disable(); 
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder()
	 {
		return new BCryptPasswordEncoder();
		 
	 }
	
}
