package ormva.Auth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ormva.Auth.User;
import ormva.Auth.service.IUserService;
import ormva.Auth.service.UserServiceImpl;
import ormva.dto.UserRegistrationDto;

@RestController
public class UserCreationController {
	
	@Autowired private IUserService userService;
	
	@PostMapping("/register")
	public User userRegistration(@RequestBody UserRegistrationDto userRegistrationDto)
	{
		 return userService.save(userRegistrationDto);
		
		
		
	}

}
