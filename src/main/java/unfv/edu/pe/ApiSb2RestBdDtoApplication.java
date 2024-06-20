package unfv.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import unfv.edu.pe.security.FiltroJWTAutorizacion;

@SpringBootApplication
@EnableSwagger2
public class ApiSb2RestBdDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSb2RestBdDtoApplication.class, args);
	}
 
	@Bean
    SecurityFilterChain webSecurityConfigSecurityFilterChain(HttpSecurity http) throws Exception {
		 http.authorizeRequests().requestMatchers("/login").permitAll()
         .requestMatchers("/users/**", "/settings/**").hasAuthority("Admin")
         .hasAnyAuthority("Admin", "Editor", "Salesperson")
         .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
         .anyRequest().authenticated()
         .and().formLogin()
         .loginPage("/login")
             .usernameParameter("email")
             .permitAll()
         .and()
         .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
         .and()
         .logout().permitAll();

 http.headers().frameOptions().sameOrigin();

 return http.build();

    }
}
