package formation.dta.ebytback.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import formation.dta.ebytback.exception.ResourceNotFoundException;
import formation.dta.ebytback.model.User;
import formation.dta.ebytback.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	public Optional<User> findByUsername(String username){
		return userRepository.findOneByUsername(username);
	}


	public User create(@Valid User user) {
		return userRepository.save(user);
	}

	public User findUserById(Long id) {
		
		Optional<User> oUser = userRepository.findById(id);
		if (oUser.isPresent()) {
			return oUser.get();
		}
		ResourceNotFoundException exceptionNotFound = new ResourceNotFoundException("Le user " + id + " n'a pas été trouvé");
		throw exceptionNotFound;
	}


	public List<User> findAll() {
		return userRepository.findAll();
	}


	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}


	public User updateUser(User user) {
		return userRepository.save(user);
	}
}
