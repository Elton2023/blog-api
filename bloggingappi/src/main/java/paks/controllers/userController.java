package paks.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import paks.entities.User;
import paks.payloads.UserDto;
import paks.payloads.apiResponse;

import org.springframework.web.bind.annotation.RestController;
import paks.services.UserService;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/users")
public class userController {
	
	@Autowired
	private UserService UserService;
	
	
	
  	@GetMapping("/User/{UserId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable("UserId")int id){
UserDto  single=	this.UserService.GetUserById(id);
	return ResponseEntity.ok(single);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto UserDto){
		
		UserDto createUserDto =this.UserService.createUser(UserDto);
		//return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		 // return ResponseEntity.of(Optional.of(createUserDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(createUserDto);

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{userId}")
public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto UserDto,@PathVariable("userId") int uid){
	UserDto updateduser=	this.UserService.UpdateUser(UserDto, uid);
	return ResponseEntity.ok(updateduser);
	
}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity <apiResponse>deleteUser(@PathVariable("uid") int uid){
		this.UserService.deleteUser(uid);
		return new ResponseEntity<apiResponse>(new apiResponse("user deleted ",true),HttpStatus.OK);
				
	}
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto>  all=	this.UserService.getAllUsers();
	return ResponseEntity.ok(all);	
	}
	/*----------------------------------------------------------*/
}
