package paks.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import paks.config.AppConstants;
import paks.exceptions.*;
import paks.entities.User;
import paks.entities.role;
import paks.payloads.UserDto;
import paks.repository.RoleDB;
import paks.repository.UserDB;
import paks.services.UserService;
@Service
public class UserserviceImp implements UserService {
	
@Autowired
private UserDB usb;
	
@Autowired
private ModelMapper ModelMapper;


@Autowired
private PasswordEncoder pd;

@Autowired
private RoleDB rdb;


	@Override
	public UserDto createUser(UserDto userDto) {
 User user =this.DtoToUser(userDto);
 User saveduser=this.usb.save(user);
		return this.UserToDto(saveduser);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto, Integer ID) {
 User usr =this.usb.findById(ID).orElseThrow(()-> new ResourceNotFoundException("user","ID",ID));
		usr.setName(userDto.getName());
		usr.setEmail(userDto.getEmail());
		usr.setPassword(userDto.getPassword());
		usr.setAbout(userDto.getAbout());
		usr=this.usb.save(usr);
	UserDto u=	this.UserToDto(usr) ;
		return u;
	}

	@Override
	public UserDto GetUserById(Integer UserId) {

		 User usr =this.usb.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("user","ID",UserId));
 
		return this.UserToDto(usr);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User>  alluser =this.usb.findAll();
		 List<UserDto> all=alluser.stream().map(user->this.UserToDto(user)).collect((Collectors.toList()));
  		return all;
	}

	@Override
	public void deleteUser(Integer UserId) {
		 User usr =this.usb.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("user","ID",UserId));
this.usb.delete(usr);
System.out.println(usr.getName() +" is deleted");
	}
	
	
	
	
	
	private User DtoToUser(UserDto ud) {//this method converts userDto to user type
		User user = new User();
		user = this.ModelMapper.map(ud, User.class);//this bean converts/transfer Data from one object to another as long they both have same variable with same names
		/*
		user.setId(ud.getId());
		user.setName(ud.getName());
		user.setEmail(ud.getEmail());
		user.setAbout(ud.getAbout());
		user.setPassword(ud.getPassword());
		*/
		return user;
	}

	private UserDto UserToDto(User us) {
		 UserDto udo=new UserDto();
		 udo = this.ModelMapper.map(us, UserDto.class);
		 /*
		  * udo.setId(us.getId());
		  
		 udo.setName(us.getName());
		 udo.setEmail(us.getEmail());
		 udo.setAbout(us.getAbout());
		 udo.setPassword(us.getPassword()); */
		return udo;
		
	}

	@Override
	public UserDto RegisterUser(UserDto UserDto) {
		User u =this.ModelMapper.map(UserDto, User.class);
		u.setPassword(this.pd.encode(u.getPassword()));
	 role foundByid =	this.rdb.findById(AppConstants.ROLE_NORMAL).get();
 	 
	 u.getRole().add(foundByid);
 	 User newUser=	 this.usb.save(u);
	 
	 UserDto ndt=this.ModelMapper.map(u, UserDto.class) ;
	 if(ndt.getRole().isEmpty() || ndt.getRole()==null) {
		 System.out.println("------------------------------------++++++++++++++failded to add role");
	 }else {
		 System.out.println("------------------------------------++++++++++++++failded to add role");
		 System.out.println("------------------------------------++++++++++++++failded to add role");
		 System.out.println("------------------------------------++++++++++++++failded to add role");
		 System.out.println("------------------------------------++++++++++++++failded to add role");
		 System.out.println("------------------------------------++++++++++++++failded to add role");

	 }
	 ndt.setPassword("blhh");
 		return ndt;
	}
	
 
	
	
}
