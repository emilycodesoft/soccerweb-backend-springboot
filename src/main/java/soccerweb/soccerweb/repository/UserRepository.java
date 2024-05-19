package soccerweb.soccerweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soccerweb.soccerweb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
