package hh.sof03.backendPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class WebSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new
				BCryptPasswordEncoder());
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests( authorize -> authorize
					.requestMatchers(antMatcher("/css/**")).permitAll()
					.requestMatchers(antMatcher("/signup")).permitAll()
					.requestMatchers(antMatcher("/recipelist")).permitAll()
					.anyRequest().authenticated()
					)
			.formLogin( formlogin -> formlogin
					.loginPage("/login")
					.defaultSuccessUrl("/recipelist", true)
					.permitAll()
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/recipelist")
			.permitAll()
			);
		return http.build();
	}
}
