package paks.config;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import paks.entities.User;
import paks.exceptions.ResourceNotFoundException;
import paks.repository.UserDB;
@Service
public class customUserDetailServices implements UserDetailsService{
 	@Autowired
	private UserDB udb;
	
	 
//'UserDetailsService' is linked to 'web securty configure' it gives user related details to it

 	 
 	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=	this.udb.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user","email",username));
	  csd csd=     new csd (user);
      System.out.println("inside "+this.getClass()+"authorites are found r"+user.getRole()+"transfer to object are "+csd.getAuthorities());
  	return csd;
 	
 	
 //	 return user;
	}
 
}
