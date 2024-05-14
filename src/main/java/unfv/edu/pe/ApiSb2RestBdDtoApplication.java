package unfv.edu.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class ApiSb2RestBdDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSb2RestBdDtoApplication.class, args);
	}

	class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	}
}
