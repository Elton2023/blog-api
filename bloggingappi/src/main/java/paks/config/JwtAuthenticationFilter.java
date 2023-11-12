package paks.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import paks.config.csd;
import paks.entities.User;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	 		@Autowired
	       private customUserDetailServices cud;

         @Autowired
          private JwtTokenBody jtb;
	

	

 


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//getting the jwt token
		 
		    
		System.out.println("inside JWTaAuthenticaton filter request hearer for token is"+request.getHeader("Authorization") +request.getHeaderNames() );
		String requestedToken =request.getHeader("Authorization");
		System.out.println("the token header we got is ->"+ requestedToken);
		String username=null;
		String token=null;
		if(requestedToken!=null && requestedToken.startsWith("Bearer") ) {
			
		token=	requestedToken.substring(7);//this removes the first 7 charecters from the to tokens header i.e the word bearer
		
		try {
			username =	this.jtb.getUsernameFromToken(token);
		} catch (Exception e) {	
System.out.println("faild to obtain username from the token ");	
e.printStackTrace();
		}
		
		} else{
			System.out.println("the filter request is null ");

		}
		
		///validating the credentials from token by matching it from database
		if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			
	 	//UserDetails ud =	this.cud.loadUserByUsername(username);
			 	csd ud =  (csd) this.cud.loadUserByUsername(username);
System.out.println("-------------------->>>>>>>"+ud.getUsername()+"And"+ud.getAuthorities());
			if(this.jtb.validateToken(token, ud)) {
				
				UsernamePasswordAuthenticationToken upat= new UsernamePasswordAuthenticationToken(ud,null,ud.getAuthorities());//this is simple presentation of a username and password. 
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));//here we tell that this must connet to web
				SecurityContextHolder.getContext().setAuthentication(upat);//here we connect it to web's security sector
			}
			else {
				System.out.println("hey mate,sorry we faild to authenticated credentials in token filter ");
			}
			
		}else {
			System.out.println("couldnt send verified recors");
		}
//----------------------------------------------------------------------------------------------------
		filterChain.doFilter(request, response);
	}

/*
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {

//	1. get token 

	String requestToken = request.getHeader("Authorization");

	// Bearer 2352523sdgsg

	System.out.println("poi re "+requestToken);

	String username = null;

	String token = null;

	if (requestToken != null && requestToken.startsWith("Bearer")) {

		token = requestToken.substring(7);

		try {
			username = this.jtb.getUsernameFromToken(token);
		} catch (IllegalArgumentException e) {
			System.out.println("Unable to get Jwt token");
		} catch (ExpiredJwtException e) {
			System.out.println("Jwt token has expired");
		} catch (MalformedJwtException e) {
			System.out.println("invalid jwt");

		}

	} else {
		System.out.println("Jwt token does not begin with Bearer");
	}

	// once we get the token , now validate

	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

		UserDetails userDetails = this.cud.loadUserByUsername(username);

		if (this.jtb.validateToken(token, userDetails)) {
			// shi chal rha hai
			// authentication karna hai

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

		} else {
			System.out.println("Invalid jwt token");
		}

	} else {
		System.out.println("username is null or context is not null");
	}

	
	filterChain.doFilter(request, response);
}	

*/


}

