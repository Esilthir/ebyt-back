package formation.dta.ebytback.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import formation.dta.ebytback.model.User;
import formation.dta.ebytback.repository.UserRepository;
import formation.dta.ebytback.exception.ResourceNotFoundException;

@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/loginCustom")
	public User login(@RequestBody User user) {
		Optional<User> oUser = userRepository.findOneByUsername(user.getUsername());
		if (oUser.isPresent()) {
			if(bCryptPasswordEncoder.matches(user.getPassword(), oUser.get().getPassword())) {
				return oUser.get();
			}
			
		}
		throw new ResourceNotFoundException( "Ressource not found" );
	}
}
