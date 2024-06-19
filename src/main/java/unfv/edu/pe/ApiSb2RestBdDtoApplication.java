package unfv.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import unfv.edu.pe.security.FiltroJWTAutorizacion;

@SpringBootApplication
public class ApiSb2RestBdDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSb2RestBdDtoApplication.class, args);
	}
	
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new FiltroJWTAutorizacion(),
                            UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()//requests -> requests
                            .antMatchers(HttpMethod.POST, "/api/v1/seguridad")
							/*
							 * .antMatchers("/api/v1/seguridad/**", "/v2/api-docs/**", "/swagger-ui/**",
							 * "/swagger-resources/**", "/configuration/**")
							 */
                            .permitAll()
                            .anyRequest()
                            .authenticated();
		
		}
		
	}
}
