package paks.config;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

 import org.springframework.security.core.GrantedAuthority;
 import org.springframework.security.core.authority.SimpleGrantedAuthority;
 import org.springframework.security.core.userdetails.UserDetails;

import paks.entities.User;
import paks.entities.role;

public class csd  implements UserDetails {

	private User user;
	private Set<role> role  ;
	
	public csd (User user)
	{
		super();
		this.user=user;
		role  =(Set<role>) this.user.getRole();
	}
 	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
 		List<SimpleGrantedAuthority> authorities=this.role.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
System.out.println("authorites found are "+authorities);
 		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
