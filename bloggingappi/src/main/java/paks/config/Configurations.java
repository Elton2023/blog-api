package paks.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
public class Configurations {
	
	@Bean//this bean converts/transfer Data from one object to another as long they both have same variable with same names
	public ModelMapper ModdelMapper() {
		
		return new ModelMapper();
		
	}

}
