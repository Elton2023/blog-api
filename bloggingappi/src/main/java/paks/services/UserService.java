package paks.services;

 import java.util.List;

import paks.payloads.UserDto;

public interface UserService {
	public UserDto	RegisterUser(UserDto UserDto);
	public UserDto	createUser(UserDto user);
	public UserDto	UpdateUser(UserDto user,Integer ID);
	public UserDto	GetUserById(Integer UserId);
public	List<UserDto>  getAllUsers();
void deleteUser(Integer UserId);

}
