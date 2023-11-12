package paks.payloads;

 
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


	
  //we created this class to diplay/expose 'user' data  via this class the Original user class will b used to cordinate with database
public class UserDto {
	private int id;
	  @NotEmpty
	  @Size(min=3,message="dude! dont give unrealistic name")
 	private String name;
	@Email(message="Dont give a shit if ya dont hv email")
	private String email;
	   @NotEmpty
	   @Size(min=6,max=15,message="Password must have min 6 characters and maximum 7 ")
	private String password;
   @NotEmpty
	private String about;
   
   private Set<RoleDto> role=new HashSet<>();
	
	
	
	
	public UserDto(String name, String email, String password, String about) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}




	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}




	public UserDto(int id, String name, String email, String password, String about,Set<RoleDto> role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;		
		this.role = role;
	}

	public UserDto(  String name, String email, String password, String about,Set<RoleDto> role ) {
		super();
 		this.name = name;
		this.email = email;
		this.password = password;		
		this.role = role;
	}



	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getAbout() {
		return about;
	}




	public void setAbout(String about) {
		this.about = about;
	}




	public Set<RoleDto> getRole() {
		return role;
	}




	public void setRole(Set<RoleDto> role) {
		this.role = role;
	}




	 
 
}
