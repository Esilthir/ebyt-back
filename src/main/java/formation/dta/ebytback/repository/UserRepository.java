package formation.dta.ebytback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.dta.ebytback.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
