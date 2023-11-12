package paks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.password.PasswordEncoder;
import paks.entities.User;
import paks.entities.role;
import paks.repository.RoleDB;
import paks.config.AppConstants;

@SpringBootApplication
public class BloggingApplicationApiApplication implements CommandLineRunner {
	
	
@Autowired
	private PasswordEncoder pd;

@Autowired
private RoleDB rd;

	public static void main(String[] args) {
		SpringApplication.run(BloggingApplicationApiApplication.class, args);
		System.out.println("So far so good");
		}
	

	@Override
	public void run(String... args) throws Exception {
 System.out.println("123456 after encoding is : "+this.pd.encode("123456"));
//the code below will create roles in database while runnig the app for first time 
 try {
	 role role =new role();
	 role.setId(AppConstants.ADMIN_ROLE);
	 role.setName("ROLE_ADMIN");
	 
	 role role1 =new role();
	 role1.setId(AppConstants.ROLE_NORMAL);
	 role1.setName("ROLE_NORMAL");
	 
	 List <role>roles=List.of(role,role1);
	 
	 List <role>results=	 this.rd.saveAll(roles);
results.forEach(r->{System.out.println("roles created suscessfully"+ r.getName());});
	 
 }catch(Exception e) {
	 e.printStackTrace();
	 System.out.println("could not create characters in role");
 }
 }
	
//-------------------------------------------------------------------------------------------------------	
}