package unfv.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import unfv.edu.pe.security.FiltroJWTAutorizacion;

@SpringBootApplication
@EnableSwagger2
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
            http.csrf(csrf -> csrf.disable())
                    .addFilterBefore(new FiltroJWTAutorizacion(),
                            UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests(requests -> requests
                            .antMatchers(
                                    "/api/v1/seguridad/**",
                                    "/v2/api-docs/**",
                                    "/swagger-ui/**",
                                    "/swagger-resources/**",
                                    "/configuration/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated());
		
		}
		
	}
}
