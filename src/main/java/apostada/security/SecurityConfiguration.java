package apostada.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/liga/**").permitAll();
		http.authorizeRequests().antMatchers("/equipo/**").permitAll();
		http.authorizeRequests().antMatchers("/apuesta/**").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		
		// Public assets
		http.authorizeRequests().antMatchers("/assets/**").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().anyRequest().authenticated();
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("email");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/");
		
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		// Disable CSRF at the moment
		http.csrf().disable();
	}

}
