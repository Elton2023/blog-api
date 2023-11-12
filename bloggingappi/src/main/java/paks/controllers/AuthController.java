package paks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paks.config.JwtTokenBody;
import paks.config.customUserDetailServices;
import paks.entities.JwtRequest;
import paks.entities.JwtResponse;
import paks.exceptions.ApiException;
import paks.payloads.UserDto;
import paks.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
    @Autowired
	private JwtTokenBody jtb;
	    
    @Autowired
  	private customUserDetailServices csd;
  	
    @Autowired
  	private AuthenticationManager am;
    
    @Autowired
    private UserService us;
    
    @PostMapping("/login")
	public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest request) throws Exception {
System.out.println("inside login ");
		this.authenticate(request.getUsername(), request.getPassword());
 		paks.config.csd userDetails = (paks.config.csd) this.csd.loadUserByUsername(request.getUsername());

		String token = this.jtb.generateToken(userDetails);

		JwtResponse response = new JwtResponse();
		response.setToken(token);
		return new ResponseEntity<JwtResponse>(response, HttpStatus.OK);

	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.am.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");
		}}

	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto>registerApi(@RequestBody UserDto UserDto){
		UserDto registeredUser =	this.us.RegisterUser(UserDto);
		return ResponseEntity.ok(registeredUser);
	}
	
   //----------------------------------------------
}
