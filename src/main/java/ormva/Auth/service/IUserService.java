package ormva.Auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ormva.Auth.User;
import ormva.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
