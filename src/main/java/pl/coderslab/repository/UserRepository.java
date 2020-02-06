package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

AppUser findByEmail(String email);
AppUser findByPassword(String password);
AppUser findByLogin(String login);



}
