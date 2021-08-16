package ormva.Auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ormva.Auth.Role;
import ormva.Auth.User;
import ormva.Auth.dao.RoleRepository;
import ormva.Auth.dao.UserRepository;
import ormva.dao.AntenneRepository;
import ormva.dto.UserRegistrationDto;
import ormva.entities.Antenne;
@Service
@Transactional @AllArgsConstructor
public class UserServiceImpl implements IUserService{

	
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;
	@Autowired private AntenneRepository antenneRepository;
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User u=userRepository.findUserByEmail(registrationDto.getEmail());
		if(u!=null) throw new RuntimeException("User Already exist");
		Role role=roleRepository.findById(registrationDto.getRole()).get();	
		Antenne antenne=antenneRepository.findById(registrationDto.getAntenne()).get();
		User user=new User();
		user.setNom(registrationDto.getNom());
		user.setPrenom(registrationDto.getPrenom());
		user.setEmail(registrationDto.getEmail());
		user.setRoles(Arrays.asList(role));
		user.setAntenne(antenne);
		user.setPassword(new BCryptPasswordEncoder().encode(registrationDto.getPassword()));
		System.out.println(user);
		userRepository.save(user);
		return user;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findUserByEmail(username);
		if(user==null) throw new UsernameNotFoundException("invalid user");
		
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRole()));
		});
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
