package pl.kostrowski.nauk.springmvcfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kostrowski.nauk.springmvcfull.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
