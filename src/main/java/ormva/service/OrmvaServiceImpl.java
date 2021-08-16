package ormva.service;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ormva.Auth.Role;
import ormva.Auth.dao.RoleRepository;
import ormva.Auth.dao.UserRepository;
import ormva.dao.AntenneRepository;
import ormva.entities.Antenne;
@Service
@Transactional @AllArgsConstructor
public class OrmvaServiceImpl implements IOrmvaService{

	@Autowired AntenneRepository antenneRepository;
	@Autowired RoleRepository roleRepository;
	@Override
	public void initAntenne() {
		Stream.of("AAA","BBB","CCC").forEach(str->{
			Antenne antenne=new Antenne();
			antenne.setAbreviation(str);
			antenne.setDesignation(str);
			antenneRepository.save(antenne);
		});
		
	}

	@Override
	public void initRole() {
		Stream.of("Admin","GUC","ADA").forEach(str->{
			Role role=new Role();
			role.setRole(str);
			roleRepository.save(role);
		});
	}

}
