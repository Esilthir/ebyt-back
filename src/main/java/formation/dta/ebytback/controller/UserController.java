package formation.dta.ebytback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.dta.ebytback.model.User;
import formation.dta.ebytback.repository.UserRepository;
import formation.dta.ebytback.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@CrossOrigin(origins = "*")
	@PostMapping("/")
	public User createUser(@RequestBody @Valid User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userService.create(user);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public List<User> getAll() {
		return userService.findAll();
	}
}
