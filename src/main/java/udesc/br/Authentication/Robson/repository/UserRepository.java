package udesc.br.Authentication.Robson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import udesc.br.Authentication.Robson.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
