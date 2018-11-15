package formation.dta.ebytback.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import formation.dta.ebytback.model.EnumRole;
import formation.dta.ebytback.model.User;
import formation.dta.ebytback.repository.UserRepository;
import formation.dta.ebytback.service.UserService;


@Service
@Transactional
public class AuthentificationService implements UserDetailsService{

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(final String username) {
//        Optional<User> option = userservice.findOneByUsername(username);
//        if (option.isPresent()) {
//            User user = option.get();
//            List<GrantedAuthority> rules = this.getUserCredentials(user);
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rules);
//        }
//        throw new UsernameNotFoundException("username.not.found");
//    }
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user);
    }

    
    // methode retournant une liste des droits de luser. Exemple un admin a les droits Role_ADMIN et ROLE_USER
    private List<GrantedAuthority> getUserCredentials(User user) {
         List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

         authorities.add(new SimpleGrantedAuthority(EnumRole.ROLE_USER.getRole()));
         if(user.getRole().equals(EnumRole.ROLE_ADMIN.getRole()))
         {
             authorities.add(new SimpleGrantedAuthority(EnumRole.ROLE_ADMIN.getRole()));
         }

        return authorities;
    }

}