package paks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
 
 @Configuration
 @EnableWebSecurity
 @EnableWebMvc
 @EnableGlobalMethodSecurity(prePostEnabled = true)//this is regarding to @PreAuthoriztion ,so it works
public class DefaultSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private customUserDetailServices customUserDetailService;

	 @Autowired
	 private JwtAuthenticationFilter jwtAuthenticationFilter;

	 @Autowired
	 private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	 
		public static final String[] PUBLIC_URLS = {
				"/auth/**",
				"/v3/api-docs",
				"/v2/api-docs",
				"/swagger-resources/**",
				"/swagger-ui/**",
				"/webjars/**"

		};
	 
	 
	 @Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers(PUBLIC_URLS).permitAll()
			.antMatchers(HttpMethod.GET).permitAll()
			.anyRequest().authenticated()
			.and().exceptionHandling()

					.authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

			http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());

		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		} 
	 
	 
	 
	 
	 /* 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 

	 @Autowired
	 private customUserDetailServices csds;

	 @Autowired
	 private JwtAuthenticationFilter jaf;

	 @Autowired
	 private JwtAuthenticationEntryPoint jep;
	 
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();

	 }

	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
 	 	http
 	 	.csrf()
 	 	.disable()
		.authorizeHttpRequests()
		.antMatchers("/api/auth/login").permitAll()
		
		.anyRequest()
		.authenticated()	
		.and()
		.exceptionHandling()
		
		.authenticationEntryPoint(this.jep)
		.and()
		.sessionManagement()
 		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 	 	
 	  
 	 	
 	 	http.addFilterBefore(this.jaf,UsernamePasswordAuthenticationFilter.class);
	 }

	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(this.csds).passwordEncoder(passwordEncoder());
	 }
	 
	 
    @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
 		return super.authenticationManagerBean();
	}
	 
*/
//------------///////////////////////////////////////////////////////////////////////////////////////
 }